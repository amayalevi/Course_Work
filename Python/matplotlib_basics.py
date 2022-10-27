import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D

#Define our 3D points
D = np.array([
    [5,6,5,6,5,6,5,6],
    [0,0,1,1,0,0,1,1],
    [7,7,7,7,6,6,6,6]
    ])
# Define the figure and plot
fig3d = plt.figure()
ax3d = fig3d.add_subplot(projection='3d')
ax3d.set_xlim([0,9])
ax3d.set_ylim([0,9])
ax3d.set_zlim([0,9])
ax3d.set_xlabel('X')
ax3d.set_ylabel('Y')
ax3d.set_zlabel('Z')

#plot the points
ax3d.scatter(D[0,:],D[1,:],D[2,:],c='r')

#Define the projection matrix
P = np.eye(4)
P[3,3] = 0
P[3,2] = 0.25
print(P)

#Convert the points D to homomgeneous coordinates
D_hmg = np.concatenate((D,np.ones((1,D.shape[1]))))

#Project the points using the projection matrix P
D_hmg_proj = P @ D_hmg

#Divide by W
D_hmg_proj /= D_hmg_proj[3,:]
print(D_hmg_proj)

D_proj_2d = D_hmg_proj[:2,:]

#Create a figure for a 2D plot
fig2d = plt.figure()
ax2d = fig2d.add_subplot()
ax2d.set_xlim([6,0])
ax2d.set_ylim([0,4])
ax2d.set_xlabel('X')
ax2d.set_ylabel('Y')

#Plot the points
ax2d.scatter(D_proj_2d[0,:],D_proj_2d[1,:], c=D[2,:])


plt.show()