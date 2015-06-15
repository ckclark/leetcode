package leetcode.implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> mQueue = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        mQueue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = mQueue.size();
        for(int i = 0; i < size - 1; i++){
            mQueue.offer(mQueue.remove());
        }
        mQueue.remove();
    }

    // Get the top element.
    public int top() {
        int size = mQueue.size();
        for(int i = 0; i < size - 1; i++){
            mQueue.offer(mQueue.remove());
        }
        int top = mQueue.remove();
        mQueue.offer(top);
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return mQueue.size() == 0;
    }
}
