package boj;

import java.util.*;
import java.io.*;

/**
* 백준 2251
* 물통
* 골드4
* https://www.acmicpc.net/problem/2251
*/
public class Boj2251 {

    private static int A;
    private static int B;
    private static int C;
    private static boolean[][][] visited;
    private static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = getValue(st);
        B = getValue(st);
        C = getValue(st);

        visited = new boolean[A + 1][B + 1][C + 1];
        set = new TreeSet<>();

        dfs(0, 0, C);

        for(int i : set)
            System.out.print(i + " ");
    }

    private static void dfs(int curA, int curB, int curC) {
        if(visited[curA][curB][curC])
            return;

        visited[curA][curB][curC] = true;

        if(curA == 0)
            set.add(curC);

        // C -> A
        if(curC + curA >= A) {
            dfs(A, curB, curC - A + curA);
        } else if(A - curA >= curC){
            dfs(Math.min(curC + curA, A), curB, 0);
        }

        // C -> B
        if(curC + curB >= B) {
            dfs(curA, B, curC - B + curB);
        } else if(B - curB >= curC) {
            dfs(curA, Math.min(curC + curB, B), 0);
        }

        // A -> C
        if(curC + curA >= C) {
            dfs(curA - C + curC, curB, C);
        } else if(C - curC >= curA) {
            dfs(0, curB, Math.min(curA + curC, C));
        }

        // A -> B
        if(curB + curA >= B) {
            dfs(curA - B + curB, B, curC);
        } else if(B - curB >= curA) {
            dfs(0, Math.min(curA + curB, B), curC);
        }

        // B -> A
        if(curB + curA >= A) {
            dfs(A, curB - A + curA, curC);
        } else if(A - curA >= curB) {
            dfs(Math.min(curB + curA, A), 0, curC);
        }

        // B -> C
        if(curB + curC >= C) {
            dfs(curA, curB - C + curC, C);
        } else if(C - curC >= curB) {
            dfs(curA,  0, Math.min(curB + curC, C));
        }

    }

    private static int getValue(StringTokenizer st) {

        return Integer.parseInt(st.nextToken());
    }
}
