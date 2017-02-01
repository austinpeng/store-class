import java.util.ArrayList;
public class Store{

	ArrayList<Item> stock = new ArrayList<Item>();
	ArrayList<String> itemNames = new ArrayList<String>();
	String storeName;

	public Store(){
		storeName = "New Store";
	}

	public Store(String name){
		storeName = name;
	}

	public Store(String name, ArrayList<Item> items){
		stock = items;
		storeName = name;
		for(Item i : items) itemNames.add(i.getName());
	}

	public void addItem(Item newItem){
		stock.add(newItem);
	}

	public void addNewItem(String itemName){
		stock.add(new Item(itemName));
	}

	public void addNewItem(String itemName, int amount){
		stock.add(new Item(itemName, amount));
	}

	public void addNewItem(String itemName, int amount, double sellPrice, double buyPrice){
		stock.add(new Item(itemName, sellPrice, buyPrice, amount));
	}

}

class Item{

	private double sellPrice, buyPrice;
	private boolean inStock;
	private int amount;
	private String name;

	public Item(String name, double sellPrice, double buyPrice){
		this.name = name;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
	}

	public Item(String name, double sellPrice, double buyPrice, int amount){
		this.name = name;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.amount = amount;
		if (amount > 0) this.inStock = true;
	}

	public Item(String name, int amount){
		this.name = name;
		this.amount = amount;
		if (amount > 0) this.inStock = true;
	}

	public Item(String name){
		this.name = name;	
	}


	public Item(){
		this.name = "New Store Item";
	}

	public void addItem(int numberOfItems){
		amount += numberOfItems;
	}

	public void soldItem(int numberOfItems){
		amount -= numberOfItems;
	}

	public void setItemAmount(int newAmount) {
		this.amount = newAmount;
	}

	public void setSellPrice(double sellPrice){
		this.sellPrice = sellPrice;
	}

	public void setBuyPrice(double buyPrice){
		this.buyPrice = buyPrice;
	}

	public void setStock(boolean isStock, int stockAmmount){
		this.inStock = inStock;
		if (!isStock){
			stockAmmount = 0;
		}else{
			stockAmmount = stockAmmount;
		}
	}

	public double getBuyPrice(){
		return this.buyPrice;
	}

	public double getSellPrice(){
		return this.sellPrice;
	}

	public String getName(){
		return name;
	}

	public int getAmout(){
		return amount;
	}

	public boolean isInStock(){
		return inStock;
	}

}