package com.expense.constants;

import java.util.ArrayList;
import java.util.List;
import com.mongodb.ServerAddress;

public class MongoDbConstants 
{
	
	public static final String MONGODB_HOST="localhost";
	public static final int MONGODB_PORT=27017;
	public static final String MONGODB_DATABASE="expense";
	
	public static List<ServerAddress> getMongoServerAddresses() 
	{
		List<ServerAddress> serverAddressList = new ArrayList<ServerAddress>();
		serverAddressList.add(new ServerAddress(MONGODB_HOST, MONGODB_PORT));
		return serverAddressList;
	}

}