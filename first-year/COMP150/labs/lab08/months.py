def date(date):
    months = ("January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
    day = date[0:2]
    month = date[3:5]
    yeet = (int(month) -1)
    month2 = months[yeet]
    year = date[-4:]
    suffix = "null"
    if int(day[0]) == 1:
        suffix = "th"
    else:
        if int(day[1]) == 1:
            suffix = "st"
        elif int(day[1]) == 2:
            suffix = "nd"
        elif int(day[1]) == 3:
            suffix = "rd"
        else:
            suffix = "th"
    print(day+suffix,month2+",",year)
    
date("24/10/2000")