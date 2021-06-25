def sig(boss):
    print ("Yours sincerely")
    print (boss)

def accept(name):
    print ("Dear " + name)
    print ("I am pleased to inform you that you have the job")
    sig ("Liam Flynn")

def reject(name):
    print ("Dear " + name)
    print ("I am sorry to inform you that you do not have the job")
    sig ("Liam Flynn")



accept("Bill")
print()
reject("Timone")