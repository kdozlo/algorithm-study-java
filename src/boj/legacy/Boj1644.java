package boj.legacy;

import java.util.*;
import java.io.*;

/**
 * 백준 1644
 * 소수의 연속합
 * 골드3
 * https://www.acmicpc.net/problem/1644
 */
public class Boj1644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N == 1)
            System.out.println(0);
        else {
            List<Integer> l = new ArrayList<>();
            boolean[] isPrime = new boolean[N + 1];

            Arrays.fill(isPrime, true);

            isPrime[0] = false;
            isPrime[1] = false;

            for(int i = 2; i <= Math.sqrt(N); i++) {
                if(isPrime[i]) {
                    for(int j = i * i; j < N + 1; j += i) {
                            isPrime[j] = false;
                    }
                }
            }

            for (int i = 2; i < N + 1; i++)
                if (isPrime[i]) {
                    l.add(i);
                }

            int start = 0;
            int end = 0;
            int sum = l.get(0);
            int count = 0;

            while(start <= end) {
                if(sum == N) {
                    count++;
                    sum -= l.get(start);
                    start++;
                } else if(sum > N) {
                    sum -= l.get(start);
                    start++;
                } else {
                    end++;
                    if(end >= l.size())
                        break;
                    sum += l.get(end);
                }
            }

            System.out.println(count);
        }
    }
}
