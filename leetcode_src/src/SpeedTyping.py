
def speedTyping():
    T = int(input())
    res = ""

    for x in range(T):
        I = input()
        P = input()

        p = len(P)-1
        for i in reversed(I):
            if P[p] != i:
                continue
            p-=1

        if p > 0:
            ans = p
        else:
            ans = "IMPOSSIBLE"

        print(f"case #{x}:{ans}")

if __name__ == '__main__':
    # print("test")
    speedTyping()