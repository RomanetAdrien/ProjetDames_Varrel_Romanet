import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

/**
 * Created by adrien on 15/03/2017.
 */
public class Tabou {

    //on donne une solution initiale plutot que de l'initialiser ici pour eventuellement faire des test avec différents
    // algorithmes pour la meme solution
    public static Solution solution(Solution init, int tailletabou){
        Solution xmin = init;
        Solution actu = init;
        int taille =  init.getN();
        float fmin = init.getFitness();
        int i=0;
        ArrayList<Solution> tabou = new ArrayList<>();
        do{
            ArrayList<Solution> C = takeAway(actu.getVoisinage(),tabou);

            if(!C.isEmpty()){
                Solution y = getXminList(C);
                float delta = y.getFitness() - actu.getFitness();
                if(delta>=0){
                    tabou.add(actu);
                    if(tabou.size()>tailletabou){
                        tabou.remove(0);
                    }
                }
                if(y.getFitness()<fmin){
                    fmin = y.getFitness();
                    xmin = y;
                }
                actu=y;
            }
            System.out.println("Iteration : " + i + "     " + "fmin : " + fmin);
            i++;
        }while ((i<=(50+taille*2))&&(fmin!=0));

        return xmin;
    }


    private static ArrayList<Solution> takeAway(ArrayList<Solution> list, ArrayList<Solution> tabou){

        list.removeAll(tabou);
        return list;
    }

    private static Solution getXminList(ArrayList<Solution> list){
        if(list.isEmpty()){
            return null;
        }
        Solution min = list.get(1);
        for (Solution s : list) {
            if(s.getFitness()<min.getFitness()){
                min=s;
            }
        }
        return min;
    }


}
