package cn.virde.nymph.db.sql;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.bson.Document;
import org.bson.types.ObjectId;

import cn.virde.nymph.Nym;
import cn.virde.nymph.db.mongo.MongoUtil;
import cn.virde.nymph.enums.common.DBStyle;


public class Test{

//	static SqlDbUtil sqlDB = new SqlDbUtil(new DBConnInfo(DBStyle.MYSQL,"139.196.50.251","db_chun","blacard","DengZhou_474183"));
//	mongodb.uri=mongodb://kingsum:kingsum1234@192.168.10.150:27017/kingsum_platform
	public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		MongoUtil util = Nym.getMongoUtil(new DBConnInfo().setIp("192.168.10.150").setUser("kingsum").setPass("kingsum1234").setDbName("kingsum_platform").setStyle(DBStyle.MONGO));	
		
		
//		Document org = util.getColl("org_socialunit").find(new Document("_id",new ObjectId("580833c737dff762f96485e6"))).first();

		long count = util.getColl("sys_user").count(new Document("orgId",new ObjectId("57cd211d37dff771e0799395")));
		System.out.println(count);
	}

}