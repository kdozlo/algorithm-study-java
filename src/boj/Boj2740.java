package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2740
 * 행렬 곱셈
 * 실버4
 * https://www.acmicpc.net/problem/2740
 */
public class Boj2740 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // A행렬 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];


        //br의 한 라인씩 읽으니까 st 계속 new 해줘야함
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        // B행렬 입력
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        int[][] B = new int[M][K];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬 계산 및 출력
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                int sum = 0;
                for(int k = 0; k < M; k++) {
                    sum += A[i][k] * B[k][j];
                }
                sb.append(sum).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
