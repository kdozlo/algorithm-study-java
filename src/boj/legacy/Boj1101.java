package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 1101
* 카드 정리 1
* 골드4
* https://www.acmicpc.net/problem/1101
*/
public class Boj1101 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 박스 수
        int M = Integer.parseInt(st.nextToken()); // 색 종류 수

        int[][] boxes = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                boxes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 50;
        for(int joker = 0; joker < N; joker++) {
            int temp = 0; // 이동 횟수
            boolean[] visited = new boolean[M];

            for(int i = 0; i < N; i++) {
                if(i == joker)
                    continue;

                int cnt = 0; // 색 종류 수
                int color = -1; // 색 종류
                for(int j = 0; j < M; j++) {
                    if(boxes[i][j] != 0) {
                        cnt++;
                        color = j;
                    }
                }

                if(cnt == 1) {
                    if(visited[color])
                        temp++;
                    else
                        visited[color] = true;
                } else if(cnt > 1) {
                    temp++;
                }
            }

            answer = Math.min(answer, temp);
        }

        System.out.println(answer);
    }
}
