class Solution {
    public int ladderLength(String beginword, String endword, List<String> wordList) {
        if(!wordList.contains(endword)) {
            return 0;
        }
     Set<String> set = new HashSet<>(wordList);
     int level = 1;   
     Queue<String> q = new LinkedList<>(); 
     if(wordList.contains(beginword)) {
      set.remove(beginword);
     }
     q.add(beginword);

     while(!q.isEmpty()) {
     int size = q.size();
     for(int j = 0; j < size; j++) {
     String word = q.poll();
  for(int i = 0; i < word.length(); i++) {
     for(char ch = 'a'; ch <= 'z'; ch++) {
        char[] chars = word.toCharArray();
        chars[i] = ch;
        String newword = new String(chars);
        if(set.contains(newword)) {
        set.remove(newword);
        q.add(newword);
        if(newword.equals(endword)) {
            return level +1 ;
             }
           }
         }
       }
     }
      level++;
    }
    return 0;
   }
 }
 // we have to first remove the word from wordlist and then add into the queue in order to maintain that no words appears again

 // also this req level ordering as if there is only a letter difference then only one count increases