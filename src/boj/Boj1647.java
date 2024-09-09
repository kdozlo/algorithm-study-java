package boj;

import java.util.*;
import java.io.*;

/**
 * 백준 1647
 * 도시 분할 계획
 * 골드4
 * https://www.acmicpc.net/problem/1647
 */
public class Boj1647 {

    private static class Node implements Comparable<Node> {

        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    static int N; // 집의 개수
    static int M; // 길의 개수
    static int[] parent; // 부모 노드
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        rank = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Node(to, from, cost));
        }

        int answer = 0;
        int index = 0;
        while(index < N - 2 && !pq.isEmpty()) {
            Node cur = pq.poll();

            if(union(cur.to, cur.from)) {
                answer += cur.cost;
                index++;
            }
        }

        System.out.println(answer);

    }

    public static int find(int a) {
        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b)
            return false;

        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else if (rank[a] > rank[b]) {
            parent[b] = a;
        } else {
            parent[b] = a;
            rank[a]++;
        }

        return true;
    }
}
