package view;

import java.util.Scanner;

public class SystemView {
	public void loginView() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║                 로그인                   ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
	}

	public void startView() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║            Mart POS System             ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
	}
	
	public void balanceView() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║                Balance                 ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
	}
	
	public void mainMenuView() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║                Main Menu               ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("══════════════════════════════════════════");
        System.out.println("      [1] 재고 체크\t[2] 현재 잔고 체크");
        System.out.println("      [3] 매출액\t\t[4] 유통기한");
        System.out.println("      [5] 업무 시작\t[6] 업무 종료");
        System.out.println("══════════════════════════════════════════");
	}
	
	public void subMenuView() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║             Start Work Menu            ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("══════════════════════════════════════════");
        System.out.println("        [1] 물건 판매");
        System.out.println("        [2] 물건 환불");
        System.out.println("        [3] 믈픔 입고 화면");
        System.out.println("        [4] 물품 재고 및 제품 이름 검색");
        System.out.println("        [5] 돌아가기");
        System.out.println("══════════════════════════════════════════");
	}
	
	public void saleMenuView() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║              Sale Product              ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("══════════════════════════════════════════");
        System.out.println("        [1] 카드 [2] 현금 [3] 돌아가기");
        System.out.println("══════════════════════════════════════════");
	}
	
	public int getMainKeyCode() {
    	Scanner sc = new Scanner(System.in);
    	int inputValue = 0;
    	
    	while(true) {
	        try {
	            System.out.println("══════════════════════════════════════════");
	            System.out.println(            "메뉴 선택를 선택해주세요."); // 사용자 입력 프롬프트
	            System.out.println("══════════════════════════════════════════");
	            inputValue = Integer.parseInt(sc.nextLine().trim()); // 엔터 체크
	            if (inputValue < 1 || inputValue > 6) {
		            System.out.println("══════════════════════════════════════════");
	                System.out.println("         1 ~ 6 사이의 숫자를 입력해주세요.");
		            System.out.println("══════════════════════════════════════════");

	            } else {
	                break; // 올바른 값이면 반복문 종료
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("══════════════════════════════════════════");
	            System.out.println("              숫자를 입력해주세요.");
	            System.out.println("══════════════════════════════════════════");
	            sc.nextLine().trim(); // 입력 버퍼를 비워준다
	        }
	    }
    	
		return inputValue;
	}
	
	public int getSubKeyCode() {
    	Scanner sc = new Scanner(System.in);
    	int inputValue = 0;
    	
    	while(true) {
	        try {
	            System.out.println("══════════════════════════════════════════");
	            System.out.println(            "메뉴 선택를 선택해주세요."); // 사용자 입력 프롬프트
	            System.out.println("══════════════════════════════════════════");
	            inputValue = Integer.parseInt(sc.nextLine().trim()); // 엔터 체크
	            if (inputValue < 1 || inputValue > 5) {
		            System.out.println("══════════════════════════════════════════");
	                System.out.println("         1 ~ 5 사이의 숫자를 입력해주세요.");
		            System.out.println("══════════════════════════════════════════");

	            } else {
	                break; // 올바른 값이면 반복문 종료
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("══════════════════════════════════════════");
	            System.out.println("              숫자를 입력해주세요.");
	            System.out.println("══════════════════════════════════════════");
	            sc.nextLine().trim(); // 입력 버퍼를 비워준다
	        }
	    }
    	
		return inputValue;
	}
	
	public int getSaleKeyCode() {
    	Scanner sc = new Scanner(System.in);
    	int inputValue = 0;
    	
    	while(true) {
	        try {
	            System.out.println("══════════════════════════════════════════");
	            System.out.println(            "메뉴 선택를 선택해주세요."); // 사용자 입력 프롬프트
	            System.out.println("══════════════════════════════════════════");
	            inputValue = Integer.parseInt(sc.nextLine().trim()); // 엔터 체크
	            if (inputValue < 1 || inputValue > 3) {
		            System.out.println("══════════════════════════════════════════");
	                System.out.println("         1 ~ 3 사이의 숫자를 입력해주세요.");
		            System.out.println("══════════════════════════════════════════");

	            } else {
	                break; // 올바른 값이면 반복문 종료
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("══════════════════════════════════════════");
	            System.out.println("              숫자를 입력해주세요.");
	            System.out.println("══════════════════════════════════════════");
	            sc.nextLine().trim(); // 입력 버퍼를 비워준다
	        }
	    }
    	
		return inputValue;
	}
}


