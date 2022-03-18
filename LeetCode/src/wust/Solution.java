package wust;

import org.junit.Test;

/**
 * 扫雷：还没弄出来
 */
public class Solution {

    public void update(int[][] map,int[][] endMap,int i,int j){
        if(i>0&&j>0&&endMap[i-1][j-1] == 0)
            endMap[i-1][j-1] = map[i][j];
        if(j>0&&endMap[i][j-1] == 0)
            endMap[i][j-1] = map[i][j];
        if(i<3&&j<3&&endMap[i+1][j+1] == 0)
            endMap[i+1][j+1] = map[i][j];
        if(i>0&&endMap[i-1][j] == 0)
            endMap[i-1][j] = map[i][j];
        if(i>0&&j<3&&endMap[i-1][j+1] == 0)
            endMap[i-1][j+1] = map[i][j];
        if(j<3&&endMap[i][j+1] == 0)
            endMap[i][j+1] = map[i][j];
        if(i<3&&j<3&&endMap[i+1][j+1] == 0)
            endMap[i+1][j+1] = map[i][j];
        if(i<3&&endMap[i+1][j] == 0)
            endMap[i+1][j] = map[i][j];

    }
    @Test
    public  void test() {
        int[][] map =
                {{0,1,2,1}
                ,{0,0,0,0}
                ,{0,0,0,0}
                ,{0,0,0,0}};
        int[][] endMap = map;
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                if(map[i][j] > 0 && map[i][j] < 9){
                    update(map,endMap,i,j);

                }
            }
        }








    }

}
