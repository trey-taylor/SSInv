package org.kingswoodoxford;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({"unused", "rawtypes", "unchecked", "serial"})

public class InventoryApp {

	private JFrame frame;
	public JTabbedPane Tabs = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel selectPanel = new JPanel();
	private final JPanel managePanel = new JPanel();
	private final JPanel checkoutPanel = new JPanel();
	JList inventoryList = new JList();
	JButton addSelection = new JButton("Add To Cart");
	JButton clearSelection = new JButton("Clear Selection");
	JLabel debugLabel = new JLabel("dab");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		selectPanel.setLayout(null);


		inventoryList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryList.setModel(new AbstractListModel()
		{
			String[] values = new String[] {"i", "hate", "ligon", "he", "is", "big", "wang", "xd", "jk"};
			public int getSize()
			{
				return values.length;
			}
			public Object getElementAt(int index)
			{
				return values[index];
			}
		});
		inventoryList.setBounds(10, 11, 759, 475);


		addSelection.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int[] selection = inventoryList.getSelectedIndices();
				String dad = "";
				for (int i = 0; i < selection.length; i++)
				{
					//dad = dad + inventoryList.getElementAt(i);
				}

				//debugLabel.setText();


			}
		});



		addSelection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addSelection.setBounds(10, 497, 138, 23);

		clearSelection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clearSelection.setBounds(158, 497, 138, 23);

		debugLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		debugLabel.setBounds(337, 497, 337, 23);


		frame.getContentPane().add(Tabs);
		selectPanel.add(inventoryList);
		selectPanel.add(addSelection);
		selectPanel.add(clearSelection);
		selectPanel.add(debugLabel);
		Tabs.addTab("Manage", null, managePanel, null);
		Tabs.addTab("Checkout", null, checkoutPanel, null);
	}
}
