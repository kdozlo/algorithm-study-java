package boj.legacy;

import java.io.*;

/**
* 백준 9252
* LCS 2
* 골드4
* https://www.acmicpc.net/problem/9252
*/
public class Boj9252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] w1 = br.readLine().toCharArray();
        char[] w2 = br.readLine().toCharArray();

        int len1 = w1.length;
        int len2 = w2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i1 = len1;
        int i2 = len2;

        while(i1 > 0 && i2 > 0) {
            if(w1[i1 - 1] == w2[i2 - 1]) {
                sb.append(w1[i1 - 1]);
                i1--;
                i2--;
            } else if (dp[i1 - 1][i2] > dp[i1][i2 - 1]) {
                i1--;
            } else {
                i2--;
            }
        }

        System.out.println(dp[len1][len2]);
        System.out.print(sb.reverse());
    }
}
