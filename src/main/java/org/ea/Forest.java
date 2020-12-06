package org.ea;

import java.util.List;

public class Forest {
    private int map[];
    private int posx = 0;
    private int posy = 0;
    private final int maxx;
    private final int maxy;

    public Forest(List<String> inputs) throws Exception {
        if(inputs.isEmpty()) throw new Exception("NO MAP!!");
        maxx = inputs.get(0).length();
        maxy = inputs.size();
        map = new int[maxy * maxx];

        int i = 0;
        for (String s : inputs) {
            for(char c : s.toCharArray()) {
                if (c == '.') {
                    map[i] = 0;
                } else {
                    map[i] = 1;
                }
                i++;
            }
        }
    }

    public void reset() {
        posx = 0;
        posy = 0;
    }

    public boolean move(int x, int y) {
        posx += x;
        //posx = posx >= maxx ? posx - maxx : posx;
        posy += y;
        return posy < maxy;
    }

    public boolean hasTree() {
        return map[(posy * maxx) + (posx % maxx)] == 1;
    }
}