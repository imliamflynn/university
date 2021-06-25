def count_possible_sentences(f):
    """
    >>> count_possible_sentences("frances_oldham_kelsey.txt")
    45
    >>> count_possible_sentences("ernest_rutherford.txt")
    32
    >>> count_possible_sentences("marie_curie.txt")
    24
    """
    end = "?!."
    count = 0
    file = open(f,"r")
    file_str = file.read()
    words = file_str.split()
    for word in words:
        if word[-1] in end:
            count += 1
        else:
            count += 0
    return count


if __name__ == "__main__":
    import doctest
    doctest.testmod(verbose=True)