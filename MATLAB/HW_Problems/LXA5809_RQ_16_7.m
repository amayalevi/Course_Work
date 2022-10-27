%{ 
ENGR1250-001 Levi Amaya  7/9/2020 

Problem Summary: Chapter 16 Review Question #7 
A rod on the surface of Jupiter’s moon Callisto has a 
volume of 0.3 cubic meters[m^3]. Write a MATLAB program 
that will determine the weight of the rod in units of pounds-force. 
The specific gravity is 4.7. Gravitational acceleration on 
Callisto is 1.25 meters per second squared[m/s^2].

Variables:
Known:
V - Volume of the rod [m^3]
SG - Specific Gravity of the rod [-]
g - gravitational acceleration of Callisto [m/s^2]

Unknown:
m - mass of the rod [kg]
d - density of the rod [kg/m^3]
w - weight of the rod [lb-f]

Assumptions: None

%}
%housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%Setting initial values: Volume, Specific Gravity, gravity acceleration
V = 0.3;     %[m^3]
SG = 4.7;  %[-]
g = 1.25;   %[m/s^2]

%Computing density of the rod: d(rod) =SG(rod)*d(water)
d = SG*1000;    %[kg/m^3]

%Computing mass of the rod: m=d*V 
m = d*V;    %[kg]

%Computing weight of rod : w=m*g 
w = m*g;    %[N]

%Converting rod's weight from Newtons to lb-force
w = w*(0.225/1)   % [N] to [lb-f]. Final answer
