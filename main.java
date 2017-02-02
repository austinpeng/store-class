import java.util.Scanner;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//import Store
public class main extends JFrame implements ActionListener{
	static Scanner sc = new Scanner(System.in);
	static Store stores = new Store();

	JButton searchForItem = new JButton("Search");
	JButton buyItem = new JButton("Buy Item");
	JButton newItem = new JButton("New Item");
	JButton removeItem = new JButton("Remove Item");
	JButton storckItem = new JButton("Stock Item");

	static  main thisGUI;


	public static void main(String[] args){
		thisGUI = new main("TEST");
		thisGUI.setSize(475, 500);
		thisGUI.setVisible(true);

		//System.out.println("Do you want to create a new store or see an existing one?");
		//if(sc.next().contains("new")){
		//	MakeNewStore();
		//}else{
		defaultStore();
		//}

	}

	public main(String name){
		super(name);
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
		stores = new Store(name, owner, number, lat, lon);
		doAction();
	}

	public static void defaultStore(){
		stores = new Store("Default", "defaultOwner", "9738738224", 74, -77);		
		doAction();
	}

		@Override
	public void actionPerformed(ActionEvent e){
	}

	public static void search(){




	}

	public static void add(){
		
		
	}

	public static void remove(){
		
		
	}

	public static void buy(){
		
		
	}
	
}
