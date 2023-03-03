def match_brackets(s):
    '''
    >>> match_brackets('(7 - 4) * (3 + 2)')
    True
    >>> match_brackets('((2 + 5) / (13 +12)')
    False
    >>> match_brackets(')14 + 12) % 3')
    False
    >>> match_brackets(')(')
    False
    >>> match_brackets('())(')
    False
    >>> match_brackets('())(()()')
    False
    >>> match_brackets('())()(')
    False
    '''
    count = 0
    for ch in s:
        if ch == "(":
            count += 1
        elif ch == ")":
            count += -1
            if count < 0:
                return False
            
    if count == 0:
        return True
    else:
        return False
    
    
if __name__== "__main__":
    import doctest
    doctest.testmod(verbose=True)