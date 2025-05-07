class Addition
{
    int add(int iParam1, int iParam2)
    {
        int iResult;
        iResult = iParam1 + iParam2;
        return iResult;
    }

    int add(int iParam1, int iParam2, int iParam3)
    {
        int iResult;
        iResult = iParam1 + iParam2 + iParam3;
        return iResult;
    }

    int add(int iParam1, int iParam2, int iParam3, int iParam4)
    {
        int iResult;
        iResult = iParam1 + iParam2 + iParam3 + iParam4;
        return iResult;
    }
}
class AddTest
{
    public static void main(String args[])
    {
        int iRet;
        Addition refObj = new Addition();

        System.out.println("\n\t******Method Overloading Demo******");
        iRet = refObj.add(10, 20);
        System.out.println("\n\t1)Addition of 10 & 20 : " + iRet);

        iRet = refObj.add(10, 20, 30);
        System.out.println("\n\t2)Addition of 10, 20 & 30 : " + iRet);

        iRet = refObj.add(10, 20, 30, 40);
        System.out.println("\n\t3)Addition of 10, 20, 30 & 40 : " + iRet);
    }
}
/***
 * o/p:
 * ******Method Overloading Demo******

	1)Addition of 10 & 20 : 30

	2)Addition of 10, 20 & 30 : 60

	3)Addition of 10, 20, 30 & 40 : 100
 */
