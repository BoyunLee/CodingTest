import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {     
        Arrays.sort(mats);
        int n = park.length;
        int m = park[0].length;
        
        for(int a=mats.length-1; a>=0; a--) {
            int mat = mats[a];
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(park[i][j].equals("-1")) {
                        if(i+mat<=n && j+mat<=m) {
                            boolean check = bfs(i, j, mat, park);
                            if(check) {
                                return mat;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    static boolean bfs(int x, int y, int m, String[][] park) {
        for(int r=x; r<x+m; r++) {
            for(int c=y; c<y+m; c++) {
                if(!park[r][c].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}