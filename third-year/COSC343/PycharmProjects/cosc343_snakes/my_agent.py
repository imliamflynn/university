__author__ = "Liam Lennon-Flynn"
__organization__ = "COSC343/AIML402, University of Otago"
__email__ = "lenli455@student.otago.ac.nz"

import numpy as np

agentName = "My Agent"
perceptFieldOfVision = 5  # Choose either 3,5,7 or 9
perceptFrames = 1         # Choose either 1,2,3 or 4
trainingSchedule = [("self", 250), ("random", 50)]  # None


# This is the class for your snake/agent
class Snake:

    def __init__(self, nPercepts, actions):
        # You should initialise self.chromosome member variable here (whatever you choose it
        # to be - a list/vector/matrix of numbers - and initialise it with some random
        # values)

        self.chromosome = list()

        self.chromosomeLength = 6
        index = 0
        while index < self.chromosomeLength:
            self.chromosome.append(np.random.randint(0, 101))
            index += 1

        self.nPercepts = nPercepts
        self.actions = actions

    # You should implement a model here that translates from 'percepts' to 'actions'
    # through 'self.chromosome'.
    #
    # The 'actions' variable must be returned, and it must be a 3-item list or 3-dim numpy vector
    # The index of the largest numbers in the 'actions' vector/list is the action taken
    # with the following interpretation:
    # -1 - move left
    # 0 - move forward
    # 1 - move right
    def AgentFunction(self, percepts):
        # Different 'percepts' values should lead to different 'actions'.  This way the agent
        # reacts differently to different situations.
        # Different 'self.chromosome' should lead to different 'actions'.  This way different
        # agents can exhibit different behaviour.

        width = len(percepts[0])
        middle = int((width/2) - 0.5)
        rowInFront = percepts[0][middle]
        watchOut = False

        if sum(self.chromosome) < (len(self.chromosome) * 100) / 7:
            index = 0
            while index < middle:
                if percepts[0][index][middle] == 1 or percepts[0][index][middle] == -1:
                    watchOut = True

                index += 1

            if watchOut:
                if percepts[0][middle][middle - 1] == 0:
                    return -1
                elif percepts[0][middle][middle + 1] == 0:
                    return 1
                else:
                    return 0

            if 2 in percepts[0][middle]:
                if np.where(rowInFront == 2)[0][0] < middle:
                    return -1
                else:
                    return 1
            return 0

        return np.random.randint(-1, 2)


def evalFitness(population):
    N = len(population)

    # Fitness initialiser for all agents
    fitness = np.zeros(N)

    # This loop iterates over your agents in the old population - the purpose of this boiler plate
    # code is to demonstrate how to fetch information from the old_population in order
    # to score fitness of each agent
    for n, snake in enumerate(population):
        # snake is an instance of Snake class that you implemented above, therefore you can access any attributes
        # (such as `self.chromosome').  Additionally, the object has the following attributes provided by the
        # game engine:
        #
        # snake.sizes - list of snake sizes over the game turns

        maxSize = np.max(snake.sizes)
        turnsAlive = np.sum(snake.sizes > 0)
        maxTurns = len(snake.sizes)

        # This fitness functions considers snake size plus the fraction of turns the snake
        # lasted for.  It should be a reasonable fitness function, though you're free
        # to augment it with information from other stats as well
        fitness[n] = maxSize + turnsAlive / maxTurns

    return fitness


# old pop is a list of Snake class instances
def newGeneration(old_population):
    # This function should return a tuple consisting of:
    # - a list of the new_population of snakes that is of the same length as the old_population,
    # - the average fitness of the old population

    N = len(old_population)
    nPercepts = old_population[0].nPercepts
    actions = old_population[0].actions
    fitness = evalFitness(old_population)

    # At this point you should sort the old_population snakes according to fitness, setting it up for parent
    # selection.

    snakeFitnessDict = dict()
    index = 0
    for fit in fitness:
        snakeFitnessDict[index] = fit
        index += 1

    sortedFitnessDictIndexes = sorted(snakeFitnessDict, key=snakeFitnessDict.get, reverse=True)

    oldPopulationSorted = list()
    for indexes in sortedFitnessDictIndexes:
        oldPopulationSorted.append(old_population[indexes])

    total = 0
    for snake in old_population:
        total += sum(snake.chromosome)

    # Create new population list...
    new_population = list()
    for n in range(N):
        # Create a new snake
        new_snake = Snake(nPercepts, actions)

        # Elitism, keeping only the best snake from last population
        if n == 0:
            new_snake.chromosome = oldPopulationSorted[0].chromosome
            new_population.append(new_snake)
            continue

        # Here you should modify the new snakes chromosome by selecting two parents (based on their
        # fitness) and crossing their chromosome to overwrite new_snake.chromosome

        probabilities = []
        for fitx in fitness:
            probabilities.append(fitx/sum(fitness))

        parent1pos, parent2pos = np.random.choice(N, size=2, replace=False, p=probabilities)

        parent1 = old_population[parent1pos].chromosome
        parent2 = old_population[parent2pos].chromosome

        chromo = []

        # Creating child chromosome
        i = 0
        for _ in parent1:
            xrand = np.random.randint(0, 101)
            if xrand < 50:
                chromo.append(parent1[i])
            else:
                chromo.append(parent2[i])
            i += 1

        # Consider implementing elitism, mutation and various other
        # strategies for producing a new creature.
        rando = np.random.randint(0, 101)
        if rando < 20:
            randy = np.random.randint(0, len(chromo))
            chromo[randy] = np.random.randint(0, 101)

        # Add the new snake to the new population
        new_snake.chromosome = chromo
        new_population.append(new_snake)

    # At the end you need to compute the average fitness and return it along with your new population
    avg_fitness = np.mean(fitness)

    return new_population, avg_fitness
