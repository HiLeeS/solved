
class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (i == 0 || s.charAt(i - 1) == ' ') {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }

            
            sb.append(c);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}