package boj;

import java.util.*;
import java.io.*;

/**
 * 백준 1197
 * 최소 스패닝 트리
 * 골드 4
 * https://www.acmicpc.net/problem/1197
 */
public class Boj1197 {

    private static class Node implements Comparable<Node> {
        int v1;
        int v2;
        long value;

        public Node(int v1, int v2, long value) {
            this.v1 = v1;
            this.v2 = v2;
            this.value = value;
        }

        @Override
        public int compareTo(Node n) {
            return Long.compare(value, n.value);
        }
    }

    static int V; // vertex
    static int E; // edge
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        rank = new int[V + 1];

        for(int i = 1; i <= V; i++)
            parent[i] = i;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            pq.add(new Node(v1, v2, value));
        }
        long answer = 0;
        while(!pq.isEmpty()) {
            Node n = pq.poll();

            if(uion(n.v1, n.v2)) {
                answer += n.value;
            }
        }

        System.out.println(answer);
    }

    public static int find(int a) {
        if(a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    public static boolean uion(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b)
            return false;

        if(rank[a] < rank[b]) {
            parent[a] = b;
        } else if(rank[a] > rank[b]) {
            parent[b] = a;
        } else {
            parent[b] = a;
            rank[a]++;
        }

        return true;
    }

}
