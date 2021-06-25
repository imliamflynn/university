def one_line(f):
    file = open(f,"r")
    file_str = file.read()
    file.close()
    new = ""
    for ch in file_str:
        if ch == "\n":
            new += "_"
        else:
            new += ch
    print(new)
            