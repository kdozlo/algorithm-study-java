package boj;

import java.io.*;
import java.util.*;

/**
* 백준 15663
* N과 M (9)
* 실버2
* https://www.acmicpc.net/problem/15663
*/
public class Boj15663 {

    private static int N;
    private static int M;
    private static int[] nums;
    private static StringBuilder sb;

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        permutation(new int[M], new boolean[N], 0);

        System.out.print(sb);
    }

    public static void permutation(int[] result, boolean[] visited, int cnt) {
        if(cnt == M) {

            for(int i : result)
                sb.append(i).append(" ");

            sb.append("\n");

            return;
        }

        int pre = 10001;
        for(int i = 0; i < N; i++) {
            if(visited[i] || pre == nums[i])
                continue;

            pre = nums[i];
            result[cnt] = nums[i];
            visited[i] = true;
            permutation(result, visited, cnt + 1);
            visited[i] = false;
        }
    }
}
