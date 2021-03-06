class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) return false;
            char curr = stack.pop();
            if (c == ')'){
                if (curr == '[' || curr == '{') return false;
            }
            if (c == ']'){
                if (curr == '(' || curr == '{') return false;
            }
            if (c == '}'){
                if (curr == '(' || curr == '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
