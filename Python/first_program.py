import sys


def validate_args(args):
    """
    Checks if the second argument in the list is a number.
    Args:
        args(list) - Command line argument
        
    Returns:
        0 if the second argument is a number
        1 if the secind argument is not a number
        2 if the list is empty
    """
    
    #Attempt to convert the second argumenty to a number
    try:
        int(args[1])
    except:
        return 1
    if len(args) ==0:
        return 2
    else:
        return 0
        
def main(args):
    """
    The main function, first point of execution
    """
    num_args = len(args)
    
    for i in range(num_args):
        print(f'args[{i}] = {args[i]}')
        
    status = validate_args(args)
    
    if status == 0:
        print(f'{args[1]} is a valid number.')
        
if __name__ == "__main__":
    main(sys.argv)