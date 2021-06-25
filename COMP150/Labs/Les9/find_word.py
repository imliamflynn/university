def find_word(f, x):
    file = open(f,"r")
    file_str = file.read()
    words = file_str.split()
    file.close()
    return(words[x])