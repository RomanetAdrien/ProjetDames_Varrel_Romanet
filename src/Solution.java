import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by ROMANET_VARREL on 15/03/2017.
 */
public class Solution {
    public ArrayList<Integer> solution;
    public int n;
    public int fitness;

    //Le voisinage correspond à toute les permutations de deux colonnes de cette solution
    //public ArrayList<Solution> voisinage;

    public Solution(int n){
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            list.add(i,i);
        }
        long seed = System.nanoTime();
        Collections.shuffle(list, new Random(seed));
        this.solution = list;
        this.n=n;
        this.calculFitness();
    }

    public Solution(ArrayList<Integer> solution){
        this.solution=solution;
        this.n=solution.size();
        this.calculFitness();
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
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

    // Inverse la position de 2 reines
    public ArrayList<Solution> getVoisinage(){
        ArrayList<Solution> voisinage = new ArrayList<>();
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                voisinage.add(getPermuted(i, j));
            }
        }
        return voisinage;
    }

    // Inverse la position de 2 reines si elles sont proches
    public ArrayList<Solution> getVoisinage(int distance){
        // Si on met une distance nulle ou qui vaut la taille totale on renvoi toutes les combinaisons
        if(distance <= 0 || distance >=n){
            return getVoisinage();
        }
        ArrayList<Solution> voisinage = new ArrayList<>();

        for (int i=0;i<n-1;i++){
            for(int j=1; j<= distance;j++) {
                if(i+j<n) {
                    voisinage.add(getPermuted(i, i+j));
                }
            }
        }
        return voisinage;
    }

    public Solution getVoisinRandom(int distance){
        int i, j, max, min;
        // i aléatoire entre 0 et n-1
        i = (int)Math.random()* n;
        if (distance <=0 || distance >= n){
            min = 0;
            max = n-1;
        }
        else {
            min = max(i - distance, 0);
            max = min(i+distance, n-1);
        }

        do{
            j= (int)( Math.random()*( max - min + 1 ) ) + min;
        } while (j == i);
        return getPermuted(i,j);
    }

    public Solution getPermuted(int i, int j){
        ArrayList<Integer> permutation; int temp;
        permutation = (ArrayList<Integer>) this.solution.clone();
        temp = permutation.get(i);
        permutation.set(i, permutation.get(j));
        permutation.set(j, temp);
        return new Solution(permutation);
    }

    public void printSolution(){
        StringBuilder sgb =new StringBuilder();
        sgb.append("S={");
        for (Integer i: this.solution) {
            sgb.append(Integer.toString(i));
            sgb.append(", ");
        }
        sgb.delete(sgb.length()-2, sgb.length());
        sgb.append("}\nF=" + this.fitness);

        System.out.println(sgb.toString());
    }


}
