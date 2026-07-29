class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] arr = path.split("/");

        for (String s : arr) {

            if (s.equals("") || s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {

                stack.push(s);

            }
        }

        String ans = "";

        for (String s : stack) {
            ans += "/" + s;
        }

        if (ans.equals("")) {
            return "/";
        }

        return ans;
    }
}