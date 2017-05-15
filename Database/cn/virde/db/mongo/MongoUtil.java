package cn.virde.db.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {
	private MongoClient mongoClient ;
	private MongoConnectInfo dbInfo ; 
	public MongoUtil(MongoConnectInfo dbInfo){
		this.dbInfo = dbInfo ;
		mongoClient = new MongoClient(dbInfo.getMongoClientURI());
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
}
