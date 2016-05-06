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
- returns the newly formed child Individual.
