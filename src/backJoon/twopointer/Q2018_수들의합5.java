package backJoon.twopointer;

import java.util.Scanner;

public class Q2018_수들의합5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;
        while (end != n){
            if (sum == n){
                count++;
                end++;
                sum = sum + end;
            }else if(sum < n){
                end++;
                sum = sum + end;
            }else{
                sum = sum - start;
                start++;
            }
        }
        System.out.println(count);
    }
}
