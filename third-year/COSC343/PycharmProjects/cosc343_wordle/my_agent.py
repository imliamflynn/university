__author__ = "Liam Lennon-Flynn"
__organization__ = "COSC343/AIML402, University of Otago"
__email__ = "lenli455@student.otago.ac.nz"

import random


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

        self.green = [0] * word_length
        self.yellow = [0] * word_length
        self.grey = [0] * word_length
        self.yellowList = []
        self.dictCopy = self.dictionary.copy()

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
        working = self.dictCopy.copy()

        # If not the first guess
        if guess_counter != 0:
            i = 0
            for state in letter_states:
                letter = self.letters[letter_indexes[i]]

                if state == 1:
                    self.green[i] = letter

                    if letter in self.yellowList:
                        self.yellowList.remove(letter)
                elif state == -1:
                    self.yellow[i] = letter
                    self.yellowList.append(letter)
                elif state == 0:
                    self.grey[i] = letter

                i += 1

            green(self, working)
            yellow(self, working)
            grey(self, working)

            # resets variables for next guess
            self.yellow = [0] * self.word_length
            self.grey = [0] * self.word_length
        else:
            # resets variables for next word
            self.green = [0] * self.word_length
            self.yellow = [0] * self.word_length
            self.grey = [0] * self.word_length

            self.yellowList = []

            self.dictCopy = self.dictionary.copy()

        try:
            # guess
            return self.dictCopy[random.randint(0, len(self.dictCopy) - 1)]
        except:
            print("Could not figure out the word.")

# removes all words from the list that DON'T have letter X in the same spot that letter X is green in
def green(self, working):
    i = 0
    for letter in self.green:
        if letter:
            for word in self.dictCopy:
                if word[i] != letter:
                    working.remove(word)
                    self.dictCopy = working.copy()
        i += 1

# removes all words from the list that DO have letter X in the same spot that letter X is yellow in
# also removes words that don't contain the unfound yellow letters
def yellow(self, working):
    i = 0
    for letter in self.yellow:
        if letter:
            for word in self.dictCopy:
                if word[i] == letter:
                    working.remove(word)
                    self.dictCopy = working.copy()
        i += 1

    for word in self.dictCopy:
        missing = 0
        for yellowLetter in self.yellowList:
            if yellowLetter not in word:
                missing += 1

        if missing != 0:
            working.remove(word)
            self.dictCopy = working.copy()

# removes words from dictionary if they have a grey letter in them aside from the green letters and unfound yellows
def grey(self, working):
    for letter in self.grey:
        if letter:
            for word in self.dictCopy:
                if letter in word:  # and letter not in self.green:
                    letterOccurrences = 0
                    greenLetterOccurrences = 0
                    for l in self.green:
                        if l == letter:
                            greenLetterOccurrences += 1
                    for l in word:
                        if l == letter:
                            letterOccurrences += 1

                    if letterOccurrences > greenLetterOccurrences and letter not in self.yellowList:

                        working.remove(word)
                        self.dictCopy = working.copy()
