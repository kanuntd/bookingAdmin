import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.bson.Document;

import com.mongodb.MongoClient;

public class ConnectMongoDB {
	MongoClientURI connectionString;
	MongoClient Client;
	MongoDatabase database;

	ConnectMongoDB() {
		connectionString = new MongoClientURI("mongodb://admin:root1234@ds147890.mlab.com:47890/roombooking");
		Client = new MongoClient(connectionString);
		database = Client.getDatabase("roombooking");
		System.out.println("successful");
	}

	MongoDatabase getMongoDatabase() {
		return database;
	}
}
