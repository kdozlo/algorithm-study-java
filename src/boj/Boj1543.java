package boj;

import java.io.*;

/**
* 백준 1543
* 문서 검색
* 실버5
* https://www.acmicpc.net/problem/1543
*/
public class Boj1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String word = br.readLine();

        int dLen = document.length();
        int wLen = word.length();

        int index = 0;
        int answer = 0;
        while(index <= dLen - wLen) {
            String cur = document.substring(index, index + wLen);

            if(cur.equals(word)) {
                answer++;
                index += wLen;
            } else {
                index++;
            }
        }

        System.out.println(answer);
    }
}
