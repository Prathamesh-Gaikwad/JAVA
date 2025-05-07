class Demo
{
    static int iCount;

    Demo()
    {
        iCount++;
    }
    static
    {
        System.out.println("\n\t***Static Block Executed***");
        iCount = 0;
    }
}
class CurrentObj
{
    public static void main(String args[])
    {
        System.out.println("\n\tTotal No. Of Objects : " + Demo.iCount);

        Demo refObj1 = new Demo();

        System.out.println("\n\tTotal No. Of Objects : " + Demo.iCount);

        Demo refObj2 = new Demo();

        System.out.println("\n\tTotal No. Of Objects : " + Demo.iCount);

    }
}
