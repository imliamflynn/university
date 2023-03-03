def multi_blank(s, n):
    old = s[n:]
    juice = len(old)
    new = s[:n] + (juice * "*")
    return new