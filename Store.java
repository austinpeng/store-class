public class Store{

	public Store(){

	}




}

public class Item{

	double sellPrice;
	double buyPrice;
	boolean inStock;
	int amount;
	String name;

	public Item(String name, boolean inStock){
		this.name = name;
		this.inStock = inStock;
	}

	public Item(String name){
		this.name = name;	
	}

	public boughItem(int numberOfItems){
		amount -= numberOfItems
	}

	public setItemAmount(int newAmount) {
		this.amount = newAmount;
	}


}