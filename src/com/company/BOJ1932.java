package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] triangle = new int[501][501];
        int[][] dp = new int[501][501];

        for(int i = 1; i <= count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++){
               triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = triangle[1][1];
        for(int i = count; i >= 1; i--){

            for(int j = 1; j <=i; j++){
                dp[i][j] = dp[i-1][j] + Math.max(triangle[i][j],triangle[i][j+1]);
            }
        }




    }
}
