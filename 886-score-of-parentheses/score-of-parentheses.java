class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                // Start a new group
                stack.push(0);
            } 
            else {
                // Get score inside current ()
                int inside = stack.pop();

                // () = 1
                // (A) = 2 * A
                int value;

                if (inside == 0) {
                    value = 1;
                } else {
                    value = 2 * inside;
                }

                int previous = stack.pop();
                stack.push(previous + value);
            }
        }

        return stack.pop();
    }
}