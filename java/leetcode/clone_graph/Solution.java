package leetcode.clone_graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import common.UndirectedGraphNode;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null) return null;
    	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	Map<Integer, UndirectedGraphNode> cloneMap = new HashMap<Integer, UndirectedGraphNode>();  
    	
    	queue.add(node);
    	while(!queue.isEmpty()){
    		UndirectedGraphNode cur = queue.remove();
    		UndirectedGraphNode clone = new UndirectedGraphNode(cur.label);
    		cloneMap.put(cur.label, clone);
    		
    		for(UndirectedGraphNode neighbor : cur.neighbors){
    			if(!cloneMap.containsKey(neighbor.label)){
    				queue.offer(neighbor);
    			}
    		}
    	}

    	queue.add(node);
    	while(!queue.isEmpty()){
    		UndirectedGraphNode cur = queue.remove();
    		UndirectedGraphNode clone = cloneMap.get(cur.label);
    		if(cur.neighbors.size() != clone.neighbors.size()){
    			for(UndirectedGraphNode neighbor : cur.neighbors){
    				clone.neighbors.add(cloneMap.get(neighbor.label));
    				UndirectedGraphNode neighborClone = cloneMap.get(neighbor.label);
    				if(neighborClone.neighbors.size() != neighbor.neighbors.size()){
    					queue.offer(neighbor);
    				}
    			}
    		}
    	}
    	return cloneMap.get(node.label);
    }
    
    public static void dump(UndirectedGraphNode node){
    	System.err.println("label: " + node.label);
    	System.err.print("neighbors: ");
    	for(UndirectedGraphNode r : node.neighbors){
    		System.err.print(r.label + " ");
    	}
    	System.err.println("");
    }
    
    public static void main(String[] args){
    	UndirectedGraphNode ugn0 = new UndirectedGraphNode(0);
    	UndirectedGraphNode ugn1 = new UndirectedGraphNode(1);
    	UndirectedGraphNode ugn2 = new UndirectedGraphNode(2);
    	ugn0.neighbors.add(ugn1);
    	ugn0.neighbors.add(ugn2);
    	ugn1.neighbors.add(ugn2);
    	ugn2.neighbors.add(ugn2);
    	
    	UndirectedGraphNode ret = new Solution().cloneGraph(ugn0);
    	dump(ret);
    	dump(ret.neighbors.get(0));
    	dump(ret.neighbors.get(1));
    }
}
