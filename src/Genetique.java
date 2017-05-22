import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Genetique {

    public static void solution(int taille, int taillePopulation, int pourcentMutation){
        ArrayList<SolutionGenetique> population = new ArrayList<SolutionGenetique>();
        // Initialisation de la population avec des solutions randoms
        for (int i = 0; i<taillePopulation; i++){
            population.add(new SolutionGenetique(taille));
        }
        SolutionGenetique best = getBest(population);
        int iterations = 0;
        Date debut = new Date();
        Random rand = new Random();
        final int iteMax = taille * 1000;

        while (best.fitness != 0 && iterations < iteMax) {
            // Roulette biaisée
            population = reproduction(population, rand);
            // Croisement en 1 point
            population = croisement(population, rand);
            // Chance de décalé une reine d'une ligne
            mutation(population, pourcentMutation, rand);

            best = getBest(population);
            iterations++;
        }


        System.out.println("Génétique : n = "+taille);
        System.out.println((best.fitness == 0?"Solution en ":"Pas de solution en ") +iterations+" itérations, "
                +TempsExecution.getTime(new Date().getTime()- debut.getTime()));
        best.printSolution();


       // System.out.print(taille+";"+best.fitness+";"+iterations+";"+ (new Date().getTime()- debut.getTime())+";;");
    }

    // Roulette biaisée
    private static ArrayList<SolutionGenetique> reproduction(ArrayList<SolutionGenetique> population, Random rand) {
        ArrayList<Double> roulette = new ArrayList<Double>();
        ArrayList<SolutionGenetique> ret = new ArrayList<SolutionGenetique>();
        double result;
        int j;

        // La fitness ne peut pas être 0, si c'est le cas l'algo s'arrête avant
        roulette.add( 1.0/population.get(0).fitness);
        for (int i =1; i< population.size(); i++){
            roulette.add(roulette.get(i-1) + 1.0/population.get(i).fitness);
        }
        for(int i=0; i< population.size(); i++){
            result = rand.nextDouble() * roulette.get(population.size()-1);
            j = 0;
            while (roulette.get(j) < result){
                j++;
            }
            ret.add(population.get(j));
        }
        return ret;
    }

    // Croisement en 1 point
    private static ArrayList<SolutionGenetique> croisement(ArrayList<SolutionGenetique> population, Random rand) {
        ArrayList<SolutionGenetique> ret = new ArrayList<SolutionGenetique>();
        for (int i=1; i<population.size(); i+=2){
            // Croisements
            ret.addAll(concat(population.get(i-1), population.get(i), rand.nextInt(population.get(0).solution.size())));
        }
        if (population.size()%2 ==1){
            // La dernière solution si nombre impair
            ret.add(population.get(population.size()-1));
        }
        return ret;
    }

    public static ArrayList<SolutionGenetique> concat(SolutionGenetique s1, SolutionGenetique s2, int position){
        ArrayList<Integer> c1 = new ArrayList<Integer>();
        ArrayList<Integer> c2 = new ArrayList<Integer>();
        ArrayList<SolutionGenetique> ret = new ArrayList<SolutionGenetique>();
        for(int i=0; i<position; i++){
            c1.add(s1.solution.get(i));
            c2.add(s2.solution.get(i));
        }
        for(int i=position; i<s1.n ;i++){
            c1.add(s2.solution.get(i));
            c2.add(s1.solution.get(i));
        }
        ret.add(new SolutionGenetique(c1));
        ret.add(new SolutionGenetique(c2));
        return ret;
    }

    // Mutation, ligne d'une reine  +/- 1
    private static void mutation(ArrayList<SolutionGenetique> population, int pourcentMutation, Random rand) {
        int position, val;
        for (int i=0; i< population.size(); i++){
            // une solution peut muter plusieurs fois
            while (rand.nextInt(100) < pourcentMutation){
                position = rand.nextInt(population.get(0).n);
                // On ajoute ou enlève 1 à la position tirée dans la solution i, modulo n pour rester sur le plateau
                val = population.get(i).solution.get(position) + (rand.nextInt(2) *2) -1;
                // -1 modulo n = -1 en java et non n-1... Donc on ajoute n avant de faire le modulo
                population.get(i).solution.set(position, (val + population.get(0).n) %  population.get(0).n);
                // On met à jour la fitness
                population.get(i).calculFitness();
            }
        }
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
