package boj.legacy;

import java.util.*;
import java.io.*;

/**
 * 백준 2617
 * 구슬 찾기
 * 골드4
 * https://www.acmicpc.net/problem/2617
 */
public class Boj2617 {

    static int N; // 구슬 수
    static int M; // 확인 수

    static List<Integer>[] l; // 자기보다 큰 수
    static int[] big; // 자기보다 큰수의 개수
    static int[] small; // 자기보다 작은수의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        l = new List[N + 1];
        for(int i = 1; i < N + 1; i++) {
            l[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            l[b].add(a);
        }

        int criteria = N / 2;
        int answer = 0;
        small = new int[N + 1];
        big = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            dfs(new boolean[N + 1], i, i);
        }

        for(int i = 1; i <= N; i++) {
            if(small[i] > criteria || big[i] > criteria)
                answer++;
        }

        System.out.println(answer);
    }

    public static void dfs(boolean[] visited, int first, int cur) {

        for(int i : l[cur]) {
            if(visited[i])
                continue;

            visited[i] = true;
            big[i]++;
            small[first]++;
            dfs(visited, first, i);
        }
    }
}
