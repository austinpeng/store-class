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

	public String getStoreName(){
		return storeName;
	}

	public String getOwner(){
		return owner;
	}

	public String getPhone(){
		return phoneNumber;
	}

	public  double getLong(){
		return longitude;
	}

	public double getLat(){
		return latiutude;
	}

	public void setAttributes(String name, String owner, String phone, double lon, double lat){
		this.storeName = name;
		this.owner = owner;
		this.phoneNumber = phone;
		this.latiutude = lat;
		this.longitude = lon;
	}

	public void addItem(Item newItem){
		stock.add(newItem);
		itemNames.add(newItem.getName());
		System.out.println("Item added with name " + newItem.getName());
	}

	public boolean buyItemWithName(String name, int numberOfItems){
		if(stock.get(itemNames.indexOf(name)).soldItem(numberOfItems)) {
			return true;
		}else{
			return false;
		}
	}

	public void restockItem(String name, int amount){
		int index = itemNames.indexOf(name);
		stock.get(index).restockItem(amount);
	}

	public void removeItem(String name){
		int index = itemNames.indexOf(name);
		stock.remove(index);
		itemNames.remove(index);
	}

	public String searchItemSellPrice(String itemName){
		int index = itemNames.indexOf(itemName);
		return Double.toString(stock.get(index).getSellPrice());
	}

	public String searchItemBuyPrice(String itemName){
		int index = itemNames.indexOf(itemName);
		return Double.toString(stock.get(index).getBuyPrice());	
	}

	public String searchItemStock(String itemName){
		int index = itemNames.indexOf(itemName);
		return Integer.toString(stock.get(index).getAmout());
	} 

	public boolean searchIsInStock(String itemName){
		int index = itemNames.indexOf(itemName);
		return stock.get(index).isInStock();
	}

	public String searchItemDescription(String itemName){
		int index = itemNames.indexOf(itemName);
		return stock.get(index).getDescription();
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

	public Item(String name, double sellPrice, int amount, String description){
		this.name = name;
		this.sellPrice = sellPrice;
		this.buyPrice = 3 * sellPrice;
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
		if(numberOfItems > amount) return false;
		amount -= numberOfItems;
		return true;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public void restockItem(int amount){
		this.amount += amount;
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