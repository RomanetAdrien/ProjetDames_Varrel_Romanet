
public class ProjetDames_Varrel_Romanet {


    public static void main (String[] args){
        int taille = 50;
        // Pour que les algos du Recuit et Tabou démarrent avec la même solution initiale
        Solution init = new Solution(taille);

        // Taille du plateau, distance voisinage
        MeilleurVoisin.solution(taille, 0);

        // Solution initiale, taille liste tabou, distance voisinage
        Tabou.solution(new SolutionTabou(init),5, 0);

        // Taille des solutions, distance voisinage
        RecuitSimule.solution(init,0);

        // Taille des solutions, taille population, % de mutation de chacune des solutions
        Genetique.solution(50,25,10);


        // Tableau
        /*int n = 50, tailleTabou = 1, taillePopulation = 25, pourcentMutation = 5;
        System.out.println("Recuit;;;;;Tabou;taille liste ="+tailleTabou+
                ";;;;Génétique;taille population ="+taillePopulation+";% mutation ="+pourcentMutation+";;;");
        System.out.println("taille;fitness;iterations;temps(ms);;taille;fitnes;iterations;temps(ms);;taille;fitnes;iterations;temps(ms);;");
        for (int i=0; i<4; i++){
            Solution s = new Solution(n);
            RecuitSimule.solution(s);
            Tabou.solution(new SolutionTabou(s), tailleTabou);
            Genetique.solution(n, taillePopulation, pourcentMutation);
            System.out.println();
        }*/
    }

}
