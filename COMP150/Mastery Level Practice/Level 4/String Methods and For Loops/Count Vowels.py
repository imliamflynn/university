def count_vowels(s):
    """
    Return the number of vowels (a,e,i,o,u) in a sentence.
    >>> count_vowels("Hello World!")
    3
    >>> count_vowels("baa baa do baa baa")
    9
    >>> count_vowels("HELLO")
    2
    >>> count_vowels("zzz")
    0
    """
    vowels = "aeiouAEIOU"
    count = 0
    for ch in s:
        if ch in vowels:
            count += 1
        else:
            count += 0
    return count


if __name__ == "__main__":
    import doctest
    doctest.testmod(verbose=True)