package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1662 {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Compress = br.readLine();
        String[] st = Compress.split("");
        int lenOfString = 0;
        int i = 0;
        while(true) {


            if(st[i].equals( ")")){
                while(true){
                    if(stack.pop().equals("(")) break;
                    stack.pop();
                    lenOfString++;

                }
                lenOfString *= Integer.parseInt(stack.pop());
            }
            else
            {
                stack.push(st[i]);
            }

            if(stack.empty()) break;
            i++;
        }

        System.out.println(lenOfString);


    }
}
