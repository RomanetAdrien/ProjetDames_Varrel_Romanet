import java.util.ArrayList;

/**
 * Created by adrie on 15/03/2017.
 */
public class ProjetDames_Varrel_Romanet {


    public static void main (String[] args){

        Solution s = new Solution(8);
        s.printSolution();

        ArrayList<Solution> voisinage = s.getVoisinage();

        for (Solution ss : voisinage) {
            ss.printSolution();
        }


    }

}
