class Solution {
public:
    int lengthOfLastWord(string s) {
        int count=0;
        if(s.size()==1){
            return 1;
        }
        for(int i=s.size()-1;i>=0;i--){
            if((s[i]>='a' && s[i]<='z') || (s[i]>='A' && s[i]<='Z')){
                count=count+1;
                if(count>=1){
                    if(i == 0 || s[i - 1] == ' '){
                        return count;
                    }
                }
          
            }
        }    
        return count;  
    }
};