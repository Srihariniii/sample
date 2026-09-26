class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> map = new HashMap<>();

        // Store knowledge
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                int start = i + 1;
                int j = start;

                while (s.charAt(j) != ')') {
                    j++;
                }

                // Extract key
                String key = s.substring(start, j);

                // Get value
                if (map.containsKey(key)) {
                    ans.append(map.get(key));
                } else {
                    ans.append("?");
                }

                // Jump to ')'
                i = j;

            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}