package programmers;

/**
 * 프로그래머스 - 숫자의 표현
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12924
 */
public class 숫자의표현 {

    public static void main(String[] args) {
        int n = 15;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int cur = i;
            while(true) {
                if(sum > n)
                    break;
                sum += cur;
                if (sum == n)
                    answer++;
                cur++;
            }
        }

        //result 4
        System.out.println(answer);
    }
}
