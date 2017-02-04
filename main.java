
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Iterator;
import java.io.*;

public class main extends JFrame implements ActionListener{
	Store store = new Store();

	JButton searchForItem = new JButton("Search");
	JButton buyItem = new JButton("Buy Item");
	JButton newItem = new JButton("New Item");
	JButton removeItem = new JButton("Remove Item");
	JButton stockItem = new JButton("Stock Item");
	JButton atributeStore = new JButton("Store");
	JButton saveStore = new JButton("Save");

	JPanel fiveButtons = new JPanel(new GridLayout(1, 7));

	static main thisGUI;


	public static void main(String[] args){
		thisGUI = new main("Store");
		thisGUI.setSize(890, 300);
		thisGUI.setVisible(true);
		thisGUI.setUpStore();
	}

	JPanel gui = new JPanel(new GridLayout(0, 1));

	public main(String name){
		super(name);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(gui);

		gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		gui.setLayout(new FlowLayout());

		searchForItem.addActionListener(this);
		newItem.addActionListener(this);
		stockItem.addActionListener(this);
		removeItem.addActionListener(this);
		buyItem.addActionListener(this);
		atributeStore.addActionListener(this);
		saveStore.addActionListener(this);

		fiveButtons.add(searchForItem);
		fiveButtons.add(newItem);
		fiveButtons.add(stockItem);
		fiveButtons.add(removeItem);
		fiveButtons.add(buyItem);
		fiveButtons.add(atributeStore);
		fiveButtons.add(saveStore);
		gui.add(fiveButtons);

	}

	public void setUpStore(){
		try{
			
			Scanner sc = new Scanner(new File("saves.txt"));

			String name = sc.nextLine();
			String owner = sc.nextLine();
			String phone = sc.nextLine();
			double lat = sc.nextDouble();
			double lon = sc.nextDouble();
			store = new Store(name, owner, phone, lon, lat);
			int run = Integer.parseInt(sc.next());
			for(int i = 0; i < run; i++){
				String blanck = sc.nextLine();
				String itemName = sc.nextLine();
				String des = sc.nextLine();
				double sellPrice = Double.parseDouble(sc.next());
				double buyPrice = Double.parseDouble(sc.next());
				int amountOfItem = Integer.parseInt(sc.next());
				store.addItem(new Item(itemName, sellPrice, buyPrice, amountOfItem, des));	
			}
		}catch(Exception e){
			displayError("There was a problem loading the save");
		}
	}

		@Override
	public void actionPerformed(ActionEvent e){
		String actionName = e.getActionCommand();

		switch(actionName){
			case "Search" : thisGUI.search(""); break;
			case "Buy Item" : thisGUI.buy(""); break;
			case "New Item" : thisGUI.newItem(false); break;
			case "Add Item" : thisGUI.newItem(true); break;
		 	case "Remove Item" : thisGUI.remove(""); break;
			case "Stock Item" : thisGUI.restock(""); break;
			case "Done" : thisGUI.search("Done"); break;
			case "Store" : thisGUI.editStore(true); break;
			case "Continue" : thisGUI.editStore(false); break;
			case "Cancel" : thisGUI.cancel(); break;
			case "Save" : thisGUI.save(); break;
			default : 
				if(actionName.contains("Remove")){
					thisGUI.remove(actionName.replace("Remove ", ""));
				}else if(actionName.contains("Restock")){
					thisGUI.restock(e.getActionCommand().replace("Restock ", ""));
				}else if (actionName.contains("Buy")){
					thisGUI.buy(actionName.replace("Buy ", ""));
				}else{
					thisGUI.search(actionName);
				}
		}

	}

	public void displayError(String message){
		int button = JOptionPane.PLAIN_MESSAGE;
		JOptionPane.showMessageDialog(null, message, "Error" , button);
	}

	ArrayList<JTextField> textFields = new ArrayList<JTextField>();
	ArrayList<JTextField> storeText = new ArrayList<JTextField>();

	JPanel searchPanel = new JPanel(new GridLayout(0, 1));
	JPanel searchInfo = new JPanel(new GridLayout(0, 1));
	JPanel propmptPanel = new JPanel(new GridLayout(0, 1));
	JPanel textBoxPanel = new JPanel(new GridLayout(0, 1));
	JPanel restockPanel = new JPanel(new GridLayout(0, 1));
	JPanel buyItemPanel = new JPanel(new GridLayout(0, 1));
	JPanel storeWords = new JPanel(new GridLayout(0,1));
	JPanel storeTextPanel = new JPanel(new GridLayout(0, 1));

	JTextField  addAmount = new JTextField(15);
	JTextField amountOfItem = new JTextField(15);

