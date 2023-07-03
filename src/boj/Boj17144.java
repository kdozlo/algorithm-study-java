package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 17144
 * 미세먼지 안녕!
 * 골드4
 * https://www.acmicpc.net/problem/17144
 */
public class Boj17144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //r 행, c 열, t 초
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] plate = new int[r][c];
        //공기 청정기 위치 int[0] = 행, int[1] = 열
        ArrayList <int[]> airFresh = new ArrayList<>();

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++) {
                int cur = Integer.parseInt(st.nextToken());
                plate[i][j] = cur;

                if(cur == -1)
                    airFresh.add(new int[] {i, j});
            }
        }

        for(int time = 0; time < t; time++) {
            int[][] tempPlate = new int[r][c];

            //미세먼지 확산
            for(int i = 0; i < r; i++) {

                for(int j = 0; j < c; j++) {
                    if(plate[i][j] == -1) {
                        tempPlate[i][j] = -1;
                        continue;
                    }

                    if(plate[i][j] > 0) {

                        tempPlate[i][j] += plate[i][j];
                        int temp = diffuseValue(plate[i][j]);

                        //상
                        if(i - 1 >= 0 && plate[i - 1][j] != -1) {
                            tempPlate[i][j] -= temp;
                            tempPlate[i - 1][j] += temp;
                        }

                        //하
                        if(i + 1 < r && plate[i + 1][j] != -1) {
                            tempPlate[i][j] -= temp;
                            tempPlate[i + 1][j] += temp;
                        }

                        //좌
                        if(j - 1 >= 0 && plate[i][j - 1] != -1) {
                            tempPlate[i][j] -= temp;
                            tempPlate[i][j - 1] += temp;
                        }

                        //우
                        if(j + 1 < c && plate[i][j + 1] != -1) {
                            tempPlate[i][j] -= temp;
                            tempPlate[i][j + 1] += temp;
                        }
                    }

                }
            }

            //반시계 공기 청정기 작동
            turnCounterClock(tempPlate, airFresh.get(0)[0], c);

            //시계 공기 청정기 작동
            turnClock(tempPlate, airFresh.get(1)[0], r, c);


            //미세먼지 업데이트
            plate = tempPlate;
        }

        System.out.println(totalDust(plate));
    }

    public static int diffuseValue(int a) {
        return a / 5;
    }

    //반시계 방향
    public static void turnCounterClock(int[][] tempPlate, int airFreshRow, int c ) {
        int startRow = 0;
        int endRow = airFreshRow;
        int startCol = 0;
        int endCol = c;

        for(int i = endRow - 1; i > 0; i--) {
            tempPlate[i][startCol] = tempPlate[i - 1][startCol];
        }

        for(int i = startCol; i < endCol - 1; i++) {
            tempPlate[startRow][i] = tempPlate[startRow][i + 1];
        }

        for(int i = startRow; i < endRow; i++) {
            tempPlate[i][endCol - 1] = tempPlate[i + 1][endCol - 1];
        }

        for(int i = endCol - 1; i > 0; i--) {
            tempPlate[endRow][i] = tempPlate[endRow][i - 1];
        }

        tempPlate[endRow][1] = 0;

    }

    //시계 방향
    public static void turnClock(int[][] tempPlate, int airFreshRow, int r, int c ) {
        int startRow = airFreshRow;
        int endRow = r;
        int startCol = 0;
        int endCol = c;

        for(int i = startRow + 1; i < endRow - 1; i++)
            tempPlate[i][startCol] = tempPlate[i + 1][startCol];

        for(int i = 0; i < endCol - 1; i++)
            tempPlate[endRow - 1][i] = tempPlate[endRow -1][i + 1];

        for (int i = endRow - 1; i > startRow; i--) {
            tempPlate[i][endCol - 1] = tempPlate[i - 1][endCol - 1];
        }

        for(int i = endCol - 1; i > 0; i--)
            tempPlate[startRow][i] = tempPlate[startRow][i - 1];

        tempPlate[startRow][1] = 0;
    }

    public static int totalDust(int[][] plate) {
        int sum = 0;

        for(int i = 0; i < plate.length; i++) {
            for(int j = 0; j < plate[0].length; j++) {
                sum += plate[i][j];
            }

        }

        return sum + 2;
    }
}
