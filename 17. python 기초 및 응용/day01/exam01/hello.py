# message = "HELLO"
# print(message)

# import turtle as t
# t.shape('turtle')
# t.color('#FFD9EC')
#
# for _ in range(7):
#     t.circle(50)
#     t.right(50)

import turtle
import random

turtles = []
for index in range(7):
    new_turtle = turtle.Turtle()
    turtles.append(new_turtle)
    new_turtle.shape('triangle')
    new_turtle.color('#FFD9EC')
    new_turtle.penup()


for count in range(30):
    for index in range(7):
        turtles[index].setheading(random.randint(0,360))
        turtles[index].forward(random.randint(1,100))
