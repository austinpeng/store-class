import java.util.Scanner;
import java.util.ArrayList;
//import Store;
public class main{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Store> stores = new ArrayList<Store>();

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
	}

	public static void defaultStore(){
		stores.add(new Store("Default", "defaultOwner", "9738738224", 74, -77));
	}











}