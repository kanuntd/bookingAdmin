import java.util.ArrayList;
import java.util.Arrays;
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

///////////////////////////////////////////////////////////////Story 1/////////////////////////////////////////////////////////////////////////////
	ArrayList<Booking> getRoomAll() {
		MongoCollection<Document> collection = database.getCollection("Booking");
		MongoCursor<Document> cursor = collection.find().iterator();
		ArrayList<Booking> getRoom = new ArrayList<Booking>();
		try {
			while (cursor.hasNext()) {
				Document obj = cursor.next();
				String room = null;
				String size = null;
				String username = null;
				String date = (String) obj.get("date");
				String timeStart = (String) obj.get("timeStart");
				String timeEnd = (String) obj.get("timeEnd");
				String status = (String) obj.get("status");
				ArrayList<Document> Room = (ArrayList<Document>) obj.get("Room");
				for (Document result : Room) {
					room = (String) result.get("room");
					size = (String) result.get("size");
				}
				ArrayList<Document> User = (ArrayList<Document>) obj.get("User");
				for (Document result : User) {
					username = (String) result.get("username");

				}
				Room rooms = new Room(room, size);
				User users = new User(username);
				Booking booking = new Booking(date, timeStart, timeEnd, status, rooms, users);
				getRoom.add(booking);
			}

		} finally {
			cursor.close();
		}
		return getRoom;

	}

	//////////////////////////////////////////////////////////////////////////// story
	//////////////////////////////////////////////////////////////////////////// 6////////////////////////////////////////////
	ArrayList<Booking> getBooking() {
		MongoCollection<Document> collection = database.getCollection("Booking");
		MongoCursor<Document> cursor = collection.find().iterator();
		ArrayList<Booking> history = new ArrayList<Booking>();
		try {
			while (cursor.hasNext()) {
				Document obj = cursor.next();
				String room = null;
				String size = null;
				String username = null;
				String date = (String) obj.get("date");
				String timeStart = (String) obj.get("timeStart");
				String timeEnd = (String) obj.get("timeEnd");
				String status = (String) obj.get("status");
				ArrayList<Document> Room = (ArrayList<Document>) obj.get("Room");
				for (Document result : Room) {
					room = (String) result.get("room");
					size = (String) result.get("size");
				}
				ArrayList<Document> User = (ArrayList<Document>) obj.get("User");
				for (Document result : User) {
					username = (String) result.get("username");

				}
				Room rooms = new Room(room, size);
				User users = new User(username);
				Booking booking = new Booking(date, timeStart, timeEnd, status, rooms, users);
				history.add(booking);
			}

		} finally {
			cursor.close();
		}
		return history;
	}

	public void updateData() {
		MongoCollection<Document> collection = database.getCollection("Booking");

		doc = new Document();
		doc.append("timeStart", "09:31");

		Document doc1 = new Document();
		doc1.append("User", Arrays.asList(new Document("username", "lllllllll")));

		Document update = new Document();
		update.append("$set", doc1);

		collection.updateOne(doc, update);
	}

	boolean updateBooking(ArrayList<Booking> arr) {
		MongoCollection<Document> collection = database.getCollection("Booking");
		System.out.println(arr.get(0).user.username + " " + arr.get(0).timeStart + " " + arr.get(0).timeEnd);

		doc = new Document();
		doc.append("timeStart", arr.get(0).timeStart);
		Document doc1 = new Document();
		doc1.append("User", Arrays.asList(new Document("username", arr.get(0).user.username))).append("status",
				"false");

		Document update = new Document();
		update.append("$set", doc1);

		collection.updateOne(doc, update);
		return true;

	}

	boolean checkUserName(String username) {
		int i = 0;
		MongoCollection<Document> collection = database.getCollection("User");
		Document doc = new Document().append("username", username);
		MongoCursor<Document> cursor = collection.find(doc).iterator();
		while (cursor.hasNext()) {
			i++;
			cursor.next();
		}
		if (i > 0) {
			return false;
		}
		return true;
	}

	boolean insert(ArrayList<User> arr) {

		MongoCollection<Document> collection = database.getCollection("User");
		Document doc = new Document().append("Username", arr.get(0).username).append("Password", arr.get(0).password)
				.append("status", arr.get(0).status);

		collection.insertOne(doc);
		return true;

	}

	void insertRequest(ArrayList<Booking> booking, String newDate, String newTimeStart, String newTimeEnd) {
		String date = "";
		MongoCollection<Document> collection = database.getCollection("Request");

		String json = "{\"Booking\": [\n" + "        {\n" + "            \"date\": \"" + booking.get(0).date + "\",\n"
				+ "            \"timeStart\": \"" + booking.get(0).timeStart + "\",\n" + "            \"timeEnd\": \""
				+ booking.get(0).timeEnd + "\",\n" + "            \"status\": \"" + booking.get(0).status + "\",\n"
				+ "            \"Room\": [\n" + "                {\n" + "                    \"room\": \""
				+ booking.get(0).room.room + "\",\n" + "                    \"size\": \"" + booking.get(0).room.size + "\"\n"
				+ "                }\n" + "            ],\n" + "            \"User\": [\n" + "                {\n"
				+ "                    \"username\": \"" + booking.get(0).user.username + "\"\n" + "                }\n"
				+ "            ]\n" + "        }\n" + "    ],\n" + "    \"newDate\": \"" + newDate + "\",\n"
				+ "    \"newTimeStart\": \"" + newTimeStart + "\",\n" + "    \"newTimeEnd\": \"" + newTimeEnd + "\"}";
		System.out.println(json);
		Document dbObject = Document.parse(json);

		collection.insertOne(dbObject);

	}

	ArrayList<Request> getRequest() {
		MongoCollection<Document> collection = database.getCollection("Request");
		MongoCursor<Document> cursor = collection.find().iterator();
		ArrayList<Request> requestA = new ArrayList<Request>();
		try {
			while (cursor.hasNext()) {
				Document obj = cursor.next();

				String newDate = (String) obj.get("newDate");
				String newTimeStart = (String) obj.get("newTimeStart");
				String newTimeEnd = (String) obj.get("newTimeEnd");
				///////////////////////////////////////////////////////
				String room = null;
				String size = null;
				String username = null;
				String date = null;
				String status = null;
				String timeStart = null;
				String timeEnd = null;
				ArrayList<Document> Booking = (ArrayList<Document>) obj.get("Booking");
				for (Document result : Booking) {

					ArrayList<Document> Room = (ArrayList<Document>) result.get("Room");
					for (Document result2 : Room) {
						room = (String) result2.get("room");
						size = (String) result2.get("size");
					}
					ArrayList<Document> User = (ArrayList<Document>) result.get("User");
					for (Document result3 : User) {
						username = (String) result3.get("username");

					}
					date = (String) result.get("date");
					timeStart = (String) result.get("timeStart");
					timeEnd = (String) result.get("timeEnd");
					System.out.println(result.get("timeEnd"));
					status = (String) result.get("status");
				}
				/////////////////////////////////////////////////
				Room rooms = new Room(room, size);
				User users = new User(username);
				Booking booking = new Booking(date, timeStart, timeEnd, status, rooms, users);
				Request request = new Request(booking, newDate, newTimeStart, newTimeEnd);
				requestA.add(request);
			}

		} finally {
			cursor.close();
		}
//	for(Request read : requestA) {
//		System.out.println(read.booking.timeEnd);
//	}

		return requestA;
	}

	public void updateEditBooking(String roomNumber, String size, String userName, String dateOld, String timeStartOld,
			String timeEndOld, String dateNew, String timeStartNew, String timeEndNew) {
		Room room = new Room(roomNumber, size);
		User user = new User("userName");
		User userDefaul = new User("");

		MongoCollection<Document> collection = database.getCollection("Booking");
		// System.out.println(arr.get(0).user.username + " " +arr.get(0).timeStart + "
		// "+arr.get(0).timeEnd );

		// New
		doc = new Document();
		doc.append("date", dateNew);
		doc.append("timeStart", timeStartNew);
		doc.append("timeEnd", timeEndNew);
		doc.append("Room", Arrays.asList(new Document("room", roomNumber).append("size", size)));

		Document doc1 = new Document();
		doc1.append("User", Arrays.asList(new Document("username", userName)));
		Document update = new Document();
		update.append("$set", doc1);
		collection.updateOne(doc, update);

		Document doc2 = new Document();
		doc2.append("status", "false");
		update = new Document();
		update.append("$set", doc2);
		collection.updateOne(doc, update);

		// Old
		doc = new Document();
		doc.append("date", dateOld);
		doc.append("timeStart", timeStartOld);
		doc.append("timeEnd", timeEndOld);
		doc.append("Room", Arrays.asList(new Document("room", roomNumber).append("size", size)));
		doc.append("User", Arrays.asList(new Document("username", userName)));

		doc2 = new Document();
		doc2.append("status", "true");
		update = new Document();
		update.append("$set", doc2);
		collection.updateOne(doc, update);

		doc1 = new Document();
		doc1.append("User", Arrays.asList(new Document("username", "")));
		update = new Document();
		update.append("$set", doc1);
		collection.updateOne(doc, update);

	}

	public void deleteRequest(String roomNumber,
			String size,
			String userName,
			String dateOld,
			String timeStartOld,
			String timeEndOld,
			String dateNew,
			String timeStartNew,
			String timeEndNew) {
				Room room = new Room(roomNumber, size);
				User user = new User("userName");
				
				MongoCollection<Document> collection = database.getCollection("Request");
				doc = new Document();
				doc.append("newDate", dateNew);
				doc.append("newTimeStart", timeStartNew);
				doc.append("newTimeEnd", timeEndNew);
				
				collection.deleteMany(doc);
	}

}
/*
 * "date": "Nov 14, 2018", "timeStart": "13:00", "timeEnd": "18:00", "status":
 * "true", "Room": [ { "room": "R01", "size": "50" } ],
 */
