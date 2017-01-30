public class Store{

	public Store(){

	}




}

public class Item{

	private double sellPrice, buyPrice;
	private boolean inStock;
	private int amount;
	private String name;

	public Item(String name, boolean inStock){
		this.name = name;
		this.inStock = inStock;
	}

	public Item(String name){
		this.name = name;	
	}

	public Item(){
		this.name = "";
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
		this.isStock = inStock;
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