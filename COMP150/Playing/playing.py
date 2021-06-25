item = input("Guess which fruit I am thinking of ")
def  fruit(item):
    if item.lower()== "banana":
        print("Woah you guessed the fruit I was thinking of.")
    else:
        print("Yuck")
        
x = input("Pick a number between 1-10 ")
def  number(x):
    if x == "7":
        print("Woah you guessed my number.")
    else:
        print("Poor effort")

fruit(item)
number(x)