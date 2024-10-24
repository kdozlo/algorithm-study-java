package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 1865
 * 웜홀
 * 골드3
 * https://www.acmicpc.net/problem/1865
 * Bellman-Ford
 */
public class Boj1865_BellmanFord {

    private static class Edge {
        int u; //시작 정점
        int v; //끝 정점
        int w; //가중치

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private static List<Edge> g;

    private static int INF = 10001;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); //지점 수
            int M = Integer.parseInt(st.nextToken()); //도로 개수
            int W = Integer.parseInt(st.nextToken()); //웜홀 개수

            g = new ArrayList<>();

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                g.add(new Edge(a, b, cost));
                g.add(new Edge(b, a, cost));
            }

            for(int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                g.add(new Edge(a, b, -cost));
            }

            if(bellmanFord())
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        System.out.print(sb);
    }

    public static boolean bellmanFord() {

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        for(int i = 0; i < N - 1; i++) {
            boolean updated = false;
            for(Edge e : g) {
                if(dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                    updated = true;
                }
            }

            if(!updated)
                return false;
        }

        for(Edge e : g) {
            if(dist[e.u] != INF && dist[e.u] + e.w < dist[e.v])
                return true;
        }

        return false;
    }
}
