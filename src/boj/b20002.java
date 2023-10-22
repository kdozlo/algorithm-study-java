package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 20002
 * 사과나무
 * 골드 5
 * https://www.acmicpc.net/problem/20002
 */
public class b20002 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] apple;
    static int[][] prefix;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        apple = new int[n+1][n+1];
        prefix = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                apple[i][j] = Integer.parseInt(str.nextToken());
                prefix[i][j]=prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+apple[i][j];
            }
        }
        long max = -1001;
        for (int i = 1; i <= n; i++) {
            long tmp = harvest(i);
            max=Math.max(max, tmp);
        }
        System.out.println(max);
    }
    public static long harvest(int k){
        long max = -1001;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i+k-1>n||j+k-1>n) continue;
                int tmp = prefix[i+k-1][j+k-1]-prefix[i-1][j+k-1]-prefix[i+k-1][j-1]+prefix[i-1][j-1];
                max = Math.max(tmp, max);
            }
        }
        return max;
    }
}
