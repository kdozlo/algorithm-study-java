package boj.legacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 백준 12919
 * A와 B 2
 * 골드5
 * https://www.acmicpc.net/problem/12919
 */
public class Boj12919 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        makeStoT(s, t);

        System.out.println(answer);
    }

    public static void makeStoT(String s, String t) {
        if(t.length() == s.length()) {
            if(t.equals(s)) {
                answer = 1;
                return;
            }
            return;
        }

        if(t.charAt(0) == 'B') {

            makeStoT(s, new StringBuilder(t.substring(1)).reverse().toString());
        }

        if(t.charAt(t.length() - 1) == 'A') {
            makeStoT(s, t.substring(0, t.length() - 1));
        }
    }

    /*public static void makeStoT (String s, String t) {

        if(s.length() > t.length())
            return;

        if(s.equals(t)) {
            answer = 1;
            return;
        }

        makeStoT(addA(s), t);
        makeStoT(addBAndReverse(s), t);

    }

    public static String addA(String s) {
        return s + "A";
    }

    public static String addBAndReverse(String s) {
        String reversed = "";
        s += "B";

        for(int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }

        return reversed;
    }*/


}
