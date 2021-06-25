def hoon(s):
    result = ""
    for ch in s:
        if ch not in "!?.,":
            result += ch
            
    
    for ch in result:
        if ch[] % 2 ==0:
            result += "!"
        
    print(result)
    
hoon("!Cuck!")
hoon("cuckles")
hoon("oidoi !!!!.....,,,??? yeeee")