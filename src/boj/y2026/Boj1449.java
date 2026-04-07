package boj.y2026;

import java.util.*;
import java.io.*;

/*
 * 백준 1449
 * 수리공 항승
 * 실버3
 * https://www.acmicpc.net/problem/1449
 */
public class Boj1449 {

    private static int N; // 물이 새는 곳 개수
    private static int L; // 데이프 길이
    private static int[] locations; // 물 새는 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        locations = new int[N];
        for(int i = 0; i < N; i++) {
            locations[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(locations);

        int answer = 1;
        int cover = locations[0] + L;
        for(int i = 1; i < N; i++) {
            if(locations[i] >= cover) {
                answer++;
                cover = locations[i] + L;
            }
        }

        System.out.println(answer);
    }
}
