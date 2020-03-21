package model;

public class User {
	private String firstName;
	private String lastName;
	private String loginName;
	private int age;
	private String pwd;
	private String[] topics;
	public User() {
	}
	public User(String firstName, String lastName, String loginName, int age, String pwd,String[] topics) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginName = loginName;
		this.age = age;
		this.pwd = pwd;
		this.topics=topics;
		System.out.println("Object sucessfully created");
	}
	public String[] getTopics() {
		return topics;
	}
	public void setTopics(String[] topics) {
		this.topics = topics;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String topics) {
		this.pwd = topics;
	}
	
}
