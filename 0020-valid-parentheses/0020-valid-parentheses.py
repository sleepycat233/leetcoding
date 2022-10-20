class Solution:
    def isValid(self, s: str) -> bool:
        mapping = {')':'(', ']':'[', '}':'{'}
        stack = []

        for c in s:
            if not stack or not c in mapping:
                stack.append(c)
            elif stack and stack.pop() != mapping[c]:
                return False

        return not stack