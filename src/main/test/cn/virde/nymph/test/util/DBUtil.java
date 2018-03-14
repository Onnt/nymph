package cn.virde.nymph.test.util;

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

/**
 * <T> T:代表的是泛型.可以是任意Object 类型
 * @author Administrator
 *
 * @param <T>
 */
public class DBUtil<T> {
	
	private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String URL = "jdbc:sqlserver://182.254.215.252:1433;DataBaseName=shanghaiwuye";

	private static String USER = "sa";
	private static String PASSWORD = "AFMafm123";
	// 获取连接
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 查询方法(当他返回的是list和一个对象的时候用这个方法)
	public List<T> query(String sql, Object[] args, Class clazz) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 存储返回的集合对象
		List<T> list = new ArrayList<T>();
		
		try {
			// 使用反射获取类的相关信息(实体类的属性--数据库里相应表的字段)
			Field[] fields = clazz.getDeclaredFields();
			
			Method method = null;

			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			
			
			// 如果sql语句有参数用args集合循环给其赋值
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					pstmt.setObject(i + 1, args[i]);// 参数位置号从1开始
				}
			}
			rs = pstmt.executeQuery();
			// 获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();//得到元数据集
			// 获取一共有多少列
			int columnCount = rsmd.getColumnCount();//得到sql语句到底查询了多少个字段
	
			
			while (rs.next()) {
				// 创建一个新对象
				T obj = (T) clazz.newInstance();//创建一个实例
				
				// 取出的结果集中列号从1开始
				for (int i = 1; i <= columnCount; i++) {
					
					String cname = rsmd.getColumnName(i);// 获取每一列[数据表的列名]的名称 
					int ctype = rsmd.getColumnType(i);// 获取每一列[数据库表的数据类型]的数据类型
					
					for (Field f : fields) {
						if (cname.equalsIgnoreCase(f.getName()))// 如果列名和字段名相同
						{
							// 开始封装数据
							String methodName = "set"
									+ f.getName().substring(0, 1).toUpperCase()
									+ f.getName().substring(1);
							// 根据列的type值的类型进行处理
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
			closeAll(null, pstmt, conn);
		}
		return list;
	}


	// 执行增删改方法(update insert delete)
	public int executeSQL(String sql, Object[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			conn = getConn();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			// 循环给sql参数赋值
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					pstmt.setObject(i + 1,args[i]);
				}
			}
			count = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();// 捕获事务异常，事务回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			System.out.println("数据库操作异常！");
		} finally {
			closeAll(null, pstmt, conn);
		}
		return count;
	}
	
	// 关闭连接
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
