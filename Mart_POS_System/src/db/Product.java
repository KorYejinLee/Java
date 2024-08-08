package db;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Product {
   private static Product[] productes;
   private static int size; // 객체 배열 Product 크기
   private String productName; // 물품 이름
   private int productPrice; // 물품 가격
   private int productAmount; // 물품 갯수
   private boolean isProhibited; // 19금 물품 유무
   private LocalDateTime expirationDate; // 유통기한
   private LocalDateTime currentTime = LocalDateTime.now(); // 유동기한

   
   private String[] productNames = {"술", "우유", "어묵", "두부", "담배", "과자", "컵라면", "머리끈", "물티슈", "우산"}; 
   private int[] productPrices = {2100, 4500, 2500, 1000, 1500, 1700, 1600, 1000, 1200, 8000}; 
   private int[] productAmounts = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
   private boolean[] inItProhibetedes = {true, true, false, false, false, false, false, false, false, false};
   
   public Product (String _productName, int _productPrice, int _productAmount, boolean _isProhibited, LocalDateTime _expirationDate) {
      this.productName = _productName;
      this.productPrice = _productPrice;
      this.productAmount = _productAmount;
      this.isProhibited = _isProhibited;
      this.expirationDate = _expirationDate;
   }
   
   public static void settingInitProduct (int _setSize) {
      size = _setSize;
	  productes = new Product[size];
   }
   
   public static void settingSize() {
	   size++;
	   productes = new Product[size];
   }
   
   public void generateInitProduct() {
      this.expirationDate = LocalDateTime.now();
      for (int i = 0; i < 10; ++i) {
         productes[i] = new Product(this.productNames[i], this.productPrices[i], this.productAmounts[i], this.inItProhibetedes[i], this.expirationDate);
         if(productNames[i].equals("우유") || productNames[i].equals("두부")) {
            productes[i] = new Product(this.productNames[i], this.productPrices[i], this.productAmounts[i], this.inItProhibetedes[i], this.expirationDate.plusDays(1));
         } else if(productNames[i].equals("어묵")) {
            productes[i] = new Product(this.productNames[i], this.productPrices[i], this.productAmounts[i], this.inItProhibetedes[i], this.expirationDate.plusHours(1));
         } else {
        	 productes[i] = new Product(this.productNames[i], this.productPrices[i], this.productAmounts[i], this.inItProhibetedes[i], null);
         }
      }
   }
   
   public void showProduct() {
       System.out.println("════════════════════════════════════════════════════════════════════════════════════");
       System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t\n","상품명","상품가격","상품갯수","청소년 판매여부","유통기한");
       System.out.println("════════════════════════════════════════════════════════════════════════════════════");     
       for (Product product : productes) {
		   System.out.println(product);
	   }
	   System.out.println("════════════════════════════════════════════════════════════════════════════════════");

   }
   
   public void printProductStar() {
		System.out.println("══════════════════════════════════════════");
   	for (Product product : productes) {
   	    System.out.print(product.getProductName() + " ");
   	    for (int i = 0; i < product.getProductAmount(); i++) {
   	        System.out.print("*");
   	    }
   	    System.out.println();
   	}
	System.out.println("══════════════════════════════════════════");
   }
   
   public void searchProductByName() {
       Scanner scanner = new Scanner(System.in);
   	   System.out.println("══════════════════════════════════════════");
       System.out.println("           검색할 상품명을 입력하세요: ");
   	   System.out.println("══════════════════════════════════════════");
       String searchName = scanner.nextLine();
       boolean found = false;

       for (Product product : productes) {
           if (product.getProductName().equalsIgnoreCase(searchName)) {
               System.out.println("════════════════════════════════════════════════════════════════════════════════════");
               System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t\n","상품명","상품가격","상품갯수","청소년 판매여부","유통기한");
               System.out.println("════════════════════════════════════════════════════════════════════════════════════");
               System.out.println(product);
               System.out.println("════════════════════════════════════════════════════════════════════════════════════");
               found = true;
               break;
           }
       }

       if (!found) {
       	   System.out.println("══════════════════════════════════════════");
           System.out.println("         해당 상품이 존재하지 않습니다.");
       	   System.out.println("══════════════════════════════════════════");
       }
   }

   
   public Product[] getProducts() {
		return productes;
	}

	public void setProducts(Product[] products) {
		this.productes = products;
	}

	public int[] getProductAmounts() {
		return productAmounts;
	}

	public void setProductAmounts(int[] productAmounts) {
		this.productAmounts = productAmounts;
	}
   
   public static Product[] getProductes() {
	return productes;
   }

   public static void setProductes(Product[] productes) {
	   Product.productes = productes;
   }	

   public String getProductName() {
	   return productName;
   }

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getProductAmount() {
		return productAmount;
	}
	
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	public boolean isProhibited() {
		return isProhibited;
	}
	
	public void setProhibited(boolean isProhibited) {
		this.isProhibited = isProhibited;
	}
	
	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}
   
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
	    String formattedDate = (expirationDate != null) ? expirationDate.format(formatter) : "유통기한 없음";
		return String.format("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t", 
				this.productName, 
				this.productPrice, 
				this.productAmount, 
				this.isProhibited ? "청소년 판매불가" : "청소년 판매가능", formattedDate);
   }
}
