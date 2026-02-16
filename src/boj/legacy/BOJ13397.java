package boj.legacy;

import java.util.*;
import java.io.*;

/**
 * 백준 13397
 * 구간 나누기 2
 * 골드4
 * https://www.acmicpc.net/problem/13397
 */
public class BOJ13397 {

    static int[] array;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 배열 사이즈
        M = Integer.parseInt(st.nextToken()); // 나누는 횟수

        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            array[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 10000;
        int answer = right;

        while(left <= right) {
            int mid = left + ((right - left) / 2);

            if(canDivide(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canDivide(int v) {
        int count = 1;
        int min = array[0];
        int max = array[0];

        for(int i = 1; i < N; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);

            if(max - min > v) {
                count++;
                min = array[i];
                max = array[i];
            }
        }

        return count <= M;
    }
}
