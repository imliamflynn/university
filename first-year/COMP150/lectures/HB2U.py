def print_twice(phrase):
    print(phrase, phrase)
#does not have to be named part 1 or part 2 etc...
def print_joined_twice(part1, part2):
    joined = part1 + " " + part2
    print_twice(joined)

line1 = "Happy Birthday"
line2 = "to you"
print_joined_twice(line1, line2)