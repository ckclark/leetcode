package leetcode.bulls_and_cows;

public class Solution {
    public String getHint(String secret, String guess) {
        int[] countSecret = new int[10];
        int[] countGuess = new int[10];
        int length = secret.length();
        int A = 0, B = 0;
        for(int i = 0; i < length; i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                A++;
            }else{
                countSecret[s - '0']++;
                countGuess[g - '0']++;
            }
        }
        for(int i = 0; i < 10; i++){
            B += Math.min(countSecret[i], countGuess[i]);
        }
        return A + "A" + B + "B";
    }
}
