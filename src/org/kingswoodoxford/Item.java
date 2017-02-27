package org.kingswoodoxford;


public class Item implements Comparable<Item>
{

	int ID;
	String name;
	double price;
	String size;
	int stock;
	public Item(int ID, String name, double price, String size, int stock)
	{
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.size = size;
		this.stock = stock;
	}

	public int getID()
	{
		return ID;
	}

	public String getName()
	{
		return name;
	}

	public double getPrice()
	{
		return price;
	}

	public String getSize()
	{
		return size;
	}

	public int getStock()
	{
		return stock;
	}

	@Override
	public String toString()
	{
		return "(" + this.getID() + ")" + " " + this.getName() + " | $" + this.getPrice() + " | Size: " + this.getSize() + " | " + this.getStock() + " left.";

	}

	@Override
	public int compareTo(Item anotherOne)
	{
		if (this.getID() < anotherOne.getID())
		{
			return -1;
		}
		else 
		{
			return 1;
		}
	}	
}
