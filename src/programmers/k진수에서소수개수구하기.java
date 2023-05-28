package programmers;

/**
 * 프로그래머스 - k진수에서 소수 개수 구하기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
public class k진수에서소수개수구하기 {
    public static void main(String[] args) {

        int n = 437674;
        int k = 3;

        int answer = 0;

        String cn = changeNum(n, k);

        for(int i = 0; i < cn.length(); i++) {
            for(int j = i + 1; j < cn.length() + 1; j++) {
                if (isPrime(Long.parseLong(cn.substring(i, j)))) {
                    if(cn.substring(i, j).contains("0")) {
                        continue;
                    }
                    //0p0
                    String x = "i: " + i + ", j: " + j + ", " + cn.substring(i, j);
                    if(i > 1 && cn.charAt(i-1) == '0' && i < j && j < cn.length() && cn.charAt(j) == '0') {
                        System.out.println(x);
                        answer++;
                    }

                    //p0
                    if(i == 0 && i < j && j < cn.length() && cn.charAt(j) == '0') {
                        System.out.println(x);
                        answer++;
                    }


                    //0p
                    if(i > 1 && cn.charAt(i-1) == '0' && j == cn.length()) {
                        System.out.println(x);
                        answer++;
                    }

                    //p
                    if(i == 0 && j == cn.length()) {
                        System.out.println(x);
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static String changeNum(int n, int k) {
        String cn = "";

        while(n > 0) {
            cn = n % k + cn;
            n /= k;
        }

        return cn;
    }

    public static boolean isPrime(long n) {
        if(n < 2)
            return false;
        if(n == 2)
            return true;

        for(long i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }
}
