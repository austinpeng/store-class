import java.util.Scanner;
import java.util.ArrayList;
//import Store;
public class main{
	static Scanner sc = new Scanner(System.in);
	static Store stores = new Store();

	public static void main(String[] args){
		System.out.println("Do you want to create a new store or see an existing one?");
		if(sc.next().contains("new")){
			MakeNewStore();
		}else{
			defaultStore();
		}
	}

	public static void MakeNewStore(){
		System.out.println("What is the name of the new store?");
		String name = sc.next();

		System.out.println("What is your name?");
		String owner = sc.next();

		System.out.println("What is your phone number?");
		String number = sc.next();

		System.out.println("What is the location (Latitude Longitude) of the store?");
		double lat = sc.nextDouble();
		double lon = sc.nextDouble();
		stores.add(new Store(name, owner, number, lat, lon));
		doAction();
	}

	public static void defaultStore(){
		stores = new Store("Default", "defaultOwner", "9738738224", 74, -77);		
		doAction();
	}

	public static void doAction(){
		System.out.println("What action do you want to do?\n(add, buy, remove, search)");
		switch(sc.next()){
			case "add" : add(); break;
			case "buy" : search(); break;
			case "remove" : remove(); break;
			case "search" : search(); break;
			default : break;
		} 		
	}

	public static void search(){
		System.out.println("Please type the name of the item");
		String name = sc.next();
	}

	public static void add(){
		System.out.println("Please type the name of the item");
		String name = sc.next();
	}

	public static void remove(){
		System.out.println("Please type the name of the item");
		String name = sc.next();
	}

	public static void buy(){
		System.out.println("Please type the name of the item");
		String name = sc.next();
	}
	
}