package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11053 {
    static int num = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        int [] arr =  new int[num];
        int [] dp  =  new int[num];
        ///
        StringTokenizer st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 1;

        for(int i = 0; i < num; i++) {
           for(int j = 0; j < num; j++){
               if (arr[i] < arr[j]) dp[j] = Math.max(dp[i] + 1, dp[j]);
           }
           if(dp[i] > max) max = dp[i];
        }
        System.out.print(max);




    }

}
