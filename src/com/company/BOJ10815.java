package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
    static int num_Mine;
    static int num_Test;

    static boolean binarySearch(int st, int find ,int end ,int[] arr){
       int mid = (st + end) / 2;
       if (st > end) return false;
       else if (arr[mid] > find) return binarySearch(st , find, mid -1, arr);
       else if (arr[mid] < find) return binarySearch(mid + 1, find, end, arr);
       else if (arr[mid] == find) return true;

    return false;
   }

    public static void main(String[] args) throws IOException {

        BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));




        num_Mine = Integer.parseInt(br.readLine());
        int[] arr = new int[num_Mine];
        StringTokenizer ar  = new StringTokenizer(br.readLine());
        for(int i = 0; i < num_Mine; i++) arr[i] = Integer.parseInt(ar.nextToken());
        Arrays.sort(arr);

        num_Test = Integer.parseInt(br.readLine());
        int[] test = new int[num_Test];
        StringTokenizer art  = new StringTokenizer(br.readLine());
        for(int i = 0; i < num_Test; i++) test[i] = Integer.parseInt(art.nextToken());

        // 입력
        ////////////////////////

        int st = num_Mine / 2 + 1;
        for(int i = 0; i < num_Test; i++){
            if(binarySearch(0,test[i],num_Mine -1, arr)) System.out.printf("1 ");
            else System.out.printf("0 ");
        }


    }
}
