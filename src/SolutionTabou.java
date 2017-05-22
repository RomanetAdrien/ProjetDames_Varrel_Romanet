import java.util.ArrayList;

public class SolutionTabou extends Solution {
    public int operation;

    public SolutionTabou(int n) {
        super(n);
    }

    public SolutionTabou(Solution solution) {
        super(solution.solution);
    }

    public SolutionTabou(ArrayList<Integer> permutation, int operation) {
        super(permutation);
        this.operation = operation;
    }


    public SolutionTabou getPermutedTabou(int i, int j){
        ArrayList<Integer> permutation; int temp;
        permutation = (ArrayList<Integer>) this.solution.clone();
        temp = permutation.get(i);
        permutation.set(i, permutation.get(j));
        permutation.set(j, temp);
        return new SolutionTabou(permutation, i*permutation.size() + j);
    }


    public ArrayList<SolutionTabou> getVoisinageTabou(){
        ArrayList<SolutionTabou> voisinage = new ArrayList<>();
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                voisinage.add(getPermutedTabou(i, j));
            }
        }
        return voisinage;
    }


    public ArrayList<SolutionTabou> getVoisinageTabou(int distance){
        // Si on met une distance nulle ou qui vaut la taille totale on renvoi toutes les combinaisons
        if(distance <= 0 || distance >=n){
            return getVoisinageTabou();
        }
        ArrayList<SolutionTabou> voisinage = new ArrayList<>();

        for (int i=0;i<n-1;i++){
            for(int j=1; j<= distance;j++) {
                if(i+j<n) {
                    voisinage.add(getPermutedTabou(i, i+j));
                }
            }
        }
        return voisinage;
    }

}
