package org.example.string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * KAnagram - Two strings can be Anagram with the exception of K characters. K characters can be different.
 * K = 2
 * "fodr" and "gork" - Can change fd to gk
 */
public class KAnagram02 {
    public static void main(String[] args) {
        String firstString = "fodr";
        String secondString = "gork";
        long k = 3;

        if(firstString.length() == secondString.length()) {
            //Find the character count of first string
            Map<String, Long> characterCountOfFirstString = Arrays
                    .stream(firstString.split(""))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


            //Check each character of 2nd String in the first map. If found, decrease the count by 1.
            String[] secondStringCharacters = secondString.split("");
            for(String character : secondStringCharacters) {
                if(characterCountOfFirstString.containsKey(character)) {
                    Long characterCount = characterCountOfFirstString.get(character);
                    if(characterCount != 0)
                        characterCountOfFirstString.put(character, characterCount - 1);
                }
            }

            //Sum the total number of characters which are mismatching. K should be greater than or equal to the sum in order for the Strings to be K Anagrams.
            long totalNoOfCharacterMismatchCount = characterCountOfFirstString.values().stream().reduce(0L, Long::sum);
            System.out.println("Total No. of character mismatches : " + totalNoOfCharacterMismatchCount);
            boolean areStringsKAnagrams = (k >= totalNoOfCharacterMismatchCount);

            System.out.println("Are two Strings K anagrams? : " + areStringsKAnagrams);
        } else {
            System.out.println("Two Strings are not anagrams as the character counts of two Strings are not same");
        }

    }
}
