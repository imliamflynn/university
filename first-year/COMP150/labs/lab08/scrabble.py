def scrabble(s):
    one = "AEIOUNRTLS"
    two = "DG"
    three = "BCMP"
    four = "FHVWY"
    five = "K"
    eight = "JX"
    ten = "QZ"
    score = 0
    for ch in s:
        if ch in one:
            score += 1
        elif ch in two:
            score += 2
        elif ch in three:
            score += 3
        elif ch in four:
            score += 4
        elif ch in five:
            score += 5
        elif ch in eight:
            score += 8
        elif ch in ten:
            score += 10
        else:
            score += 0
    return score