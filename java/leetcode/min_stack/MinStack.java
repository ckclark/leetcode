package leetcode.min_stack;

class MinStack {
	private static final int SIZE = 100000;
	private int[] mList = new int[SIZE];
	private int[] mMinList = new int[SIZE];
	private int mSize = 0;

	public void push(int x) {
		mList[mSize] = x;
		int minVal = x;
		if(mSize > 0){
			minVal = Math.min(mMinList[mSize - 1], x);
		}
		mMinList[mSize] = minVal;
		mSize++;
    }

    public void pop() {
    	mSize--;
    }

    public int top() {
        return mList[mSize - 1];
    }

    public int getMin() {
        return mMinList[mSize - 1];
    }
}
