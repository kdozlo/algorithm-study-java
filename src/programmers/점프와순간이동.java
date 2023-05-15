package programmers;

/**
 * 프로그래머스 - 점프와 순간 이동
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */
public class 점프와순간이동 {
    public static void main(String[] args) {
        int n = 5;
        int ans = 0;

        while(n != 0) {
            while(n % 2 == 0) {
                n /= 2;
            }
            n--;
            ans++;
        }
        System.out.println(ans);
    }
}
