#include<stdio.h>
#include<string.h>

char cache[1 << 20];

char top_down(int s, int rem, int mci){
    int i;
    char ret = 1;
    if(cache[s] > 0){
        return cache[s] - 1;
    }
    for(i = 0; i < mci; i++){
        if(((1 << i) & s) == 0){
            int v = i + 1;
            if(v >= rem){
                cache[s] = 2;
                return 1;
            }
        }
    }
    for(i = 0; i < mci; i++){
        if((s & (1 << i)) == 0){
            if(!top_down(s | (1 << i), rem - (i + 1), mci)){
                ret = 2;
                break;
            }
        }
    }
    cache[s] = ret;
    return cache[s] - 1;
}

char canIWin(int maxChoosableInteger, int desiredTotal) {
    memset(cache, 0, sizeof(char[1 << 20]));
    int i = 0;
    if(maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal){
        return 0;
    }
    return top_down(0, desiredTotal, maxChoosableInteger);
}

int main(){
    int i, j;
    for(i = 1; i <= 20; i++){
        printf("%d ", i);
        for(j = i * (i + 1) / 2; j >= 1; j--){
            printf("%d", canIWin(i, j));
        }
        puts("");
    }
}
