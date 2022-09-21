package org.example.string;

import java.util.Arrays;

public class LongestCommonPrefix04 {
    public static void main(String[] args) {
        String[] str = {"clumsy", "cluster", "class", "clove"};

        //Sort the array
        Arrays.sort(str);

        //Get first and last Strings
        char[] firstString = str[0].toCharArray();
        char[] lastString = str[str.length - 1].toCharArray();

        StringBuilder longestCommonPrefix = new StringBuilder();
        //Compare the two Strings
        for(int i = 0; i < firstString.length; i++) {
            if(firstString[i] != lastString[i])
                break;
            longestCommonPrefix.append(firstString[i]);
        }

        System.out.println("Longest common prefix : " + longestCommonPrefix);
    }
}
