package boj.legacy;

import java.io.*;
import java.util.*;

/**
* 백준 1865
* 웜홀
* 골드3
* https://www.acmicpc.net/problem/1865
* Floyd-Warshall
*/
public class Boj1865_FloydWarshall {

    private static int INF = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); //지점 수
            int M = Integer.parseInt(st.nextToken()); //도로 개수
            int W = Integer.parseInt(st.nextToken()); //웜홀 개수

            int[][] dist = new int[N + 1][N + 1];
            for(int i = 1; i <= N; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                dist[a][b] = Math.min(dist[a][b], cost);
                dist[b][a] = Math.min(dist[b][a], cost);
            }

            for(int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                dist[a][b] = -cost;
            }

            floydWarshall(dist, N);

            boolean isNegativeCycle = false;
            for(int i = 1; i <= N; i++) {
                if(dist[i][i] < 0) {
                    isNegativeCycle = true;
                    break;
                }
            }

            if(isNegativeCycle)
                sb.append("YES\n");
            else
                sb.append("NO\n");

        }

        System.out.print(sb);
    }


    public static void floydWarshall(int[][] dist, int n) {
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                if (dist[i][k] == INF) continue;
                for(int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
