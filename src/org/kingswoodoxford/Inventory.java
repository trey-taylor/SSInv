package org.kingswoodoxford;

import java.util.ArrayList;
import java.util.Collections;

public class Inventory
{
	ArrayList<Item> inventoryStock;
	
	public Inventory ()
	{
		inventoryStock = new ArrayList<Item>();
	}
	
	public void addItem(Item item)
	{
		inventoryStock.add(item);
		Collections.sort(inventoryStock);
	}
	
	public void removeItem(Item item)
	{
		boolean valid = true;
		int i = 0;		
		while (valid && i < inventoryStock.size())
		{
			if (inventoryStock.get(i).getID() == item.getID())
			{
				inventoryStock.remove(i);
				valid = false;
			}
			i++;
		}
	}
	
	public Item getItem(int index)
	{
		return inventoryStock.get(index);
	}
	public int getSize()
	{
		return inventoryStock.size();
	}
	
	public void printList()
	{
		for (int i = 0; i < inventoryStock.size(); i++)
		{
			System.out.println(inventoryStock.get(i).getName());
		}
	}
}
