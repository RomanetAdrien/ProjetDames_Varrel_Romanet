import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import static java.lang.Math.exp;

public class RecuitSimule {

    public static void solution(int taille, int distance){

        Solution x, y, best;
        x = best = new Solution(taille);
        Date debut = new Date();
        int iterations = 0;
        Random rand = new Random();
        final int iteMax = taille * 10000;

        float df, temp = taille/2, fTemp = (float) 0.95;
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
            if (temp > 0.001 && iterations % (taille) == 0){
                temp = temp * fTemp;
            }
            iterations++;
        } while(best.fitness != 0 && iterations < iteMax);

        System.out.println("Recuit simulé : n = "+taille);
        System.out.println((best.fitness == 0?"Solution en ":"Pas de solution en ") +iterations+" itérations, "
                +TempsExecution.getTime(new Date().getTime()- debut.getTime()));
        best.printSolution();
    }
}
