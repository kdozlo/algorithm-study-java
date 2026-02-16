package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 14003
* 가장 긴 증가하는 부분 수열 5
* 플래5
* https://www.acmicpc.net/problem/14003
*/
public class Boj14003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        List<Integer> lis = new ArrayList<>();
        lis.add(ary[0]);
        int[] seq = new int[N];
        seq[0] = 1;

        for(int i = 1; i < N; i++) {
            if(lis.get(lis.size() - 1) < ary[i]) {
                lis.add(ary[i]);
                seq[i] = lis.size();
            } else {
                int left = 0;
                int right = lis.size() - 1;

                while(left <= right) {
                    int mid = (left + right) >>> 1;

                    if(lis.get(mid) < ary[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                seq[i] = left + 1;
                lis.set(left, ary[i]);
            }
        }

        int[] result = new int[lis.size()];
        Stack<Integer> s = new Stack<>();
        int index = lis.size();
        for(int i = N - 1; i >= 0; i--) {
            if(index == 0)
                break;

            if(seq[i] == index) {
                result[index - 1] = ary[i];
                index--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis.size()).append("\n");
        for(int i : result)
            sb.append(i).append(" ");

        System.out.print(sb);

    }
}
