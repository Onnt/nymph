package cn.blacard.dbopera.query;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import cn.blacard.dbopera.para.DBConnectPara;


/**
 * 适应于有大量频繁数据库操作的情况<br/>
 * 需要手动关闭链接，
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @create 2017年1月24日 下午5:39:02
 * @param <T>
 */
public class QueryOften<T> {
	
	// 数据库链接
	private Connection conn = null;
	
	public QueryOften(DBConnectPara para) {
		try {
			Class.forName(para.getDRIVER());
			conn = DriverManager.getConnection(para.getURL(), para.getUser(), para.getPass());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author Blacard
	 * @create 2017年1月24日 下午5:42:52
	 * @param sql
	 * @param args
	 * @param clazz
	 * @return
	 */
	public List<T> query(String sql, Object[] args, Class clazz) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<T> list = new ArrayList<T>();
		
		try {
			Field[] fields = clazz.getDeclaredFields();
			
			Method method = null;

			pstmt = conn.prepareStatement(sql);
			
			
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					pstmt.setObject(i + 1, args[i]);
				}
			}
			rs = pstmt.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();

			int columnCount = rsmd.getColumnCount();
	
			
			while (rs.next()) {

				T obj = (T) clazz.newInstance();
				
				for (int i = 1; i <= columnCount; i++) {
					
					String cname = rsmd.getColumnName(i);
					int ctype = rsmd.getColumnType(i);
					
					for (Field f : fields) {
						if (cname.equalsIgnoreCase(f.getName()))
						{

							String methodName = "set"
									+ f.getName().substring(0, 1).toUpperCase()
									+ f.getName().substring(1);
							switch (ctype) {
							
							case Types.INTEGER:
								method = clazz.getMethod(methodName,
										Integer.class);
								method.invoke(obj, rs.getInt(i));
								break;
							case Types.DATE:
							case Types.DATALINK:
							case Types.NVARCHAR:
							case Types.VARCHAR:
								method = clazz.getMethod(methodName,
										String.class);
								method.invoke(obj, rs.getString(i));
								break;
							default:method = clazz.getMethod(methodName,
									String.class);
							method.invoke(obj, rs.getString(i));
							}
						}
					}
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		return list;
	}

	
	/**
	 * 
	 * @author Blacard
	 * @create 2017年1月24日 下午5:44:21
	 * @param sql
	 * @param args
	 * @return
	 */
	public int executeSQL(String sql, Object[] args) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);

			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					pstmt.setObject(i + 1,args[i]);
				}
			}
			count = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			System.out.println("增删改时出现异常");
		} finally {
			closeAll(null, pstmt, null);
		}
		return count;
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2017年1月24日 下午5:45:11
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
