// Last updated: 10/19/2026, 6:54:12 PM
class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                
                if (stack.isEmpty())
                    stack.push(i);
                else
                    res = Math.max(res, i - stack.peek());
            }
        }
        
        return res;
    }
}