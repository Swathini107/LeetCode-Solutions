# Last updated: 10/22/2026, 3:58:51 PM
1class Solution(object):
2    def isHappy(self, n):
3        """
4        :type n: int
5        :rtype: bool
6        """
7        if (n == 1 or n == 7):
8            return True
9        elif (n<10):
10            return False
11        else:
12            sum=0
13            while(n>0):
14                temp=n%10
15                sum +=temp*temp
16                n //= 10
17            return self.isHappy(sum)
18
19        