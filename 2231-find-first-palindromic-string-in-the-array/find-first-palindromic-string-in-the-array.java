class Solution {
    public String firstPalindrome(String[] words) {

        String s="";
        String v="";
        char c;

        for(int i=0;i<words.length;i++){

            s = words[i];
            v = "";

            for(int j=s.length()-1;j>=0;j--){
                c = s.charAt(j);
                v = v + c;
            }

            if(v.equals(s)){
                return v;
            }
        }

        return "";
    }
}