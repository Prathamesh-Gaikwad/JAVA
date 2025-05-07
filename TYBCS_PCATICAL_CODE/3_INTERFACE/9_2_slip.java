import java.util.Scanner;

interface ProductInfo
{

}

class Product implements ProductInfo
{
    int id;
    int cost;
    String name;
    int quantity;
    static int count;

    Product()
    {
        id = 0;
        cost = 0;
        name = "NULL";
        quantity = 0;
        ++count;
    }

    Product(int param1, int param2, String param3, int param4)
    {
        id = param1;
        cost = param2;
        name = param3;
        quantity = param4;
        ++count;
    }

    void Display()
    {
        System.out.println("\n\t****Product Details****");
        System.out.println("\n\t1)Product ID : " + id);
        System.out.println("\n\t2)Product Cost : " + cost);
        System.out.println("\n\t3)Product Name : " + name);
        System.out.println("\n\t4)Product Quantity : " + quantity + "gm");
        System.out.println("\n\t************************");
        System.out.println("\n\t Total Objects : " + count);
    }

    static
    {
        count = 0;
    }
}

class MarkerInterface
{
    public static void main(String args[])
    {
        Product productRef1 = new Product();

        productRef1.Display();

        Product productRef2 = new Product(101, 120, "Umbrella", 500);
        productRef2.Display();

    }
}
