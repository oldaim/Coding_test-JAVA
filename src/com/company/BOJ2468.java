package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2468 {
    static int[][] arrayGraph = new int[101][101];

    static int num = 0;
    static int max = 0;
    public static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 그래프 입력
        num = Integer.parseInt(br.readLine());

        for (int i = 1; i <= num; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= num; j++)
            {
                arrayGraph[i][j] = Integer.parseInt(st.nextToken());
            }

        }

    }

    public static int dfs(int height)

    {
        boolean[][] visited = new boolean[101][101];
        int count = 0;
        for (int i = 1; i <= num ; i++)
        {
            for (int j = 1; j <= num; j++)
            {
                if(!visited[i][j] && arrayGraph[i][j] >=  height)
                {
                    visited[i][j] = true;
                    count++;
                    DFSfind( i , j ,height , visited);
                }
            }
        }
        return count;
    }

    private static void DFSfind(int i , int j, int height ,boolean[][] visited) {
        int[][] dx = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int k = 0; k < 4; k++) {
            if(i + dx[k][0] <= 0 || j +dx[k][1] <= 0 || i +dx[k][0] > num || j + dx[k][1] > num) continue;
            if(visited[i + dx[k][0]][j + dx[k][1]] || arrayGraph[i + dx[k][0]][j + dx[k][1]] <  height) continue;

            visited[i + dx[k][0]][j + dx[k][1]] = true;
            DFSfind(i + dx[k][0],j + dx[k][1], height, visited);
        }

    }

    public static void main(String[] args) throws IOException {

        Input();
        for (int i = 1; i <= 100 ; i++) {
           max = Math.max(max,dfs(i));
        }

        System.out.println(max);
    }

}
