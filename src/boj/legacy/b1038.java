package boj.legacy;

import java.util.*;
import java.io.*;

/*
 * 백준 1038
 * 감소하는 수
 * 골드 5
 * https://www.acmicpc.net/problem/1038
 */
public class b1038 {

    static boolean[] check = new boolean[10];
    static List<Long> l = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int end = Integer.parseInt(st.nextToken());

        if(end <= 10)
            System.out.println(end);
        else {
            for(int i = 1; i <= 10; i++) {
                combi(i, 0, 0);
            }

            Collections.sort(l);
            if(end >= l.size())
                System.out.println(-1);
            else
                System.out.println(l.get(end));
        }


    }

    public static void combi(int d, int cnt, int cur) {
        if(d == cnt) {
            long place = 1;
            long num = 0;

            for(int i = 0; i < 10; i++) {
                if(check[i]) {
                    num += i * place;
                    place *= 10;
                }
            }

            l.add(num);

            return;
        }

        for(int i = cur; i < 10; i++) {
            if(check[i])
                continue;
            check[i] = true;
            combi(d, cnt + 1, i + 1);
            check[i] = false;
        }
    }
}
/**
 * 0 1 2 3 4 5 6 7 8 9 10 20 21 30 31 32 40 41 42 ... 9876543210
 */
