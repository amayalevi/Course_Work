%{
ENGR1250-001 Levi Amaya 7/9/2020

Problem Summary: Chapter 16 Review Question #12
A cylindrical tank filled to a height of 25 feet [ft] with 
tribromoethylene has been pressurized to 3 atmospheres [atm]
(Psurface = 3 atmospheres). The total pressure in at the 
bottom of the tank is 5 atmospheres [atm]. Write a MATLAB 
program to determine the density of tribromoethylene in 
units of kilograms per cubic meter [kg/m^3].

Variables:
Known:
H - Height of the tank [ft]
Ps - Surface pressure on the tank [atm]
Pt - Total Pressure on the bottom of the tank [atm]

Unknown:
d - density of tribromoethylene

Assumptions:
g - gravitational acceleration = 9.8 [m/s^2]

%}
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%Setting initial values: Height, Surface pressure, Total pressure,
%gravitational acceleration 
H = 25;     %[ft]
Ps = 3;     %[atm]
Pt = 5;      %[atm]
g = 9.8;     %[m/s^2]

%Converting height to [m]
H=H*(1/3.28);    %[ft] -> [m]

%Converting both total and surface pressure to Pascal
Ps = Ps*(101325/1); %[atm] -> [Pa]
Pt = Pt*(101325/1); %[atm] -> [Pa]

%Computing density of tribromoethylene:
% d=Pt-Ps/(g*H)
d=(Pt-Ps)/(g*H)  %[kg/m^3]. Final Answer
