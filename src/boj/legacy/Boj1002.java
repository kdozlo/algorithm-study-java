package boj.legacy;

import java.io.*;
import java.util.StringTokenizer;

/**
* 백준 1002
* https://www.acmicpc.net/problem/1002
* 실버3
* 터렛
*/
public class Boj1002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(countingPoints(x1,  y1, r1, x2, y2, r2)).append("\n");
        }

        System.out.print(sb);
    }

    private static int countingPoints(int x1, int y1, int r1, int x2, int y2, int r2) {
        if(x1 == x2 && y1 == y2 && r1 == r2)
            return -1;

        int d = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        int rSum = (r1 + r2) * (r1 + r2);
        int rDif = (r1 - r2) * (r1 - r2);

        if(d > rSum)
            return 0;

        if(d < rDif)
            return 0;

        if(d == rSum || d == rDif)
            return 1;

        return 2;
    }
}
