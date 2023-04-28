package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 프로그래머스 - 최댓값과 최솟값
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */
public class 최댓값과최솟값 {

    public static void main(String[] args) {
        String s = "1 2 3 4";
        String answer = "";

        StringTokenizer st = new StringTokenizer(s);

        int num = Integer.parseInt(st.nextToken());
        int min = num;
        int max = num;
/*
       //이렇게도 가능
        int max= Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
*/
        while (st.hasMoreTokens()) {
            num = Integer.parseInt(st.nextToken());
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        answer += min + " " + max;

        /*
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String[] str = s.split(" ");

        for(int i=0; i<str.length; i++) {
            arr.add(Integer.parseInt(str[i]));
        }

        answer = "" + Collections.min(arr) + " " + Collections.max(arr);
        */

        //result 1, 4
        System.out.println(answer);
    }
}
