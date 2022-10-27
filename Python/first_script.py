"""
first.py
This is a python script
"""

str1 = "World!"
str2 = "Everyone!"

# Read input from the user
choice = input("Enter either 0 or 1: ")
try:
    choice = int(choice)
except:
    print(f'\"{choice}\" is not a number. Defaulting to 0')
    choice =0
       
if choice == 0:
    print(f'Hello {str1}')
elif choice ==1:
    print(f'Hello {str2}')
else:
    print(f'{choice} is not a valid input.')