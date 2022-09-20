package org.example.string;

public class ReverseString03 {
    public static void main(String[] args) {
        String str = "Pradipta";
        String reversedString = "";
        for(int i = str.length() - 1; i >=0; i--) {
            reversedString = reversedString + str.charAt(i);
        }
        System.out.println(reversedString);
    }
}
