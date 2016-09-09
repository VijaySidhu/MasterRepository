package com.google.interview.questions;

public class BruteForceApproachStringSearch {

	public static void main(String[] args) {
		BruteForceApproachStringSearch bruteForceApproachStringSearch = new BruteForceApproachStringSearch();
		
		bruteForceApproachStringSearch.search2("abc", "babcd");

	}

	 // return offset of first match or N if no match
    public static int search2(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) return i - M;    // found
        else        return N;        // not found
    }
    

    // return offset of first match or N if no match
    public static int search2(char[] pattern, char[] text) { 
        int M = pattern.length;
        int N = text.length;
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (text[i] == pattern[j]) j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) return i - M;    // found
        else        return N;        // not found
    } 


}
