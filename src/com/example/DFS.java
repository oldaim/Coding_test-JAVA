package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS {
    static int[][] arrayGraph = new int[101][101];
    static boolean[] visited = new boolean[101];
    static int num = 0;
    public static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 그래프 입력
        num = Integer.parseInt(br.readLine());
        for (int i = 1; i <= num; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vOne = Integer.parseInt(st.nextToken());
            int vTwo = Integer.parseInt(st.nextToken());
            arrayGraph[vOne][vTwo] = 1;
        }

    }

    public static void dfs()
    {
        for (int i = 1; i <= num ; i++)
        {
            for (int j = 1; j < num; j++)
            {
                if(!visited[i] && arrayGraph[i][j] == 1) DFSfind(i);
            }
        }
    }

    private static void DFSfind(int i) {
        for (int j = 1; j <= num ; j++) {
            if(!visited[j]&& arrayGraph[i][j] == 1)
            {
                visited[j] = true;
                System.out.print(i + " " + j + "\n");
                DFSfind(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Input();
        dfs();
    }

}
