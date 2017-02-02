import java.util.Scanner;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
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
	JButton stockItem = new JButton("Stock Item");

	JPanel fiveButtons = new JPanel(new GridLayout(1, 5));

	static  main thisGUI;


	public static void main(String[] args){
		thisGUI = new main("TEST");
		thisGUI.setSize(650, 500);
		thisGUI.setVisible(true);
		defaultStore();

	}

	JPanel gui = new JPanel(new GridLayout(0, 1));

	public main(String name){
		super(name);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(gui);

		gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		gui.setLayout(new FlowLayout());

		fiveButtons.add(searchForItem);
		fiveButtons.add(newItem);
		fiveButtons.add(stockItem);
		fiveButtons.add(removeItem);
		fiveButtons.add(buyItem);
		gui.add(fiveButtons);

	}

	public static void defaultStore(){
		stores = new Store("Default", "defaultOwner", "9738738224", 74, -77);		
		Item firstStoreItem = new Item("");
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
