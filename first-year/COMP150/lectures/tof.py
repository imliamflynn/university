def boolean_test(x,y):
    one = x or y
    two = not (x and y)
    
    print(x, "or", y, "is", one)
    print("not (" + str(x), "and", str(y) + ") is", two)


boolean_test(True, True)
boolean_test(False, False)
boolean_test(True, False)
boolean_test(False, True)