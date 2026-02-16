package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 1484
* 다이어트
* 골드5
* https://www.acmicpc.net/problem/1484
*/
public class Boj1484 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        boolean[] checked = new boolean[100001];

        for(int i = 1; i < G + 1; i++) {
            if(G % i == 0) {
                int temp = i + G / i;

                if(temp % 2 == 0) {
                    temp /= 2;
                    if(i - temp != 0)
                        checked[temp] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 100001; i++) {
            if(checked[i])
                sb.append(i).append("\n");
        }

        if(sb.length() == 0)
            System.out.println(-1);
        else
            System.out.print(sb);
    }
}
