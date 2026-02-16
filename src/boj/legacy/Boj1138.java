package boj.legacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 1138
 * 한 줄로 서기
 * 실버2
 * https://www.acmicpc.net/problem/1138
 */
public class Boj1138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] info = new int[n];
        for(int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        int[] line = new int[n];

        for(int i = 0; i < n; i++) {
            int blank = 0;

            for(int j = 0; j < n; j++) {
                if(line[j] == 0)
                    blank++;

                if(info[i] == blank - 1 && j >= info[i]) {
                    line[j] = i + 1;
                    break;
                }

            }

        }

        for(int i : line) {
            System.out.print(i + " ");
        }

    }
}
