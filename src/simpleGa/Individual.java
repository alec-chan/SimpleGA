package simpleGa;

import java.util.Random;

/**
 * Individual gene in the population pool
 * @author Alec Chan
 */
public class Individual {

    static int defaultGeneLength = 64;
    private char[] genes = new char[defaultGeneLength];
    // Cache
    private int fitness = 0;

    // Create a random individual
    public void generateIndividual() {
        Random r = new Random();
        for (int i = 0; i < size(); i++) {
            char gene = (char) (r.nextInt(94)+32);
            genes[i] = gene;
        }
    }

    /* Getters and setters */
    // Change gene length
    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }

    public char getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, char value) {
        genes[index] = value;
        fitness = 0;
    }

    /* Public methods */
    public int size() {
        return genes.length;
    }

    public int getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }
}