package boj.legacy;

import java.io.*;
import java.util.*;

/**
 * 백준 15651
 * N과 M (3)
 * 실버3
 * https://www.acmicpc.net/problem/15651
 */
public class Boj15651 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        pick(new boolean[M][N + 1], N, M, 0);

        System.out.print(sb);
    }

    public static void pick(boolean[][] visited, int n, int m, int cnt) {
        if(cnt == m) {
            for(int i = 0; i < m; i++) {
                for(int j = 1; j < n + 1; j++)
                    if(visited[i][j])
                        sb.append(j).append(" ");
            }

            sb.append("\n");

            return;
        }

        for(int i = 1; i < n + 1; i++) {
            if(visited[cnt][i])
                continue;

            visited[cnt][i] = true;
            pick(visited, n, m, cnt + 1);
            visited[cnt][i] = false;
        }
    }
}
