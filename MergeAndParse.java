/*
 * Program takes two strings of characters between a-z. Then returns to the user 
 * a sorted string of every distinct letter found in the first two strings.
 * If there are any non-letters found in the strings, return -1.
 *
 * @author Stewart
 * @version JAVA 8, 7/23/2019
 */

import java.util.HashMap;
import java.util.Arrays;

public class MergeAndParse {
    public static void main(String[] args){
        /* Test Cases */
        System.out.println(mergeAndParse("bananarama", "bamboozled"));
        System.out.println(mergeAndParse("barbarian", ""));
        System.out.println(mergeAndParse("xyaabbbccccdefww", "xxyyabklmopq"));
        System.out.println(mergeAndParse("", ""));
        System.out.println(mergeAndParse("aa", "a"));
        System.out.println(mergeAndParse("bananaram&", "bamboozled"));
        System.out.println(mergeAndParse("barbarian", "2"));
    }

    private static String mergeAndParse(String str1, String str2){
        /*
         * Merges 'str1' and 'str2' into 'str' as there is no need to track 2 seperate
         * string values
         */
        String str = str1 + str2;
        /* Generates a HashMap named 'map' to track the letters that are found in 'str' */
        HashMap<Character, Integer> map = new HashMap<>();
        for(char j = 'a'; j <= 'z'; j++){
            map.put(j, 0);
        }

        /*
         * Runs toLowerCase() on 'str' and then breaks it down into chars using
         * toCharArray() and sets it equal to 'strC'
         */
        char[] strC = str.toLowerCase().toCharArray();

        /* Loops through acceptable chars */
        for(int i = 0; i < strC.length; i++){
            /* If a char is found that is outside of the desired range, return -1 */
            if(strC[i] < 97 || strC[i] > 122){
                return "-1";
            }
            /* Adds 1 to the matching char found in 'map' */
            map.put(strC[i], map.get(strC[i]) + 1);
        }

        /* Resets 'str' to be reused in the return */
        str = "";

        /* Loops through range of disired chars */
        for(char k = 'a'; k <= 'z'; k++){
            /* 
             * Checks with 'map' the matching char, if the key's value is change
             * (greater than 0) the letter has been used and is added to 'str'.
             * This prevents  dupicate letters in the return.
             */
            if(map.get(k) > 0){
                str += k;
            }
        }
        /* Returns rebuilt string to user */
        return str;
    }
}
