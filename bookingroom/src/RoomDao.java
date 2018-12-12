import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class RoomDao {
	ConnectMongoDB connect;
	MongoDatabase database;
	Document doc;
	MongoCursor<Document> cursor;

	RoomDao() {
		connect = new ConnectMongoDB();
		database = connect.getMongoDatabase();
	}

	ArrayList<Booking> getRoomAll() {
		MongoCollection<Document> collection = database.getCollection("Booking");
		MongoCursor<Document> cursor = collection.find().iterator();
		ArrayList<Booking> getRoom = new ArrayList<Booking>();
		try {
			while(cursor.hasNext()) {
				Document obj = cursor.next();
				String room = null;
				String size = null;
				String username = null;
				//System.out.println(obj);
				String date = (String) obj.get("date");
				String timeStart = (String) obj.get("timeStart");
				String timeEnd = (String) obj.get("timeEnd");
				String status = (String) obj.get("status");
				ArrayList<Document> Room = (ArrayList<Document>) obj.get("Room");
				for(Document result : Room) {
					 room = (String) result.get("room");
					 size = (String) result.get("size");
				}
				ArrayList<Document> User = (ArrayList<Document>) obj.get("User");
				for(Document result : User) {
					username = (String) result.get("username");
					
				}
				Room rooms = new Room(room,size);
				User users = new User(username);
				Booking booking = new Booking(date, timeStart, timeEnd, status, rooms, users);
				getRoom.add(booking);
			}
			
		} finally {
		    cursor.close();
		}
		return getRoom;


	}
	////////////////////////////////////////////////////////////////////////////story 6////////////////////////////////////////////
	ArrayList<Booking> getBooking() {
		MongoCollection<Document> collection = database.getCollection("Booking");
		MongoCursor<Document> cursor = collection.find().iterator();
		ArrayList<Booking> history = new ArrayList<Booking>();
		try {
			while(cursor.hasNext()) {
				Document obj = cursor.next();
				String room = null;
				String size = null;
				String username = null;
				//System.out.println(obj);
				String date = (String) obj.get("date");
				String timeStart = (String) obj.get("timeStart");
				String timeEnd = (String) obj.get("timeEnd");
				String status = (String) obj.get("status");
				ArrayList<Document> Room = (ArrayList<Document>) obj.get("Room");
				for(Document result : Room) {
					 room = (String) result.get("room");
					 size = (String) result.get("size");
				}
				ArrayList<Document> User = (ArrayList<Document>) obj.get("User");
				for(Document result : User) {
					username = (String) result.get("username");
					
				}
				Room rooms = new Room(room,size);
				User users = new User(username);
				Booking booking = new Booking(date, timeStart, timeEnd, status, rooms, users);
				history.add(booking);
			}
			
		} finally {
		    cursor.close();
		}
		return history;
	}
}

