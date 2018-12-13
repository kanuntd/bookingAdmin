
public class Request {
Booking booking = new Booking();
String newDate, newTimeStart, newTimeEnd;

Request(Booking booking, String newDate, String newTimeStart, String newTimeEnd){
	this.booking = booking;
	this.newDate = newDate;
	this.newTimeStart = newTimeStart;
	this.newTimeEnd = newTimeEnd;
}
}
