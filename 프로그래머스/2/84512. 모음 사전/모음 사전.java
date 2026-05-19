import java.util.*;
class Solution {
    String[] s = {"A", "E", "I", "O", "U"};
    int count = 0;
    boolean check = false;
    
    void dfs(List<String> list, String word){
        
        if(word.length() == list.size()){
            StringBuilder sb = new StringBuilder();
            
            for(String c : list){
                sb.append(c);
            }
            
            if(word.equals(sb.toString())){
                check = true;
                return;
            }
        }
        
        if(check || list.size() == 5){
            return;
        }
        
        
        for(int i = 0; i < 5; i++){
            if(check){
                return;
            }
            
            list.add(s[i]);
            count++;
            dfs(list, word);
            list.remove(list.size()-1);
            
            if(check){
                return;
            }
        }
        
    }
    
    public int solution(String word) {
        
        dfs(new ArrayList<>(), word);
        
        return count;
    }
}