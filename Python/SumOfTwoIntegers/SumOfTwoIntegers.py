#Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
#Example:
#Given a = 1 and b = 2, return 3.

#Credits:
#Special thanks to @fujiaozhu for adding this problem and creating all test cases.

class Solution:
    def getSum(self, a, b):
        """
                :type a: int
                :type b: int
                :rtype: int
                """
        result = a + b
        return result

c = Solution().getSum(1, 5)
print(c)