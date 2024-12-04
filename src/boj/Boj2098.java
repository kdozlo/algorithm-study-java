package boj;

import java.util.*;
import java.io.*;

/**
* 백준 2098
* 외판원 순회
* 골드 1
* https://www.acmicpc.net/problem/2098
*/
public class Boj2098 {

    static final int INF = 17_000_000;

    static int N; //도시 수
    static int[][] w; //비용
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        w = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][1 << N];
        for(int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);


        System.out.println(tsp(0, 1));
    }

    public static int tsp(int cur, int visited) {
        if(visited == (1 << N) - 1) {

            return w[cur][0] == 0 ? INF : w[cur][0];
        }

        // 이미 방문한 적이 있다.
        if(dp[cur][visited] != -1)
            return dp[cur][visited];

        // 방문 했다는 표시
        dp[cur][visited] = INF;

        for(int i = 0; i < N; i++) {
            int next = visited | (1 << i);

            // 가는 경로가 없는 경우, 이미 방문 했을 경우
            if(w[cur][i] == 0 || (visited & (1 << i)) != 0)
                continue;

            dp[cur][visited] = Math.min(dp[cur][visited], w[cur][i] + tsp(i, next));
        }

        return dp[cur][visited];
    }

}
