class Solution:
    def isValid(self, s:str) -> bool:
        stack = []
        map = {")":"(", "]":"[", "}":"{"}

        for char in s:
            if char in map:
                top = stack.pop() if stack else '#'
                if top != map[char]:
                    return False
            else:
                stack.append(char)

        return not stack

print(Solution().isValid("(){}"))
print(Solution().isValid("({[}])"))
