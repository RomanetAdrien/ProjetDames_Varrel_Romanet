import java.util.ArrayList;
import java.util.Date;

public class TabouV2 {

    //on donne une solution initiale plutot que de l'initialiser ici pour eventuellement faire des test avec différents
    // algorithmes pour la meme solution
    public static Solution solution(SolutionTabou init, int tailletabou, int tailleVoisinage){
        Date debut = new Date();
        SolutionTabou xmin = init;
        SolutionTabou actu = init;
        int taille = init.getN();
        float fmin = init.getFitness();
        int i=0;
        ArrayList<Integer> tabou = new ArrayList<Integer>();
        do{
            ArrayList<SolutionTabou> C = takeAway(actu.getVoisinageTabou(tailleVoisinage),tabou);

            if(!C.isEmpty()){
                SolutionTabou y = getXminList(C);
                float delta = y.getFitness() - actu.getFitness();
                if(delta>=0){
                    tabou.add(actu.operation);
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
            //System.out.println("Iteration : " + i + "     " + "f : " + actu.fitness);
            i++;
        }while (i < taille * 10 && fmin!=0);

        System.out.println("Tabou : n = "+taille);
        System.out.println((xmin.fitness == 0?"Solution en ":"Pas de solution en ") +i+" itérations, "
                +TempsExecution.getTime(new Date().getTime()- debut.getTime()));
        xmin.printSolution();
        return xmin;
    }

    private static ArrayList<SolutionTabou> takeAway(ArrayList<SolutionTabou> list, ArrayList<Integer> tabou){
        for (int i = 0; i < list.size(); i++){
                if (tabou.contains(list.get(i).operation)) {
                    list.remove(i);
                    i--;
                }
        }
        return list;
    }

    private static SolutionTabou getXminList(ArrayList<SolutionTabou> list){
        if(list.isEmpty()){
            return null;
        }
        SolutionTabou min = list.get(0);
        for (SolutionTabou s : list) {
            if(s.getFitness()<min.getFitness()){
                min=s;
            }
        }
        return min;
    }


}
