class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        int moves = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(ch);
            } 
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } 
                else {
                    moves++;
                }
            }
        }

        moves += stack.size();

        return moves;
    }
}