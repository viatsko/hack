class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.length() == 1 && "+-/*".contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                
                switch(token.charAt(0)) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        
        return stack.peek();
    }
}
