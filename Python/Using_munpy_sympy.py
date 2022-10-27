#Levi Amaya
#ID: 1001445809
# 4/18/20201

import numpy as np
import sympy

#HW9, Question #4
B = np.matrix([
              [-3,1,5],
              [6,8,5],
              [2,-4,-2]                
])
print('B = \n',B)

C = np.matrix([
              [1,1,-7],
              [-8,5,1],
              [-8,8,-1]                
])
print('C = \n',C)

B_sympy = sympy.Matrix(B)
C_sympy = sympy.Matrix(C)

#Finding P(B to C)
P_BtoC = C_sympy.gauss_jordan_solve(B_sympy)
P_BtoC = np.array(P_BtoC[0].tolist())
print('P(B to C) = \n',P_BtoC)

#Finding P(C to B)
P_CtoB = B_sympy.gauss_jordan_solve(C_sympy)
P_CtoB = np.array(P_CtoB[0].tolist())
print('P(C to B) = \n',P_CtoB)