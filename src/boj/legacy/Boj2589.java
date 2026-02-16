package boj.legacy;

import java.util.*;
import java.io.*;

/**
 * 백준 2589
 * 보물섬
 * 골드5
 * https://www.acmicpc.net/problem/2589
 */
public class Boj2589 {

    private static int R, C;
    private static char[][] map;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int maxDistance = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    maxDistance = Math.max(maxDistance, bfs(i, j));
                }
            }
        }

        System.out.println(maxDistance);
    }

    private static int bfs(int r, int c) {
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0});
        visited[r][c] = true;

        int max = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0], cc = cur[1], dist = cur[2];
            max = Math.max(max, dist);

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == 'W') {
                    continue;
                }

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc, dist + 1});
            }
        }

        return max;
    }
}
