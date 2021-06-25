def is_divisible(x,y):
    if (x % y) == 0:
        print (x,"is divisible by",y)
    else:
        print (x,"is not divisble by",y)



x = int(input("Enter a number: "))
y = int(input("Enter another number: "))
is_divisible(x,y)