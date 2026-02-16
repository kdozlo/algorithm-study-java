package boj.legacy;

import java.io.*;

/**
* 백준 16120
* PPAP
* 골드4
* https://www.acmicpc.net/problem/16120
*/
public class Boj16120 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            sb.append(c);
            int len = sb.length();

            if(len < 4)
                continue;

            if(isPpap(sb, len)) {
                sb.delete(len - 3, len);
            }
        }

        if(sb.toString().equals("P"))
            System.out.println("PPAP");
        else
            System.out.println("NP");
    }

    public static boolean isPpap(StringBuilder sb, int len) {

        if(sb.charAt(len - 1) != 'P')
            return false;
        if(sb.charAt(len - 2) != 'A')
            return false;
        if(sb.charAt(len - 3) != 'P')
            return false;
        if(sb.charAt(len - 4) != 'P')
            return false;

        return true;
    }
}
