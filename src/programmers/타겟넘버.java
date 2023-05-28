package programmers;

/**
 * 프로그래머스 - 타겟 넘버
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class 타겟넘버 {
    static int count = 0;
    static int cnt = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;


        dfs(numbers, target, 0, 0);

        System.out.println(count);
        System.out.println(cnt);
    }

    public static void dfs(int[] numbers, int target, int d, int sum) {
        cnt++;
        if( d == numbers.length) {
            if(target == sum)
                count++;
        } else {
            dfs(numbers, target, d + 1, sum + numbers[d]);
            dfs(numbers, target, d + 1, sum - numbers[d]);
        }

    }
}
