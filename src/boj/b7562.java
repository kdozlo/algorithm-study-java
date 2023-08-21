package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 7562
 * 나이트의 이동
 *  실버 1
 * https://www.acmicpc.net/problem/7562
 */
public class b7562 {

    static int l;
    static int sr;
    static int sc;
    static int er;
    static int ec;

    static int min;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //테스트 케이스
        int t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            //체스판 길이
            l = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            //출발 좌표
            sr = Integer.parseInt(st.nextToken());
            sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            //목표 좌표
            er = Integer.parseInt(st.nextToken());
            ec = Integer.parseInt(st.nextToken());

            min = Integer.MAX_VALUE;
            visited = new boolean[l][l];

            bfs();

            System.out.println(min);

        }

    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            if(temp[0] == er && temp[1] == ec) {
                min = Math.min(min, temp[2]);
                continue;
            }

            //위
            if(temp[0] - 2 >= 0 && temp[1] - 1 >= 0 && !visited[temp[0] - 2][temp[1] - 1]) {
                q.add(new int[]{temp[0] - 2, temp[1] - 1, temp[2] + 1});
                visited[temp[0] - 2][temp[1] - 1] = true;
            }

            if(temp[0] - 2 >= 0 && temp[1] + 1 < l && !visited[temp[0] - 2][temp[1] + 1]) {
                q.add(new int[]{temp[0] - 2, temp[1] + 1, temp[2] + 1});
                visited[temp[0] - 2][temp[1] + 1] = true;
            }

            //좌
            if(temp[1] - 2 >= 0 && temp[0] - 1 >= 0 && !visited[temp[0] - 1][temp[1] - 2]) {
                q.add(new int[]{temp[0] - 1, temp[1] - 2, temp[2] + 1});
                visited[temp[0] - 1][temp[1] - 2] = true;
            }

            if(temp[1] - 2 >= 0 && temp[0] + 1 < l && !visited[temp[0] + 1][temp[1] - 2]) {
                q.add(new int[]{temp[0] + 1, temp[1] - 2, temp[2] + 1});
                visited[temp[0] + 1][temp[1] - 2] = true;
            }

            //아래
            if(temp[0] + 2 < l && temp[1] - 1 >= 0 && !visited[temp[0] + 2][temp[1] - 1]) {
                q.add(new int[]{temp[0] + 2, temp[1] - 1, temp[2] + 1});
                visited[temp[0] + 2][temp[1] - 1] = true;
            }

            if(temp[0] + 2 < l && temp[1] + 1 < l && !visited[temp[0] + 2][temp[1] + 1]) {
                q.add(new int[]{temp[0] + 2, temp[1] + 1, temp[2] + 1});
                visited[temp[0] + 2][temp[1] + 1] = true;
            }

            //오른
            if(temp[1] + 2 < l && temp[0] - 1 >= 0 && !visited[temp[0] - 1][temp[1] + 2]) {
                q.add(new int[]{temp[0] - 1, temp[1] + 2, temp[2] + 1});
                visited[temp[0] - 1][temp[1] + 2] = true;
            }

            if(temp[1] + 2 < l && temp[0] + 1 < l && !visited[temp[0] + 1][temp[1] + 2]) {
                q.add(new int[]{temp[0] + 1, temp[1] + 2, temp[2] + 1});
                visited[temp[0] + 1][temp[1] + 2] = true;
            }

        }
    }

}
