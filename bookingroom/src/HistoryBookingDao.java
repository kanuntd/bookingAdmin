import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class HistoryBookingDao {
	ConnectMongoDB connect;
	MongoDatabase database;
	Document doc;
	MongoCursor<Document> cursor;

	HistoryBookingDao() {
		connect = new ConnectMongoDB();
		database = connect.getMongoDatabase();
	}
	
	
	public ArrayList<Booking> getHistoryBooking(String username) {
		MongoCollection collection = database.getCollection("Booking");
		ArrayList<Booking> getHistoryBooking = new ArrayList<Booking>();
		doc = new Document("User",new Document("username",username));
		MongoCursor<Document> cursor = collection.find(doc).iterator();
		try {
			while (cursor.hasNext()) {
				Document a = cursor.next();
				ArrayList<Document> Room = (ArrayList<Document>) a.get("Room");
				String room = null;
				String size = null;	
				String date = null;
				String timeStart = null;
				String timeEnd = null;
				String status = null;
				for(Document result : Room) {
					 room = (String) result.get("room");
					 size = (String) result.get("size");
				}
               
                ArrayList<Document> User = (ArrayList<Document>) a.get("User");
				for(Document result : User) {
					username = (String) result.get("username");
					
				}
				Room rooms = new Room(room,size);
				User users = new User(username);
				
				Booking booking = new Booking(room,(String) a.get("date"), (String) a.get("timeStart"),
						(String) a.get("timeEnd"),(String) a.get("status"),size,username);
				getHistoryBooking.add(booking);
//				getHistoryBooking.add(new Booking(room,size, (String) a.get("date"), (String) a.get("timeStart"),
//						(String) a.get("timeEnd"),(String) a.get("status"),users));
			}
			cursor.close();
		} finally {
			cursor.close();

		}
		return getHistoryBooking;
	}
}
