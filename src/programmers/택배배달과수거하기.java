package programmers;

/**
 * 프로그래머스 - 택배 배달과 수거하기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/150369
 */
public class 택배배달과수거하기 {
    public static void main(String[] args) {
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        int cap = 4;
        int n = 5;

        long answer = 0;
        int delivery = 0;
        int pickup = 0;

        for(int i = n-1; i >= 0; i--) {
            int cnt = 0;
            if(deliveries[i] != 0 || pickups[i] != 0) {
                while(delivery < deliveries[i] || pickup < pickups[i]) {
                    cnt++;
                    delivery += cap;
                    pickup += cap;
                }
                delivery -= deliveries[i];
                pickup -= pickups[i];
                answer += cnt * (i+1) * 2;
            }
        }

        //result 16
        System.out.println(answer);
    }
}
