def isitin(f,s):
    """
    >>> isitin("test.txt", "Mary")
    True
    >>> isitin("test.txt", "Joseph")
    False
    >>> isitin("test.txt", "fleece")
    True
    """
    file = open(f,"r")
    file_str = file.read()
    words = file_str.split()
    file.close()
    if s in words:
        return True
    else:
        return False


if __name__ == "__main__":
    import doctest
    doctest.testmod(verbose=True)