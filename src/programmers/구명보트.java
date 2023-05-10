package programmers;

import java.util.Arrays;

/**
 * 프로그래머스 - 구명보트
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 */
public class 구명보트 {

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        int answer = 0;

        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;

        while(start <= end) {
            if(people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            answer +=1;
        }

        //result : 3
        System.out.println(answer);
    }
}
