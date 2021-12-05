package cmpe202.individualproject;

public abstract class ItemInterface {
	String category, item;
	Integer quantity;
	Float price;
	 
	
	public ItemInterface(String category, String item, Integer quantity, Float price) {
		super();
		this.category = category;
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}
	
	public ItemInterface(String item, Integer quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
}

