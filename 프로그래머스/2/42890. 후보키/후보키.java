import java.util.*;

public class Solution {
    public int solution(String[][] relation) {
        int rowCount = relation.length;
        int colCount = relation[0].length;

        List<Integer> listAll = new ArrayList<>();

        // 모든 속성의 조합 생성
        for (int i = 1; i < (1 << colCount); i++) {
            if (Unique(i, relation, rowCount, colCount)) {
                listAll.add(i);
            }
        }

        // 최소성 검사
        List<Integer> candidateKeys = new ArrayList<>(listAll);
        for (int i = 0; i < listAll.size(); i++) {
            for (int j = i + 1; j < listAll.size(); j++) {
                if ((listAll.get(i) & listAll.get(j)) == listAll.get(i)) {
                    candidateKeys.remove(listAll.get(j));
                }
            }
        }

        // 후보키 개수 출력
        int candidateKeyCount = candidateKeys.size();
        System.out.println(candidateKeyCount);

        return candidateKeyCount;
    }

    private static boolean Unique(int combination, String[][] relation, int rowCount, int colCount) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < rowCount; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < colCount; j++) {
                if ((combination & (1 << j)) != 0) {
                    sb.append(relation[i][j]).append(",");
                }
            }
            if (!seen.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }
}