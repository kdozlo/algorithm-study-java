package boj.legacy;

import java.util.*;
import java.io.*;

/**
 * 백준 2665
 * 미로만들기
 * 골드4
 * https://www.acmicpc.net/problem/2665
 */
public class Boj2665 {

    private static class Point implements Comparable<Point> {
        int r;
        int c;
        int cnt;

        Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        public int compareTo(Point p) {
            return Integer.compare(cnt, p.cnt);
        }
    }

    private static int n;
    private static char[][] rooms;

    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        rooms = new char[n][n];
        for(int i = 0; i < n; i++)
            rooms[i] = br.readLine().toCharArray();

        System.out.println(bfs());
    }

    public static int bfs() {

        PriorityQueue<Point> pq = new PriorityQueue<>();
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], 2500);
        }
        pq.add(new Point(0, 0, 0)); // row, col, changed room count

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if(cur.r == n - 1 && cur.c == n - 1) {
                return cur.cnt;
            }

            for(int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                int nCount = rooms[nr][nc] == '0' ? cur.cnt + 1 : cur.cnt;

                if(visited[nr][nc] <= nCount)
                    continue;

                visited[nr][nc] = nCount;
                pq.add(new Point(nr, nc, nCount));
            }

        }

        return -1;
    }
}
