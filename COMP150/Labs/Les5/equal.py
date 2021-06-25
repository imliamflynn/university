def equal(x,y,z):
    if x == y and x == z:
        print("All three inputs match.")
    elif x == y:
        print("The first and second input match.")
    elif x == z:
        print("The first and third input match.")
    elif y == z:
        print("The second and third input match.")
    else:
        print("No inputs match.")

equal(1,1,1)