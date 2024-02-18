package boj;

import java.io.*;
import java.util.*;

/*
 * 백준 1976
 * 여행 가자
 * 골드 4
 * https://www.acmicpc.net/problem/1976
 * union-find
 */
public class b1976 {

    static int n; // number of city
    static int m; // number of planning city
    static int[] parent;
    static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 1; i < n + 1; i++)
            parent[i] = i;

        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++) {
                if(st.nextToken().equals("1")) {
                    union(i, j);
                }
            }
        }

        plan = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
            plan[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < m; i++) {
            if(find(plan[i - 1]) != find(plan[i])) {
                sb.append("NO");
                break;
            }

            if(i == m - 1)
                sb.append("YES");
        }

        if(m == 1)
            sb.append("YES");

        System.out.println(sb.toString());
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x > y)
            parent[x] = y;
        else
            parent[y] = x;
    }

    public static int find(int x) {
        if(parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }
}

///*
// * 백준 1976
// * 여행 가자
// * 골드 4
// * https://www.acmicpc.net/problem/1976
// * bfs
// */
//public class b1976 {
//
//    static int n; // number of city
//    static int m; // number of planning city
//    static List<Integer>[] g;
//    static int[] plan;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        m = Integer.parseInt(st.nextToken());
//
//        g = new ArrayList[n + 1];
//        for(int i = 1; i < n + 1; i++)
//            g[i] = new ArrayList<Integer>();
//
//        for(int i = 1; i < n + 1; i++) {
//            st = new StringTokenizer(br.readLine());
//            for(int j = 1; j < n + 1; j++) {
//                if(st.nextToken().equals("1")) {
//                    g[i].add(j);
//                    g[j].add(i);
//                }
//
//            }
//        }
//
//        plan = new int[m];
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < m; i++)
//            plan[i] = Integer.parseInt(st.nextToken());
//
//        StringBuilder sb = new StringBuilder();
//        for(int i = 1; i < m; i++) {
//            if(!bfs(plan[i - 1], plan[i])) {
//                sb.append("NO");
//                break;
//            }
//
//            if(i == m - 1)
//                sb.append("YES");
//        }
//
//        if(m == 1)
//            sb.append("YES");
//
//        System.out.println(sb.toString());
//    }
//
//    public static boolean bfs(int start, int end) {
//
//        if(start == end)
//            return true;
//
//        Queue<Integer> q = new LinkedList<>();
//        boolean[] visited = new boolean[n + 1];
//
//        visited[start] = true;
//        q.add(start);
//
//        while(!q.isEmpty()) {
//            int cur = q.poll();
//
//            for(int next : g[cur]) {
//                if(visited[next])
//                    continue;
//
//                if(next == end)
//                    return true;
//
//                visited[next] = true;
//                q.add(next);
//            }
//        }
//
//        return false;
//    }
//}
