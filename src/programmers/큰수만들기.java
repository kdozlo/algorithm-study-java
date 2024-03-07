package programmers;

import java.util.*;

/**
 * 프로그래머스 - 큰 수 만들기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */
public class 큰수만들기 {

    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        StringBuilder sb = new StringBuilder();

        int len = number.length();

        int start = 0;
        int end = k;

        while(end < len) {
            char max = number.charAt(start);
            int index = start;
            for(int i = start + 1; i <= end; i++) {
                char temp = number.charAt(i);
                if(max < temp) {
                    max = temp;
                    index = i;
                }
            }

            sb.append(max);
            start = index + 1;

            end++;
        }

        System.out.println(sb.toString());
    }
}
