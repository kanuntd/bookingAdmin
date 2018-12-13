
public class Booking {
	String date, timeStart, timeEnd, status;
	Room room = new Room();
	User user = new User();
	public Booking() {
		
	}

	public Booking(String date, String timeStart, String timeEnd, String status, Room rooms, User users) {
		this.date = date;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.status = status;
	
		this.room.room = rooms.room;
		this.room.size = rooms.size;
		this.user.username = users.username;
	}

	public Booking(String room,String date, String timeStart, String timeEnd, String status, String size, String username) {
		this.date = date;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.status = status;
		
		this.room.room = room;
		this.room.size =size;
		this.user.username = username;
	}

}
