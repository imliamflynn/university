def guess_right(secret,guess):
    if guess != secret:
        print ("You lose.", guess, "is not equal to", secret)
    else:
        print ("You win.", guess, "is equal to", secret)




secret = 55
guess = int(input("Guess a number between 50 and 100: "))
guess_right(secret,guess)