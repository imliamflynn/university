def mid(s):
    letters = "abcdefghijklmnopqrstuvwxyz"
    new = s.lower()
    middle = ""
    middle2 = ""
    final = ""
    if new[0] in letters:
        middle = new
    else:
        middle = new[1:]

    if middle[-1] in letters:
        middle2 = middle
    else:
        middle2 = middle[:-1]
        
    return middle2
        
        
print(mid("Hello"))
print(mid("!Hello?"))
print(mid("Hello."))