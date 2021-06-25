def find_slice(s, l):
    new = ""
    for ch in s:
        if l not in s:
            return new
        elif ch == l:
            new += ch
            return new
        else:
            new += ch
    return new