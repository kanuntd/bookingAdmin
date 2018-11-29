import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.bson.Document;

import com.mongodb.MongoClient;

public class ConnectMongoDB {
	MongoClientURI connectionString;
	MongoClient Client; 
	MongoDatabase database;
	ConnectMongoDB(){
		connectionString = new MongoClientURI("mongodb://booking:booking123@ds243212.mlab.com:43212/ox");
	    Client = new MongoClient(connectionString);
	    database = Client.getDatabase("ox");
	   //System.out.println("successful");

	}
	MongoDatabase getMongoDatabase() {
		return database;
	}
	
	
   
}
