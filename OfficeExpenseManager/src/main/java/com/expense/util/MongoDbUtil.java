package com.expense.util;

import java.util.List;

import com.expense.constants.MongoDbConstants;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class MongoDbUtil 
{
	public static MongoClient mongoClient = null;
	public static MongoDatabase mongoDatabase = null;
	public static DB jongoDB = null;
	
	static 
	{
		initializeDB();
	}

	private static void initializeDB() 
	{
		if(mongoClient==null)
		{
			List<ServerAddress> serverAddresses = MongoDbConstants.getMongoServerAddresses();
			System.out.println("Size of ServerAddress :- "+serverAddresses.size());
			if (serverAddresses != null && serverAddresses.size() > 1) 
			{
				MongoClientOptions.Builder builder=new MongoClientOptions.Builder();
				builder.maxConnectionIdleTime(50000);
				builder.sslEnabled(true);
				
				MongoClientOptions options=builder.build();
				mongoClient=new MongoClient(serverAddresses,options);
				mongoClient.slaveOk();
			}
			else
				mongoClient=new MongoClient(serverAddresses);
		}
		if(mongoDatabase==null)
			mongoDatabase=mongoClient.getDatabase(MongoDbConstants.MONGODB_DATABASE);
		if (jongoDB == null)
			jongoDB =new DB(mongoClient, MongoDbConstants.MONGODB_DATABASE);
	}
	
	public static DB getDB() 
	{
		if (jongoDB == null) 
			initializeDB();
		return jongoDB;
	}
}
















