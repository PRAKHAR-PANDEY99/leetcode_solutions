class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<students.length;i++){
            q.offer(students[i]);
        }
        int i=0;
        int c=0;
        while(!q.isEmpty()){
            if(sandwiches[i]==q.peek()){
                q.poll();
                i++;
                c=0;
            }
            else{
                c=c+1;
                int l=q.poll();
                q.add(l);
            }
            if(c==q.size()){
                return q.size();
            }
        }
        return 0;
        
    }
}