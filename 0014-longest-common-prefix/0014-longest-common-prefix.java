class Solution {
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);
            
            for (int j = 1; j < strs.length; j++) {
                // Pehle length check (crash se bachne ke liye), phir char mismatch check
                if (i == strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        // Agar poora strs[0] sabhi strings mein match ho gaya
        return strs[0];
    }
}
// first we always have to match the chars as if the chars get mismatched we got the ans straight away so they are in the outer loop