package boj;

import java.io.*;

/**
 * 백준 17609
 * 회문
 * 골드5
 * https://www.acmicpc.net/problem/17609
 */
public class Boj17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String cur;
        for(int i = 0; i < T; i++) {
            cur = br.readLine();

            int answer1 = 0;
            int left = 0;
            int right = cur.length() - 1;
            int left2 = 0;
            int right2 = cur.length() - 1;

            while(left < right) {
                if(cur.charAt(left) == cur.charAt(right)) {
                    left++;
                    right--;
                    continue;
                }

                if(++answer1 == 2) break;

                left2 = left++;
                right2 = right;

            }

            if(answer1 == 2) {
                answer1 = 0;

                while(left2 < right2) {
                    if(cur.charAt(left2) == cur.charAt(right2)) {
                        left2++;
                        right2--;
                        continue;
                    }

                    if(++answer1 == 2) break;

                    right2--;
                }
            }

            sb.append(answer1).append("\n");
        }

        System.out.print(sb);
    }
}
