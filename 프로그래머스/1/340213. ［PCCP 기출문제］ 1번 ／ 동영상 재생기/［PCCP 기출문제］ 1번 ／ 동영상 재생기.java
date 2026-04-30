class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] time = pos.split(":");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);

        String[] end = video_len.split(":");
        int eh = Integer.parseInt(end[0]);
        int em = Integer.parseInt(end[1]);
        
        String[] ops = op_start.split(":");
        int osh = Integer.parseInt(ops[0]);
        int osm = Integer.parseInt(ops[1]);

        String[] ope = op_end.split(":");
        int oeh = Integer.parseInt(ope[0]);
        int oem = Integer.parseInt(ope[1]);
        
        int opst = osh*60 + osm;
        int opet = oeh*60 + oem;
        
        for(int t=0; t<commands.length; t++) {
            int cur = h*60+m;
            if(opst <= cur && cur < opet) {
                h = oeh;
                m = oem;
            }
            if(commands[t].equals("prev")) {
                m -= 10;
                if(m < 0) {
                    h -= 1;
                    m = 60 + m;
                }
                if(h < 0) {
                    h = 0;
                    m = 0;
                }
            } else if(commands[t].equals("next")) {
                m += 10;
                if(m >= 60) {
                    h += 1;
                    m -= 60;
                }
                
                if(h > eh) {
                    h = eh;
                    m = em;
                } if(h==eh && m>em) {
                    m = em;
                }
            }
            cur = h*60+m;
            if(opst <= cur && cur < opet) {
                h = oeh;
                m = oem;
            }
        }
        return String.format("%02d:%02d", h, m);
    }
}