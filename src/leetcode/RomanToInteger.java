package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class RomanToInteger {

    public static void main(String[] args) {

        String userGivenText = "LVIII";
        if (!checkStringLength(userGivenText)) {
            System.out.println("Please give a string value length range between 1 to 15");
        } else if (!checkIfStringContainsRomanCharOrNot(userGivenText)) {
            System.out.println("Please give a proper roman numerals");
        } else {
            int value = getIntegerNumberFromRomanNumerals(userGivenText);
            System.out.println(value);
        }
    }

    private static int getIntegerNumberFromRomanNumerals(String userGivenText) {

        HashMap<String, Integer> map = new HashMap<>(getRomanValues());
        char[] romanChar = userGivenText.toCharArray();
        int total = 0;
        for (char ch : romanChar) {
            int value = map.get(String.valueOf(ch));
            total = total + value;
        }

        return total;
    }

    static boolean checkStringLength(String s) {
        return s.length() >= 1 && s.length() <= 15;
    }

    static boolean checkIfStringContainsRomanCharOrNot(String text) {

        ArrayList<String> romanCharList = new ArrayList<>(Arrays.asList("I", "V", "X", "L", "C", "D", "M"));
        char[] ch = text.toCharArray();
        for (char ch1 : ch) {
            if (!romanCharList.contains(String.valueOf(ch1).toUpperCase()))
                return false;
        }
        return true;
    }

    static HashMap<String, Integer> getRomanValues() {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        return map;
    }

}
