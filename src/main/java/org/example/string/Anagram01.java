package org.example.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Anagram means two strings have exactly the same set of characters
 */
public class Anagram01 {
    public static void main(String[] args) {
        //Method 1 - Sort the two strings. If they are equal after sorting, then they are Anagrams else not.
        //Time - O(nlogn), Space - O(1)
        String firstString = "geeksforgeeks";
        String secondString = "geeksgeeksfor";
        String sortedFirstString = sortString(firstString);
        String sortedSecondString = sortString(secondString);
        System.out.println("Two strings are anagrams?(Approach 1) : " + sortedFirstString.equals(sortedSecondString));

        //Method 2 - Count the number of characters in both the Strings. If they match then they are Anagrams else not.
        //Time - O(n), Space - O(n)
        Map<String, Long> characterCountMapForFirstString = countCharactersInString(firstString);
        Map<String, Long> characterCountMapForSecondString = countCharactersInString(secondString);
        System.out.println("Two strings are anagrams?(Approach 2) : " + characterCountMapForFirstString.equals(characterCountMapForSecondString));
    }

    private static String sortString(String unsortedString) {
        return Arrays.stream(unsortedString.split("")).sorted().collect(Collectors.joining(""));
    }

    private static Map<String, Long> countCharactersInString(String stringVal) {
        return Arrays.stream(stringVal.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
