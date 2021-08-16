package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int num = 0;
    static ArrayList<Integer> ar = new ArrayList<>();
    static int ansMin = Integer.MIN_VALUE ,ansMax = Integer.MAX_VALUE;
    static int Min = 0;
    static int Max = 0;

    static int calculate(int[] num_ar , int[] arr ,int num){
        int total = num_ar[0];

        for(int i = 0; i < num -1; i++) {

            if(arr[i] == 0) total += num_ar[ i + 1 ];
            if(arr[i] == 1) total -= num_ar[ i + 1 ];
            if(arr[i] == 2) total *= num_ar[ i + 1 ];
            if(arr[i] == 3) total /= num_ar[ i + 1 ];
        }



        return total;
    }

    static void permutation(int[] num_array,int[] arr, int depth, int n, int r) {
        if (depth == r) {
            ansMax = Math.min(calculate(num_array,arr,num),ansMax);
            ansMin = Math.max(calculate(num_array,arr,num),ansMin);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(num_array , arr, depth + 1, n, r);
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
        StringTokenizer t1  = new StringTokenizer(br.readLine());
        StringTokenizer t2  = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        int[] iter = new int[4];
        int[] iter_visited = new int[num - 1];
        int index = 0;
        int[] num_array = new int[num];

        for(int i = 0; i < num; i++) num_array[i] = Integer.parseInt(t1.nextToken()); // 순서 변화 x
        for(int i = 0; i < 4; i++) iter[i] = Integer.parseInt(t2.nextToken());

        /*
         index 0 = 덧셈 , index 1 = 뺄셈 , index 2 = 곱셈, index 3 = 나눗셈
        */
        while(index <= num - 2){

            if(iter[0] != 0)
            {
                iter_visited[index] = 0;
                iter[0] -= 1;
                index++;
            }
            else if(iter[1] != 0)
            {
                iter_visited[index] = 1;
                iter[1] -= 1;
                index++;
            }
            else if(iter[2] != 0)
            {
                iter_visited[index] = 2;
                iter[2] -= 1;
                index++;
            }
            else if(iter[3] != 0)
            {
                iter_visited[index] = 3;
                iter[3] -= 1;
                index++;
            }


        }//배열 생성
    permutation(num_array,iter_visited,0,num-1,num-1);

    System.out.println(ansMin);
    System.out.println(ansMax);


    }
}
