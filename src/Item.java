public class Item {
	private String name;
	private int price;

	public Item(String name, int price){
		this.name = name;
		this.price = price;
	}

	public Item(){
		this("N/N");
	}

	public Item(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString(){
		return name + " за " + price + " эре";
	}
}
