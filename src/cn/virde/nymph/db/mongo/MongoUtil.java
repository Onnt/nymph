package cn.virde.nymph.db.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import cn.virde.nymph.db.sql.DBConnInfo;

public class MongoUtil {
	private MongoClient mongoClient ;
	private DBConnInfo dbInfo ; 
	public MongoUtil(DBConnInfo dbInfo){
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
}
