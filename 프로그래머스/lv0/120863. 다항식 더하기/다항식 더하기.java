import java.util.*;

public class Solution {
    public static String solution(String polynomial) {
        // 항을 분리합니다.
        String[] terms = polynomial.split(" \\+ ");
        
        // 항을 저장할 맵을 생성합니다.
        Map<String, Integer> termMap = new HashMap<>();
        
        for (String term : terms) {
            // 항을 분석합니다.
            term = term.trim();
            if (term.contains("x")) {
                if (term.equals("x")) {
                    termMap.put("x", termMap.getOrDefault("x", 0) + 1);
                } else {
                    int coefficient = term.contains("x") ? Integer.parseInt(term.replace("x", "").trim()) : 1;
                    termMap.put("x", termMap.getOrDefault("x", 0) + coefficient);
                }
            } else {
                int constant = Integer.parseInt(term.trim());
                termMap.put("constant", termMap.getOrDefault("constant", 0) + constant);
            }
        }
        
        // 결과를 문자열로 변환합니다.
        StringBuilder result = new StringBuilder();
        if (termMap.containsKey("x")) {
            int xCoefficient = termMap.get("x");
            if (xCoefficient != 0) {
                if (xCoefficient == 1) {
                    result.append("x");
                } else {
                    result.append(xCoefficient).append("x");
                }
            }
        }
        
        if (termMap.containsKey("constant")) {
            int constant = termMap.get("constant");
            if (constant != 0) {
                if (result.length() > 0) {
                    result.append(" + ").append(constant);
                } else {
                    result.append(constant);
                }
            }
        }
        
        return result.length() == 0 ? "0" : result.toString();
    }
}