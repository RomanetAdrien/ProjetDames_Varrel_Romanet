import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 * Created by ROMANET_VARREL on 15/03/2017.
 */
public class Solution {
    public ArrayList<Integer> solution;
    public int n;
    public float fitness;

    //Le voisinage correspond à toute les permutations de deux colonnes de cette solution
    //public ArrayList<Solution> voisinage;

    public Solution(int n){
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            list.add(i,i);
        }
        this.solution = list;
        this.n=n;
        this.calculFitness();
    }

    public Solution(ArrayList<Integer> solution){
        this.solution=solution;
        this.n=solution.size();
        this.calculFitness();
    }

    public void calculFitness(){
        this.fitness=0;
        for(int i=0;i<this.n;i++){
            for(int j=i+1;j<this.n;j++){
                if(abs(this.solution.get(i) - this.solution.get(j)) == j-i){
                    this.fitness ++;
                }
            }
        }
    }

    public ArrayList<Solution> getVoisinage(){
        ArrayList<Solution> voisinage = new ArrayList<>();
        ArrayList<Integer> permutation; int temp;
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                permutation = (ArrayList<Integer>) this.solution.clone();
                temp=permutation.get(i);
                permutation.set(i,permutation.get(j));
                permutation.set(j,temp);
                voisinage.add(new Solution(permutation));
            }
        }
        return voisinage;
    }

    public void printSolution(){
        StringBuilder sgb =new StringBuilder();
        sgb.append("S={");
        for (Integer i: this.solution) {
            sgb.append(Integer.toString(i));
            sgb.append(", ");
        }
        sgb.delete(sgb.length()-2, sgb.length());
        sgb.append("}   F=" + this.fitness);

        System.out.println(sgb.toString());
    }


}
