package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 17951
* 흩날리는 시험지 속에서 내 평점이 느껴진거야
* 골드3
* https://www.acmicpc.net/problem/17951
*/
public class Boj17951 {

    private static int N; // 시험지 개수
    private static int K; // 나눌 그룹 수
    private static int[] score; // 맞은 문제의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        score = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            score[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 2000000;
        while(left <= right) {
            int mid = (left + right) >>> 1;

            int group = 0;
            int curSum = 0;
            for(int i = 0; i < N; i++) {
                curSum += score[i];

                if(curSum >= mid) {
                    group++;
                    curSum = 0;
                }
            }

            if(group >= K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(right);
    }
}
