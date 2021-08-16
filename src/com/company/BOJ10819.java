package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {


    static int[] ar = new int[9];
    static int count = 0;
    static int max = 0;

    public static int sum_array(int[] ar, int n){
        int total = 0;
        for(int i=0;i<n;i++) {
            total += Math.abs(ar[i] - ar[i+1]);
        }
        return total;
    }

     static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {

            count++;
            if(max <= sum_array(arr,r)) max = sum_array(arr,r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }

     }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        StringTokenizer t  = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) ar[i] = Integer.parseInt(t.nextToken());

        permutation(ar,0,n,n-1);
        System.out.println(count);
        System.out.printf("%d",max);


    }
}