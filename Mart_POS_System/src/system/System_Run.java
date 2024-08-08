package system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import db.Product;
import db.TotalSale;
import db.User;
import logic.ExpirationDate;
import logic.Login;
import logic.Sale;
import view.SystemView;

public class System_Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = new Product(null, 0, 0, false, null);
		User user = new User();
		Login login = new Login();
		LocalDateTime currentTime;
		Sale sale = new Sale(null, 0, 0, false, null);
		ExpirationDate ed = new ExpirationDate(null, 0, 0, false, null);
		Scanner sc = new Scanner(System.in);
		boolean logined = login.isLogined();
        boolean worked = true;
		boolean mainBack = false;

		
		SystemView sv = new SystemView(); // View 화면 
		Product.settingInitProduct(10); // 초기 물품 초기화
		product.generateInitProduct(); // 초기 물품 데이터 넣기

		sv.startView();
		sv.loginView();
		logined = login.isLogined();
	
        while(!logined) {
        	System.out.println("══════════════════════════════════════════");
		    System.out.println("              ID를 입력해주세요.");
		    System.out.println("══════════════════════════════════════════");
		    String inputId = sc.nextLine().trim(); 
		    System.out.println("══════════════════════════════════════════");
		    System.out.println("           PASSWORD를 입력해주세요.");
		    System.out.println("══════════════════════════════════════════");
		    String inputPW = sc.nextLine().trim(); 
			login.checkUserInfo(inputId, inputPW); // 유저 정보 체크
			logined = login.isLogined();
			

	        if (!logined) {
	            System.out.println("══════════════════════════════════════════");
	            System.out.printf("%16s로그인 실패%-16s\n","","");
	            System.out.println("══════════════════════════════════════════");
	        } 
        }

        while (worked) {
        	currentTime = LocalDateTime.now();
			user.setLoginTime(currentTime);
            sv.mainMenuView();
            int mainKeyCode = sv.getMainKeyCode();
            if (mainKeyCode == 1) { 
				product.showProduct();
			} else if (mainKeyCode == 2) {
				sv.balanceView();
				sale.showBalance();
			} else if (mainKeyCode == 3) { 
				sale.showSale();
			} else if (mainKeyCode == 4) { 
				ed.showRemainingTime();
			} else if (mainKeyCode == 5) {
				mainBack = false;
				while (!mainBack) {
					sv.subMenuView();
					int subKeyCode = sv.getSubKeyCode();
					switch (subKeyCode) {
	                case 1:
	                	sale.saleMenu();
	                    break;
	                case 2:
	                	sale.refundCard();
	                    break;
	                case 3:
	                    break;
	                case 4: 
	                	product.searchProductByName();
	                case 5:
	                    System.out.println("══════════════════════════════════════════");
	                    System.out.println("              메인 메뉴로 돌아갑니다.");
	                    System.out.println("══════════════════════════════════════════");
	                    mainBack = true;
	                    break;
	                default:
	                    System.out.println("══════════════════════════════════════════");
	                    System.out.println("           올바른 메뉴 번호를 입력해주세요.");
	                    System.out.println("══════════════════════════════════════════");
	                    break;
					}
				}
			} else if (mainKeyCode == 6) {
				currentTime = LocalDateTime.now();
				user.setLogOutTime(currentTime); 
				
		        int minutes1 = user.getLoginTime().getMinute();
				int minutes2 = user.getLogOutTime().getMinute();
				int dailyWagePerMinute = 9_800;
				int workTime = minutes2 - minutes1;
				user.setDailyWage((minutes2 - minutes1) * dailyWagePerMinute);

				System.out.println("══════════════════════════════════════════");
				System.out.printf("               일한 시간 : %d 분\n",workTime);
				System.out.println("══════════════════════════════════════════");
			    System.out.println("══════════════════════════════════════════");
				System.out.printf("               일당 : %s (원)\n",user.getDailyWage());
			    System.out.println("══════════════════════════════════════════");
				product.printProductStar();
				worked = false;
			}
        }
	}
}
