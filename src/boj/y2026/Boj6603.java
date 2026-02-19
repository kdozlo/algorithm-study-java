package boj.y2026;

import java.io.*;
import java.util.*;

/*
 * 백준 6603
 * 로또
 * 실버2
 * https://www.acmicpc.net/problem/6603
 */
public class Boj6603 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k == 0)
                break;

            int[] array = new int[k];
            for(int i = 0; i < k; i++)
                array[i] = Integer.parseInt(st.nextToken());

            combi(0, 0, array, new int[6]);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void combi(int start, int depth, int[] array, int[] result) {
        if(depth == 6) {
            for(int i = 0; i < 6; i++)
                sb.append(result[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = start; i < array.length; i++) {
            result[depth] = array[i];
            combi(i + 1, depth + 1, array, result);
        }
    }
}
