class Solution {
    public String getHint(String secret, String guess) {
        int bull=0;
        int cow=0;
        int i=0;
        int j=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(i<secret.length() && j<guess.length()){
            if(secret.charAt(i)==guess.charAt(j)){
                bull++;
            }
            else{
                map.put(guess.charAt(j),map.getOrDefault(guess.charAt(j),0)+1);
            }
            i++;
            j++;
        }
        i=0;
        j=0;
        while(i<secret.length() && j<guess.length()){
            if(secret.charAt(i)!=guess.charAt(j)){
                if(map.containsKey(secret.charAt(i)) && map.get(secret.charAt(i))>0){
                    cow++;
                    map.put(secret.charAt(i),map.get(secret.charAt(i))-1);
                }
            }
            i++;
            j++;
        }
        return String.valueOf(bull)+"A"+String.valueOf(cow)+"B";

        
    }
}