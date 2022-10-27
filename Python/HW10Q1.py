import numpy as np

#vector u
u = np.array([3,-1,4])
print("u = \n",u)
#vector v
v = np.array([-2,3,1])
print("v = \n",v)

cos_theta = (np.vdot(u,v))/np.dot(np.linalg.norm(u),np.linalg.norm(v))
print("Cos(Theta) = \n",cos_theta)

#2nd set
u = np.array([5,6,-5])
print("u = \n",u)

v = np.array([6,2,-5])
print("v = \n",v)

cos_theta = (np.vdot(u,v))/np.dot(np.linalg.norm(u),np.linalg.norm(v))
print("Cos(Theta) = \n",cos_theta)

#3rd set
u = np.array([-3,1,7])
print("u = \n",u)

v = np.array([7,-4,7])
print("v = \n",v)

cos_theta = (np.vdot(u,v))/np.dot(np.linalg.norm(u),np.linalg.norm(v))
print("Cos(Theta) = \n",cos_theta)