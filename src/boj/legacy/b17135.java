package boj.legacy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 17135
 * 캐슬 디펜스
 * 골드 3
 * https://www.acmicpc.net/problem/17135
 */
public class b17135 {

    static int[][] map;
    static int[][] tempMap;
    static List<int[]> archer = new ArrayList<>(); //궁수 위치 저장 리스트
    static List<int[]> enemy = new ArrayList<>(); //적 위치 저장 리스트

    static int max = Integer.MIN_VALUE;
    static int n;
    static int m;
    static int d;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        int[] temp = new int[3];
        combi(m, temp, 0, 0);

        countKill();

        System.out.println(max);
    }

    // 궁수 3개의 조합 마다 죽인 값 최소로 구하기 map 복사 해서 구하기
    // 한 조합이 끝날대 킬 최대값 비교해서 업데이트 하기
    public static void countKill() {
        for(int k = 0; k < archer.size(); k++) {
            //tempMap에 값 채우기 + enemy 값 채우기
            tempMap = new int[n][m];
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tempMap[i][j] = map[i][j];
                    if(tempMap[i][j] == 1) {
                        enemy.add(new int[]{i, j});
                    }
                }
            }

            int tempMax = 0;
            //적이 모두 사라질 때까지 궁수가 죽인 수 구하기
            while(!enemy.isEmpty()) {
                //궁수 한명당 죽일 적 구하기
                killEnemy(tempMap, k, 0);
                killEnemy(tempMap, k, 1);
                killEnemy(tempMap, k, 2);

                //죽은 적 없애기 -> 이때 tempMax 업데이트 / 나머지 적 한칸씩 전진
                for(int i = enemy.size() - 1; i >= 0; i--) {
                    if(tempMap[enemy.get(i)[0]][enemy.get(i)[1]] > 1) {
                        tempMap[enemy.get(i)[0]][enemy.get(i)[1]] = 0;
                        enemy.remove(i);
                        tempMax += 1;
                        continue;
                    }

                    //끝에 도달한 적 없애기
                    if(enemy.get(i)[0] == n - 1) {
                        tempMap[enemy.get(i)[0]][enemy.get(i)[1]] = 0;
                        enemy.remove(i);
                        continue;
                    }

                    //한칸씩 전진
                    if(enemy.get(i)[0] < n - 1) {
                        tempMap[enemy.get(i)[0] + 1][enemy.get(i)[1]] = 1;
                        tempMap[enemy.get(i)[0]][enemy.get(i)[1]] = 0;
                        enemy.get(i)[0] += 1;
                    }
                }
            }

            if(max < tempMax)
                max = tempMax;
        }
    }

    public static void killEnemy(int[][] tempMap, int k, int num) {
        int x = -1;
        int y = -1;
        int dd = Integer.MAX_VALUE;

        for (int i = 0; i < enemy.size(); i++) {
            int temp = distance(n, archer.get(k)[num], enemy.get(i)[0], enemy.get(i)[1]);

            if(temp <= d && temp < dd) {
                dd = temp;
                x = enemy.get(i)[0];
                y = enemy.get(i)[1];
            }

            //거리가 같은 경우
            if (temp <= d && dd == temp) {
                if(enemy.get(i)[1] < y) {
                    x = enemy.get(i)[0];
                    y = enemy.get(i)[1];
                }
            }
        }
        if(x != -1 && y != -1)
            tempMap[x][y] += 1;
    }

    public static int distance(int r1, int c1, int r2, int c2) {

        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public static void combi(int m, int[] temp, int cur, int finish) {
        if (finish == 3) {
            //궁수 배치 조합 저장
            int[] add = new int[3];
            for(int i = 0; i < 3; i++)
                add[i] = temp[i];

            archer.add(add);
            return;
        }

        for(int i = cur; i < m; i++) {
            temp[finish] = i;
            combi(m, temp, i + 1, finish + 1);
        }
    }
}

// 궁수 3명 배치, 성이 있는 칸에 배치 할 수 있음
// 모든 궁수는 동시에 거리 D이하의 적중 가장 가깝고 왼쪽인 적 공격, 같은 적이 여러 궁수한테 공격 당할 수 있음
// 궁수 공격 끝 -> 적 아래로 한칸 이동, 성 있는 칸 도착시 게임에서 제외


