package boj;

import java.util.*;
import java.io.*;

/**
* 백준 11403
* 경로 찾기
* 골드
* https://www.acmicpc.net/problem/11403
*/
public class Boj11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(matrix[i][k] == 1 && matrix[k][j] == 1)
                        matrix[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
