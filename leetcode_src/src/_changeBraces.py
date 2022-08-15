def cb(s):
    s = s.replace('[', '{').replace(']', '}')
    print(s)
    return s

cb("[[1,2],[2,3],[3,4],[1,4],[1,5]]")