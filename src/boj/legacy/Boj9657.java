package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 9657
* 돌 게임 3
* 실버3
* https://www.acmicpc.net/problem/9657
*/
public class Boj9657 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[N + 1];

        dp[1] = true;
        if(N > 1)
            dp[2] = false;
        if(N > 2)
            dp[3] = true;
        if(N > 3)
            dp[4] = true;

        for(int i = 5; i <= N; i++)
            dp[i] = !(dp[i - 1] && dp[i - 3] && dp[i - 4]);

        System.out.println(dp[N] ? "SK" : "CY");
    }
}
