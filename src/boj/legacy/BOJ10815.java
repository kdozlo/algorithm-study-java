package boj.legacy;

import java.io.*;
import java.util.*;

/**
 * 백준 10815
 * 숫자 카드
 * 실버 5
 * https://www.acmicpc.net/problem/10815
 */
public class BOJ10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수

        st = new StringTokenizer(br.readLine());
        int[] cards = fillArray(st, N);

        int M = Integer.parseInt(br.readLine()); // 주어진 숫자 개수
        st = new StringTokenizer(br.readLine());
        int[] nums = fillArray(st, M);

        Arrays.sort(cards);

        for(int n : nums) {
            sb.append(binarySearch(n, cards, N)).append(" ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int n, int[] cards, int len) {
        int left = 0;
        int right = len - 1;

        while(left <= right) {
            int mid = left + ((right - left) / 2);

            if(cards[mid] < n) {
                left = mid + 1;
            } else if(cards[mid] > n) {
                right = mid - 1;
            } else {
                return 1;
            }
        }

        return 0;
    }

    private static int[] fillArray(StringTokenizer st, int len) {
        int[] array = new int[len];

        for(int i = 0; i < len; i++)
            array[i] = Integer.parseInt(st.nextToken());

        return array;
    }
}
