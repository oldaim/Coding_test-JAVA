package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BOJ14889 {

    static int[][] people = new int[21][21];
    static int[] numOfPeople = new int[21];
    static boolean[] visit = new boolean[21];
    static int min = Integer.MAX_VALUE;
    static int total = 0;


    static void combination(int[] arr, boolean[] visited,int depth ,int n ,int r)
    {
        if(r == 0)
        {
            print(arr,visited,n);
            return;
        }

        if(depth == n)
        {
            return;
        }

        visited[depth] = true;
        combination(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(arr,visited,depth + 1, n , r);
    }



    static void permutation(int[] arr, int depth, int n, int r) {

        if (depth == r) {

            total += (people[arr[0]][arr[1]] + people[arr[1]][arr[0]]);
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

    private static void print(int[] arr, boolean[] visited, int n) {
            int[] teamStart = new int[n/2];
            int[] teamLink = new int[n/2];
            int cnt = 0 , cnt2 = 0;
            for (int i = 0; i < n; i++) {
                if(visited[i]) {
                    teamStart[cnt] = arr[i];
                    cnt++;
                }
                if(!visited[i]) {
                    teamLink[cnt2] = arr[i];
                    cnt2++;
                }
            }

            for (int i = 0; i < n/2 ; i++) {
                System.out.print(teamLink[i]+" ");
            }

            System.out.println();

            for (int i = 0; i < n/2 ; i++) {
                System.out.print(teamStart[i]+ " ");
            }

            System.out.println();

            permutation(teamLink,0,n/2,2 );
            int teamS = total;
            total = 0;
            permutation(teamStart,0,n/2,2);
            int teamL =  total;
            total = 0;

            min = Math.min( min, Math.abs(teamS - teamL));

            //////

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count  = Integer.parseInt(br.readLine());

        for (int i = 1; i <= count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numOfPeople[i-1] = i;
            for (int j = 1; j <= count; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        combination(numOfPeople,visit,0,count,count/2);

        System.out.println(min);
    }

}
