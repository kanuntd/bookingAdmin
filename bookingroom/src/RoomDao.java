import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class RoomDao {
    ConnectMongoDB connect;
    MongoDatabase database;
    Document doc;
    MongoCursor<Document> cursor;
	RoomDao(){
	  connect = new ConnectMongoDB();
	  database = connect.getMongoDatabase();
    }
	
	ArrayList<Room> getRoomAll(ArrayList<Room> arr2) {
		MongoCollection  collection = database.getCollection("Booking");
	
		//System.out.println(arr2.get(0).size);
			doc = new Document("size",arr2.get(0).size);
			cursor = collection.find(doc).iterator();	
		
		

		
		ArrayList<Room> arr = new ArrayList<>();
		try {
		    while (cursor.hasNext()) {
		    Document a=	cursor.next();
		    	
               //arr.add(new Room((String)a.get("size"),(String)a.get("date"),(String)a.get("timeStart"),(String)a.get("timeEnd"),(String)a.get("room"),(String)a.get("status")));
		    }
		} finally {
		    cursor.close();
		}
    return arr;
	
	}
	
}
