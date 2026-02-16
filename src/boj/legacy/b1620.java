package boj.legacy;

import java.util.*;
import java.io.*;

/*
 * 백준 1620
 * 나는야 포켓몬 마스터 이다솜
 * 실버 4
 * https://www.acmicpc.net/problem/1620
 */
public class b1620 {

    static int n; //포켓몬 개수
    static int m; //맞춰야 하는 문제 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, String> sKey = new HashMap<>();
        Map<String, String> iKey = new HashMap<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            String cur = br.readLine();

            sKey.put(cur, i + "");
            iKey.put(i + "", cur);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            String cur = br.readLine();

            if(sKey.containsKey(cur))
                sb.append(sKey.get(cur));

            if(iKey.containsKey(cur))
                sb.append(iKey.get(cur));

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
