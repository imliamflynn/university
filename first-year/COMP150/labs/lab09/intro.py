# file is 'test.txt' or whatever the filename is
file = open("test.txt") # first open the file
all_lines = wordfile.readlines() # reads in all lines
one_line = wordfile.readline() # read the next line
file.close() # close the file
for line in all_lines:
    for ch in line: # this is an example of a nested loop
        if ch not in 'aeiouAEIOU':
            print(ch, end="")