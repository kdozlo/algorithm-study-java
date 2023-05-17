package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/**
 * 백준 1753
 * 최단경로
 * 골드 4
 * https://www.acmicpc.net/problem/1753
 */

class Node implements Comparable<Node>{
    int end;
    int w;
    public Node(int end, int w) {
        this.end = end;
        this.w = w;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.w, node.w);
    }
}

public class Boj1753 {

    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];
        dist = new int[v + 1];
        int INF = Integer.MAX_VALUE;

        for(int i = 1; i < v + 1; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Node node = new Node(end, w);

            graph[start].add(node);
        }

        Dijkstra(s);

        for(int i = 1; i < v + 1; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }

    public static void Dijkstra(int s) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if(dist[curNode.end] < curNode.w)
                continue;

            for(Node node : graph[curNode.end]) {
                int cost = curNode.w + node.w;
                if (cost < dist[node.end]) {
                    dist[node.end] = cost;
                    pq.add(new Node(node.end, cost));
                }
            }
        }
    }
}


