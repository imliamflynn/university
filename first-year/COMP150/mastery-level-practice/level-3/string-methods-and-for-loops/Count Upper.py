def count_upper(s):
    """
    >>> count_upper("Hello World!")
    2
    >>> count_upper("27th of April 1968")
    1
    >>> count_upper("HELLO")
    5
    >>> count_upper("zzz")
    0
    """
    uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    count = 0
    for ch in s:
        if ch in uppercase:
            count += 1
        else:
            count += 0
    return count
    

if __name__ == "__main__":
    import doctest
    doctest.testmod(verbose=True)