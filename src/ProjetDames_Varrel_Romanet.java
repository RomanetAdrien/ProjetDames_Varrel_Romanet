import java.util.ArrayList;

/**
 * Created by adrie on 15/03/2017.
 */
public class ProjetDames_Varrel_Romanet {


    public static void main (String[] args){
        /*
        SolutionTabou s = new SolutionTabou(100);
        // Solution initiale, taille liste tabou
        Tabou.solution(s,5);
        // Solution initiale, taille liste tabou, distance voisinage
        TabouV2.solution(s,5, 0);
        // Taille des solutions, distance voisinage
        RecuitSimule.solution(100,0);
        // Taille des solutions, taille population, % de mutation de chacune des solutions
        Genetique.solution(100,25,10);
        */

        // Tableau
        int n = 100, tailleTabou = 5, taillePopulation = 25, pourcentMutation = 5;
        System.out.println("Recuit;;;;;Tabou;taille liste ="+tailleTabou+
                ";;;;Génétique;taille population ="+taillePopulation+";% mutation ="+pourcentMutation+";;;");
        System.out.println("taille;fitnes;iterations;temps(ms);;taille;fitnes;iterations;temps(ms);;taille;fitnes;iterations;temps(ms);;");
        for (int i=0; i<100; i++){
            Solution s = new Solution(n);
            RecuitSimule.solution(s);
            TabouV2.solution(new SolutionTabou(s), tailleTabou);
            //Genetique.solution(n, taillePopulation, pourcentMutation);
            System.out.println();
        }
    }

}
