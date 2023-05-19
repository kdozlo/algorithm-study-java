package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 - 연속 부분 수열 합의 개수
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */
public class 연속부분수열합의개수 {

    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};

        Set<Integer> set = new HashSet<>();

        for(int i = 1; i < elements.length + 1; i++) {
            for(int j = 0; j < elements.length; j++) {
                int sum = 0;
                for(int k = 0; k < i; k++) {
                    sum  += elements[(j + k) % elements.length];
                }
                set.add(sum);
            }
        }

        System.out.println(set.size());
    }
}
