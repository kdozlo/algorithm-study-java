package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 18353
* 병사 배치하기
* 실버2
* https://www.acmicpc.net/problem/18353
*/
public class boj18353 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] info = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(n - getLDSSize(info));
    }

    private static int getLDSSize(int[] info) {
        List<Integer> lds = new ArrayList<>();

        for(int i : info) {
            int index = binarySearch(lds, i) + 1;

            if(index == lds.size())
                lds.add(i);
            else
                lds.set(index, i);
        }

        return lds.size();
    }

    private static int binarySearch(List<Integer> l, int target) {
        int left = 0;
        int right = l.size() - 1;

        while(left <= right) {
            int mid = (left + right) >>> 1;

            if(l.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
