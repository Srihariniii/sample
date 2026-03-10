class Solution {
    public String toLowerCase(String s) {

        String result = "";
        char c;

        for(int i = 0; i < s.length(); i++){

            c = s.charAt(i);

            if(c >= 'A' && c <= 'Z'){
                c = (char)(c + 32);
            }

            result = result + c;
        }

        return result;
    }
}