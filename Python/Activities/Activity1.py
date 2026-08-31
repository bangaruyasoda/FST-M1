#Write a program that asks the user to enter their name and their age.
#Print out a message addressed to them that tells them the year that they will turn 100 years old.
print("Hello World")
name= input("Hello user enter your name")
age = input("Enter your age")
print(name)
print(age)
years =str(100-int(age))
print(name + " will turn 100 years after " +years + " years")