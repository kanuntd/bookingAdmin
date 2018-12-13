import java.util.ArrayList;

public class HistoryBookingService {

	ArrayList<Booking> getHistoryBooking(String arr) {
		HistoryBookingDao dao = new HistoryBookingDao();
		ArrayList<Booking> arr2 = dao.getHistoryBooking(arr);
		return arr2;
	}

}
