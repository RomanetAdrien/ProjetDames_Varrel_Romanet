import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Genetique {

    public static void solution(int taille, int taillePopulation, int chanceMutation){
        ArrayList<SolutionGenetique> population = new ArrayList<SolutionGenetique>();
        // Initialisation de la population avec des solutions randoms
        for (int i = 0; i<taillePopulation; i++){
            population.add(new SolutionGenetique(taille));
        }
        SolutionGenetique best = getBest(population);
        int iterations = 0;
        Date debut = new Date();
        Random rand = new Random();
        final int iteMax = taille * 5000;

        while (best.fitness != 0 && iterations < iteMax) {
            // Reproduction
            population = reproduction(population, rand);
        }

    }

    private static ArrayList<SolutionGenetique> reproduction(ArrayList<SolutionGenetique> population, Random rand) {
        ArrayList<Float> roulette = new ArrayList<Float>();
        ArrayList<SolutionGenetique> ret = new ArrayList<SolutionGenetique>();
        float result;
        int j;

        // La fitness ne peut pas être 0, si c'est le cas l'algo s'arrête avant
        roulette.add((float) (1/population.get(0).fitness));
        for (int i =1; i< population.size(); i++){
            roulette.add(roulette.get(i-1) +  population.get(i).fitness);
        }
        for(int i=0; i< population.size(); i++){
            result = rand.nextFloat() * roulette.get(population.size());
            j = 0;
            while (roulette.get(j) < result){
                j++;
            }
            ret.add(population.get(j));
        }
        return ret;
    }

    private static SolutionGenetique getBest(ArrayList<SolutionGenetique> list){
        if(list.isEmpty()){
            return null;
        }
        SolutionGenetique min = list.get(0);
        for (SolutionGenetique s : list) {
            if(s.getFitness()<min.getFitness()){
                min=s;
            }
        }
        return min;
    }
}
