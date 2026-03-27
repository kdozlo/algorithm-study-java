package boj.y2026;

import java.util.*;
import java.io.*;

/*
 * 백준 2512
 * 예산
 * 실버2
 * https://www.acmicpc.net/problem/2512
 */
public class Boj2512 {

    private static int N;
    private static int[] budgets;
    private static int totalBudget;

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(binearySearch());
    }

    private static int binearySearch() {
        int l = 0;
        int r = budgets[N - 1];

        while(l <= r) {
            int mid = (r + l) >>> 1;

            if(checking(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }

    private static boolean checking(int mid) {
        long sum = 0;

        for(int i : budgets) {
            if(i > mid)
                sum += mid;
            else
                sum += i;

            if(sum > totalBudget)
                return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());

        budgets = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(budgets);

        totalBudget = Integer.parseInt(br.readLine());
    }
}
