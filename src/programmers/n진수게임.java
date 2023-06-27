package programmers;

/**
 * 프로그래머스 - n진수 게임
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */
public class n진수게임 {

    public static void main(String[] args) {
        int n = 2;
        int t  = 4;
        int m = 2;
        int p = 1;

        StringBuilder total = new StringBuilder();
        String answer = "";

        int len = t * m;
        int num = 0;

        while(total.length() < len) {
            String cur = Integer.toString(num, n).toUpperCase();
            total.append(cur);
            num++;
        }


        for(int i = p - 1; i < len; i += m) {
            answer += total.toString().charAt(i);
        }

        System.out.println(answer);
    }

}
