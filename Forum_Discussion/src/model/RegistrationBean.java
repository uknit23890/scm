package model;

public class RegistrationBean {
	
	String userid;
	String password;
	String confirmPassword;
	String name;
	char gender;
	int age;
	String city;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public boolean comparePasswords(){
		if(password.equals(confirmPassword))
			return true;
		else
			return false;
	}
	

	public boolean checkDataValidity(){
		if(userid == null || userid.equals(""))
			return false;
		
		if(password == null || password.equals(""))
			return false;
		
		if(confirmPassword == null || confirmPassword.equals(""))
			return false;
		
		if(name == null || name.equals(""))
			return false;
		
		return true;
	}
}
