from chess_board import chess_board
import random

# Initialise the board
board = chess_board()

# Init your population with randomly chosen (valid) chromosomes.
population_size = 10
population = [0] * population_size

i = 0
while i < population_size:
    chromosome = [0] * 8

    j = 0
    while j < 8:
        random_number = random.randint(0, 63)
        if random_number not in chromosome:
            chromosome[j] = random_number
            j += 1

    population[i] = chromosome

    i += 1

# Iterate over number of generations . . .
index = 0
while index < 5:
    print("Gen #" + str(index))
    print("Pre fitness test population: " + str(population))

    bestFitness = 0
    bestChromosome = []
    secondChromosome = []

    # Iterate over number of individuals in your population . . .
    for chromo in population:

        # Evaluate fitness of each individual; chromo is the chromosome (an 8-item
        # list of integer values between 0 and 63) of an individual.
        fitness = board.nonattacking_pairs(chromo)

        if fitness > bestFitness:
            secondChromosome = bestChromosome
            bestFitness = fitness
            bestChromosome = chromo
        else:
            if not secondChromosome:
                secondChromosome = chromo

        print(bestFitness)

    # Pick the best individual and show the corresponding board ; bestChromosome
    # is the chromosome of the best individual in the population.
    board.show_state(bestChromosome)

    # Check if fitness of the best individual is 28 . . . if so , you’re done and the shown board is the
    # solution to 8−queens problem. If you’re not done continue with creation of new generation.

    if bestFitness != 28:

        # For each new child . . .
        newChildren = []
        i = 0
        while i < population_size:

            # Select two parents based on fitness.
            parent1 = bestChromosome
            parent2 = secondChromosome

            # Cross over parents to create the new child.
            child = [0] * 8
            j = 0
            while j < 8:
                if j % 2 != 0:
                    child[j] = parent1[j]
                else:
                    child[j] = parent2[j]

                j += 1

            # Decide at random if there is going to be a mutation.
            if 5 > random.randint(0, 99):
                x = random.randint(0, 7)
                child[x] = random.randint(0, 63)

            newChildren.append(child)

            i += 1

        # Replace the current population with the new children.
        population = newChildren

    print("Post fitness test population: " + str(population))

    index += 1
