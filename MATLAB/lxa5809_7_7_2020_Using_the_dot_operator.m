% ENGR 1250 Levi Amaya 7/7/2020

%housekeeping
clear        %clears workspace
clc            %clears command window
close all   %open figure

%Using the dot operator

%Set the required inputs and constants
R=[0.25:0.25:2];
SG=0.79;
rho_w=1000;
g=9.8;

%Convert R from [in] to [m]
R=R*2.54/100;

%Calcualte the density of the fluid
rho_a=SG*rho_w;

%Calculate the surface tension
%sigma=R^2*g*rho_a   <---- wont work
sigma=R.^2*g*rho_a   %correct way to square each element using '.'
%The dot operator goes BEFORE THE MATH OPERATOR, not after the matrix
