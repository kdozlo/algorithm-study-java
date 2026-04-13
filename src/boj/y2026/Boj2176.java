package boj.y2026;

import java.util.*;
import java.io.*;

/*
 * 백준 2176
 * 합리적인 이동경로
 * 골드2
 * https://www.acmicpc.net/problem/2176
 */
public class Boj2176 {

    private static final int INF = 1000000000;

    private static class Node implements Comparable<Node> {
        int index;
        int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    private static int N;
    private static int M;
    private static int[] distance;
    private static List<Node>[] graph;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];
        for(int i = 0; i < N + 1; i++)
            distance[i] = INF;

        graph = new List[N + 1];
        for(int i = 1; i < N + 1; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        dp = new int[N + 1];
        dijkstra(2);

        System.out.println(dp[1]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;
        dp[2] = 1;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(distance[cur.index] < cur.distance)
                continue;

            for(Node n : graph[cur.index]) {
                int dist = distance[cur.index] + n.distance;

                if(dist < distance[n.index]) {
                    distance[n.index] = dist;
                    pq.add(new Node(n.index, dist));
                }

                if(distance[n.index] > distance[cur.index])
                    dp[n.index] += dp[cur.index];
            }
        }
    }
}
