import java.util.Scanner;

//functional interface.. having only one method and interface declared using interface keyword
interface Cube
{
    public static final int power = 3;

    public abstract double result(int param);
}

//implementer..
class FunctionalInterface implements Cube
{
    //defined method
    public double result(int param)
    {
        return Math.pow(param, Cube.power);
    }

    //main method
    public static void main(String args[])
    {
        int number;

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\tEnter Number : ");
        number = scanner.nextInt();

        scanner.close();
        
        FunctionalInterface objRef = new FunctionalInterface();
        System.out.println("\n\t Cube : " + objRef.result(number));
    }
}

