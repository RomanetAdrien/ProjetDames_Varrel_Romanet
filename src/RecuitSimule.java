import java.util.Date;
import java.util.Random;

import static java.lang.Math.exp;

public class RecuitSimule {

    // Solution du recuit en prenant comme voisinage les permutations des reines proches (moins de distance * n voisins)
    public static void solution(Solution init, int distance){
        Solution x, y, best;
        x = best = init;
        Date debut = new Date();
        int iterations = 0, taille = init.n;
        Random rand = new Random();
        final int iteMax = taille * 10000;

        float df, temp = 5*taille, fTemp = (float) 0.9;
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
            if (temp > 0.19 && iterations % (taille) == 0){
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
