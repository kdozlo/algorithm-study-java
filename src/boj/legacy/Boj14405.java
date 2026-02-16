package boj.legacy;

import java.io.*;

/**
* 백준 14405
* 피카츄
* 실버5
* https://www.acmicpc.net/problem/14405
*/
public class Boj14405 {

    private final static String word1 = "pi";
    private final static String word2 = "ka";
    private final static String word3 = "chu";


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        s = s.replaceAll(word1 + "|" + word2 + "|" + word3, "");

        System.out.println(s.isEmpty() ? "YES" : "NO");
    }
}
