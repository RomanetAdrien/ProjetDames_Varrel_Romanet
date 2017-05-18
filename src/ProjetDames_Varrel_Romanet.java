import java.util.ArrayList;

/**
 * Created by adrie on 15/03/2017.
 */
public class ProjetDames_Varrel_Romanet {


    public static void main (String[] args){
        SolutionTabou s = new SolutionTabou(100);
        // Solution initiale, taille liste tabou
        Tabou.solution(s,5);
        // Solution initiale, taille liste tabou, distance voisinage
        TabouV2.solution(s,5, 0);
        // Taille des solutions, distance voisinage
        RecuitSimule.solution(100,0);
        // Taille des solutions, taille population, % de mutation de chacune des solutions
        Genetique.solution(100,25,10);
    }

}
