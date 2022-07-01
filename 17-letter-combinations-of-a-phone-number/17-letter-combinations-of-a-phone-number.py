
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if(len(digits) == 0):
            return []

        letters = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl",
                    "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}

        def combine(index, run):
            if(index == len(digits)):
                combinations.append("".join(run))
            else:
                group = letters[digits[index]]
                for i in range(len(group)):
                    run.append(group[i])
                    combine(index+1, run)
                    run.pop()

        combinations = []
        combine(0, [])
        return combinations
