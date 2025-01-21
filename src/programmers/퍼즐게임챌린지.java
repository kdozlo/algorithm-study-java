package programmers;

/**
* 프로그래머스 340212
* 퍼즐 게임 챌린지
* lv2
* https://school.programmers.co.kr/learn/courses/30/lessons/340212
*/
public class 퍼즐게임챌린지 {

    public static void main(String[] args) {

        int[] diffs = {1, 5, 3};
        int[] times = {2, 4, 7};
        int limit = 30;

        int start = 1;
        int end = 100000;

        while(start <= end) {
            int mid = (start + end) >>> 1;

            if(checking(diffs, times, limit, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        System.out.println(start); // 3
    }

    public static boolean checking(int[] diffs, int[] times, long limit, int mid) {
        long sum = 0;

        if(diffs[0] - mid > 0) {
            sum += (diffs[0] - mid + 1) * times[0];
        } else {
            sum += times[0];
        }

        for(int i = 1; i < diffs.length; i++) {

            if(diffs[i] - mid > 0) {
                sum += (diffs[i] - mid) * (times[i] + times[i - 1]) + times[i];
            } else {
                sum += times[i];
            }

            if(sum > limit)
                return false;
        }

        return true;
    }
}
