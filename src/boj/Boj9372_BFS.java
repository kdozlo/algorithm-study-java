package boj;

import java.util.*;
import java.io.*;

/**
 * 백준 9372
 * 상근이의 여행
 * 실버4
 * https://www.acmicpc.net/problem/9372
 */
public class Boj9372_BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 국가의 수
            int M = Integer.parseInt(st.nextToken()); // 비행기의 종류

            List<Integer>[] l = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++)
                l[i] = new ArrayList<>();

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                l[a].add(b);
                l[b].add(a);
            }

            int cnt = 0;

            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            boolean[] visited = new boolean[N + 1];
            visited[1] = true;
            while(!q.isEmpty()) {
                int cur = q.poll();

                for(int i : l[cur]) {
                    if(visited[i])
                        continue;

                    visited[i] = true;
                    cnt++;
                    q.add(i);
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
