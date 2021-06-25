def chunks(s,x):
    new = ""
    index = 0
    for ch in s:
        if index % x == 0:
            new += ch + "*"
        else:
            new += ch
        index += 1
    return new