	boolean isSearching = false;
	boolean isAdding = false;
	boolean isRestocking = false;
	boolean isBuying = false;
	boolean isEditing = false;

	public void cancel(){
		if (isSearching){
			gui.remove(searchPanel);
			gui.remove(searchInfo);
			searchInfo.removeAll();
			searchPanel.removeAll();
			gui.add(fiveButtons);
			isSearching = false;
		}else if (isAdding){
			gui.remove(propmptPanel);
			gui.remove(textBoxPanel);
			propmptPanel.removeAll();
			textBoxPanel.removeAll();
			textFields.clear();
			gui.add(fiveButtons);
			isAdding = false;
		}else if (isRestocking){
			gui.remove(restockPanel);
			restockPanel.removeAll();
			addAmount = new JTextField(15);
			gui.add(fiveButtons);
			isRestocking = false;
		}else if (isBuying){
			gui.remove(buyItemPanel);
			gui.add(fiveButtons);
			buyItemPanel.removeAll();
			amountOfItem = new JTextField(15);
			isBuying = false;
		}else if (isEditing){
			gui.remove(storeWords);
			gui.remove(storeTextPanel);
			storeWords.removeAll();
			storeTextPanel.removeAll();
			storeText.clear();
			gui.add(fiveButtons);
			isEditing = false;
		}

		this.repaint();
		this.revalidate();
	}

	public void editStore(boolean edit){
		if(edit){
			storeWords.add(new JLabel("Name: ")); 
			storeWords.add(new JLabel("Owner: "));
			storeWords.add(new JLabel("Phone Number : "));
			storeWords.add(new JLabel("Longitude: "));
			storeWords.add(new JLabel("Latitude: "));
			for (int i = 0; i < 5; i ++){
				JTextField newTextField = new JTextField(25);
				switch(i){
					case 0: newTextField.setText(store.getStoreName()); break;
					case 1: newTextField.setText(store.getOwner()); break;
					case 2: newTextField.setText(store.getPhone()); break;
					case 3: newTextField.setText(Double.toString(store.getLong())); break ; 
					case 4: newTextField.setText(Double.toString(store.getLat())); break;
					default: break;
				}
				storeText.add(newTextField);
				storeTextPanel.add(newTextField);
			}
			JButton cancel = new JButton("Cancel");
			JButton continueButton = new JButton("Continue");
			cancel.addActionListener(this);
			continueButton.addActionListener(this);
			storeWords.add(continueButton);
			storeTextPanel.add(cancel);
			gui.remove(fiveButtons);
			gui.add(storeWords);
			gui.add(storeTextPanel);
			isEditing = true;
		}else{
			try{
				String name = storeText.get(0).getText();
				String owner = storeText.get(1).getText();
				String phoneNumber = storeText.get(2).getText();
				double lon = Double.parseDouble(storeText.get(3).getText());
				double lat = Double.parseDouble(storeText.get(4).getText());
				if (!name.equals("") && !owner.equals("") && !phoneNumber.equals("")){
					store.setAttributes(name, owner, phoneNumber, lon, lat);
					cancel();
				}else{
					displayError("Please fill out all inputs");
				}
			}catch(Exception e){
				displayError("Please fill out everything with correct data types");
			}
		}

		this.repaint();
		this.revalidate();
	}

	public void search(String searchItem){
		if (searchItem.equals("")){
			Iterator it = store.getItemNames().iterator();
			while(it.hasNext()){
				String nextItem = (String) it.next();
				JButton newButton = new JButton(nextItem);
				newButton.addActionListener(this);
				searchPanel.add(newButton);
			}
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(this);
			searchPanel.add(cancelButton);
			gui.remove(fiveButtons);
			gui.add(searchPanel);
			isSearching = true;
		}else if (searchItem.equals("Done")){
			cancel();
		}else{
			gui.remove(fiveButtons);
			gui.remove(searchPanel);
			searchPanel.removeAll();
			JLabel nameLabel = new JLabel("Name: " + searchItem);
			JLabel sellPrice = new JLabel("Sell Price: " + store.searchItemSellPrice(searchItem));
			JLabel buyPrice = new JLabel("Buy Price: " + store.searchItemBuyPrice(searchItem));
 			JLabel stockOfItem = new JLabel(store.searchIsInStock(searchItem) ? "Stock: " + store.searchItemStock(searchItem) : searchItem + " is not in stock");
 			JLabel description = new JLabel("Description: " + store.searchItemDescription(searchItem));
 			JButton backButton = new JButton("Done");
 			backButton.addActionListener(this);

 			searchInfo.add(nameLabel);
 			searchInfo.add(description);
 			searchInfo.add(sellPrice);
 			searchInfo.add(buyPrice);
 			searchInfo.add(stockOfItem);
 			searchInfo.add(backButton);
 			gui.add(searchInfo);
		}

		this.repaint();
		this.revalidate();
	}

