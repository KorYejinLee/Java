package db;

import java.time.LocalDateTime;

public class TotalSale extends Product {
	public TotalSale(String _productName, int _productPrice, int _productAmount, boolean _isProhibited,
			LocalDateTime _expirationDate) {
		super(_productName, _productPrice, _productAmount, _isProhibited, _expirationDate);
		// TODO Auto-generated constructor stub
	}

	private int revenueTotal = 0;
	private int balance = 395_000;

	public int getSale() {
		return revenueTotal;
	}

	public void addSale(int _revenue) {
		this.revenueTotal += _revenue;
	}
	
	public void minSale(int _revenue) {
		this.revenueTotal -= _revenue;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void addBalance(int _billSale) {
		this.balance += _billSale;
	}
	
	public void showSale() {
        System.out.println("══════════════════════════════════════════");
        System.out.printf("             매출액은 %s (원) 입니다.\n", getSale());
        System.out.println("══════════════════════════════════════════");
	}
	
	public void showBalance() {
        System.out.println("══════════════════════════════════════════");
        System.out.printf("          현재 잔고는 %s (원) 입니다.\n", getBalance());
        System.out.println("══════════════════════════════════════════");
	}
}
