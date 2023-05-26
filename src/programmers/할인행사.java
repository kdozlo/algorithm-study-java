package programmers;

/**
 * 프로그래머스 - 할인 행사
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */
public class 할인행사 {

    public static void main(String[] args) {

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int answer = 0;

        for(int j = 0; j < discount.length - 9; j++) {
            int check = 0;
            for(int i = 0; i < want.length; i++) {
                int wantCnt = 0;
                for(int k = j; k < j + 10; k++) {
                    if(want[i].equals(discount[k])) {
                        wantCnt++;
                    }

                    if(wantCnt >= number[i]) {
                        check++;
                        break;
                    }

                }
                if(check == want.length)
                    answer++;

            }

        }

        System.out.println(answer);
    }
}
