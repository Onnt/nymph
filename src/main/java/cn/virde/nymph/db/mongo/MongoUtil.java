package cn.virde.nymph.db.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import cn.virde.nymph.Nym;
import cn.virde.nymph.db.ConnInfo;

/**
 * 
 * @author Virde
 * 2018年2月8日 下午3:00:10
 */
public class MongoUtil{
	
	private MongoClient mongoClient ;
	private ConnInfo dbInfo ; 
	
	public MongoUtil(ConnInfo dbInfo){
		this.dbInfo = dbInfo ;
		mongoClient = new MongoClient(new MongoClientURI(dbInfo.getURL()));
	}
	public MongoClient getMongoClient(){
		return mongoClient;
	}
	public MongoDatabase getDatabase(String dbName){
		return mongoClient.getDatabase(dbName);
	}
	public MongoDatabase getDatabase(){
		return getDatabase(dbInfo.getDbName());
	}
	
	public MongoCollection<Document> getColl(String collName){
		return getDatabase().getCollection(collName);
	}
	
	public void close() {
		if (mongoClient != null) {
			mongoClient.close();
		}
	}
	
	public boolean isSuccessConn(){
		Document command = new Document("buildInfo",1);
		try{
			Document doc = getDatabase().runCommand(command);
			return true ;
		}catch(Exception e){
			return false ;
		}
	}
	
	public boolean isExistColl(String collName){
		MongoIterable<String> collNames = getDatabase().listCollectionNames();
		for(String collName_: collNames){
			 if (collName_.equalsIgnoreCase(collName)) {
				 return true ;
			 }
		}
		return false ;
	}
	
	public void insertOne(Object obj) {
		String json = Nym.json.objectToJsonString(obj);
		Document doc = Document.parse(json);
		String collName = Nym.clazz.getField(obj.getClass(), "collName");
		getColl(collName).insertOne(doc);
	}
}
