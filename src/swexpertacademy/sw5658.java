package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * sw 5658
 * 보물상자 비밀번호
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo
 */
public class sw5658 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int test = 1; test <= t; test++) {
            st = new StringTokenizer(br.readLine());

            //4의 배수
            int n = Integer.parseInt(st.nextToken());
            //k번째로 큰 수
            int k = Integer.parseInt(st.nextToken());

            char[] s = br.readLine().toCharArray();



        }
    }
}

/*
16진수 적힌 보물상자
뚜껑 시계방향으로 돌릴 수 있음 + 숫자도 같이 한칸 이동
각변 동일 개수 수자 존재

*/