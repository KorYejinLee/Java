package db;

import java.time.LocalDateTime;

public class User {
	private String userName = "이씨유"; // 사용자 이름
	private String userId = "cu"; // 사용자 id
	private String userPW = "1234"; // 사용자 password
	private int dailyWage; // 일당
	private LocalDateTime LoginTime; // 로그인 시간
	private LocalDateTime LogOutTime; // 로그아웃 시간
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public int getDailyWage() {
		return dailyWage;
	}
	public void setDailyWage(int dailyWage) {
		this.dailyWage = dailyWage;
	}
	public LocalDateTime getLoginTime() {
		return LoginTime;
	}
	public void setLoginTime(LocalDateTime loginTime) {
		LoginTime = loginTime;
	}
	public LocalDateTime getLogOutTime() {
		return LogOutTime;
	}
	public void setLogOutTime(LocalDateTime logOutTime) {
		LogOutTime = logOutTime;
	}
	
}