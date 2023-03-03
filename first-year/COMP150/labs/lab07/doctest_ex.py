def compare(a,b):
    if a > b:
        return 1
    elif a == b:
        return 0
    else:
        return -1


def hypo(a,b):
    return (a**2 + b**2)**.5


def f2c(x):
    return round((x-32)/1.8)


def c2f(x):
    return round((x*1.8)+32)


def kg2p(x):
    if x > 0:
        return round(x/0.45359237,1)
    else:
        return -1


def cuboid(x,y,z):
    if x <= 0 or y <= 0 or z <= 0:
        return -1
    else:
        return x * y * z


def vop(a,b):
    if a < 0 or b < 0:
        return -1
    else:
        return (a**2) * (b/3)


if __name__ == "__main__":
    import doctest
    doctest.testmod(verbose=True)