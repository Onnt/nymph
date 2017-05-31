package cn.virde.nymph.db.sql;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import cn.virde.nymph.Nym;
import cn.virde.nymph.NymLog;

public class SqlDbCurdResultAsObject<T> extends SqlDbCurd{

	private NymLog log = Nym.getLogger(this.getClass().getName());
	
	private PreparedStatement ppsta ;
	private ResultSet rs ;
	private Connection conn ;
	
	public SqlDbCurdResultAsObject(DBConnInfo info) {
		super(info);
	}

	public List<T> query(String sql, Object[] args, Class clazz) {
		if(!openPreparedStatement(sql,args)) return null;
		executeQuery();
		List<T> list = null;
		try {
			list = createResultObjectList(clazz);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException | SQLException e) {
			log.i("出现异常，异常不明确，这个地方需要分解", e);
		}
		close();
		return list;
	}
	private boolean executeQuery(){
		try {
			rs = ppsta.executeQuery();
			return true;
		} catch (SQLException e) {
			log.i("ppsta.executeQuery()时出现异常情况，操作已经终止", e);
			close();
			return false ;
		}
	}
	private List<T> createResultObjectList(Class clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, SQLException{
		List<T> list = new ArrayList<T>();
		while (rs.next()) {
			T obj = (T) createObj(clazz);
			list.add(obj);
		}
		return list;
	}
	private int getColumnCount(ResultSetMetaData rsmd){
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			log.i("通过查询结果元信息获取行数时发生异常，操作将继续但不会获得任何结果", e);
			return -1 ;
		}
	}
	private ResultSetMetaData getResultSetMetaData(){
		ResultSetMetaData rsmd;
		try {
			return rs.getMetaData();
		} catch (SQLException e) {
			log.i("获取查询结果元信息时发生异常,操作将终止",e);
			return null;
		}
	}
	private Object createObj(Class clazz) throws InstantiationException, IllegalAccessException, SQLException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		
		ResultSetMetaData rsmd = getResultSetMetaData();
		if(rsmd == null) return null;
		T obj = (T) clazz.newInstance();
		int columnCount = getColumnCount(rsmd);
		for (int i = 1; i <= columnCount; i++) {
			
			String cname = rsmd.getColumnName(i);
			int ctype = rsmd.getColumnType(i);

			Field[] fields = clazz.getDeclaredFields();
			Method method = null;
			for (Field field : fields) {
				if (cname.equalsIgnoreCase(field.getName()))
				{
					String methodName = createMethodName(field);
					if(ctype == Types.INTEGER){
						method = clazz.getMethod(methodName,Integer.class);
						method.invoke(obj, rs.getInt(i));
					}else{
						method = clazz.getMethod(methodName,String.class);
						method.invoke(obj, rs.getString(i));
					}
				}
			}
		}
		return obj;
	}
	private String createMethodName(Field field){
		return "set"+ field.getName().substring(0, 1).toUpperCase()+ field.getName().substring(1);
	}
	private boolean openPreparedStatement(String sql,Object[] args){
		if(!open()) return false;
		if(!initPpsta(sql)) return false ;
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				if(initPpstaPara(i + 1, args[i]))
					return false;
			}
		}
		return true;
	}
	private boolean initPpsta(String sql){
		try {
			ppsta = conn.prepareStatement(sql);
			return true;
		} catch (SQLException e) {
			log.i("创建Ppsta时出现异常，操作已经终止", e);
			close();
			return false;
		}
	}
	private boolean initPpstaPara(int i ,Object para){
		try {
			ppsta.setObject(i, para);
			return true;
		} catch (SQLException e) {
			log.i("给ppsta初始化参数时发生异常，操作已经终止",e);
			close();
			return false;
		}
	}
	

	// 执行(update insert delete)之类的操作
	public int executeSQL(String sql, Object[] args){
		if(!open()) return -1;
		int count = 0;
		try {
			if(conn == null) System.out.println("conn . is null");
			conn.setAutoCommit(false);
			ppsta = conn.prepareStatement(sql);
			//
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					ppsta.setObject(i + 1,args[i]);
				}
			}
			count = ppsta.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();//出现异常，事务回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			System.out.println("增删改时出现异常");
		} finally {
			close();
		}
		return count;
	}
	
	
	
	private boolean open(){
		try {
			conn = getConn();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			log.i("打开链接时出现异常，操作已经终止", e);
			close();
			return false;
		}
	}
	private void close(){
		closePpsta(ppsta); ppsta = null;
		closeConn(conn); conn = null;
		closeRs(rs); rs = null;
		
	}
}
