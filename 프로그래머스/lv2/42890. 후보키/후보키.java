import java.util.*;
class Solution {
    List<List<Integer>> list;
    
    public int solution(String[][] relation) {
        list = new ArrayList<>();
        for (int i = 1; i <= relation[0].length; i++) {
            dfs(relation, i, 0, new ArrayList<>());
        }
        return list.size();
    }
    
    public void dfs(String[][] relation, int n, int start, List<Integer> now) {
        if (now.size() == n) {
            
            // 유일성 검사
            Set<List<String>> set = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                List<String> tmp = new ArrayList<>();
                for (int x : now) {
                    tmp.add(relation[i][x]);
                }
                set.add(tmp);
            }
            
            // 최소성 검사
            if (set.size() == relation.length) {
                boolean flag = true;
                for (List<Integer> x : list) {
                    int cnt = 0;
                    for (int y : now) {
                        if (x.contains(y)) {
                            cnt++;
                        }
                    }
                    if (cnt == x.size()) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list.add(new ArrayList<>(now));
                }
            }
            return;
        }
        
        for (int i = start; i < relation[0].length; i++) {
            now.add(i);
            dfs(relation, n, i+1, now);
            now.remove(now.size() - 1);
        }
    }
}