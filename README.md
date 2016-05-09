[![Packagist](https://img.shields.io/packagist/l/doctrine/orm.svg?maxAge=2592000?style=plastic)]()
# SimpleGA
Simple String searching genetic algorithm

##Structure
Code is in src/simpleGa package

----------
####Algorithm.java
----------
- Most of the "genetic" part of the genetic algorithm occurs here.
- The algorithm parameters are stored here as private static final constants.

#####Constants:
- *double uniformRate*: the percentage of genes that a new individual inherits from one of its parents.  A value of 0.5 will cause a newly made individual to inheirit 50% of its genes from one of the parents and 50% of the genes from another.
- *double mutationRate*: the % chance for each of an individual's genes to mutate when creating a new individual.
- *int tournamentSize*: the number of individuals picked out of the population to participate in a tournament when tournamentSelection is called.
- *boolean elitism*: if set to true, elitism will be enabled in the evolvePopulation method.  This forces evolvePopulation to protect the fittest individual out of the population to make sure that it does not get its genes overwritten by mutation.  In general this will increase efficiency.

#####Public Methods:
*Population evolvePopulation(Population pop)*
- This method is the main genetic method.  It accepts your current population pool as an argument and returns the next generation population.
- To evolve the population to the next generation this method uses private methods: crossover, mutate and tournamentSelection.  

#####Private Methods:
*Individual crossover(Individual indiv1, Individual indiv2)*
- Takes 2 Individuals as arguments - the *parents*
- Creates a new individual - the *child*
- Loops through the child's genes and for each gene, picks a parent to inherit that gene from based on the chance set in uniformRate.  Setting uniformRate = 0.5 will cause 50% of the child's genes to come from one parent and 50% from another.
- This method parallels real life reproduction by taking two fit Individuals from the population and mixing their genes in an attempt to improve the next generation's fitness.
- returns the newly formed child Individual.

*void mutate(Individual indiv)*
- This method loops through the genes of the Individual passed to it and each gene has a mutationRate% chance of being set to a random value.

*Individual tournamentSelection(Population pop)*
- This method takes tournamentSize Individuals from the passed Population and then returns the fittest of those Individuals.

--------
####Individual.java
--------
- This class represents an Individual from a Population
- The Individual has an array of genes

#####Properties
- *int defaultGeneLength*: the how many genes the individual should have.  Can be changed by setDefaultGeneLength() and should always match the length of the solution set in FitnessCalc.
- *char[] genes*: the array of genes that make up the individual.  These do not have to be chars, any comparable types like boolean, int etc... will work, though a lot of code in other places will need to be updated to be compatible with different gene types.  When the genes of an individual == FitnessCalc.solution, then the algorithm is done and you have found your solution.
- *double fitness*: The individual's fitness rating.  This is set from FitnessCalc.getFitness().  In this implementation of the algorithm, the algorithm is set to maximize this fitness rating.  In other implementations, the goal could be minimization.

#####Public Methods:
*void generateIndividual()*
- This method is called right after creating the Individual.  It sets each of the Individual's genes to a random ASCII value between 32 and 126 inclusive.
*int size()*
- Returns the length of the gene array for the Individual.
*int getFitness()*
- Calls FitnessCalc.getFitness() and returns the fitness value for this Individual.
*String toString()*
- Overrides the toString() method and returns this Individuals genes as a String.

--------
####Population.java
--------
- This class is a container for a group of Individuals.

#####Fields:
- *Individual[] individuals*: The group of Individuals contained in this Population.

#####Public Methods:

*ctor*
- The contructor for this class takes 2 arguments, int populationSize, and boolean initialize.  populationSize determines how many Individuals will be contained in this Population.  If set to true, initialize will create populationSize number of Individuals, if set to false the Population will be created with no Individuals, requiring the use of saveIndividual() to populate the array.
*Individual getFittest(int index)*
- This method loops through each Individual in the Population and returns the Individual with the highest fitness.
*int size()*
- Returns length of individuals array.
*void saveIndividual(int index, Individual indiv)*
- Sets the Individual at individuals[index] to the Individual passed in the arguments.

-------
####FitnessCalc.java
-------
- This is a utility class used for performing fitness calculations on Individuals.

#####Fields:
- *char[] solution*: The ideal array of genes.  This is what the algorithm is searching for.  An Individual with genes = solution has a fitness level equal to FitnessCalc.getMaxFitness()

#####Methods:
- All methods are static

*void setSolution(String newSolution)*
- Accepts a String as argument, then converts it to char array and saves it to FitnessCalc.solution.
- Sets Individual.setDefaultGeneLength() to solution.length to avoid any errors.

*double getFitness(Individual individual)*
- Evaluates the fitness of an Individual's genes by comparing each one to the corresponding gene in the solution array and adding 1 to the Individual's fitness score if the gene is equal to the solution gene.  ~This is currently just a binary evaluation of the fitness.  Could be changed to a distance evaluation, treating the genes as vectors and basing the fitness score on the distance between the Individual's gene and the solution gene.  Would need to change the algorithm to a minimization function by setting FitnessCalc.getMaxFitness() to 0.~

*int getMaxFitness()*
- Returns the maximum fitness that an Individual could possibly have.  In the case of a binary evaluation of fitness, this would be equal to the length of the solution array.




