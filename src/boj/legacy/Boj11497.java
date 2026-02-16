package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 11497
* 통나무 건너뛰기
* 실버1
* https://www.acmicpc.net/problem/11497
*/
public class Boj11497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine()); //통나무 개수
            int[] trees = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                trees[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(trees);

            int[] setting = new int[N];
            int index1 = 0;
            int index2 = N - 1;
            for(int i = 0; i < N; i++) {
                if(i % 2 == 0) {
                    setting[index1++] = trees[i];
                } else {
                    setting[index2--] = trees[i];
                }
            }

            int max = Math.abs(setting[0] - setting[N - 1]);
            for(int i = 1; i < N; i++)
                max = Math.max(max, Math.abs(setting[i] - setting[i - 1]));

            sb.append(max).append("\n");
        }

        System.out.print(sb);

    }
}
