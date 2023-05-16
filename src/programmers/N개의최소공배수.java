package programmers;

import java.util.Arrays;

public class N개의최소공배수 {
    public static void main(String[] args) {
        int[] arr ={2,6,8,14};

        int answer = 0;

        Arrays.sort(arr);

        int start = arr[arr.length - 1];

        boolean check = false;
        while(!check) {
            for(int i : arr) {
                if (start % i != 0) {
                    break;
                } else if (i == arr[arr.length - 1]) {
                    check = true;
                }

            }
            start++;
        }

        answer = start - 1;

        System.out.println(answer);
    }
}
