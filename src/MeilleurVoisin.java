import java.util.ArrayList;
import java.util.Date;

public class MeilleurVoisin {

    public static void solution(int taille, int distance){
        int iterations = 0, essais = 0;
        Solution s; ArrayList<Solution> voisinage;
        Date debut = new Date();
        do {
            // On prend une solution aléatoire
            essais++;
            s = new Solution(taille);
            int coince = 0;
            do {
                voisinage = s.getVoisinage(distance);
                // Si on trouve une meilleure solution ou une équivalente chez un voisin on la prend
                for (Solution ss : voisinage) {
                    if (ss.fitness <= s.fitness) {
                        // Si la fitness est meilleure, on se rapproche du but donc on n'est pas coincé
                        if (ss.fitness < s.fitness) {
                            coince = 0;
                        }
                        s = ss;
                    }
                }
                iterations++;
                coince++;
                // On répête temps qu'on n'a pas la solution et qu'on n'est pas coincé
            } while (coince < 10 && s.fitness > 0);
        } while (s.fitness != 0);
        System.out.println("Meilleur voisin : n = "+taille);
        System.out.println("Solution en "+iterations+" itérations, "+essais+" essais, "+
                TempsExecution.getTime(new Date().getTime()- debut.getTime()));
        s.printSolution();
    }
}
