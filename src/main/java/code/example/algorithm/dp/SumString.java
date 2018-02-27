package code.example.algorithm.dp;

/**
 * Given a string of digits, determine whether it is a ‘sum-string’.
 * A string S is called a sum-string if a rightmost substring can be written as sum of two substrings before it and same is recursively true for substrings before it.
 * <p>
 * eg:
 * “12243660” is a sum string.
 * <p>
 * Explanation :
 * 12 + 24 = 36
 * 24 + 36 = 60
 * <p>
 * “1111112223” is a sum string.
 * <p>
 * Explanation:
 * 1+111 = 112
 * 111+112 = 223
 * <p>
 * “2368” is not a sum string
 */
public class SumString {

    public static void main(String[] args) {
        //System.out.println(isSumString("12243660"));
       /* System.out.println(isSumString("1111112223"));
        System.out.println(isSumString("2368"));
        System.out.println(isSumString("12358"));
        System.out.println(isSumString("199100199"));
        System.out.println(isSumString("2368"));*/

        //printAllSubString("yaser");
        printAllSubSequences("yaser");

    }

    private static boolean isSumString(String string, int x, int y) {
        if (string.length() == 0) return true;

        for (int k = 0; k < string.length(); k++) {
            int z = Integer.parseInt(string.substring(0, k + 1));
            if ((x + y) == z) {
                System.out.println(x + "+" + y + "=" + z);
                return isSumString(string.substring(k + 1), y, z);
            } else if ((x + y) < z) break; // z > x+y
        }
        return false;
    }

    private static boolean isSumString(String string) {
        System.out.println("----------------------------");
        System.out.println("isSumString(" + string + ")");
        System.out.println("----------------------------");

        if (string.length() == 0) return true;
        if (string.length() < 3) return false;
        for (int i = 0; i < string.length() - 2; i++) {
            for (int j = i + 1; j < string.length() - 1; j++) {
                int x = Integer.parseInt(string.substring(0, i + 1));
                int y = Integer.parseInt(string.substring(i + 1, j + 1));
                System.out.println(x + " " + y);
                if (isSumString(string.substring(j + 1), x, y)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static void printAllSubString(String str) {
        if (str.length() > 0) {
            for (int i = 0; i < str.length(); i++) {
                System.out.println(str.substring(0, i + 1));
            }
            printAllSubString(str.substring(1));
        }
    }


    private static void printAllSubSequences(String str, String result) {
        if (str.length() > 0) {
            String s = str.substring(0, 1);
            System.out.println(result + s);
            printAllSubSequences(str.substring(1), result + s);
            printAllSubSequences(str.substring(1), result);
        }
    }

    private static void printAllSubSequences(String str) {
        printAllSubSequences(str, "");
    }
}
