class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {
            if (s.matches("[0-9]+")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}