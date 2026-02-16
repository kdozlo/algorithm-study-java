package boj.y2026;

import java.io.*;
import java.util.*;

/*
 * 백준 20040
 * 사이클 게임
 * 골드 4
 * https://www.acmicpc.net/problem/20040
 */
public class Boj20040 {

    private static int n; // 점의 수
    private static int m; // 진행 차례 수
    private static int[] parent;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!union(a, b)) {
                answer = i + 1;
                break;
            }
        }

        System.out.println(answer);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b)
            return false;
        if(a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }

        return true;
    }

    private static int find(int a) {
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}
