import numpy as np
import sympy

#Create random matrix A
A = np.random.randint(-9,9,(3,3))
print('A = \n',A)

#Convert the numpy array to sympy.Matrix
A_sympy = sympy.Matrix(A)
print(A_sympy)

#Calculate RREF of A_sympy
#'rref' returns 2 objects: RREF(A) and a list of the pivot columns
A_rref = A_sympy.rref()
print('A_rref (from sympy):\n',A_rref)

#Convert A_rref to numpy
A_rref = np.array(A_rref[0].tolist())
print('A_rref=\n',A_rref)
