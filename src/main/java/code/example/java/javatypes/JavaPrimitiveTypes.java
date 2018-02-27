package java.java.app.javatypes;

public class JavaPrimitiveTypes {
    public static void main(String[] args) {
        String dash = "--------------------------";
        boolean bool = false;
        char c = 65; //'\u0065';

        byte b = -0x80;
        short s = 0x7fff;
        int i = 0x7fffffff;
        long l = 0x7fffffffffffffffL;

        float f = 0.0f;
        double d = 0.0;

        System.out.println("bool: " + bool);
        System.out.println("char: " + c);
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);

        System.out.println(dash);


        b = (byte) s; // why type cast?
        i = (int) l;
        //b = -0b1000_0000;
        System.out.println("byte: " + Integer.toBinaryString(b));
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println(dash);


        l = 2147483647L; // Can we remove L in the literal value? what if 2147483647

        System.out.println("MIN_INTEGER" + Integer.MIN_VALUE);
        System.out.println("MAX_INTEGER" + Integer.MAX_VALUE);

    }
}
