def powers(n):
    print(n**0)
    print(n**1)
    print(n**2)
    print(n**3)
    print(n**4)

def score_summary(name,x,y,z):
    big = str(max(x,y,z))
    lil = str(min(x,y,z))
    print(name + " - " + "Max: " + big + " , " + " Min: " + lil + " , " + "Average: " + str((x + y + z)/3))



score_summary("Liam",9,8,7)