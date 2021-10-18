package com.vladLeb.testPackage.Algoritms;

public class Palindrome {
    public static void main(String[] args) {
        String text = "aabaa";
        System.out.println(isPalindrome(text));
    }

    static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n/2); i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
