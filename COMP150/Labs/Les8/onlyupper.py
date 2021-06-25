def only_upper(s):
    new = ""
    for ch in s:
        if ch.isupper():
            new += ch
    print (new)