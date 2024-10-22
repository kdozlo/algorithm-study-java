package boj;

import java.io.*;
import java.util.*;

/**
* 백준 4179
* 불!
* 골드3
* https://www.acmicpc.net/problem/4179
*/
public class Boj4179 {

    private static int[][] map;
    private static int R; //행
    private static int C; //열

    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        int r =  -1; //시작 행
        int c = -1; //시작 열
        for(int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                if(temp[j] == 'J') {
                    r = i;
                    c = j;
                } else if(temp[j] == 'F') {
                    map[i][j] = 1;
                } else if(temp[j] == '#') {
                    map[i][j] = -1;
                }
            }
        }

        spreadFire();

        System.out.println(findRoot(r, c));

    }

    public static String findRoot(int r, int c) {

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        q.add(new int[]{r, c, 1});

        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C)
                    return String.valueOf(cur[2]);

                if(map[nr][nc] != 0 && map[nr][nc] <= cur[2] + 1)
                    continue;

                if(visited[nr][nc])
                    continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, cur[2] + 1});
            }
        }

        return "IMPOSSIBLE";
    }

    public static void spreadFire() {

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 1)
                    q.add(new int[]{i, j, 1});
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C)
                    continue;

                if(map[nr][nc] != 0)
                    continue;

                map[nr][nc] = cur[2] + 1;
                q.add(new int[]{nr, nc, cur[2] + 1});
            }
        }
    }
}
