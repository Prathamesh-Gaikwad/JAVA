import java.io.*;

abstract class Order
{
	protected int ID;
	protected String Desc;
	
	Order(int Param1, String Param2)
	{
		ID = Param1;
		Desc = Param2;
	}
	
	abstract void Display();
}

class PurchaseOrder extends Order
{
	String CustomerName;
	String VendorName;
	
	PurchaseOrder(int Param1, String Param2, String Param3, String Param4)
	{
		super(Param1, Param2);
		CustomerName = Param3;
		VendorName = Param4;
	}
	
	public void Display()
	{
		System.out.println("\nID : " + ID + " Description : " + " CustomerName : " + CustomerName + " VendorName : " + VendorName);
	}
}

class SalesOrder extends Order
{
	int Price;
	String Item;
		
	SalesOrder(int Param1, String Param2, int Param3, String Param4)
        {
		super(Param1, Param2);
		Price = Param3;
		Item = Param4;

}
	
	public void Display()
	{
		System.out.println("\nID : " + ID + " Description : " + " Price : " + Price + " Item : " + Item);
	}
}

class Ass3B1
{
	public static void main(String args[])throws IOException
	{
		int i;
		int ID;
		int Size;
		int Price;
		String Item;
		String Description;
		String CustomerName;
		String VendorName;

		BufferedReader BRref = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nEnter Total No. Of Purchase Orders : ");
		Size = Integer.parseInt(BRref.readLine());
		
		Order Oref[] = new Order[Size];
		
		System.out.println("\nEnter Purchase Order Details : ");
		
		for(i = 0; i < Size; i++)
		{
			System.out.print("\nEnter ID : ");
			ID = Integer.parseInt(BRref.readLine());

			System.out.print("\nEnter Description : ");
			Description = BRref.readLine();


      System.out.print("\nEnter Customer Name : ");
			CustomerName = BRref.readLine();

			System.out.print("\nEnter Vendor Name : ");
			VendorName = BRref.readLine();

			Oref[i] = new PurchaseOrder(ID, Description, CustomerName, VendorName);
		}
		
		System.out.println("\nPurchase Order Details Are :");
		for(i = 0; i < Size; i++)
			Oref[i].Display();

		System.out.print("\nEnter Total No. Of Sales Orders : ");
		Size = Integer.parseInt(BRref.readLine());
		
		System.out.println("\nEnter Sales Order Detail : ");

		for(i = 0; i < Size; i++)
		{
			System.out.print("\nEnter ID : ");
			ID = Integer.parseInt(BRref.readLine());

			System.out.print("\nEnter Description : ");
			Description = BRref.readLine();

			System.out.print("\nEnter Price : ");

Price = Integer.parseInt(BRref.readLine());

			System.out.print("\nEnter Item : ");
			Item = BRref.readLine();
			
			Oref[i] = new SalesOrder(ID, Description, Price, Item);
		}

		System.out.println("\nSales Order Details Are :");
		for(i = 0; i < Size; i++)
			Oref[i].Display();
	}
}
