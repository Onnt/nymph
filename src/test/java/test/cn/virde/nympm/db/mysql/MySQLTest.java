package test.cn.virde.nympm.db.mysql;

import cn.virde.nymph.db.exception.NymDBException;
import cn.virde.nymph.db.mysql.MySql;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

/**
 * @author SunAo
 * @Date 2019/7/10
 **/
public class MySQLTest {


    public static void main(String[] args) {
        new InsertSpeedTest().start();
        new InsertSpeedTest().start();
        new InsertSpeedTest().start();
        new InsertSpeedTest().start();
        new InsertSpeedTest().start();
        new InsertSpeedTest().start();
        new InsertSpeedTest().start();
        new InsertSpeedTest().start();
        new InsertSpeedTest().start();
        new InsertSpeedTest().start();
        new InsertSpeedTest().start();
        new InsertSpeedTest().start();
    }
}

class InsertSpeedTest extends Thread{
    private MySql mysql = new MySql("virde.cn","db_study","study","Good_2_study");

    @Override
    public void run() {
        int i = 0 ;
        while(i < 10_000){
            i++;
            System.out.println("正在插入："+i);
            try {
                mysql.executeSQL("insert into tb(u,n) VALUES(?,?) ",new Object[]{"23",""+new Date().getTime()});
            } catch (NymDBException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
