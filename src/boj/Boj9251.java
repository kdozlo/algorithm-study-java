package boj;

import java.util.Scanner;

/**
 * 백준 9251
 * LCS
 * 골드5
 * https://www.acmicpc.net/problem/9251
 */
public class Boj9251 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s1 = sc.nextLine().toCharArray();
        char[] s2 = sc.nextLine().toCharArray();

        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for(int i = 1; i < s1.length + 1; i++){

            for(int j = 1; j < s2.length + 1; j++) {
                if(s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[s1.length][s2.length]);
    }
}
