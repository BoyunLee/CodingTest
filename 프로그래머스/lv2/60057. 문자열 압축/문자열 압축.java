class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int compressed = compress(s, i);
            answer = Math.min(answer, compressed);
        }

        return answer;
    }

    private int compress(String s, int unit) {
        StringBuilder result = new StringBuilder();
        String prev = s.substring(0, unit);
        int count = 1;

        for (int i = unit; i < s.length(); i += unit) {
            String substr = s.substring(i, Math.min(i + unit, s.length()));
            if (prev.equals(substr)) {
                count++;
            } else {
                result.append((count > 1) ? count : "").append(prev);
                prev = substr;
                count = 1;
            }
        }

        result.append((count > 1) ? count : "").append(prev);
        return result.length();
    }
}