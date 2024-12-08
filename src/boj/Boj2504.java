package boj;

import java.util.*;
import java.io.*;

/**
* 백준 2504
* 괄호의 값
* 골드5
* https://www.acmicpc.net/problem/2504
*/
public class Boj2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] cs = br.readLine().toCharArray();
        Stack<String> s = new Stack<>();
        boolean flag = false; // 괄호 짝이 다른 경우 false
        for(char c : cs) {

            if(c == '(' || c == '[') {
                s.add(c + "");
            } else if(c == ')'){
                int num = 0;
                flag = false;

                while(!s.isEmpty()) {
                    String temp = s.pop();

                    if(temp.equals("(")) {
                        flag = true; // 괄호 짝이 맞는 경우
                        break;
                    } else if(temp.equals("[")){
                        break;
                    } else {
                        num += Integer.parseInt(temp);
                    }
                }

                if(!flag) {
                    break;
                }

                num = num == 0 ? 2 : num * 2;
                s.add(num + "");
            } else if(c == ']'){
                int num = 0;
                flag = false;

                while(!s.isEmpty()) {
                    String temp = s.pop();

                    if(temp.equals("[")) {
                        flag = true;
                        break;
                    } else if(temp.equals("(")){
                        break;
                    } else {
                        num += Integer.parseInt(temp);
                    }
                }

                if(!flag) {
                    break;
                }

                num = num == 0 ? 3 : num * 3;
                s.add(num + "");
            }
        }

        int answer = 0;
        if(flag) {
            while(!s.isEmpty()) {
                String temp = s.pop();

                // 괄호가 남아 있는 경우
                if(temp.equals("(") || temp.equals("[")) {
                    answer = 0;
                    break;
                }
                answer += Integer.parseInt(temp);
            }
        }
        System.out.println(answer);
    }
}
