package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 10942
 * 팰린드롬?
 * 골드 4
 * https://www.acmicpc.net/problem/10942
 */
public class Boj10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N + 1];
        for(int i = 1; i <= N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[N + 1][N + 1];
        //길이 1인 팰린드롬
        for(int i = 1; i <= N; i++)
            dp[i][i] = true;

        //길이 2인 팰린드롬
        for(int i = 1; i < N; i++) {
            if(nums[i] == nums[i + 1])
                dp[i][i + 1] = true;
        }

        //길이 3이상 팰린드롬
        for(int l = 2; l <= N; l++) {
            for(int i = 1; i <= N - l + 1; i++) {
                int j = i + l - 1;
                if(nums[i] == nums[j] && dp[i + 1][j - 1])
                    dp[i][j] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(dp[s][e])
                sb.append(1);
            else
                sb.append(0);

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
