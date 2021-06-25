def details(name, current_age):
    print ("Hello " + name + ", you are " + str(current_age) + " years old.")
    aged = str(int(current_age) + 1)
    print ("Next year you will be " + aged)

name = input("Enter your name: ")
age = input("Enter your age: ")
details(name,age)