def yesno(x):
    if x == "Y":
        print ("You chose Yes")
    elif x == "y":
        print ("You chose Yes")
    elif x == "yes":
        print ("You chose Yes")
    elif x == "Yes":
        print ("You chose Yes")
    elif x == "YES":
        print ("You chose Yes")
    else:
        print ("You chose No")


x = input("Are you a gay: ")
yesno(x)