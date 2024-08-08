package logic;

import java.time.LocalDateTime;

import db.User;

public class Login extends User {

	private boolean isLogined = false; // 로그인 여부 체크
	
	public boolean checkUserInfo(String userId, String userPW) {  
		if (getUserId().equals(userId)) {
			if (getUserPW().equals(userPW)) {
		        System.out.println("══════════════════════════════════════════");
	 			System.out.printf("%10s%s님께서 로그인 되었습니다.%-10s\n","",getUserName(),"");
		        System.out.println("══════════════════════════════════════════");
				this.isLogined = true;
			} else if (!getUserPW().equals(userPW)) {
		        System.out.println("══════════════════════════════════════════");
	            System.out.printf("%13s비밀번호가 틀렸습니다.%-13s\n","","");
		        System.out.println("══════════════════════════════════════════");
				this.isLogined = false;
			}
			
		} 
		
		else if (!getUserId().equals(userId)) {
			if (getUserPW().equals(userPW)) {
		        System.out.println("══════════════════════════════════════════");
	            System.out.printf("%10s찾을 수 없는 사용자 입니다.%-10s\n","","");
		        System.out.println("══════════════════════════════════════════");
			} else if (!getUserPW().equals(userPW)) {
		        System.out.println("══════════════════════════════════════════");
	            System.out.printf("%10s찾을 수 없는 사용자 입니다.%-10s\n","","");
		        System.out.println("══════════════════════════════════════════");
			} this.isLogined = false;		
		}
		return this.isLogined;
	}
	
	public boolean isLogined() {
		return isLogined;
	}
	
	public void setLogined (boolean isLogined) {
		this.isLogined = isLogined;
	}
}
