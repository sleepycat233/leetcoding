class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums)-1

        while l <= r:
            mid = (l+r)//2

            if nums[l] <= nums[mid]:
                if nums[l] <= target and target <= nums[mid]:
                    r = mid
                    break
                else:
                    l = mid + 1

            else:  # nums[mid] < nums[r]
                if nums[mid] <= target and target <= nums[r]:
                    l = mid
                    break
                else:
                    r = mid - 1

        while l <= r:
            mid = (l+r) // 2

            if target < nums[mid]:
                r = mid - 1
            elif target > nums[mid]:
                l = mid + 1
            else:
                return mid

        return -1