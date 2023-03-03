def water_state(x):
    if x > 100:
        print ("Steam")
    elif x < 0:
        print ("Ice")
    else:
        print ("Liquid")

x = int(input("Enter the degrees in centigrade and I will let you know what state water would be at that temperature: "))
water_state(x)