package boj.legacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;


/**
 * 백준 1260
 * DFS와 BFS
 * 실버1
 * https://www.acmicpc.net/problem/1260
 */
public class Boj1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] ary = new int[n + 1][n + 1];

        int[] visited = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ary[a][b] = 1;
            ary[b][a] = 1;
        }

        dfs(ary, visited, v);
        System.out.println();
        Arrays.fill(visited, 0);
        bfs(ary, visited, v);
    }

    public static void dfs(int[][] ary, int[] visited, int v) {

        visited[v] = 1;
        System.out.print(v+" ");

        for (int i = 1; i < ary.length; i++) {
            if (ary[v][i] == 1 && visited[i] == 0) {
                dfs(ary, visited, i);
            }
        }
    }

    public static void bfs(int[][] ary, int[] visited, int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        visited[v] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            System.out.print(cur + " ");

            for(int i = 1; i < ary.length; i++) {
                if(ary[cur][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    q.add(i);
                }
            }
        }
    }
}
