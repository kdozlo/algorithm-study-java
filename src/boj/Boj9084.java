package boj;

import java.io.*;
import java.util.*;

/**
* 백준 9084
* 동전
* 골드5
* https://www.acmicpc.net/problem/9084
*/
public class Boj9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] count = new int[M + 1];
            count[0] = 1;
            for(int coin : coins) {
                for (int i = coin; i <= M; i++) {
                    count[i] += count[i - coin];
                }
            }

            sb.append(count[M]).append("\n");
        }

        System.out.println(sb);
    }
}
