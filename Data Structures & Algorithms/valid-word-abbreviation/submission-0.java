class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while(i < word.length() && j < abbr.length()){
            char w_c = word.charAt(i);
            char a_c = abbr.charAt(j);

            if(Character.isDigit(a_c)){
                if(a_c == '0'){
                    return false;
                }else{
                    int curr = 0;

                    while(j < abbr.length() && Character.isDigit(abbr.charAt(j)))
                    {
                        curr = curr * 10 + (abbr.charAt(j) - '0');
                        j++;
                    }
                    i += curr;
                }
            }else{
                if (a_c != w_c){
                    return false;
                }
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}