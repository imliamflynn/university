def wack():
    prefixes = "JKLMNOPQ"
    suffix = "ack"
    suffix2 = "uack"
    for ch in prefixes:
        if ch == "O" or ch == "Q":
            print (ch + suffix2)
        else:
            print (ch + suffix)