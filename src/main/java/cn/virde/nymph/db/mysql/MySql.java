package cn.virde.nymph.db.mysql;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import cn.virde.nymph.common.info.ValidInfo;
import cn.virde.nymph.db.ConnInfo;
import cn.virde.nymph.db.DatabaseClient;
import cn.virde.nymph.db.exception.NymDBException;
import cn.virde.nymph.enums.common.DBStyle;
import cn.virde.nymph.util.Log;

/**
 * 
 * @author Virde
 * 2018年4月23日 下午3:58:46
 * @param <T> 要查询数据的具体类型
 */
public class MySql<T> extends DatabaseClient{
	
	public MySql(String ip,String dbName,String user,String pass) {
		info = new ConnInfo(DBStyle.MYSQL,ip,dbName,user,pass);
	}
	public MySql(ConnInfo connInfo) {
		connInfo.setStyle(DBStyle.MYSQL);
		info = connInfo;
	}

	@SuppressWarnings("rawtypes")
	public synchronized List<T> query(String sql, Object[] args, Class clazz) throws NymDBException, SQLException{
		try {
//			long start = System.currentTimeMillis();
			openPreparedStatement(sql,args);
			rs = ppsta.executeQuery();
			List<T> list = createResultObjectList(clazz);
//			long end = System.currentTimeMillis() ;
//			Log.alert("查询耗时：" + (end - start) +"ms，SQL："+sql);
			return list;
		} catch (NymDBException e) {
			throw e ;
		} catch (SQLException e) {
			throw e ;
		}finally {
			close();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<T> createResultObjectList(Class clazz) throws SQLException, NymDBException {
		List<T> list = new ArrayList<T>();
		try {
			while (rs.next()) {
				T obj = (T) createObj(clazz);
				list.add(obj);
			}
			return list;
		} catch (InstantiationException | IllegalAccessException |  SecurityException | InvocationTargetException |IllegalArgumentException e) {
			throw new NymDBException(e);
		} catch (NoSuchMethodException e) {
			throw new NymDBException("实体方法有问题，实体字段需要换个数据库字段一一对应，用封装类型代替基本类型",e);
		} catch (SQLException e) {
			throw e ;
		}
	}
	
	private int getColumnCount(ResultSetMetaData rsmd){
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			Log.info("通过查询结果元信息获取行数时发生异常，操作将继续但不会获得任何结果", e);
			return -1 ;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object createObj(Class clazz) throws InstantiationException, IllegalAccessException, SQLException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		ResultSetMetaData rsmd = rs.getMetaData();
		
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
	private void openPreparedStatement(String sql,Object[] args) throws NymDBException, SQLException{
		try {
			open();
			ppsta = conn.prepareStatement(sql);
			initPpstaParas(args);
		}catch(SQLException e) {
			throw  e ;
		}
	}
	
	private void initPpstaParas(Object[] args) throws SQLException {
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				ppsta.setObject(i+1, args[i]);
			}
		}
	}
	// 执行(update insert delete)之类的操作
	public synchronized int executeSQL(String sql, Object[] args) throws NymDBException, SQLException{
//		long start = System.currentTimeMillis() ;
		open();
		int count = 0;
		try {
			conn.setAutoCommit(false);
			ppsta = conn.prepareStatement(sql);
			initPpstaParas(args);
			count = ppsta.executeUpdate();
			conn.commit();

//			long end = System.currentTimeMillis() ;
//			Log.alert("执行耗时：" + (end - start) +"ms，SQL:"+sql);
			return count;
		} catch (SQLException e) {
			try {
				conn.rollback();//出现异常，事务回滚
			} catch (SQLException e1) {
				throw e1 ;
			}
			throw e ;
		} finally {
			close();
		}		
	}
	
	
	

	/**
	 * 获取数据库的所有表 的表名
	 * @return 返回
	 * @throws NymDBException  异常
	 */
	public List<String> getAllTableNames() throws NymDBException {
		open();
		List<String> list = new ArrayList<String>();
		DatabaseMetaData dbmd = null;
		try {
			dbmd = conn.getMetaData();
	
			rs = dbmd.getTables(null, null, null, new String[]{"TABLE"});
	
			while(rs.next()){
				String puffix = rs.getString(2);
				String table = rs.getString(3);
				if(puffix==null)
					list.add(table);
				else
					list.add(rs.getString(2)+"."+rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
	/**
	 * 测试是否能够链接成功 
	 * @author Virde
	 * 2018年4月24日 上午11:29:24
	 * @return 返回
	 */
	public ValidInfo valid() {
		ValidInfo validInfo = new ValidInfo();
		try {
			Class.forName(info.getDRIVER());
		} catch (ClassNotFoundException e) {
			validInfo.add(e.getMessage());
		}
		try {
			conn = DriverManager.getConnection(info.getURL(), info.getUser(), info.getPass());
		} catch (SQLException e) {
			validInfo.add(e.getMessage());
		}finally {
			close();
		}
		return validInfo ;
	}
}
