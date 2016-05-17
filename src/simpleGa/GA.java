package simpleGa;

/**
 * Basic String search GA
 * @author Alec Chan
 */
public class GA {

    public staString[] args) {

        // Set a candidate solution string.  ASCII values 32-126 valid.
        FitnessCalc.setSolution("1245713659135ADGVABadgbadgadgADG';[]09^&*");

        // Create an initial population
        Population myPop = new Population(100, true);
        System.out.println("Gene Length: "+Individual.defaultGeneLength);
        // Evolve population until solution is reached
        int generationCount = 0;
        while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
            myPop = Algorithm.evolvePopulation(myPop);
        }
        System.out.println("------------------------");
        System.out.println("Solution found");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFittest());

    }
}
