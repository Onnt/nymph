package cn.virde.nymph.db.mysql;  
  
import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.virde.nymph.db.ConnInfo;

import java.beans.PropertyVetoException;  
import java.sql.Connection;  
import java.sql.SQLException;  
  
/** 
 * Created by wuxueyou on 2017/2/23. 
 */  
  
public class ConnPool {  
    private static boolean needInit = true ;
    private static final ConnPool instance = new ConnPool();  
    private static ComboPooledDataSource comboPooledDataSource;
  
    public static boolean needInit() {
    	return needInit ;
    }
    public static void init(ConnInfo connInfo) throws ClassNotFoundException, PropertyVetoException {
//            Class.forName(connInfo.getDRIVER());  
            comboPooledDataSource = new ComboPooledDataSource();  
            comboPooledDataSource.setDriverClass(connInfo.getDRIVER());  
            comboPooledDataSource.setJdbcUrl(connInfo.getURL());  
            comboPooledDataSource.setUser(connInfo.getUser());  
            comboPooledDataSource.setPassword(connInfo.getPass());  
            //下面是设置连接池的一配置  
            comboPooledDataSource.setMaxPoolSize(20);  
            comboPooledDataSource.setMinPoolSize(5);  
            needInit = false ;
    }
    
    
  
    @SuppressWarnings("finally")
	public synchronized static Connection getConnection() {  
        Connection connection = null;  
        try {  
            connection = comboPooledDataSource.getConnection();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            return connection;  
        }  
    }  
  
    private ConnPool() {  
    }  
    
    public static ConnPool getInstance() {  
        return instance;  
    }  
}  