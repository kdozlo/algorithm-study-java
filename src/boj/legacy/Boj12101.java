package boj.legacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 12101
 * 1, 2, 3 더하기 2
 * 실버1
 * https://www.acmicpc.net/problem/12101
 */
public class Boj12101 {

    //내풀이
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == 1 && k == 1) {
            System.out.println("1");
            return;
        }

        if (n == 2 && k == 1) {
            System.out.println("1+1");
            return;
        }

        if (n == 2 && k == 2) {
            System.out.println("2");
            return;
        }

        if (n < 3 && k > 1) {
            System.out.println("-1");
            return;
        }

        int[] cnt = new int[n + 1];

        cnt[1] = 1;
        cnt[2] = 2;
        cnt[3] = 4;

        for(int i = 4; i < n+1; i++) {
            cnt[i] = cnt[i -1] + cnt[i - 2] + cnt[i - 3];
        }

        String[][] dp = new String[n + 1][cnt[n]];

        dp[1][0] = "1";

        dp[2][0] = "1+1";
        dp[2][1] = "2";

        dp[3][0] = "1+1+1";
        dp[3][1] = "1+2";
        dp[3][2] = "2+1";
        dp[3][3] = "3";

        for(int i = 4; i < n+1; i++) {

            for (int j = 0; j < cnt[i-3]; j++) {
                dp[i][j] = dp[i-3][j] + "+3";
            }

            for (int j = 0; j < cnt[i-2]; j++) {
                dp[i][cnt[i-3] + j] = dp[i-2][j] + "+2";
            }

            for (int j = 0; j < cnt[i - 1]; j++) {
                dp[i][cnt[i-3] + cnt[i -2] + j] = dp[i-1][j] + "+1";
            }
        }

        Arrays.sort(dp[n]);


        if(k > cnt[n]) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n][k-1]);
        }
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<String>[] arr = new ArrayList[n + 3];

        for(int i = 0; i <= n + 2; i++) {
            arr[i] = new ArrayList<>();
        }

        arr[1].add("1");

        arr[2].add("1+1");
        arr[2].add("2");

        arr[3].add("1+2");
        arr[3].add("1+1+1");
        arr[3].add("2+1");
        arr[3].add("3");

        for(int i = 4; i <= n; i++) {
            for(int j = 1; j <= 3; j++) {
                for(String op : arr[i - j]) {
                    arr[i].add(op + "+" + j);
                }
            }
        }

        if(arr[n].size() < k) {
            System.out.println(-1);
        } else {
            Collections.sort(arr[n]);
            System.out.println(arr[n].get(k-1));
        }
    }
}