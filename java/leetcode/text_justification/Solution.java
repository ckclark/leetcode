package leetcode.text_justification;

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
    	ArrayList<String> ans = new ArrayList<String>();
    	ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
    	if(words.length == 0) return ans;
    	int lineIdx = 0;
    	int wordIdx = 0;
    	int lineUsage = 0;
    	while(wordIdx < words.length){
    		ArrayList<String> currLine;
    		if(lines.size() <= lineIdx){
    			currLine = new ArrayList<String>(); 
    			lines.add(currLine);
    			lineUsage = 0;
    		}else{
    			currLine = lines.get(lineIdx);
    		}
    		if(lineUsage > 0){
    			if(lineUsage + 1 + words[wordIdx].length() > L){
    				lineIdx++;
    			}else{
    				lineUsage += 1 + words[wordIdx].length();
    				currLine.add(words[wordIdx]);
    				wordIdx++;
    			}
    		}else{
    			lineUsage = words[wordIdx].length();
    			currLine.add(words[wordIdx]);
    			wordIdx++;
    		}
    	}
    	for(int idx = 0; idx < lines.size(); idx++){
    		ArrayList<String> line = lines.get(idx);
    		StringBuilder sb = new StringBuilder();
    		int lengthSum = 0;
    		for(String s : line){
    			lengthSum += s.length();
    		}
    		int spaceSize;
    		int extraSpaceSize;
    		int used = 0;
    		if(line.size() == 1 || idx == lines.size() - 1){
    			spaceSize = 1;
    			extraSpaceSize = 0;
    		}else{
    			spaceSize = (L - lengthSum) / (line.size() - 1);
    			extraSpaceSize = (L - lengthSum) % (line.size() - 1);
    		}
    		
    		for(int i = 0; i < line.size(); i++){
    			if(i > 0){
    				if(i <= extraSpaceSize){
    					sb.append(' ');
    					used++;
    				}
    				for(int j = 0; j < spaceSize; j++){
    					sb.append(' ');
    				}
    				used += spaceSize;
    			}
    			sb.append(line.get(i));
    			used += line.get(i).length();
    		}
    		for(int i = L - used; i > 0; i--){
    			sb.append(' ');
    		}

    		ans.add(sb.toString());
    	}
    	return ans;
    }
    
    public static void main(String[] args){
    	for(String s : new Solution().fullJustify(new String[]{"What","must","be","shall","be."}, 12)){
    		System.err.println("'" + s + "'");
    	}
    }
}
