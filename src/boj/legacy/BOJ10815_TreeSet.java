package boj.legacy;

import java.io.*;
import java.util.*;

/**
 * 백준 10815
 * 숫자 카드
 * 실버 5
 * https://www.acmicpc.net/problem/10815
 */
public class BOJ10815_TreeSet {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수
        Set<Integer> cards = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine()); // 주어진 숫자 개수
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            if(cards.contains(target))
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
}
