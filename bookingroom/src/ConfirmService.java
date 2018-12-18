import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ConfirmService {
	public static ArrayList<Request> getRequest() { 
		RoomDao dao = new RoomDao();
		return dao.getRequest();
	}
	
	public static boolean updateEditBooking(String roomNumber,
			String size,
			String userName,
			String dateOld,
			String timeStartOld,
			String timeEndOld,
			String dateNew,
			String timeStartNew,
			String timeEndNew)
			{
				Room room = new Room(roomNumber, size);
				ArrayList<Booking> arr = new ArrayList<>();
				arr = searchBooking(room, dateNew, timeStartNew, timeEndNew);
				ConfirmStatus confirmStatus = new ConfirmStatus();
//				System.out.println(arr.size());
//				System.out.println(arr.get(0).date);
//				System.out.println(arr.get(0).timeEnd);
//				System.out.println(arr.get(0).timeStart);
//				System.out.println(arr.get(0).room.room);
				if(arr.get(0).status.equals("true")) {
					RoomDao dao = new RoomDao();
					//update booking
					dao.updateEditBooking(roomNumber, size, userName, dateOld, timeStartOld, timeEndOld, dateNew, timeStartNew, timeEndNew);
					//delete request
					dao.deleteRequest(roomNumber, size, userName, dateOld, timeStartOld, timeEndOld, dateNew, timeStartNew, timeEndNew);
					//show อนุมัติสำเร็จ
					//confirmStatus.showTable();
					JOptionPane.showMessageDialog(null, "Approve success");
					return true;
					//System.out.println("Go");			
					
				}else {
					//delete request
					RoomDao dao = new RoomDao();
					dao.deleteRequest(roomNumber, size, userName, dateOld, timeStartOld, timeEndOld, dateNew, timeStartNew, timeEndNew);
					confirmStatus.showTable();
					JOptionPane.showMessageDialog(null, "Approve fail");
					return false;	
				}
				
			}
	
	public static ArrayList<Booking> searchBooking(Room room, String date, String timestart, String timeEnd) {
		RoomDao dao = new RoomDao();
		ArrayList<Booking> history = new ArrayList<>();
		for (Booking read : dao.getBooking()) {
			if (true) {///////////////////////// ****
				if (room.room.equals("") || room.room.equals(read.room.room)) {
					if (room.size.equals("") || room.size.equals(read.room.size)) {
						if (date.equals(read.date)) {
							int start = 0;
							int end = 0;
							int dbstart = Integer.parseInt(read.timeStart.substring(0, 2));
							int dbend = Integer.parseInt(read.timeEnd.substring(0, 2));
							if (timestart.equals("") && timeEnd.equals("")) {
								history.add(new Booking(read.date, read.timeStart, read.timeEnd, read.status, read.room, read.user));
							} else if (timestart.equals("")) {
								end = Integer.parseInt(timeEnd.substring(0, 2));
								if (end>=dbend) {
									history.add(new Booking(read.date, read.timeStart, read.timeEnd, read.status, read.room, read.user));
								}
							} else if (timeEnd.equals("")) {
								start = Integer.parseInt(timestart.substring(0, 2));
								if (start<=dbstart) {
									history.add(new Booking(read.date, read.timeStart, read.timeEnd, read.status, read.room, read.user));
								}
							} else {
								start = Integer.parseInt(timestart.substring(0, 2));
								end = Integer.parseInt(timeEnd.substring(0, 2));
								if (start<=dbstart&&end>=dbend) {
									history.add(new Booking(read.date, read.timeStart, read.timeEnd, read.status, read.room, read.user));
								}
							}
						}
					}
				}
			}
		}
//		for(Booking g : history) {
//			System.out.println(g.user.username);
//			System.out.println("test");
//		}
		return history;
	}
}
