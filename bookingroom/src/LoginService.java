import java.util.ArrayList;

public class LoginService {
	LoginService(){
		
	}
      public ArrayList<User>checkLogin(ArrayList<User> arr) {
    	  
    	  System.out.println("LoginService runing "+arr.get(0).password);
    	  
    	  LoginDao login = new LoginDao();
    	  ArrayList<User> returnArr =  login.getUserLogin(arr);  
    	  
    	  return returnArr;
      }
}
