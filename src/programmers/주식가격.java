package programmers;

import java.util.Arrays;

/**
 * 프로그래머스 - 주식가격
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584?language=java
 */
public class 주식가격 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};


        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                if(j == prices.length - 1) {
                    answer[i] = j - i;
                    break;
                }

                if(j - i == 1 && prices[i] > prices[j]) {
                    answer[i] = 1;
                    break;
                }

                if(prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(answer));

    }
}
