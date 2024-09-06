package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 15681
 * 트리와 쿼리
 * 골드5
 * https://www.acmicpc.net/problem/15681
 */
public class Boj15681 {

    static int N; // 트리 정점의 수
    static int R; // 루트 노드 번호
    static int Q; // 쿼리 수
    static List<Integer>[] l; // 노드에 연결된 노드 정보
    static boolean[] visited;
    static int[] countNode; // 서브트리 정점 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        l = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            l[i] = new ArrayList<>();
        }

        for(int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            l[a].add(b);
            l[b].add(a);
        }

        countNode = new int[N + 1];
        visited = new boolean[N + 1];
        countSubtreeNodes(R);

        for(int i = 0; i < Q; i++) {
            int cur = Integer.parseInt(br.readLine());
            sb.append(countNode[cur]).append("\n");
        }

        System.out.println(sb);
    }

    public static void countSubtreeNodes(int cur) {
        countNode[cur] = 1;
        visited[cur] = true;
        for(int i : l[cur]) {
            if(visited[i])
                continue;

            countSubtreeNodes(i);
            countNode[cur] += countNode[i];
        }
    }
}
