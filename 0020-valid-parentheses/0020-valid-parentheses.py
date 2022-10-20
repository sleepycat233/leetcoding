class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        def isOpen(c):
            return c == '(' or c == '[' or c == '{'

        def isMatched(l, r):
            if l == '(': return r == ')'
            elif l == '[': return r == ']'
            elif l == '{': return r == '}'

        for c in s:
            if isOpen(c):
                stack.append(c)
            elif stack:
                l = stack.pop()
                if not isMatched(l, c):
                    return False
            else:
                return False

        return len(stack) == 0