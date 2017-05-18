import java.util.ArrayList;

import static java.lang.Math.abs;

public class SolutionGenetique extends Solution {

    public SolutionGenetique(int n) {
        super(n);
    }

    public SolutionGenetique(ArrayList<Integer> solution) {
        super(solution);
    }

    @Override
    public void calculFitness(){
        this.fitness=0;
        for(int i=0;i<this.n;i++){
            for(int j=i+1;j<this.n;j++){
                if(abs(this.solution.get(i) - this.solution.get(j)) == j-i){
                    this.fitness ++;
                }
                if (this.solution.get(i) == this.solution.get(j)){
                    this.fitness ++;
                }
            }
        }
    }
}
