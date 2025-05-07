class TryCatch
{
    public static void main(String args[])
    {
        int result = 0;

        try
        {
            System.out.println("\n\tDividing 10 by 0 : ");
            result = 10 / 0;
        }
        catch(ArithmeticException exceptionObj)
        {
            System.out.println("\n\tYes !! Exception Caught Successfull !!");
            System.out.println("\n\t Exception : " + exceptionObj);
        }

        System.out.println("\n\tLeaving main()");
    }
}
/*
    Above (10) : Exception generate jhalyavr... method dwaare.. tya exception cha object
                 tayaar kela jaato .. aani to exception handler tya method madhe aahe
                 ka he pahto.. asel tar to tithe deal hoto.. i.e. catch block madhe..
                 nahi tar.. method baher yeun.. run time system i.e. JVM kade to object
                 sopavalaa jaato.. 
*/
/* 
    o/p:
        Dividing 10 by 0 : 

        Yes !! Exception Caught Successfull !!

        Exception : java.lang.ArithmeticException: / by zero

        Leaving main()
*/