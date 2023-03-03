import os
print(os.listdir("."))
file_input1 = input("Please enter a file name: ")
file_input2 = input("Please enter another file name: ")
file1 = open(file_input1,"r")
file2 = open(file_input2,"r")
file_str1 = file1.read()
file_str2 = file2.read()
file1.close()
file2.close()
if len(file_str1) == len(file_str2):
    print("Both files are the same length.")
elif len(file_str1) > len(file_str2):
    print(file_str1)
else:
    print(file_str2)