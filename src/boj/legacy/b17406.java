package boj.legacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 17406
 * 배열 돌리기 4
 * 골드 4
 * https://www.acmicpc.net/problem/17406
 */
public class b17406 {
    //돌린 결과 담는 배열
    static int[][] tempA;
    //초기 배열
    static int[][] a;
    //회전 연산
    static Map<Integer, int[]> map;

    //최소값
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        a = new int[n + 1][m + 1];
        tempA = new int[n + 1][m + 1];

        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < m + 1; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map = new HashMap<>();

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            map.put(i, new int[] {r, c, s});

        }

        int[] result = new int[k];
        boolean[] visited = new boolean[k];
        permatation(result, visited, 0);

        System.out.println(min);
    }

    static void rotate(int r1, int c1, int r2, int c2) {

        for(int cnt = 0; cnt < Math.min(r2 - r1, c2 - c1) / 2; cnt++) {

            //왼
            int temp = tempA[r1 + cnt][c1 + cnt];
            for(int i = r1 + cnt; i < r2 - cnt; i++) {
                tempA[i][c1 + cnt] = tempA[i+1][c1 + cnt];
            }

            //아래
            for (int j = c1 + cnt; j < c2 - cnt; j++) {
                tempA[r2 - cnt][j] = tempA[r2 - cnt][j+1];
            }

            //오른
            for (int i = r2 - cnt; i > r1 + cnt; i--) {
                tempA[i][c2 - cnt] = tempA[i -1][c2 - cnt];
            }

            //위
            for(int j = c2 - cnt; j > c1 + cnt; j--) {
                tempA[r1 + cnt][j] = tempA[r1 + cnt][j - 1];
                if(j == c1 + cnt + 1)
                    tempA[r1 + cnt][j] = temp;
            }
        }
    }

    static void permatation(int[] result, boolean[] visited, int depth) {
        if(depth == map.size()) {
            for(int i = 0; i < a.length; i++) {
                System.arraycopy(a[i], 0, tempA[i], 0, a[i].length);
            }

            //최소값 구하기
            for(int i : result) {
//                System.out.println(i + " " + Arrays.toString( map.get(i)));
                int r = map.get(i)[0];
                int c = map.get(i)[1];
                int s = map.get(i)[2];
                //가장 왼쪽 위  (r-s, c-s)
                //가장 오른 아래 (r+s, c+s)
                rotate(r - s, c - s, r + s, c + s);

//                for(int r1 = 1; r1 < tempA.length; r1++) {
//                    for (int c1 = 1; c1 < tempA[r1].length; c1++) {
//                        System.out.print(tempA[r1][c1] + " ");
//                    }
//                    System.out.println();
//                }
            }



            for(int i = 1; i < a.length; i++) {
                int cur = 0;
                for(int j = 1; j < a[i].length; j++) {
                    cur += tempA[i][j];
                }
//                System.out.println(cur);
                if(cur < min)
                    min = cur;
            }


            return;
        }

        for(int i = 0; i < map.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                permatation(result, visited, depth + 1);
                visited[i] =false;
            }
        }
    }

}
