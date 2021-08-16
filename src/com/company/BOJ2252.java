package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2252 {
    static int n;


    public static void main(String[] args) throws IOException {

        BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        //n = 정점 e = 간선 갯수 입력


        int[] indegree = new int[n + 1];
        int[] min_time = new int[n + 1];
        int[] process = new int[n + 1];
        List<List<Integer>> array = new ArrayList<List<Integer>>();

        for (int i = 0; i < n + 1; i++)  array.add(new ArrayList<Integer>());

        
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            process[i + 1] =  Integer.parseInt(st2.nextToken());
            // 여기서 걸리는 시간 받고
            while (true){
                int c = Integer.parseInt(st2.nextToken());
                if( c == -1) break;
                array.get( c ).add( i+1 );
                indegree[ i + 1 ]++;
            }
        }

        /**
         * 1. v1 -> v2 인접리스트 생성
         * 2. v2 를 가리키는 노드 갯수 indegree 증가
         */


        topologicalSort(process,min_time,indegree, array);
    }

    static void topologicalSort(int[] process ,int[] min_time,int[] indegree, List<List<Integer>> array) {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();
        boolean[] visited = new boolean[n+1];

        // 큐에 indegree 가 0 인 노드 담기
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        /**
         * 1. 큐에서 값을 꺼내며 해당 노드가 가리키는 노드의 indegree 를 1 감소
         * 2. 만약 indegree가 0 이 된다면 큐에 넣기
         * 3. 큐가 빌때까지 반복
         */
        while (!q.isEmpty()) {
            int node = q.poll();
            result.offer(node);
            min_time[node] += process[node];
            visited[node] = true;
          // for(int t = 1; t < n + 1; t++)min_time[t]  += process[node];


            for (Integer i : array.get(node)) {
                indegree[i]--;
                if(!visited[i]) min_time[i] += min_time[node];
                else min_time[i] += process[node];
                visited[i] = true;


                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

       for(int t = 1; t < n + 1; t++) System.out.println(min_time[t]);

    }
}
