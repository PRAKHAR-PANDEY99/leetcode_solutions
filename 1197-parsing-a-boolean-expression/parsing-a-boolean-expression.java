class Solution {
    
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        Stack<Character> st2=new Stack<>();
        
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            
            if(ch=='!' || ch=='&' || ch=='|'){
                st.push(ch);
            }
            else if(ch=='f' || ch=='t'){
                st2.push(ch);
            }
            else if(ch=='('){
                st2.push('(');
            }
            else if(ch==')'){
                char c=st.pop();
                
                boolean ans;
                
                if(c=='&'){
                    ans=true;
                }
                else if(c=='|'){
                    ans=false;
                }
                else{
                    ans=true;
                }
                
                while(st2.peek()!='('){
                    char a=st2.pop();
                    
                    if(c=='&'){
                        ans=ans && (a=='t');
                    }
                    else if(c=='|'){
                        ans=ans || (a=='t');
                    }
                    else if(c=='!'){
                        ans=!(a=='t');
                    }
                }
                
                st2.pop();
                
                if(ans){
                    st2.push('t');
                }
                else{
                    st2.push('f');
                }
            }
        }
        
        return st2.peek()=='t';
    }
}