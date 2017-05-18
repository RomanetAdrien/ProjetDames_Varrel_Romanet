import java.util.ArrayList;

/**
 * Created by adrie on 15/03/2017.
 */
public class ProjetDames_Varrel_Romanet {


    public static void main (String[] args){
        SolutionTabou s = new SolutionTabou(200);
        Tabou.solution(s,5);
        TabouV2.solution(s,5, 0);
        TabouV2.solution(s,5, 3);
        RecuitSimule.solution(200,0);
        RecuitSimule.solution(200,3);
    }

}
