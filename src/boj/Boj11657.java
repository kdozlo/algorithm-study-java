package boj;

import java.util.*;
import java.io.*;

/**
* 백준 11657
* 타임머신
* 골드4
* https://www.acmicpc.net/problem/11657
*/
public class Boj11657 {

    private static class Edge {
        int a; // 시작 도시
        int b; // 도착 도시
        int c; // 걸리는 시간

        Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    private static final int INF = 5000001;

    private static int N; // 도시의 개수
    private static int M; // 버스 노선의 개수

    private static Edge[] g;
    private static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        g = new Edge[M];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            g[i] = new Edge(a, b, c);
        }

        StringBuilder sb = new StringBuilder();
        dist = new long[N + 1];
        if(BellmanFord(1)) {
            sb.append(-1);
        } else {
            for(int i = 2; i <= N; i++)
                if(dist[i] == INF)
                    sb.append(-1).append("\n");
                else
                    sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static boolean BellmanFord(int start) {
        Arrays.fill(dist, INF);

        dist[start] = 0;
        for(int i = 0; i < N - 1; i++) {
            boolean updated = false;

            for(Edge e : g) {
                if(dist[e.a] != INF && dist[e.a] + e.c < dist[e.b]) {
                    dist[e.b] = dist[e.a] + e.c;
                    updated = true;
                }
            }

            if(!updated)
                return false;
        }

        for(Edge e : g) {
            if(dist[e.a] != INF && dist[e.a] + e.c < dist[e.b])
                return true;
        }

        return false;
    }
}
