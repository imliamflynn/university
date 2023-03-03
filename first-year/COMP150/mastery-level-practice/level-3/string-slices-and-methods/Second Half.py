def second_half(s):
    a = len(s)
    if (a%2) != 0:
        b = round((a + 1)/2)
    else:
        b = round(a/2)
    new = ""
    half = s[b:]
    for ch in half:
        new += ch
    return new