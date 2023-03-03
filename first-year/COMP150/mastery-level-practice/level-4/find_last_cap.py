def find_last_capitalised(f):
    """
    >>> find_last_capitalised('ernest_rutherford.txt')
    'British'
    >>> find_last_capitalised('tycho_brahe.txt')
    'Together,'
    >>> find_last_capitalised('test_5.txt')
    ''
    """
    capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    file = open(f,"r")
    file_str = file.read()
    words = file_str.split()
    newlist = ""
    for word in words:
        if word[0] in capitals:
            newlist += word + " "
        else:
            newlist += ""
    if newlist == "":
        return ""
    else:    
        newlist2 = newlist.split()
        winner = newlist2[-1]
        return winner
            

if __name__ == "__main__":
    import doctest
    doctest.testmod(verbose=True)