import java.util.ArrayList;
import java.util.Date;

public class RecuitSimule {

    public static void Solution(int taille, int distance){

        Solution s, best, ss;
        s = best = new Solution(taille);
        ArrayList<Solution> voisinage;
        Date debut = new Date();
        int iterations = 0;

        float df, temperature;
        do{
            ss = s.getVoisinRandom(distance);
            df = ss.fitness -s.fitness;

        } while(s.fitness != 0);
    }
}
