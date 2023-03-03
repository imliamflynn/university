def funa():
    print("Function A was called")


def funb():
    print("Function B was called")


def func():
    print("Function C was called")

def dispatch(x):
    if x == "a":
        funa()
    elif x == "b":
        funb()
    elif x == "c":
        func()
    else:
        print("Invalid Choice.")


x = input("a, b or c? ")
dispatch(x)