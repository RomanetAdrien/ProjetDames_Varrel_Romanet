import java.util.ArrayList;

/**
 * Created by adrie on 15/03/2017.
 */
public class ProjetDames_Varrel_Romanet {


    public static void main (String[] args){
        int n= 4;
        do {
            Solution s = new Solution(n);
            float best = s.fitness;
            int i = 0;
            do {
                ArrayList<Solution> voisinage = s.getVoisinage();

                for (Solution ss : voisinage) {
                    if (ss.fitness <= best) {
                        s = ss;
                        best = ss.fitness;
                    }
                }
                i++;
            } while (i < 300 && best > 0);
            if(best==0) {
                System.out.println(n);
                s.printSolution();
                System.out.println("Itérations : " + i);
            }
            n++;
        }while(n<100);

    }

}
