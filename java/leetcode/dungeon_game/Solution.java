package leetcode.dungeon_game;

import java.util.LinkedList;

public class Solution {
	public static class Tuple{
		public int needHealth;
		public int remainHealth;
		public Tuple(int needHealth, int remainHealth){
			this.needHealth = needHealth;
			this.remainHealth = remainHealth;
		}
	}

	public static class TupleLinkedList extends LinkedList<Tuple>{

		@Override
		public boolean add(Tuple tuple) {
			for(int i = size() - 1; i >= 0; i--){
				Tuple cur = get(i);
				if(tuple.needHealth > cur.needHealth){
					if(tuple.remainHealth - tuple.needHealth > cur.remainHealth - cur.needHealth){
						super.add(i + 1, tuple);
						return true;
					}else{
						return true;
					}
				}else if(tuple.needHealth == cur.needHealth){
					cur.remainHealth = Math.max(tuple.remainHealth, cur.remainHealth);
					return true;
				}else{
					if(cur.remainHealth - cur.needHealth <= tuple.remainHealth - tuple.needHealth){
						remove(i);
					}
				}
			}
			super.add(0, tuple);
			return true;
		}

	}

	public int calculateMinimumHP(int[][] dungeon) {
        int w = dungeon[0].length;
        int h = dungeon.length;
        TupleLinkedList[][] tll = new TupleLinkedList[h][w];
        for(int y = 0; y < h; y++){
        	for(int x = 0; x < w; x++){
        		tll[y][x] = new TupleLinkedList();
        	}
        }
        if(dungeon[0][0] > 0){
        	tll[0][0].add(new Tuple(1, dungeon[0][0] + 1));
        }else{
        	tll[0][0].add(new Tuple(-dungeon[0][0] + 1, 1));
        }
        for(int y = 0; y < h; y++){
        	for(int x = 0; x < w; x++){
        		int cur = dungeon[y][x];
        		if(x > 0){
        			if(cur >= 0){
        				for(Tuple t : tll[y][x - 1]){
        					tll[y][x].add(new Tuple(t.needHealth, t.remainHealth + cur));
        				}
        			}else{
        				for(Tuple t : tll[y][x - 1]){
        					int remainHealth = t.remainHealth + cur;
        					if(remainHealth > 0){
        						tll[y][x].add(new Tuple(t.needHealth, remainHealth));
        					}else{
        						tll[y][x].add(new Tuple(t.needHealth - remainHealth + 1, 1));
        					}
        				}
        			}
        		}
        		if(y > 0){
        			if(cur >= 0){
        				for(Tuple t : tll[y - 1][x]){
        					tll[y][x].add(new Tuple(t.needHealth, t.remainHealth + cur));
        				}
        			}else{
        				for(Tuple t : tll[y - 1][x]){
        					int remainHealth = t.remainHealth + cur;
        					if(remainHealth > 0){
        						tll[y][x].add(new Tuple(t.needHealth, remainHealth));
        					}else{
        						tll[y][x].add(new Tuple(t.needHealth - remainHealth + 1, 1));
        					}
        				}
        			}
        		}
        	}
        }
        return tll[h - 1][w - 1].get(0).needHealth;
    }
}
