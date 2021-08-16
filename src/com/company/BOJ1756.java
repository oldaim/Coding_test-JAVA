package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1756 {
    static int depth = 0;
    static int num = 0;
    static int last_depth = 0;
    static int binarySearch(int start, int find ,int end ,int[] arr){
        int mid = (start + end) / 2;
        if (start > end) return last_depth - 1;
        else if (arr[mid] > find) return binarySearch(start , find, mid -1, arr);
        else if (arr[mid] < find) return binarySearch(mid + 1, find, end, arr);
        else if (arr[mid] == find) return mid;

        return -1;
    }

    public static void main(String[] args) throws IOException {
    BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st  = new StringTokenizer(br.readLine());

    depth = Integer.parseInt(st.nextToken());
    num = Integer.parseInt(st.nextToken());
    int[] depth_arr = new int[depth];
    int[] pizza_arr = new int[num];

    StringTokenizer ar  = new StringTokenizer(br.readLine());
    StringTokenizer art  = new StringTokenizer(br.readLine());

    for(int i = 0; i < depth; i++) depth_arr[i] =  Integer.parseInt(ar.nextToken());
    for(int i = 0; i < num; i++) pizza_arr[i] =  Integer.parseInt(art.nextToken());
    ///////////////////
    int min = depth_arr[0];
    for(int i = 0; i < depth; i++){
        min = Math.min(min,depth_arr[i]);
        depth_arr[i] = min;
    }
    ///////////////////
    last_depth = depth - 1;
    for(int i = 0; i < num; i++){
        last_depth = binarySearch(0,pizza_arr[i],last_depth,depth_arr);
        System.out.println(last_depth + 1);
    }
    System.out.println(last_depth + 1);

    }
}
