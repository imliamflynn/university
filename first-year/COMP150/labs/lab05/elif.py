def compare(x,y):
    if x < y:
        print(x, "is less than", y)
    elif x > y:
        print(x, "is greater than", y)
    else:
        print(x, "and", y, "are equal")

compare(1,2)
compare(2,1)
compare(1,1)