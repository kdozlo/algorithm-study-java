package boj;

import java.util.*;
import java.io.*;

/**
* 백준 15654
* N과 M (5)
* 실버3
* https://www.acmicpc.net/problem/15654
*/
public class Boj15654 {

    static int N;
    static int M;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        permutation(new boolean[N], new int[M], 0);

        System.out.print(sb);
    }

    public static void permutation(boolean[] visited, int[] pick, int cnt) {
        if(cnt == M) {
            for(int i : pick)
                sb.append(i).append(" ");
            sb.append("\n");

            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i])
                continue;

            pick[cnt] = nums[i];
            visited[i] = true;
            permutation(visited, pick, cnt + 1);
            visited[i] = false;
        }
    }
}
