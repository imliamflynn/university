def next_level(a,b,c,d,e,f):
    x = (a+b+c+d+e+f) - min(a,b,c,d,e,f)
    if x < 200:
        print ("Fail")
    else:
        print ("Pass")

next_level(50,50,50,20,20,20)