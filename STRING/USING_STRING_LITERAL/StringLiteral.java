import java.lang.String;
class StringLiteral
{
    public static void main(String args[])
    {
        String Str1 = "Hello";
        System.out.println("Str1(sizeof) : " + java.lang.instrument.Instrumentation.getObjectSize(Str1));
    }
}
