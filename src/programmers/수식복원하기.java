package programmers;

import java.util.*;

/**
* 프로그래머스 340210
* 수식 복원하기
* lv3
* https://school.programmers.co.kr/learn/courses/30/lessons/340210
*/
public class 수식복원하기 {

    private static boolean[] digit = new boolean[10];

    public static void main(String[] args) {

        String[] expressions = {"2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "8 + 4 = X"};

        for(int i = findMax(expressions) + 1; i < 10; i++)
            digit[i] = true;

        List<String[]> l1 = new ArrayList<>();
        List<String[]> l2 = new ArrayList<>();

        for(String s : expressions) {

            String[] expression = s.split(" ");

            if(expression[4].equals("X")) {
                l2.add(expression);
            } else {
                l1.add(expression);
            }
        }

        if(l1.size() != 0) {
            for(int i = 2; i < 10; i++) {
                int cnt = 0;
                for(String[] expression : l1) {
                    if(digit[i]) {
                        String temp = calculate(expression, i);
                        if(temp.equals(expression[4])){
                            cnt++;
                        }
                    }
                }

                if(cnt == l1.size())
                    digit[i] = true;
                else
                    digit[i] = false;
            }
        }

        List<String> result = new ArrayList<>();

        for(String[] expression : l2) {
            Set<String> s = new HashSet<>();
            for(int i = 2; i < 10; i++) {
                if(digit[i]) {
                    s.add(calculate(expression, i));
                }
            }

            if(s.size() == 1) {
                for(String e : s)
                    expression[4] = e;
            } else {
                expression[4] = "?";
            }

            StringBuilder sb = new StringBuilder();
            sb.append(expression[0]).append(" ")
                    .append(expression[1]).append(" ")
                    .append(expression[2]).append(" ")
                    .append(expression[3]).append(" ")
                    .append(expression[4]);

            result.add(sb.toString());

        }

        for(String s : result)
            System.out.println(s); // ["2 + 2 = 4", "7 + 4 = 12", "8 + 4 = 13"]
    }

    private static String calculate(String[] s, int digit) {
        int result = -1;

        switch(s[1]) {
            case "+":
                result = Integer.parseInt(s[0], digit) + Integer.parseInt(s[2], digit);
                break;
            case "-":
                result = Integer.parseInt(s[0], digit) - Integer.parseInt(s[2], digit);
        }

        return result == -1 ? "-1" : Integer.toString(result, digit);
    }

    private static int findMax(String[] expressions) {
        int max = 0;

        for(String s : expressions) {
            for(char c : s.toCharArray()) {
                int num = Character.getNumericValue(c);
                if(num > 9 || num < 2)
                    continue;
                max = Math.max(max, num);
            }
        }

        return max;
    }
}
