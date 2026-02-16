package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 2109
* 순회강연
* 골드3
* https://www.acmicpc.net/problem/2109
*/
public class Boj2109 {

    private static class Node implements Comparable<Node> {
        int p;
        int d;

        Node(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if(p == o.p)
                return Integer.compare(d, o.d);

            return Integer.compare(o.p, p);
        }
    }

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        if(n == 0) {
            System.out.println(0);
            return;
        }

        Node[] nodes = new Node[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(nodes);

        parent = new int[10001];
        for(int i = 1; i < 10001; i++)
            parent[i] = i;

        int answer = 0;
        for(Node node : nodes) {
            int day = find(node.d);

            if(day > 0) {
                answer += node.p;
                parent[day] = find(day - 1);
            }
        }

        System.out.println(answer);
    }

    public static int find(int x) {
        if(parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }
}
