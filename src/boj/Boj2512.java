package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


/**
 * 백준 2512
 * 예산
 * 실버3
 * https://www.acmicpc.net/problem/2512
 */
public class Boj2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //도시 수
        int num = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        //예산 목록
        int[] money = new int[num];
        int maxMoney = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < num; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            sum += money[i];
            maxMoney = Math.max(money[i], maxMoney);
        }


        st = new StringTokenizer(br.readLine());
        //최대 예산
        int max = Integer.parseInt(st.nextToken());

        int answer = 0;
        if(sum > max) {
            for(int i = maxMoney - 1; i> 0; i--) {
                sum = 0;
                for(int j = 0; j < num; j++) {
                    if(money[j] > i) {
                        money[j] = i;
                    }
                    sum += money[j];
                }
                if(sum <= max) {
                    answer = i;
                    break;
                }
            }
        }
        else {
            answer = maxMoney;
        }

        System.out.println(answer);

    }

}
