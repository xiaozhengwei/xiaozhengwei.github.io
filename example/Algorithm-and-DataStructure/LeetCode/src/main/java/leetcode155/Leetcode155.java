package leetcode155;

import java.util.ArrayList;
import java.util.Arrays;

class MinStack {

    private final static int IMCREASE=100;

    private int[]stack;
    private int head;
    private int tail;
    private int size;
    private int min;
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack=new int[100];
        head=0;
        tail=-1;
        size=0;
        min=Integer.MAX_VALUE;
    }

    public boolean isEmpty(){
        return size<=0;
    }

    public void push(int val) {
        if(size==stack.length){
            stack=Arrays.copyOf(stack,size+IMCREASE);
        }
        stack[++tail]=val;
    }

    public void pop() {
        if (!isEmpty()){
            tail--;
            size--;
        }
    }

    public int top() {
        return stack[head];
    }

    public int getMin() {
        return min;
    }

}
