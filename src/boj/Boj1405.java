package boj;

import java.util.*;
import java.io.*;

/**
* 백준 1405
* 미친 로봇
* 골드4
* https://www.acmicpc.net/problem/1405
*/
public class Boj1405 {

    private static int N;
    private static double[] p; // 동 서 남 북 순서
    private static boolean[][] visited;
    private static double result;

    private static int[] dx = {1, -1, 0, 0}; // 동 서 남 북 순서
    private static int[] dy = {0, 0, -1, 1}; // 동 서 남 북 순서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        p = new double[4];
        for(int i = 0; i < 4; i++)
            p[i] = Integer.parseInt(st.nextToken()) / 100.0;

        visited = new boolean[29][29];

        result = 0.0;
        visited[14][14] = true;
        dfs(14, 14, 0, 1.0);

        System.out.println(result);
    }

    public static void dfs(int x, int y, int index, double curP) {
        if(index == N) {
            result += curP;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(visited[nx][ny])
                continue;

            visited[nx][ny] = true;
            dfs(nx, ny, index + 1, curP * p[i]);
            visited[nx][ny] = false;
        }
    }


}
