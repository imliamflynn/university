def letter_count(f):
    """
    >>> letter_count("ernest_rutherford.txt")
    3245
    >>> letter_count("frances_oldham_kelsey.txt")
    4235
    """
    letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    file = open(f,"r")
    file_str = file.read()
    file.close()
    count = 0
    for ch in file_str:
        if ch in letters:
            count += 1
        else:
            count += 0
    return count


if __name__ == "__main__":
    import doctest
    doctest.testmod(verbose=True)