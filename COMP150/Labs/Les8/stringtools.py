def remove_letter(l, s):
    new = ""
    for ch in s:
        if ch == l:
            new += ""
        else:
            new += ch
    return new


def reverse(s):
    new = ""
    for ch in s:
        new = ch+new
    return new


def mirror(s):
    new = ""
    for ch in s:
        new = ch+new
    news = s+new
    return news