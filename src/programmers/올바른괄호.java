package programmers;

import java.util.Stack;

/**
 * 프로그래머스 - 올바른 괄호
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class 올바른괄호 {

    public static void main(String[] args) {
        String s = "()()";

        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')' && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(1);
            }
        }

        if (stack.empty()) {
            System.out.println("true");
        } else {
            System.out.println("false");;
        }
    }
}
