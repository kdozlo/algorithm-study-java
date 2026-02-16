package boj.legacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

/**
 * 백준 14949
 * 쉬운 최단거리
 * 실버1
 * https://www.acmicpc.net/problem/14940
 */
public class Boj14940 {

    private static final int[] dx = {1,0,-1,0};
    private static final int[] dy = {0,-1,0,1};
    private static int m ,n;
    private static int[][] map, distance;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        distance = new int[n][m];

        int targetX = -1;
        int targetY = -1;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp ;

                if(temp == 2) {
                    targetX = i;
                    targetY = j;
                }
            }
        }

        bfs(targetX, targetY);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    distance[i][j] = -1;
                }
                sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (map[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY]) continue;

                queue.add(new Point(nextX, nextY));
                distance[nextX][nextY] = distance[current.x][current.y] + 1;
                visited[nextX][nextY] = true;
            }

        }
    }
    private static class Point {
        public int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


