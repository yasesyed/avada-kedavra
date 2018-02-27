package code.example.algorithm.dp;

import java.util.*;

/**
 * Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words.
 * See following examples for more details.
 * <p>
 * Consider the following dictionary
 * { i, like, sam, sung, samsung, mobile, ice,
 * cream, icecream, man, go, mango}
 * <p>
 * Input:  ilike
 * Output: Yes
 * The string can be segmented as "i like".
 * <p>
 * Input:  ilikesamsung
 * Output: Yes
 * The string can be segmented as "i like samsung"
 * or "i like sam sung".
 */

public class WordBreakProblem {

    private static final Set<String> dict = new HashSet<>();
    private static final List<String> words = new ArrayList<>(Arrays.asList(
            "my,name,is,khan,am,are,was,there,here,come,go,going,list,apple,dimple,wave,dream,like,lime,dreams,h,he,her,the,their,them,theme"
                    .split(",")));

    static {
        //dict.addAll(Arrays.asList("i,like,sam,sung,samsung,mobile,ice".split(",")));
        dict.addAll(words);
    }


    public static boolean solve(String str, int i) {
        if (i == str.length())
            return true;
        for (int j = i; j < str.length(); j++) {
            if (dict.contains(str.substring(i, j + 1)) && solve(str, j + 1)) {
                return true;
            }

        }
        return false;
    }


    public static boolean solve(String str) {
        if (0 == str.length())
            return true;
        for (int i = 0; i < str.length(); i++) {
            if (dict.contains(str.substring(0, i + 1).toLowerCase()) && solve(str.substring(i + 1))) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(solve("mymynamenameisKHANwasamarethereappleapplethemthemelikelistdreamgoinggocomeher"));
    }

}
