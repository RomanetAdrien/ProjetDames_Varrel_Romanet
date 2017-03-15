import java.util.ArrayList;

/**
 * Created by adrie on 15/03/2017.
 */
public class MeilleurVoisin {

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
        } while (i < 100 && best > 0);
        if(best==0) {
            System.out.println(n);
            s.printSolution();
            System.out.println("Itérations : " + i);
            n++;
        }
    }while(n<100);
}
