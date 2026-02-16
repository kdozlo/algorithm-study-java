package boj.legacy;

import java.util.Scanner;


/**
 * 백준 12865
 * 평범한 배낭
 * 골드5
 * https://www.acmicpc.net/problem/12865
 */
public class Boj12865 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] ary = new int[n + 1][2];
        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1; i < n + 1; i++){
            ary[i][0] = sc.nextInt();
            ary[i][1] = sc.nextInt();
        }

        for(int i=1; i<=n; i++){
            int weight = ary[i][0];
            int value = ary[i][1];
            for(int j=1; j<=k; j++){
                if(weight <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight]+value);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
