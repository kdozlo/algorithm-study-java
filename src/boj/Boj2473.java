package boj;

import java.util.*;
import java.io.*;

/**
 * 백준 2473
 * 세 용액
 * 골드3
 * https://www.acmicpc.net/problem/2473
 */
public class Boj2473 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long[] answer = new long[3];

        int N = Integer.parseInt(br.readLine());
        List<Long> nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(nums);

        long near = 3000000001L;

        for(int i = 0; i < N; i++) {
            long cur = nums.get(i);

            int start = i + 1;
            int end = N - 1;

            while(start < end) {
                long sum = cur + nums.get(start) + nums.get(end);
                int mid = start + ((end - start) / 2);

                if (Math.abs(sum) < Math.abs(near)) {
                    near = sum;
                    answer[0] = cur;
                    answer[1] = nums.get(start);
                    answer[2] = nums.get(end);
                }

                if(sum > 0)
                    end--;
                else
                    start++;
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
