package logic;

import java.time.Duration;
import java.time.LocalDateTime;

import db.Product;

public class ExpirationDate extends Product {

	public ExpirationDate(String _productName, int _productPrice, int _productAmount, boolean _isProhibited,
			LocalDateTime _expirationDate) {
		super(_productName, _productPrice, _productAmount, _isProhibited, _expirationDate);
		// TODO Auto-generated constructor stub
	}
	
   public void showRemainingTime() {
	   System.out.println("══════════════════════════════════════════");
	   System.out.println("                  유통기한");
	   System.out.println("══════════════════════════════════════════");
       System.out.printf("%-10s\t%s\t\n", "상품명", "유통기한");
       for (Product product : getProductes()) {
           LocalDateTime expirationDateTime = product.getExpirationDate();
           if (expirationDateTime != null) {
               Duration remainingTime = Duration.between(LocalDateTime.now(), expirationDateTime);

               if (remainingTime.isNegative() || remainingTime.isZero()) {
                   System.out.println("══════════════════════════════════════════");
                   System.out.printf("%-10s\t유통기한 만료\n", product.getProductName());
                   System.out.println("══════════════════════════════════════════");
               } else {
                   long days = remainingTime.toDays();
                   long hours = remainingTime.toHours() % 24;
                   long minutes = remainingTime.toMinutes() % 60;
                   long seconds = remainingTime.getSeconds() % 60;

                   System.out.println("══════════════════════════════════════════");
                   System.out.printf("%-10s\t%d시간 %d분 %d초 남았습니다.\n", product.getProductName(), hours, minutes, seconds);
                   System.out.println("══════════════════════════════════════════");
               }
           }
       }
   }
}
