import java.util.Scanner;

class Continient
{
    String place;

    Continient(String param)
    {
        place = param;
    }
}

class Country extends Continient
{
    String country;

    Country(String param1, String param2)
    {
        super(param2);
        country = param1;
    }
}

class State extends Country
{
    String state;

    State(String param1, String param2, String param3)
    {
        super(param2, param3);
        state = param1;
    }

    void Display()
    {
        System.out.println("\n\n\t*********Your Gloabl Address*********");
        System.out.println("\n\t1)Your Place [Continient] : " + place);
        System.out.println("\n\t2)Your Country : " + country);
        System.out.println("\n\t3)Your State : " + state);
        System.out.println("\n\t************************************\n\n");
    }
}

class Multilevel
{
    public static void main(String args[])
    {
        String place;
        String country;
        String state;

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\t---[Global Address Information System]---\n"+"\n\t1)Enter Your Continient : ");
        place = scanner.next();

        System.out.print("\n\t2)Enter Your Country : ");
        country = scanner.next();

        System.out.print("\n\t3)Enter Your State : ");
        state = scanner.next();

        scanner.close();

        State stateref = new State(state, country, place);
        stateref.Display();
    }
}

