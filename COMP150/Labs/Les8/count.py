def count_letters(string,letter):
    count = 0
    for ch in string:
        if ch == letter:
            count += 1
    print(count)