package boj;

import java.io.*;

/**
 * 백준 1509
 * 팰린드롬 분할
 * 골드1
 * https://www.acmicpc.net/problem/1509
 */
public class Boj1509 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray();
        int len = s.length;

        boolean[][] dp = new boolean[len][len];

        for(int i = 0; i < len; i++)
            dp[i][i] = true;

        for(int i = 1; i < len; i++) {
            if(s[i - 1] == s[i])
                dp[i - 1][i] = true;
        }

        for(int l = 2; l < len; l++) {
            for(int i = 0; i < len - l; i++) {
                int j = i + l;
                if(s[i] == s[j] && dp[i + 1][j - 1])
                    dp[i][j] = true;
            }
        }

        int[] answer = new int[len];

        for(int i = 0; i < len; i++) {
            if(dp[0][i]) {
                answer[i] = 1;
            } else {
                answer[i] = 2501;

                for(int j = 0; j < i; j++) {
                    if(dp[j + 1][i]) {
                        answer[i] = Math.min(answer[i], answer[j] + 1);
                    }
                }
            }
        }

        System.out.println(answer[len - 1]);
    }
}
