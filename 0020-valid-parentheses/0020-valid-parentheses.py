class Solution:
    def isValid(self, s: str) -> bool:
        mapping = {')':'(', ']':'[', '}':'{'}
        stack = []

        for c in s:
            if not c in mapping:
                stack.append(c)
            elif not stack or stack.pop() != mapping[c]:
                return False

        return not stack