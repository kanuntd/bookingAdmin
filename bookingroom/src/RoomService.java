import java.util.ArrayList;

import org.bson.Document;

public class RoomService  {
   public static ArrayList<Room> arr ;
   public static ArrayList<Room> data;
   public RoomService() {
//	   arr = new ArrayList<>();
//	   data = new ArrayList<>();
//	   Room r = new Room("50","Nov 14, 2018","08:00","09:00","R01","empty");
//	   Room r1 = new Room("50","Nov 14, 2018","09:00","10:00","R01","busy");
//	   Room r2 = new Room("50","Nov 14, 2018","10:00","11:00","R01","empty");
//	   Room r3 = new Room("50","Nov 14, 2018","11:00","12:00","R01","empty");
//	   Room r4 = new Room("50","Nov 14, 2018","12:00","13:00","R01","empty");
//	   Room r5 = new Room("50","Nov 14, 2018","13:00","14:00","R01","empty");
//	   Room r6 = new Room("50","Nov 14, 2018","14:00","15:00","R01","empty");
//	   Room r7 = new Room("50","Nov 14, 2018","16:00","17:00","R01","busy");
//	   Room r8 = new Room("50","Nov 14, 2018","18:00","19:00","R01","empty");
//	   Room r9 = new Room("50","Nov 14, 2018","19:00","20:00","R01","busy");
//	   data.add(r);
//	   data.add(r1);
//	   data.add(r2);
//	   data.add(r3);
//	   data.add(r4);
//	   data.add(r5);
//	   data.add(r6);
//	   data.add(r7);
//	   data.add(r8);
//	   data.add(r9);
//	   
	   
   }
//	public static ArrayList<Room> getRoom(String size, String date, String timeStart, String timeEnd,String room, String status){
//		RoomDao roomDao = new RoomDao();
//		arr.add(new Room(size,date,timeStart,timeEnd,room,status));
//		//roomDao.getRoomAll(arr);
//		//ArrayList<Room> s = roomDao.getRoomAll(arr);
//		ArrayList<Room> getroom = new ArrayList<>();
//		
//		for(int i=0;i<data.size();i++) {
//			if(size.equals(data.get(i).size) || size.equals("")) {
//				if(date.equals(data.get(i).date) || date.equals("")) {
//					if(timeStart.hashCode()<=data.get(i).timeStart.hashCode() || timeStart.equals("")) {
//						if(timeEnd.hashCode()>=data.get(i).timeEnd.hashCode()|| timeEnd.equals("")) {
//							if(room.equals(data.get(i).room) || room.equals("")) {
//								getroom.add(data.get(i));
//							}
//						}
//					}
//				}
//			}
//		}
//		if(getroom.isEmpty()) {
//			return getroom;
//		}
//		return getroom;
//	}
	public static void insertBooking() {
		
		
	}
	public static ArrayList<Booking> getBooking(Room room,String date,String timeEnd,String timestart){
		ArrayList<Booking> getBooking = new ArrayList<>();
		return getBooking;
	}

}
