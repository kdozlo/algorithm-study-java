package programmers;

import java.util.Arrays;

/**
 * 프로그래머스 - 행렬 테두리 회전하기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/77485
 */
public class 행렬테두리회전하기 {

    public static void main(String[] args) {

        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        int[] answer = new int[queries.length];

        int[][] plate = new int[rows][columns];

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                plate[i][j] = (i * columns + j + 1);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int startRow = queries[i][0] - 1;
            int startCol = queries[i][1] - 1;
            int endRow = queries[i][2] - 1;
            int endCol = queries[i][3] - 1;

            int firstNum = plate[startRow][endCol];
            int min = firstNum;
            //오른쪽
            for(int j = endCol; j > startCol; j--) {
                plate[startRow][j] = plate[startRow][j - 1];
                min = Math.min(min, plate[startRow][j]);
            }

            //위
            for(int j = startRow; j < endRow; j++) {
                plate[j][startCol] = plate[j + 1] [startCol];
                min = Math.min(min, plate[j][startCol]);
            }

            //왼쪽
            for(int j = startCol; j < endCol; j++) {
                plate[endRow][j] = plate[endRow][j + 1];
                min = Math.min(min, plate[endRow][j]);
            }

            //아래
            for(int j = endRow; j > startRow; j--) {
                plate[j][endCol] = plate[j - 1][endCol];
                min = Math.min(min, plate[j][endCol]);
            }
            plate[startRow + 1][endCol] = firstNum;

            answer[i] = min;
        }

        System.out.println(Arrays.toString(answer));
    }
}
