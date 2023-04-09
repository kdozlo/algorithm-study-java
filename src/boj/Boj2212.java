package boj;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2212
 * 센서
 * 골드5
 * https://www.acmicpc.net/problem/2212
 */
public class Boj2212 {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (K >= N) {
            bw.write("0\n");
            bw.close();
            br.close();
            return;
        }

        int[] censor = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            censor[i] = temp;
        }
        Arrays.sort(censor);


    }
}
