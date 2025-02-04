/*
 * @Author: Tungbo
 * @Date: 2022-07-13 11:23:57
 * @LastEditTime: 2022-07-13 15:12:31
 * @LastEditors: Tungbo
 * @Description: leecode: 735. 行星碰撞
 * 
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220711;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution735 {
    
    public static void main(String[] args) {
        System.out.println(new Solution735().asteroidCollision(new int[]{10,2,-5}));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            Integer target = asteroids[i];
            if(!stack.isEmpty() && isCollision(stack.peek(), target)) {
                while (!stack.isEmpty() && isCollision(stack.peek(), target)) {
                    if(Math.abs(stack.peek()) < Math.abs(target)) {
                        stack.pop();
                    } else if(Math.abs(stack.peek()) == Math.abs(target)){
                        stack.pop();
                        target = null;
                    } else {
                        target = null;
                        break;
                    }
                }
            }
            if(target!=null) stack.push(target);
        }
        int[] ans = new int[stack.size()];
        int i =stack.size()-1;
        while(!stack.isEmpty()) {
            ans[i--] = stack.pop();
        }
        return ans;
    }

    private boolean isCollision(Integer peek, Integer target) {
        if(target == null) return false;
        if(peek >= 0 && target < 0) return true;
        return false;
    }

    public int[] asteroidCollision1(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (Integer aster : asteroids) {
            boolean alive = true;
            while(alive && aster < 0 && ! stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster;
                if(stack.peek() <= -aster) {
                    stack.pop();
                }
            }
            if(alive) stack.push(aster);
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
