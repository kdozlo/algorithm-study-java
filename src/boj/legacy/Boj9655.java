package boj.legacy;

import java.io.*;


/**
* 백준 9655
* 돌 게임
* 실버5
* https://www.acmicpc.net/problem/9655
*/
public class Boj9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[n + 1]; // 상근이 승리 = true, 상근이 패배 = false

        if(n >= 1)
            dp[1] = true;

        if(n >= 2)
            dp[2] = false;

        if(n >= 3)
            dp[3] = true;

        for(int i = 4; i <= n; i++)
            dp[i] = !(dp[i - 1] && dp[i - 3]);

        System.out.println(dp[n] ? "SK" : "CY");
    }
}
