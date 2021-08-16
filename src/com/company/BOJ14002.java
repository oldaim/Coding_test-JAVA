package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14002 {
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
        int max_int = 0;

        for(int i = 0; i < num; i++) {
            for(int j = i; j < num; j++){
                if (arr[i] < arr[j]) dp[j] = Math.max(dp[i] + 1, dp[j]);
            }
            if(dp[i] > max) {
                max = dp[i];
                max_int = i;
            }
        }
        int c = max;
        int [] dp_arr = new int[max + 1];
        dp_arr[c] = arr[max_int];
        for(int i = max_int; i >= 0; i--){
            if(c == 1) break;
            if(dp[i] == c - 1) {
                dp_arr[c - 1] = arr[i];
                c = dp[i];
            }


        }

        System.out.println(max);
        for(int i = 1; i <= max; i++) System.out.print(dp_arr[i] + " ");




    }

}
