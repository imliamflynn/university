import os
print(os.listdir("."))
file_input1 = input("Please enter a file name: ")
file_input2 = input("Please enter another file name: ")
file1 = open(file_input1,"r")
file2 = open(file_input2,"r")
file_str1 = file1.read()
file_str2 = file2.read()
words1 = file_str1.split()
words2 = file_str2.split()
file1.close()
file2.close()
if len(words1) == len(words2):
    print("Both files have the same amount of words.")
elif len(words1) > len(words2):
    print(file_input1,"has more words in it than",file_input2)
else:
    print(file_input2,"has more words in it than",file_input1)