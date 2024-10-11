package boj;

import java.io.*;

/**
 * 백준 9935
 * 문자열 폭발
 * 골드 4
 * https://www.acmicpc.net/problem/9935
 */
public class Boj9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String bomb = br.readLine();
        int len = bomb.length();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            result.append(s.charAt(i));

            if(result.length() < len)
                continue;

            if(isSame(result, bomb, len)) {
                result.delete(result.length() - len, result.length());
            }

        }


        if(result.length() == 0)
            System.out.println("FRULA");
        else
            System.out.println(result);
    }

    public static boolean isSame(StringBuilder result, String bomb, int len) {

        boolean flag = true;
        for(int j = 0; j < len; j++) {
            if(result.charAt(result.length() - len + j) != bomb.charAt(j)) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}