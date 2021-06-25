def area_of_circle(radius):
    if radius<0:
        return "Error: can't have a negative radius"
    
    return 3.1415*radius**2



def distance(x1, y1, x2, y2):
    dx = x1 - x2
    dy = y1 - y2
    dx2 = dx**2
    dy2 = dy**2
    return (dx2 + dy2)**0.5



def area_of_circle_two_points(x1,y1,x2,y2):
    return area_of_circle(distance(x1,y1,x2,y2))



print (area_of_circle_two_points(0,0,3,4))