%{
ENGR1250-001 Levi Amaya 7/17/2020

Problem Summary: 4.	The Eco-Marathon is an annual competition 
sponsored by Shell Oil, in which participants build special vehicles 
to achieve the highest possible fuel efficiency. The Eco-Marathon 
is held around the world with events in the United Kingdom, Finland,
France, Holland, Japan, and the United States.
A world record was set in the Eco-Marathon by a French team in
2003 called Microjoule with a performance of 10,705 miles per gallon.
The Microjoule runs on ethanol, which has a specific gravity of 0.789.0
Write a MATLAB program to determine how far the Microjoule will
travel in kilometers given a user-specified amount of ethanol,
provided in units of grams. Your program should ask for the mass
using an input statement and display the distance in a formatted
sentence similar to the output shown below.

Sample Input/Output:

'Enter mass of ethanol [grams]: 100'
'The distance the Microjoule traveled is 577 kilometers.'

Variables:
    Known:
        perf = Performance of the Microjoule in miles per gallon [mi/gal]
        SG = Specific Gravity of ethanol [-]
        fuel = Amount of ethanol given in grams [g] - provided by user input

    Unknown:
        rho = density of the ethanol fuel. in kilograms per cubic meter [kg/m^3]
        D = distance the Microjoule travels in kilometers [km]
        V = Volume of ethanol in gallons [gal]                          

Assumptions: Distance traveled is under ideal conditions.

%}
%Housekeeping
clc
clear
close all

%Initializing variables
perf = 10705;   %[mi/gal]
SG = 0.789; %[-]

%Setting fuel = user provided amount in grams [g]
fuel = input('Enter mass of ethanol [grams] : ');

%Computing density of ethanal : rho(ethanol) = SG(ethanol)*rho(water)
rho = SG*1000;  %[kg/m^3]

%Converting density of ethanol from kg -> g 
% and m^3 -> cm^3 -> mL -> L -> gal
rho = rho*(1000/1)*(1/10^6)*(10^3/1)*(1/0.264);   %[g/gal]

%Computing volume of ethanol: Volume = mass/density
V = fuel/rho; %[gal]

%Converting performance from mi -> km. gal remains the same
perf = perf*(1/0.621);  %[km/gal]

%Calculating distance traveled by the Microjoule: Distance = %Performance*Volume
D = perf*V; %[km]

%Outputting the distance as an integer as per the sample output:
fprintf('The distance the Microjoule traveled is %0.0f kilometers.\n',D) %Final Answer