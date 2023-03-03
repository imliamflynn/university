def print_twice(phrase):
    print (phrase, phrase)

def print_joined_twice (part1, part2):
    joined = part1 + part2
    print_twice(joined)

line1 = "Happy birthday, "
line2 = "to you."
print_joined_twice(line1, line2)