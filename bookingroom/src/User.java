
public class User {
	String username,password,status;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username) {
	this.username = username;
	}
	
	public User(String user,String password,String status){
    	this.username = user;
    	this.password = password;
    	this.status = status;
    }
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
