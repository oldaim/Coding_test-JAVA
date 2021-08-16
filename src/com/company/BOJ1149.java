package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    static int[] dp = new int[1001];
    static int[][] house = new int[1001][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count  = Integer.parseInt(br.readLine());
        int min = 1001;
        int min_index = 0;
        for(int i = 1; i <= count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //////
        for(int j = 0; j < 3; j++){
            if(min > house[1][j])
            {
             min = house[1][j];
             min_index = j;
            }
        }
        dp[1] = min;
        /////
        for(int i = 2; i <= count - 1; i++){
            if(min_index == 0) {
                dp[i] = Math.min(house[i][1],house[i][2]);

            }
            ///
            if(min_index == 1) {
                dp[i] = Math.min(house[i][0],house[i][2]);
            }
            ///
            if(min_index == 2) {
                dp[i] = Math.min(house[i][0],house[i][1]);
            }
        }

    }
}
