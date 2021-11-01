/* 10. Regular Expression Matching */

#include <stdio.h>
#include <stdbool.h>

 

/**
 *  wrong.. it is like wildcard matching. not find substring.
 *  */
/* bool isMatch(char *s, char *p) {
    char *ps = s;
    char *pp;
    char c = 0;

    for(; *p; ++p) {
        if(*s == *p || *p == '.') {
            ps = s+1;
            pp = p+1;
            for(; *ps && *pp; ++ps, ++pp) {
                if(*pp == '*') {
                    c = *(pp-1);
                }
                else {
                    c = *pp;
                }
                if(*ps != c && c!='.') {
                    break;
                }
            }
            if(*ps=='\0') {
                return true;
            }
        }
    }

    return false;
} */

int main() {
    printf("%d\n", isMatch("aa", "a"));
    printf("%d\n", isMatch("aaa", "a*"));
    printf("%d\n", isMatch("ab", ".*"));
    printf("%d\n", isMatch("aab", "b*a*b"));
    printf("%d\n", isMatch("mississippi", "mis*is*p*."));
}