	public void newItem(boolean done){
		if(!done){
			propmptPanel.add(new JLabel("Item Name: "));
			propmptPanel.add(new JLabel("Item Description: "));
			propmptPanel.add(new JLabel("Item Sold For: "));
			propmptPanel.add(new JLabel("Item Amount: "));
			JButton addButton = new JButton("Add Item");
			addButton.addActionListener(this);
			propmptPanel.add(addButton);
			for (int i = 0; i < 4; i++){
				JTextField newTextField = new JTextField(25);
				textBoxPanel.add(newTextField);
				textFields.add(newTextField);
			}
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(this);
			textBoxPanel.add(cancelButton);
			gui.remove(fiveButtons);
			gui.add(propmptPanel);
			gui.add(textBoxPanel);
			isAdding = true;
		}else{
			try{
				String name = textFields.get(0).getText();
				String description = textFields.get(1).getText();
				Double price = Double.parseDouble(textFields.get(2).getText());
				int amount = Integer.parseInt(textFields.get(3).getText());

				if(!name.equals("") && !description.equals("")){
					System.out.println(description);
					Item newItem = new Item(name, price, amount, description);
					store.addItem(newItem);
					cancel();
				}else{
					displayError("Please fill out all the fields.");
				}
			}catch(Exception e){
				displayError("Please fill everything in with the correct value types");
			}
		}

		this.repaint();
		this.revalidate();
	}

	

	public void restock(String itemName){
		if(itemName.equals("")){
			restockPanel.add(addAmount);
			Iterator it = store.getItemNames().iterator();
			while(it.hasNext()){
				String nextItem = (String) it.next();
				JButton newButton = new JButton("Restock " + nextItem);
				newButton.addActionListener(this);
				restockPanel.add(newButton);
			}
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(this);
			restockPanel.add(cancelButton);
			gui.remove(fiveButtons);
			gui.add(restockPanel);
			isRestocking = true;
		}else{
			try{
				int amount = Integer.parseInt(addAmount.getText());
				store.restockItem(itemName, amount);
				cancel();
			}catch(Exception e){
				displayError("Please enter a valid integer");
			}
		}


		this.repaint();
		this.revalidate();
	}

	public void remove(String itemName){
		if(itemName.equals("")){
			Iterator it = store.getItemNames().iterator();
			while(it.hasNext()){
				String nextItem = (String) it.next();
				JButton newButton = new JButton("Remove " + nextItem);
				newButton.addActionListener(this);
				searchPanel.add(newButton);
			}
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(this);
			searchPanel.add(cancelButton);
			gui.remove(fiveButtons);
			gui.add(searchPanel);
			isSearching = true;
		}else{
			store.removeItem(itemName);
			cancel();
		}
		this.repaint();
		this.revalidate();
	}

	public void buy(String itemName){
		if (itemName.equals("")){
			buyItemPanel.add(amountOfItem);
			Iterator it = store.getItemNames().iterator();
			while(it.hasNext()){
				String nextItem = (String) it.next();
				JButton newButton = new JButton("Buy " + nextItem);
				newButton.addActionListener(this);
				buyItemPanel.add(newButton);
			}
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(this);
			buyItemPanel.add(cancelButton);
			gui.remove(fiveButtons);
			gui.add(buyItemPanel);
			isBuying = true;
		}else{
			try{
				int amount = Integer.parseInt(amountOfItem.getText());
				if(store.buyItemWithName(itemName, amount)){
					cancel();
				}else{
					displayError("There are not enough Items\nfor you to buy that many");
				}
			}catch(Exception e){
				displayError("Please enter a valid integer");
			}
		}

		this.repaint();
		this.revalidate();
	}

	public void save(){
		try{
			PrintWriter writer = new PrintWriter("saves.txt", "UTF-8");
			writer.println(store.getStoreName());
			writer.println(store.getOwner());
			writer.println(store.getPhone());
			writer.println(store.getLat());
			writer.println(store.getLong());
			ArrayList<Item> items = store.getItems();
			writer.println(items.size());
			for(int i = 0; i < items.size(); i++){
				Item thisItem = store.getItems().get(i);
				writer.println(thisItem.getName());
				writer.println(thisItem.getDescription());
				writer.println(thisItem.getSellPrice());
				writer.println(thisItem.getBuyPrice());
				writer.println(thisItem.getAmount());
			}
			int Button = JOptionPane.PLAIN_MESSAGE;
			JOptionPane.showMessageDialog(null, "Save was successful", "Save Progress" , Button);
			writer.close();
		}catch(Exception e){
			displayError("Info Could Not be Saved");
		}
	}
	
}
