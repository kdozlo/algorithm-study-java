package boj.y2026;

import java.util.*;
import java.io.*;

/*
 * 백준 16398
 * 행성 연결
 * 골드4
 * https://www.acmicpc.net/problem/16398
 */
public class Boj16398 {

    private static class Edge implements Comparable<Edge> {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    private static int n; // number of planets
    private static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        cost = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(prim());

    }

    private static long prim() {
        long totalCost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];

        pq.add(new Edge(0, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(visited[cur.to])
                continue;

            visited[cur.to] = true;
            totalCost += cur.weight;

            for(int i = 0; i < n; i++) {
                if(visited[i])
                    continue;

                pq.add(new Edge(i, cost[cur.to][i]));
            }
        }

        return totalCost;
    }
}
