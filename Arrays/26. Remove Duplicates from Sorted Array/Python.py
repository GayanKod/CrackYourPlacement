class Solution:
    from typing import List

    def removeDuplicates(self, nums: List[int]) -> int:
        temp = nums[0]
        k=1

        for i in range (1,len(nums)):
            if (temp != nums[i]):
                k +=1
                temp = nums[i]
                nums[k-1] = nums[i]
        return k

def main():
    solution = Solution()
    nums = [1, 1, 2, 2, 3, 4, 4]
    k = solution.removeDuplicates(nums)
    print("The number of unique elements is:", k)
    print("The modified array is:", nums[:k])

if __name__ == "__main__":
    main()