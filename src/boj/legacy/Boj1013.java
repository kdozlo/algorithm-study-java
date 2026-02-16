package boj.legacy;

import java.io.*;

/**
* 백준 1013
* Contact
* 골드5
* https://www.acmicpc.net/problem/1013
*/
public class Boj1013 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            String str = br.readLine();

            if (matches(str))
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }

        System.out.print(sb);
    }

    public static boolean matches(String s) {
        int n = s.length();
        int i = 0;

        while (i < n) {
            // 분기 1: "01"
            if (i + 1 < n && s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                i += 2;           // "01" 두 글자 소비
                continue;         // 다시 시작 상태로
            }

            // 분기 2: "100+1+"
            if (i + 2 < n
                    && s.charAt(i)=='1'
                    && s.charAt(i + 1)=='0'
                    && s.charAt(i + 2)=='0') {
                int j = i + 3;
                // 0을 최소 하나 더 읽어서 "100+" 만족
                while (j < n && s.charAt(j) == '0') j++;

                // 1을 최소 하나 읽기
                if (j >= n || s.charAt(j) != '1') return false;
                j++;

                // 추가 1을 읽되, "다음에 100이 오면 멈춤"
                while (j < n
                        && s.charAt(j) == '1'
                        && !(j + 2 < n
                            && s.charAt(j + 1)=='0'
                            && s.charAt(j + 2)=='0')) {
                    j++;
                }

                // 여기까지가 한 패턴
                i = j;
                continue;
            }

            // 어느 패턴에도 안 걸리면 바로 NO
            return false;
        }

        // 모두 소비했으면 YES
        return true;
    }
}
