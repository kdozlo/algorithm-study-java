package boj;

import java.util.*;
import java.io.*;

/**
* 백준 17298
* 오큰수
* 골드4
* https://www.acmicpc.net/problem/17298
*/
public class Boj17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] NGE = new int[N];

        for(int i = 0; i < N; i++) {
            NGE[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> s = new Stack<>();
        Stack<Integer> out = new Stack<>();
        for(int i = N - 1; i >= 0; i--) {
            while(!s.isEmpty() && NGE[i] >= s.peek()) {
                s.pop();
            }

            if(s.isEmpty()) {
                out.add(-1);
            } else {
                out.add(s.peek());
            }

            s.add(NGE[i]);
        }

        while(!out.isEmpty()) {
            sb.append(out.pop()).append(" ");
        }

        System.out.println(sb);
    }


}
