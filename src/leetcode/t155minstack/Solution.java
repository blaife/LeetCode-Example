package leetcode.t155minstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Blaife
 * @description 155 - 最小栈
 * @data 2020/5/12 10:40
 * 题意：
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class Solution {

    public static void main(String[] args) {
        MinStack stact = new MinStack();
        System.out.println(stact.getMin());
        stact.push(2);
        stact.push(0);
        stact.push(3);
        System.out.println(stact.getMin());
        stact.pop();
        stact.pop();
        System.out.println(stact.top());
        System.out.println(stact.getMin());
    }

}

/**
 * 数组实现最小栈 - 不使用stack辅助栈
 */
class MinStack {

    // 存储元素
    private int[] elementData;
    // 栈顶下标
    private int index;

    /** initialize your data structure here. */
    public MinStack() {
        // 默认长度为10
        elementData = new int[10];
        // 默认下标为0
        index = 0;
    }

    /**
     * 推入元素
     * @param x 元素值
     */
    public void push(int x) {
        if (index >= elementData.length - 1) {
            grow();
        }
        elementData[index++] = x;
    }

    /**
     * 移除栈顶元素
     */
    public void pop() {
        elementData[--index] = 0;
    }

    /**
     * 获取栈顶元素
     * @return 栈顶元素
     */
    public int top() {
        return elementData[index-1];
    }

    /**
     * 获取最小值
     * @return 最小值
     */
    public int getMin() {
        int min = Integer.MAX_VALUE;
        if (index == 0) {
            return min;
        }
        for (int i = 0; i < index; i++) {
            min = Math.min(min, elementData[i]);
        }
        return min;
    }

    /**
     * 扩充容量
     */
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
}