package boj.legacy;

import java.util.*;
import java.io.*;

/**
 * 백준 1027
 * 고층 건물
 * 골드4
 * https://www.acmicpc.net/problem/1027
 */
public class Boj1027 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] buildings = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            buildings[i] = Integer.parseInt(st.nextToken());


        int max = 0;
        for(int i = 0; i < N; i++) {
            int cnt = 0;

            if(i + 1 < N) {
                cnt++;
                for(int j = i + 2; j < N; j++) {
                    int cur = buildings[j];
                    boolean flag = true;
                    for(int k = i + 1; k < j; k++) {
                        double mid = midH(buildings[i], cur, k - i, j - k);

                        if(mid <= buildings[k]) {
                            flag = false;
                            break;
                        }
                    }

                    if(flag) {
                        cnt++;
                    }
                }
            }

            if(i - 1 >= 0) {
                cnt++;
                for(int j = i - 2; j >= 0; j--) {
                    int cur = buildings[j];
                    boolean flag = true;
                    for(int k = i - 1; k > j; k--) {
                        double mid = midH(cur, buildings[i], k - j, i - k);

                        if(mid <= buildings[k]) {
                            flag = false;
                            break;
                        }
                    }

                    if(flag) {
                        cnt++;
                    }
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    public static double midH(int a, int b, int aD, int bD) {

        return (((long) a * bD) + ((long)b * aD)) / (double) (aD + bD);
    }
}
