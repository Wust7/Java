import java.util.*;

public class demo {
    public  ArrayList<Double> getRX(double P[][]) {
//            int gen = 0;
//            for(gen=1;gen<maxGen;gen++){
        int numn = P.length;
        int i = 1;
        ArrayList<Double> randNum = new ArrayList<>();
        while (i <= numn) {
            randNum.add((double) i);
            i++;
        }
        Collections.shuffle(randNum);
//        }
        return randNum;

    }

    public ArrayList<Double> getMin_Max(Double bestobjv[][], Double curideal[], Double curnadir[]) {
        Double min = bestobjv[0][0];
        Double max = bestobjv[1][0];
        for (int k = 0; k < 2; k++) {
            for (int i = 1; i < bestobjv[k].length; i++) {
                if (min > bestobjv[k][i])
                    min = bestobjv[k][i];
            }
            if (curideal[k] > min)
                curideal[k] = min;
            for (int j = 1; j < bestobjv[k].length; j++) {
                if (max < bestobjv[k][j])
                    max = bestobjv[k][j];
            }
            if (curnadir[k] < max)
                curideal[k] = max;
        }
        ArrayList<Double> min_Max=new ArrayList<>();
        min_Max.add(curideal[0]);
        min_Max.add(curideal[1]);
        min_Max.add(curnadir[0]);
        min_Max.add(curnadir[1]);
        return min_Max;
    }

    public ArrayList<Integer> getIndex(Double scoreS[],int N){
        HashMap<Double,Integer> map = new HashMap<>();
        int i = 0;
        while(i<scoreS.length){
            map.put(scoreS[i],i+1);
        }
        Object[] key = map.keySet().toArray();
        Arrays.sort(key);
        ArrayList<Integer> index = new ArrayList<>();
        for(int j =0;j<N;j++){
            index.add(map.get(key[j]));
        }
        return index;
    }
}
