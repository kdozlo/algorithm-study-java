package programmers;

import java.util.*;

/**
 * 프로그래머스 - 택배상자
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 */
public class 택배상자 {

    public static void main(String[] args) {

        int[] order = {4, 3, 1, 2, 5};

        Stack<Integer> s = new Stack<>();
        int len = order.length;
        int index = 0;

        for(int i = 1; i < len + 1; i++) {
            if(order[index] == i) {
                index++;
            } else {
                s.add(i);
            }

            while(!s.isEmpty() && order[index] == s.peek()) {
                s.pop();
                index++;
                continue;
            }

        }

        System.out.println(index);
    }
}
