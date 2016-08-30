package cn.blacard.dbopera.opera;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import cn.blacard.dbopera.connect.Connect;
import cn.blacard.dbopera.para.DBConnectPara;

/**
 * 此类定义了数据库操作常用的一些对象
 * 有需要进行数据库操作的类可以先继承此类
 * @changeTime 2016年8月30日16:05:53
 * @since 2016年8月30日16:06:04
 * @author Blacard
 * @e_mail blacard@163.com
 *
 */
public class OperaBase {

	protected Logger log = Logger.getLogger(Query.class.getName());
	
	protected ResultSet rs = null;
	protected Statement sta = null;
	protected Connection conn = null;
	
	/**
	 * 打开数据库连接
	 * 给conn赋值
	 * 前提是 Connect类已经设置数据库连接参数
	 */
	protected void openConnect(){
		conn = Connect.getConn();
		try {
			sta = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭各种
	 */
	protected void closeConnect(){
		Connect.closeAll(rs, sta, conn);
	}
}
