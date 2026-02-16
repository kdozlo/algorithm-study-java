package boj.legacy;

import java.util.*;
import java.io.*;

/**
 * 백준 9372
 * 상근이의 여행
 * 실버4
 * https://www.acmicpc.net/problem/9372
 */
public class Boj9372_Tree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 국가의 수
            int M = Integer.parseInt(st.nextToken()); // 비행기의 종류

            for(int i = 0; i < M; i++) {
                br.readLine();
            }

            sb.append(N - 1).append("\n");
        }

        System.out.print(sb);
    }
}
