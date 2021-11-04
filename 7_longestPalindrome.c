#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int is_substring_palindrome(int start, int end, char *s) {
    int i = start;
    int j = end;
    while(i < j) {
        if(s[i] == s[j]) {
            ++i;
            --j;
        }
        else {
            return 0;
        }
    }
    return end - start + 1;
}

char *longestPalindrome(char *s) {
    char *res;
    int i, j;
    int len = strlen(s);
    int max = 0;
    int n;
    int start = 0, end = 0;

    for(i = 0; i < len-1; i++) {
        for(j = i+1; j < len; j++) {
            n = is_substring_palindrome(i, j, s);
            if(n > max) {
                max = n;
                start = i;
                end = j;
            }
        }
    }

    res = (char *)malloc(sizeof(char) * (end-start+1+1));
    i = 0;
    while(start <= end) {
        res[i++] = s[start++];
    }
    res[i] = '\0';

    return res;
}

int main() {
    // longestPalindrome();

    char *str = "babad";
    // printf("%d\n", is_substring_palindrome(0,strlen(str)-1,str));
    printf("%s\n", longestPalindrome(str));
}