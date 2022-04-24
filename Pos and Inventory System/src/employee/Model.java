package employee;

import java.util.Date;

public class Model 
{
	private int quantity,item_code;
	private double price,total,discount_percentage,discount_amount;
	private Date mydate;
	
	
	public double getDiscount_percentage() {
		return discount_percentage;
	}
	public void setDiscount_percentage(double discount_percentage) {
		this.discount_percentage = discount_percentage;
	}
	public double getDiscount_amount() {
		return discount_amount;
	}
	public void setDiscount_amount(double discount_amount) {
		this.discount_amount = discount_amount;
	}
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getPrice()
	{
		return price;
	}

	public double getTotal() {
		return total;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public java.sql.Date getMydate() {
		return (java.sql.Date) mydate;
	}
	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}

	private String item_name;


	
	

}
