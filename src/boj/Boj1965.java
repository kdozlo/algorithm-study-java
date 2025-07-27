package boj;

import java.util.*;
import java.io.*;

/**
* 백준 1965
* 상자넣기
* 실버2
* https://www.acmicpc.net/problem/1965
*/
public class Boj1965 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] boxes = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            boxes[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(boxes[i] < boxes[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        int max = dp[0];
        for(int i = 1; i < n; i++)
            max = Math.max(max, dp[i]);

        System.out.println(max + 1);
    }
}
