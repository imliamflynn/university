def remove_duplicates(s):
    new = ""
    for ch in s:
        if ch == " ":
            new += " "
        elif ch in new:
            new += ""
        else:
            new += ch
    return new