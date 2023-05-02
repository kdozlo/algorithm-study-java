package programmers;

/**
 * 프로그래머스 - 다음 큰 숫자
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 */
public class 다음큰숫자 {
    public static int oneCount(int n) {
        int cnt = 0;
        while(n != 0) {
            if (n % 2 == 1) {
                cnt++;
            }
            n = n / 2;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int n = 78;
        int answer = 0;

        int nOneCount = oneCount(n);

        for (int i = n + 1; i <= 1000000; i++) {
            int iOneCount = oneCount(i);

            if(nOneCount == iOneCount){
                answer = i;
                break;
            }
        }

        //result : 83
        System.out.println(answer);
    }
}
