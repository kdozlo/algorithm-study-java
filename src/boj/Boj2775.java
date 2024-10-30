package boj;

import java.io.*;
import java.util.*;

/**
* 백준 2775
* 부녀회장이 될테야
* 브론즈1
* https://www.acmicpc.net/problem/2775
*/
public class Boj2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[15][15];

        for(int i = 1; i < 15; i++)
            dp[0][i] = i;

        for(int i = 1; i < 15; i++) {
            for(int j = 1; j < 15; j++) {
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
            }
        }

        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[k][n]).append("\n");
        }

        System.out.println(sb);
    }
}
