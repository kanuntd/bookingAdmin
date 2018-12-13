import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class LoginDao {
	ConnectMongoDB connect;
	MongoDatabase database;
	Document doc;
	MongoCursor<Document> cursor;

	LoginDao() {
		connect = new ConnectMongoDB();
		database = connect.getMongoDatabase();
	}
	public ArrayList<User> getUserLogin(ArrayList<User> arr2){
		
		System.out.println("LoginDao runing");
		MongoCollection collection = database.getCollection("User");
		ArrayList<User> arr = new ArrayList<>();
		doc = new Document("Username", arr2.get(0).username).append("Password", arr2.get(0).password);
		cursor = collection.find(doc).iterator();
		try {
			while (cursor.hasNext()) {
				Document a = cursor.next();

				arr.add(new User((String) a.get("Username"), (String) a.get("Password"), (String) a.get("status")));
			}
			cursor.close();
		} finally {
			cursor.close();

		}
		return arr;
	}
}
