package code.java.javatypes;

public class WrapperClasses {

    public static class IntegerTest {
        int value;

        public IntegerTest(int value) {
            this.value = value;
        }

        void setValue(int value) {

            this.value = value;
            System.out.println("called int version");
        }

        void setValue(int Integer, Integer b) {
            this.value = value;
            System.out.println("called with Integer version");
        }


        void setValue(Number value) {
            this.value = value.intValue();
        }
    }

    public static void main(String[] args) {

        IntegerTest integerTest = new IntegerTest(10);

        integerTest.setValue(10, 20);
        System.out.println(Integer.toUnsignedString(-1));
        System.out.println(Integer.toHexString(-1));
        System.out.println(Integer.highestOneBit(39));
        System.out.println(Integer.lowestOneBit(36));

        int i = 10;

        Long l = Integer.valueOf(i).longValue();

    }
}
