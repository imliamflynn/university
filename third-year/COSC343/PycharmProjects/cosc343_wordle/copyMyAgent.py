__author__ = "Liam Lennon-Flynn"
__organization__ = "COSC343/AIML402, University of Otago"
__email__ = "lenli455@student.otago.ac.nz"


class WordleAgent:
    """
        A class that encapsulates the code dictating the
        behaviour of the Wordle playing agent

        ...

        Attributes
        ----------
        dictionary : list
            a list of valid words for the game
        letter : list
            a list containing valid characters in the game
        word_length : int
            the number of letters per guess word
        num_guesses : int
            the max. number of guesses per game
        mode: str
            indicates whether the game is played in 'easy' or 'hard' mode

        Methods
        -------
        AgentFunction(percepts)
            Returns the next word guess given state of the game in percepts
        """

    def __init__(self, dictionary, letters, word_length, num_guesses, mode):
        """
        :param dictionary: a list of valid words for the game
        :param letters: a list containing valid characters in the game
        :param word_length: the number of letters per guess word
        :param num_guesses: the max. number of guesses per game
        :param mode: indicates whether the game is played in 'easy' or 'hard' mode
        """

        self.dictionary = dictionary
        self.letters = letters
        self.word_length = word_length
        self.num_guesses = num_guesses
        self.mode = mode

        letter_frequencies = {}
        for letter in letters:
            letter_frequencies[letter] = 0

        for word in dictionary:
            for letter in word:
                letter_frequencies[letter] += 1

        letter_frequencies = sorted(letter_frequencies, key=letter_frequencies.get)


        self.wordsOrderedByScore = {}
        for word in dictionary:
            self.wordsOrderedByScore[word] = 0

        for word in dictionary:
            wordScore = 0
            for letter in word:
                wordScore += letter_frequencies.index(letter)
            self.wordsOrderedByScore[word] = wordScore

        self.orderedWords = sorted(self.wordsOrderedByScore, key=self.wordsOrderedByScore.get, reverse=True)

    def AgentFunction(self, percepts):
        """Returns the next word guess given state of the game in percepts

        :param percepts: a tuple of three items: guess_counter, letter_indexes, and letter_states;
                 guess_counter is an integer indicating which guess this is, starting with 0 for initial guess;
                 letter_indexes is a list of indexes of letters from self.letters corresponding to
                             the previous guess, a list of -1's on guess 0;
                 letter_states is a list of the same length as letter_indexes, providing feedback about the
                             previous guess (conveyed through letter indexes) with values of 0 (the corresponding
                             letter was not found in the solution), -1 (the correspond letter is found in the
                             solution, but not in that spot), 1 (the corresponding letter is found in the solution
                             in that spot).
        :return: string - a word from self.dictionary that is the next guess
        """

        # This is how you extract three different parts of percepts.
        guess_counter, letter_indexes, letter_states = percepts
        indexesToDelete = []

        if guess_counter != 0:
            for state in letter_states:
                if state == 1:
                    for word in self.orderedWords:
                        if word[letter_states.index(state)] != self.letters[letter_indexes[letter_states.index(state)]]:
                            indexesToDelete.append(self.orderedWords.index(word))
                            if self.letters[letter_indexes[letter_states.index(state)]] in self.yellowLetters:
                                self.yellowLetters.remove(self.letters[letter_indexes[letter_states.index(state)]])
                elif state == -1:
                    for word in self.orderedWords:
                        if word[letter_states.index(state)] == self.letters[letter_indexes[letter_states.index(state)]] or self.letters[letter_indexes[letter_states.index(state)]] not in word:
                            indexesToDelete.append(self.orderedWords.index(word))
                            if self.letters[letter_indexes[letter_states.index(state)]] not in self.yellowLetters:
                                self.yellowLetters.append(self.letters[letter_indexes[letter_states.index(state)]])
                elif state == 0:
                    for word in self.orderedWords:
                        if self.letters[letter_indexes[letter_states.index(state)]] not in self.yellowLetters:
                            if self.letters[letter_indexes[letter_states.index(state)]] in word:
                                indexesToDelete.append(self.orderedWords.index(word))

            noDupes = []
            for index in indexesToDelete:
                if index not in noDupes:
                    noDupes.append(index)

            noDupes.sort(reverse=True)

            working = self.orderedWords.copy()

            for index in noDupes:
                working.pop(index)

            self.orderedWords = working.copy()

            try:
                return self.orderedWords[0]
            except:
                print("Could not figure out the word.")
        else:
            self.yellowLetters = []
            self.orderedWords = self.wordsOrderedByScore.copy()
            return "AROSE" # Optimal starting word made from the top 5 letters ranked by frequency
