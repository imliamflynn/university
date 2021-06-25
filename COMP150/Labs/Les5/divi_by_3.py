def divisible_by_3(x):
    if (x % 3) == 0:
        print ("This number is divisible by 3.")
    else:
        print ("This number is not divisble by 3.")



x = int(input("Enter a positive number: "))
divisible_by_3(x)