class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        n = len(numbers)
        l, r = 0, n-1
        dif = target - numbers[l] - numbers[r]

        while dif != 0:
            if dif > 0:
                dif += numbers[l]
                l += 1
                dif -= numbers[l]
            else:
                dif += numbers[r]
                r -= 1
                dif -= numbers[r]

        return [l+1, r+1]