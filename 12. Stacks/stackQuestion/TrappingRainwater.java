package com.stackQuestion;
import java.util.*;
public class TrappingRainwater {
    public static void main(String[] args){
       int height[]={7,0,4,2,5,0,6,4,0,6};
        System.out.println(maxWater(height));

    }
    public static int maxWater(int[] height){
        Stack<Integer>stack=new Stack<>();
        int n=height.length;
        int ans=0;
        for (int i=0; i<n; i++){
            while ((!stack.isEmpty()) && (height[stack.peek()]<height[i])){
                int pop_height=height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int distance=i-stack.peek()-1;
                int minHeight=Math.min(height[stack.peek()],height[i])-pop_height;
                ans+=distance*minHeight;

            }
            stack.push(i);
        }
        return ans;
    }
}
