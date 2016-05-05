package simpleGa;

/**
 * Fitness Calculations done in this utility class
 * @author Alec Chan
 */
public class FitnessCalc {

    static char[] solution;


    // Set candidate solution
    static void setSolution(String newSolution) {

        solution=newSolution.toCharArray();
        //Fit gene length to length of passed string
        Individual.setDefaultGeneLength(solution.length);

    }



    // Calculate individual fitness by comparing each char to the solution char at the same position
    static int getFitness(Individual individual) {
        int fitness = 0;
        // Loop through our individuals genes and compare them to solution
        for (int i = 0; i < individual.size() && i < solution.length; i++) {
            if (individual.getGene(i) == solution[i]) {
                fitness++;
            }
        }
        return fitness;
    }

    // Get optimum fitness
    static int getMaxFitness() {
        int maxFitness = solution.length;
        return maxFitness;
    }
}