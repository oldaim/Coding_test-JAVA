package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        int[][] t_arr = new int[N+1][N+1];
        int[][] way = new int[M+1][4];
        /////////
        for(int i = 0; i < N; i++){
            StringTokenizer t = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] += Integer.parseInt(t.nextToken());
                if(j != N - 1)arr[i][j + 1] += arr[i][j];

            }

        }

        for(int i = 0; i < N; i++){

            for(int j = 0; j < N; j++){
                t_arr[j][i] += arr[j][i];
                t_arr[j + 1][i] += t_arr[j][i];

            }

        }
        ///////////
        for(int i = 0; i < M; i++){
            StringTokenizer t2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                way[i][j] = Integer.parseInt(t2.nextToken());
            }
        }
        //////////

        for(int i = 0; i < N; i++){

            for(int j = 0; j < N; j++){
                System.out.print(t_arr[i][j] + " ");

            }
            System.out.println();
        }

        for(int i = 0; i < M; i++){
            int start_row = way[i][0] - 1;
            int start_col = way[i][1] - 1;
            int end_row = way[i][2] - 1;
            int end_col = way[i][3] - 1;
            int total_sum = 0;
            int a = t_arr[end_row][end_col];
            int b , c , d;


            if(start_row <= 0 ) b = 0;
            else b = t_arr[start_row -1][end_col];

            if(start_col <= 0 ) c = 0;
            else c = t_arr[end_row][start_col -1];

            if(start_col <= 0 || start_row <= 0 ) d = 0;
            else d = t_arr[start_row -1][start_col -1];


            total_sum = a - b - c + d;


            System.out.println(total_sum);
            total_sum = 0;

        }





    }
}
