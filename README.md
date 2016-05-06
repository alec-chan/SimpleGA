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


