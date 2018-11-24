package code.java;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by syed.yaser on 01/04/17.
 */
public class SteamExample {

    public static void main(String[] args) throws FileNotFoundException {
        List<Integer>  integers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Stream<Integer> stream = integers.stream();

     System.out.println(stream.filter(integer -> integer % 2 == 0)
                .map(in -> in.intValue())
                .reduce(0, (carry, age) -> carry + age));


        File file = new File("/workspace/MyProject/MyPrograms/src/main/resources/abc.txt");
        BufferedReader bs = new BufferedReader(new FileReader(file));
       //bs.lines().forEach(System.out::println);
        Stream.of("abc","xyz").forEach(System.out::println);

    }
}
