import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import static java.lang.Math.exp;

public class RecuitSimule {

    public static void Solution(int taille, int distance){

        Solution x, y, best;
        x = best = new Solution(taille);
        Date debut = new Date();
        int iterations = 0;
        Random rand = new Random();

        float df, temp = (float) ((taille/4) / 0.22314355), fTemp = (float) 0.99;
        do{
            y = x.getVoisinRandom(distance);
            df = y.fitness - x.fitness;
            if (df <= 0) {
                 x = y;
                if (x.fitness < best.fitness){
                    best = x;
                }
            }
            else if (rand.nextDouble() <= exp((-df) / temp)){
                x = y;
            }
            if (iterations % 25 == 0){
                temp = temp * fTemp;
            }
            iterations++;
        } while(best.fitness != 0 && iterations <taille * 1000);

        System.out.println("Recuit simulé : n = "+taille);
        if (best.fitness == 0) {
            System.out.println("Solutions en " + iterations + " itérations, " + (new Date().getTime() - debut.getTime()) + "ms");
        }
        else{
            System.out.println("Pas de solutions en " + iterations + " itérations, " + (new Date().getTime() - debut.getTime()) + "ms");
        }
        best.printSolution();
    }
}
