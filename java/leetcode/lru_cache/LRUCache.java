package leetcode.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private static class CacheEntry{
		int key, val;
		CacheEntry prev, next;
		public CacheEntry(int key, int val){
			this.key = key;
			this.val = val;
		}
	}
	private int capacity;
	private CacheEntry mCacheHead, mCacheTail;
	private int mCacheSize;
	private Map<Integer, CacheEntry> mIndexMap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        mCacheHead = mCacheTail = null;
        mIndexMap = new HashMap<Integer, CacheEntry>();
        mCacheSize = 0;
    }
    
    public void moveToFirst(CacheEntry entry){
    	if(entry.prev != null){
    		CacheEntry next = entry.next;
    		CacheEntry prev = entry.prev;
    		prev.next = next;
    		if(next == null){
    			mCacheTail = prev;
    		}else{
    			next.prev = prev;
    		}
    		entry.next = mCacheHead;
    		entry.prev = null;
    		mCacheHead.prev = entry;
    		mCacheHead = entry;
    	}
    }
    
    public int get(int key) {
    	CacheEntry entry = mIndexMap.get(key);
    	if(entry == null) return -1;
    	moveToFirst(entry);
    	return entry.val;
    }
    
    public void set(int key, int value) {
        CacheEntry entry = mIndexMap.get(key);
        if(entry != null){
        	entry.val = value;
        	moveToFirst(entry);
        }else{
        	if(mCacheSize >= capacity){
        		moveToFirst(mCacheTail);
        		mIndexMap.remove(mCacheHead.key);
        		mCacheHead.val = value;
        		mCacheHead.key = key;
        	}else{
        		entry = new CacheEntry(key, value);
        		if(mCacheHead == null){
        			mCacheTail = mCacheHead = entry;
        		}else{
        			entry.next = mCacheHead;
        			mCacheHead.prev = entry; 
        			mCacheHead = entry;
        		}
        		mCacheSize++;
        	}
        	mIndexMap.put(key, mCacheHead);
        }
    }
    
    public static void main(String[] args){
    	LRUCache cache = new LRUCache(8);
    	for(int i = 0; i < 10; i++){
    		cache.set(i, i + 100);
    	}
    	for(int i = 0; i < 10; i++){
    		System.err.println(cache.get(i));
    	}
    	cache.get(5);
    	cache.set(10, 110);
    	cache.set(11, 111);
    	CacheEntry entry = cache.mCacheHead;
    	while(entry != null){
    		System.err.println(entry.key + ": " + entry.val);
    		entry = entry.next;
    	}
    }
}
