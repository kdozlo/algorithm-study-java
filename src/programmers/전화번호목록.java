package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 - 전화번호 목록
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class 전화번호목록 {

    public static void main(String[] args) {
        String[] phoneBook = {"119", "97674223", "1195524421"};

        boolean answer = true;
        Set<String> pb = new HashSet<>();

        for(String s : phoneBook) {
            pb.add(s);
        }

        for(String s: phoneBook) {
            for(int i = 1; i < s.length(); i++) {
                System.out.println(s.substring(0, i));
                if(pb.contains(s.substring(0, i))) {
                    answer = false;
                    break;
                }
            }
            if(answer == false)
                break;
        }

        System.out.println("answer = " + answer);
    }
}
