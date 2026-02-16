package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 2565
* 전깃줄
* 골드5
* https://www.acmicpc.net/problem/2565
*/
public class Boj2565 {

    private static class Line implements Comparable<Line>{
        int a;
        int b;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(a, o.a);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Line> lines = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines.add(new Line(a, b));
        }

        Collections.sort(lines);

        System.out.println(n - findLIS(lines));
    }

    public static int findLIS(List<Line>  lines) {
        List<Integer> lis = new ArrayList<>();

        for (Line l : lines) {

            int cur = binarySearch(lis, l.b);

            if(cur == lis.size())
                lis.add(l.b);
            else
                lis.set(cur, l.b);
        }

        return lis.size();
    }

    public static int binarySearch(List<Integer> lis, int num) {
        int left = 0;
        int right = lis.size() - 1;

        while(left <= right) {
            int mid = (left + right) >>> 1;

            if(lis.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}
