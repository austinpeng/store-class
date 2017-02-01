import java.util.ArrayList;
public class Store{

	ArrayList<Item> stock = new ArrayList<Item>();
	ArrayList<String> itemNames = new ArrayList<String>();
	String storeName;
	String owner;
	String phoneNumber;
	double longitude, latiutude;

	public Store(){
		storeName = "New Store";
		owner = "NaP";
	}

	public Store(String name, String owner, String phoneNumber, double lon, double lat){
		storeName = name;
		this.owner = owner;
		this.phoneNumber = phoneNumber;
		this.longitude = lon;
		this.latiutude = lat;
	}

	public void setNewOwner(String owner){
		this.owner = owner;
	}

	public void setPhoneNum(String phoneNum){
		this.phoneNumber = phoneNumber;
	}

	public void setLocation(double lat, double lon){
		this.latiutude = lat;
		this.longitude = lon;
	}

	public void addItem(Item newItem){
		stock.add(newItem);
		itemNames.add(newItem.getName());
	}

	public void addNewItem(String itemName, int amount, double sellPrice, double buyPrice, String description){
		stock.add(new Item(itemName, sellPrice, buyPrice, amount, description));
	}

	public boolean buyItemWithName(String name, int numberOfItems){
		if(stock.get(itemNames.indexOf(name)).soldItem(numberOfItems)) {
			return true;
		}else{
			return false;
		}
	}

	public void removeItem(String name){
		int index = itemNames.indexOf(name);
		stock.remove(index);
		itemNames.remove(index);
	}

	public double searchItemSellPrice(String itemName){
		int index = itemNames.indexOf(itemName);
		return stock.get(index).getSellPrice();
	}

	public double searchItemBuyPrice(String itemName){
		int index = itemNames.indexOf(itemName);
		return stock.get(index).getBuyPrice();	
	}

	public int searchItemStock(String itemName){
		int index = itemNames.indexOf(itemName);
		return stock.get(index).getAmout();
	}

	public boolean searchIsInStock(String itemName){
		int index = itemNames.indexOf(itemName);
		return stock.get(index).isInStock();
	}

}

class Item{

	private double sellPrice, buyPrice;
	private boolean inStock;
	private int amount;
	private String name;
	private String description;

	public Item(String name, double sellPrice, double buyPrice, int amount, String description){
		this.name = name;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.amount = amount;
		this.description = description;
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

	public boolean soldItem(int numberOfItems){
		if(amount < 1) return false;
		amount -= numberOfItems;
		return true;
	}

	public void setDescription(String description){
		this.description = description;
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

	public String getDescription(){
		return description;
	}

}