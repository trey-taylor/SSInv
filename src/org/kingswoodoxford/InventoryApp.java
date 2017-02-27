package org.kingswoodoxford;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings({"rawtypes", "unchecked", "serial"})

public class InventoryApp {

	private JFrame frame;
	public JTabbedPane Tabs = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel selectPanel = new JPanel();
	private final JPanel managePanel = new JPanel();
	private final JPanel checkoutPanel = new JPanel();

	//Select Tab
	JList inventoryList = new JList();
	JButton refreshButton = new JButton("Refresh");
	JButton addItemButton = new JButton("Add Item");
	JLabel debugLabel = new JLabel("DAB");
	JButton clearButton = new JButton("Clear");


	//Other variables
	ArrayList<Item> cart = new ArrayList<Item>();

	//Temp stuff
	Inventory ssInv = new Inventory();
	Item shirt = new Item(0001, "SHIRT", 00.01, "Small", 47);
	Item shorts = new Item(0002, "Short", 48.12, "Large", 832);
	Item ligonsChain = new Item(6969, "LIGON'S GOLD CHAIN", 69.69, "massive", 420);

	String fileLoc = "src/org/kingswoodoxford/inventory.txt";
	BufferedReader br = null;
	String splitData = ",";
	String line = "";

	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryApp window = new InventoryApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventoryApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Tabs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Tabs.setBounds(0, 0, 784, 561);
		Tabs.addTab("Select", null, selectPanel, null);
		Tabs.addTab("Manage", null, managePanel, null);
		Tabs.addTab("Checkout", null, checkoutPanel, null);
		selectPanel.setLayout(null);
		managePanel.setLayout(null);
		checkoutPanel.setLayout(null);

		/*
		 * CODE FOR GETTING INVENTORY AND PUTTING INTO ARRAY
		 * temp code for testing VVV
		 * File reading to sub for DB
		 */

		try
		{
			br = new BufferedReader(new FileReader(fileLoc));
			
			while ((line = br.readLine()) != null)
			{
				String[] itemFromFile = line.split(splitData);
				ssInv.addItem(new Item(Integer.parseInt(itemFromFile[0]), itemFromFile[1], Double.parseDouble(itemFromFile[2]), itemFromFile[3], Integer.parseInt(itemFromFile[4])));
			}

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		ssInv.printList();



		String[] jListValues = new String[ssInv.getSize()];
		for (int i = 0; i < ssInv.getSize(); i++)
		{
			jListValues[i] = ssInv.getItem(i).toString();
		}


		//Select Panel GUI
		inventoryList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryList.setModel(new AbstractListModel()
		{
			String[] values = jListValues;
			public int getSize()
			{
				return values.length;
			}
			public Object getElementAt(int index)
			{
				return values[index];
			}
		});
		inventoryList.setBounds(0, 0, 769, 460);

		frame.getContentPane().add(Tabs);
		selectPanel.add(inventoryList);

		addItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addItemButton.setBounds(10, 465, 150, 29);
		selectPanel.add(addItemButton);

		clearButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clearButton.setBounds(160, 465, 150, 29);
		selectPanel.add(clearButton);

		refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		refreshButton.setBounds(310, 465, 141, 29);
		selectPanel.add(refreshButton);

		debugLabel.setBounds(459, 464, 92, 26);
		selectPanel.add(debugLabel);


		/*
		 * Action Listeners
		 * Select Panel
		 */
		//Add Item
		addItemButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int[] indicies = inventoryList.getSelectedIndices();
				String[] selectedValues = new String[indicies.length];
				String debug = "";

				for (int i = 0; i < indicies.length; i++)
				{
					inventoryList.setSelectedIndex(indicies[i]);
					selectedValues[i] = inventoryList.getSelectedValue().toString();
					debug = debug + selectedValues[i];
				}

				debugLabel.setText(debug);
			}
		});
		//Clear Selection
		clearButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				inventoryList.setSelectedIndex(0);
			}
		});
		//Refresh Inventory list
		refreshButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{

			}
		});

	}
}
