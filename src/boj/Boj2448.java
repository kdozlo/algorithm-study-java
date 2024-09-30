package boj;

import java.io.*;

/**
 * 백준 2448
 * 별 찍기 - 11
 * 골드4
 * https://www.acmicpc.net/problem/2448
 */
public class Boj2448 {

    static int N;
    static boolean[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stars = new boolean[N][N * 2];

        divided(0, N - 1, N);

        printStars();
    }

    public static void divided(int r, int c, int cnt) {
        if(cnt == 3) {
            stars[r][c] = true;
            stars[r + 1][c - 1] = true;
            stars[r + 1][c + 1] = true;

            for(int i = c - 2; i <= c + 2; i++)
                stars[r + 2][i] = true;

            return;
        }

        int next = cnt / 2;
        divided(r, c, next);
        divided(r + next, c - next, next);
        divided(r + next, c  + next, next);
    }

    public static void printStars() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2; j++) {
                if (stars[i][j])
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
