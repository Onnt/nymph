package cn.virde.db.sql;

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

public class SqlDbCurdResultAsObject<T> extends SqlDbCurd{
	
	private PreparedStatement ppsta ;
	private ResultSet rs ;
	private Connection conn ;
	
	public SqlDbCurdResultAsObject(SqlDbConnectInfo info) {
		super(info);
	}

	public List<T> query(String sql, Object[] args, Class clazz) throws NoSuchMethodException, SecurityException, SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		openPreparedStatement(sql,args);
		rs = ppsta.executeQuery();

		List<T> list = createResultObjectList(clazz);

		close();
		
		return list;
	}
	
	private List<T> createResultObjectList(Class clazz) throws SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		List<T> list = new ArrayList<T>();
		while (rs.next()) {
			T obj = (T) createObj(clazz,columnCount,rsmd);
			list.add(obj);
		}
		return list;
	}
	
	private Object createObj(Class clazz,int columnCount,ResultSetMetaData rsmd) throws InstantiationException, IllegalAccessException, SQLException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		T obj = (T) clazz.newInstance();
		
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
	private void openPreparedStatement(String sql,Object[] args) throws SQLException, ClassNotFoundException{
		ppsta = getConn().prepareStatement(sql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				ppsta.setObject(i + 1, args[i]);
			}
		}
	}
	
	private void close() throws SQLException{
		closePpsta(ppsta); ppsta = null;
		closeConn(conn); conn = null;
		closeRs(rs); rs = null;
		
	}
}
