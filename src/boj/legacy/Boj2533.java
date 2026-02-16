package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 2533
* 사회망 서비스(SNS)
* 골드3
* https://www.acmicpc.net/problem/2533
*/
public class Boj2533 {

    private static int N; // 정점 개수
    private static List<Integer>[] tree;

    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new List[N + 1];
        for(int i = 1; i < N + 1; i++)
            tree[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        dp = new int[2][N + 1];

        dfs(1, new boolean[N + 1]);

        System.out.println(Math.min(dp[0][1], dp[1][1]));
    }

    public static void dfs(int cur, boolean[] visited) {

        visited[cur] = true;
        dp[1][cur] = 1;
        dp[0][cur] = 0;

        for(int i : tree[cur]) {
            if(!visited[i]) {

                dfs(i, visited);

                dp[0][cur] += dp[1][i];
                dp[1][cur] += Math.min(dp[0][i], dp[1][i]);
            }
        }


    }
}
