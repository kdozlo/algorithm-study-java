package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 1326
* 폴짝폴짝
* 실버2
* https://www.acmicpc.net/problem/1326
*/
public class Boj1326 {

    private static int N;
    private static int[] bridges;
    private static int start;
    private static int end;

    public static void main(String[] args) throws IOException {
        getInput();

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == end)
                return cur[1];

            int next = cur[0] + bridges[cur[0]];
            while(next < N) {
                if(!visited[next]) {
                    q.add(new int[]{next, cur[1] + 1});
                    visited[next] = true;
                }
                next += bridges[cur[0]];
            }

            next = cur[0] - bridges[cur[0]];
            while(next >= 0) {
                if(!visited[next]) {
                    q.add(new int[]{next, cur[1] + 1});
                    visited[next] = true;
                }
                next -= bridges[cur[0]];
            }
        }

        return -1;
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        bridges = new int[N];
        for(int i = 0; i < N; i++)
            bridges[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;
    }
}
