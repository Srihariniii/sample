import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            String current = queue.poll();

            // Check whether current string is valid
            if (isValid(current)) {
                ans.add(current);
                found = true;
            }

            // If we already found valid strings,
            // don't remove more parentheses.
            if (found) {
                continue;
            }

            // Remove one parenthesis at every position
            for (int i = 0; i < current.length(); i++) {

                char ch = current.charAt(i);

                // We only remove '(' or ')'
                if (ch != '(' && ch != ')') {
                    continue;
                }

                String next = current.substring(0, i)
                        + current.substring(i + 1);

                // Avoid duplicates
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        return ans;
    }

    // Checks whether parentheses are valid
    private boolean isValid(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                count++;
            }
            else if (ch == ')') {
                count--;

                // More ')' than '('
                if (count < 0) {
                    return false;
                }
            }
        }

        // All '(' must have matching ')'
        return count == 0;
    }
}