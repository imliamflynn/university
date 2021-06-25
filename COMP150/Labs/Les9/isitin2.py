def isitin2(f,s,s2):
    """
    >>> isitin2("test.txt", "Mary", "fleece")
    True
    >>> isitin2("test.txt", "Joseph", "poop")
    False
    >>> isitin2("test.txt", "fleece", "poop")
    False
    """
    file = open(f,"r")
    file_str = file.read()
    words = file_str.split()
    file.close()
    if s in words and s2 in words:
        return True
    else:
        return False


if __name__ == "__main__":
    import doctest
    doctest.testmod(verbose=True)
