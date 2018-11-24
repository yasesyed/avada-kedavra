package code.java.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by syed.yaser on 29/07/17.
 */
public class LambdaFunction {

    public static class A {
        public static void f1() {

        }

        public void f2() {

        }
    }


    public static String join(String a, String b) {
        return a;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //numbers.stream().forEach( e -> System.out.println(e));
        //numbers.stream().forEach(System.out::println);
        numbers.stream()
                .map(String::valueOf) // String.valueOf(e)
                .forEach(System.out::println); // System.out.println(e)

//        numbers.stream()
//                .map(Integer::valueOf)
//                .map(String::valueOf) // String.valueOf(e) : String
//                //.map(String::toString) // e.toString() : String
//                .forEach(System.out::println); // System.out.println(e) : void


        String s = numbers.stream()
                .map(String::valueOf)
                .reduce("", (a, b) -> join(a, b));
        System.out.println(s);
    }
}
