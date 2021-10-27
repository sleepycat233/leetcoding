
#include <stdio.h>



/* ////////////////////////////////////// */

int top = 0;
char stack[16];

void push(char x) { stack[top++] = x; }

char pop(void) { return stack[--top]; }

int is_empty(void) { return top == 0; }

char peek(void) {
    if(!is_empty())
        return stack[top - 1];
    else
        return -1;
}

int r2i(char c)
{
    switch (c) {
    case 'I':
        return 1;
    case 'V':
        return 5;
    case 'X':
        return 10;
    case 'L':
        return 50;
    case 'C':
        return 100;
    case 'D':
        return 500;
    case 'M':
        return 1000;
    }
    return -1;
}

int romanToInt(char *s)
{
    int res = 0;
    char pc, nc;

    if (s == NULL) {
        return -1;
    }

    for (; *s; ++s) {
        push(*s);
        ++s;
        // nc = *(s+1);

        if (s == NULL) {
            break;
        }

        pc = peek();
        if(*s != pc) {
            if(r2i(*s) > r2i(pc)) {
                if ((pc == 'I' && (*s == 'V' || *s == 'X'))
                    || (pc == 'X' && (*s == 'L' || *s == 'C'))
                    || (pc == 'C' && (*s == 'D' || *s == 'M'))) {
                    res += r2i(*s) - r2i(pop());
                }
                else {
                    return -1;
                }
            }

            else {
                --s;
                while (!is_empty()) {
                    res += r2i(pop());
                }
            }
        }
        else {
            push(*s);
        }

    }

    while (!is_empty()) {
        res += r2i(pop());
    }

    return res;
}

int main() {
    printf("%d\n",romanToInt("MCMXCIV"));
}