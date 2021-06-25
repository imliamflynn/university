import os
print(os.listdir("."))
file_input = input("Please enter the file name you would like to print: ")
file = open(file_input,"r")
file_str = file.read()
file.close()
print(file_str)