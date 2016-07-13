package com.a2zcinema.entity;

public class Users implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailId;
	private String gender;
	
	public Users() {
	}
	
	/*@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)*/
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/*@Column(name = "username", unique = true, nullable = false)*/
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	/*@Column(name = "password")*/
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*@Column(name = "first_name", length = 50)*/
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/*@Column(name = "last_name", length = 50)*/
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/*@Column(name = "email_id", unique = true)*/
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", gender=" + gender + "]";
	}
	
	
}
