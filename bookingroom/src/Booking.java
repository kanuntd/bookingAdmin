
public class Booking {
	String date, timeStart, timeEnd, status;
	Room room = new Room();
	User user = new User();

	public Booking(String date, String timeStart, String timeEnd, String status, Room rooms, User users) {
		this.date = date;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.status = status;
		this.room.room = rooms.room;
		this.room.room = rooms.room;
		this.room.size = rooms.size;
		this.user.username = users.username;
	}

}
