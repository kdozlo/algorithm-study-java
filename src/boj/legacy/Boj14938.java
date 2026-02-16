package boj.legacy;

import java.util.*;
import java.io.*;

/**
 * 백준 14938
 * 서강그라운드
 * 골드 4
 * https://www.acmicpc.net/problem/14938
 */
public class Boj14938 {

    private static class Area implements Comparable<Area> {
        int num;
        int cost;

        public Area(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Area a) {
            return Integer.compare(cost, a.cost);
        }
    }

    private static int n; // 지역 수
    private static int m; // 수색 범위
    private static int[] items; // 지역별 아이템 수
    private static List<Area>[] l; // 연결된 지역 정보

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()); // 길 수

        items = new int[n + 1];
        l = new List[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            l[i] = new ArrayList<>();
        }

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Area a1 = new Area(n1, cost);
            Area a2 = new Area(n2, cost);

            l[n1].add(a2);
            l[n2].add(a1);
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dijkstra(i));
        }

        System.out.println(max);
    }

    public static int dijkstra(int i) {
        int total = 0;
        PriorityQueue<Area> pq = new PriorityQueue<>();
        pq.add(new Area(i, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 17);
        dist[i] = 0;

        while(!pq.isEmpty()) {
            Area cur = pq.poll();

            if(cur.cost > dist[cur.num])
                continue;

            total += items[cur.num];

            for(Area next : l[cur.num]) {

                if(cur.cost + next.cost >= dist[next.num] || cur.cost + next.cost > m)
                    continue;

                dist[next.num] = cur.cost + next.cost;
                pq.add(new Area(next.num, dist[next.num]));

            }

        }

        return total;
    }
}
