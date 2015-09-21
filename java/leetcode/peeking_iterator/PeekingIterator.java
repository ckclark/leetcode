package leetcode.peeking_iterator;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> mIterator;
    private Integer mNext;
    private boolean mHasNext;
    
    private final void nextInternal(){
        mHasNext = mIterator.hasNext();
        if(mHasNext){
            mNext = mIterator.next();
        }
    }

    public PeekingIterator(Iterator<Integer> iterator) {
        mIterator = iterator;
        nextInternal();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return mNext;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(mHasNext){
            Integer ret = mNext;
            nextInternal();
            return ret;
        }else{
            return null; // don't know how to handle
        }
    }

    @Override
    public boolean hasNext() {
        return mHasNext;
    }

    @Override
    public void remove() {
        
    }
}
