package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 1743
* 음식물 피하기
* 실버1
* https://www.acmicpc.net/problem/1743
*/
public class Boj1743 {

    private static int n; // 세로
    private static int m; // 가로
    private static int k; // 쓰레기 개수

    private static boolean[][] checked;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        checked = new boolean[n][m];

        for(int i =0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            checked[r][c] = true;
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(checked[i][j]) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(max);
    }

    private static int bfs(int r, int c) {
        int count = 1;

        checked[r][c] = false;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nextR = cur[0] + dx[i];
                int nextC = cur[1] + dy[i];

                if(nextR >= n || nextR < 0 || nextC >= m || nextC < 0)
                    continue;

                if(checked[nextR][nextC]) {
                    checked[nextR][nextC] = false;
                    q.add(new int[]{nextR, nextC});
                    count++;
                }
            }
        }

        return count;
    }
}
