package boj;

import java.util.*;
import java.io.*;

/**
* 백준 6497
* 전력난
* 골드4
* https://www.acmicpc.net/problem/6497
*/
public class Boj6497 {

    private static class City implements Comparable<City> {
        int s;
        int e;
        int cost;

        City(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return Integer.compare(cost, o.cost);
        }
    }

    static int m; //집의 수
    static int n; //길의 수
    static PriorityQueue<City> pq;
    static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if(m == 0 && n == 0)
                break;

            int totalCost = 0;
            pq = new PriorityQueue<>();
            while(n-- > 0) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                pq.add(new City(s, e, cost));
                totalCost += cost;
            }

            parent = new int[m];
            for(int i = 0; i < m; i++)
                parent[i] = i;

            sb.append(totalCost - kruskal()).append("\n");
        }
        System.out.print(sb);
    }

    public static int kruskal() {
        int cost = 0;

        while(!pq.isEmpty()) {
            City c = pq.poll();

            if(union(c.s, c.e)) {
                cost += c.cost;
            }
        }

        return cost;
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b)
            return false;

        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;

        return true;
    }

    public static int find(int a) {
        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }
}
