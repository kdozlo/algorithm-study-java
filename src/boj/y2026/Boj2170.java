package boj.y2026;

import java.util.*;
import java.io.*;

/*
 * 백준 2170
 * 선 긋기
 * 골드 5
 * https://www.acmicpc.net/problem/2170
 */
public class Boj2170 {

    private static int N; // 선을 그은 횟수
    private static List<int[]> l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        l = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            l.add(new int[]{a, b});
        }

        Collections.sort(l, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });


        int start = l.get(0)[0];
        int end = l.get(0)[1];
        long answer = 0;
        for(int i = 1; i < N; i++) {
            int a = l.get(i)[0];
            int b = l.get(i)[1];

            if(end >= a) {
                end = Math.max(end, b);
            } else {
                answer += end - start;
                start = a;
                end = b;
            }
        }

        answer += end - start;

        System.out.println(answer);
    }
}
