package leetcode.implement_queue_using_stacks;

import java.util.Stack;

class MyQueue {
    Stack<Integer> mStackIn = new Stack<Integer>();
    Stack<Integer> mStackOut = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        mStackIn.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(mStackOut.isEmpty()){
            while(!mStackIn.isEmpty()){
                mStackOut.push(mStackIn.pop());
            }
        }
        mStackOut.pop();
    }

    // Get the front element.
    public int peek() {
        if(mStackOut.isEmpty()){
            while(!mStackIn.isEmpty()){
                mStackOut.push(mStackIn.pop());
            }
        }
        return mStackOut.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return mStackIn.isEmpty() && mStackOut.isEmpty();
    }
}