package ua.ithillel.lectures.lecrure_4.encapsulation;

public class Encapsulation {
    private int myInt = 5;
    String myString = "a";
    protected String myProtectedString = "A";
    public long myLong = 67889;
    public static String myStaticString = "AAa";

    static {
        System.out.println("Static input ");
    }

    private void method (){
        myInt = 6;
    }
     public Encapsulation(){

     }
}
