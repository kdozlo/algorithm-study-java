package programmers;

import java.util.Stack;

/**
 * 프로그래머스 - 괄호 회전하기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */
public class 괄호회전하기 {

    public static void main(String[] arsg) {
        String s = "[](){}";

        int answer = 0;

        String newS = s;
        for(int i = 0; i < s.length(); i++){
            if(checkBracket(newS)) answer++;
            newS = newS.substring(1, s.length()) + newS.charAt(0);
        }

        System.out.println(answer);
    }

    public static boolean checkBracket (String s) {
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()) {
            try {
                if (c == '[' || c == '(' || c =='{') {
                    stack.push(c);
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                }
            } catch (Exception e) {
                return false;
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
