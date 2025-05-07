class NestedTryCatch
{
    public static void main(String args[])
    {
        int result;

        try
        {
            System.out.println("\n\tOuter Try Block Executing : ");

            try
            {
                System.out.println("\n\tWe're now generating innner try block exception : ");
                System.out.println("\n\targs[0] : " + args[0]);
            }
            catch(NumberFormatException exceptionObj)
            {
                System.out.println("\n\tYes !! Exception Caught Successfull !!");
                System.out.println("\n\t Exception : " + exceptionObj);
            }

            System.out.println("\n\tOuter Try block exception generation : ");
            result = Integer.parseInt(args[1]);
        }
        catch(ArrayIndexOutOfBoundsException exceptionObj)
        {
            System.out.println("\n\tYes !! Exception Caught Successfull !!");
            System.out.println("\n\t Exception : " + exceptionObj);
        }

        System.out.println("\n\tLeaving main()");
    }
}
/* 
    Above(14) : inner block exception outer block madhe deal kelay.. 
    Above(23) : outer block exception deal kelela nahi, tyas JVM kade forward karnyat
                yeil..
*/
/*
    1)when i'm not passing command line argument..[it's handler is outer catch] 
    o/p:
        Outer Try Block Executing : 

        We're now generating innner try block exception : 

        Yes !! Exception Caught Successfull !!

        Exception : java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0

        Leaving main()

    2)trying to generate, exception in inner try block..[It's handler is inner catch]
    o/p:
        Outer Try Block Executing : 

        We're now generating innner try block exception : 

        args[0] : 10

        Outer Try block exception generation : 

        Yes !! Exception Caught Successfull !!

        Exception : java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1

        Leaving main()
    
    3)trying to determine JVM default exception handler..
    o/p:
        Outer Try Block Executing : 

        We're now generating innner try block exception : 

        args[0] : 10

        Outer Try block exception generation : 
        Exception in thread "main" java.lang.NumberFormatException: For input string: "A"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        at java.base/java.lang.Integer.parseInt(Integer.java:588)
        at java.base/java.lang.Integer.parseInt(Integer.java:685)
        at NestedTryCatch.main(Nestedtrycatch.java:23)
*/