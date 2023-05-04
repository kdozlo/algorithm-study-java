package programmers;

import java.util.Stack;

/**
 * 프로그래머스 - 짝지어 제거하기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
public class 짝지어제거하기 {

    public static void main(String[] args) {
        String s = "baabaa";

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        // result 1
        if(stack.empty())
            System.out.println(1);
        else
            System.out.println(0);
    }
}
