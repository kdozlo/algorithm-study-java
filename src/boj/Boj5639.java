package boj;

import java.io.*;

/**
 * 백준 5639
 * 이진 검색 트리
 * 골드4
 * https://www.acmicpc.net/problem/5639
 */
public class Boj5639 {

    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }

        public void insert(int k) {
            if(k < this.key) {
                if(this.left == null) {
                    this.left = new Node(k);
                } else {
                    this.left.insert(k);
                }
            } else {
                if(this.right == null) {
                    this.right= new Node(k);
                } else {
                    this.right.insert(k);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Node root = new Node(Integer.parseInt(input));

        while((input = br.readLine()) != null) {
            if (input.equals("")) {
                break;
            }
            int k = Integer.parseInt(input);

            root.insert(k);
        }

        postOrder(root);
    }

    public static void postOrder(Node n) {
        if(n == null)
            return;

        postOrder(n.left);
        postOrder(n.right);
        System.out.println(n.key);
    }
}
