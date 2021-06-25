def balloon_string(s, x):
    '''
    >>> balloon_string('abcdef', 4)
    'abbccceff'
    >>> balloon_string('A great day!', 4)
    'Agggrreaay!'
    >>> balloon_string('ABC 1234', 3)
    'AAC  1224'
    '''
    new = ""
    for ch in s:
        skuxx = ord(ch)
        skuxx2 = skuxx % x
        new += (ch*skuxx2)
    return new




if __name__== "__main__":
    import doctest
    doctest.testmod(verbose=True)             