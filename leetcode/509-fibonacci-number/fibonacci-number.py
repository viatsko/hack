class Solution:
    def fib(self, N: int) -> int:
        sum = 0
        stack = [N]

        while(len(stack) > 0):
            val = stack.pop()

            if val == 0:
                sum += 0
            elif val == 1:
                sum += 1
            else:
                stack.append(val - 2)
                stack.append(val - 1)

        return sum
