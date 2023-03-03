def get_ords(s):
    '''
    >>> get_ords('abc')
    '97 98 99 '
    >>> get_ords('a b c')
    '97 32 98 32 99 '
    >>> get_ords('a1 b2 c3')
    '97 49 32 98 50 32 99 51 '
    >>> get_ords('[(!)]')
    '91 40 33 41 93 '
    '''
    new = ""
    for ch in s:
        skuxx = str(ord(ch))
        new += skuxx + " "
    return new



if __name__ == "__main__":
    import doctest
    doctest.testmod(verbose=True)