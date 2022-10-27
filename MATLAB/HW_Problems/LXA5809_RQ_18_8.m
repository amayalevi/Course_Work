%{
ENGR 1250-001 Levi Amaya 08/14/2020

Problem Summary:
    The Eco-Marathon is an annual competition sponsored by Shell Oil,
    in which participants build special vehicles to achieve the highest
    possible fuel efficiency. The Eco-Marathon is held around the world
    with events in the United Kingdom, Finland, France, Holland, Japan,
    and the United States.

    A world record was set in the Eco-Marathon by a French team in
    2003 called Microjoule with a performance of 10,705 miles per gallon.
    The Microjoule runs on ethanol. 

    Write a MATLAB program to determine how far the Microjoule will 
    travel in kilometers given a user-specified amount of ethanol, provided 
    in units of grams. Your program should ask for the mass using an input 
    statement and display the distance in a formatted sentence similar to 
    the output that follows.
    
    If the user provides a mass less than zero or greater than 500
    grams, your program should terminate after displaying an error
    message using the error function indicating that the provided mass
    of ethanol is outside of the desired range of input.

Variables:
    Known:
        perf = Performance of the Microjoule in miles per gallon [mi/gal]
        SG = Specific Gravity of ethanol [-]
        fuel = Amount of ethanol given in grams [g] - provided by user input
        rho_water = The density of water in kilograms per cubic meter [kg/m^3]

    Unknown:
        rho = density of the ethanol fuel. in kilograms per cubic meter [kg/m^3]
        D = distance the Microjoule travels in kilometers [km]
        V = Volume of ethanol in gallons [gal]                          

Assumptions: 
    Distance traveled is under ideal conditions.
    User input is valid.
%}
%Housekeeping
clc
clear
close all

%Initializing known variables
perf = 10705;%[mi/gal]
SG = 0.789;
rho_water = 1000;%[kg/m^3]

%Setting fuel = user provided amount in grams [g]
fuel = input('Enter mass of ethanol [grams] : ');

%Checking if fuel is within the acceptable range
if(fuel < 0 || fuel >500)%If fuel is less than 0 or greater than 500
    error('Error: Mass must be between 0 and 500 grams');%Terminate program and display message 
end%Otherwise continue program

%Computing density of ethanal : rho(ethanol) = SG(ethanol)*rho(water)
rho = SG*rho_water;  %[kg/m^3]

%Converting density of ethanol from kg -> g 
% and m^3 -> cm^3 -> mL -> L -> gal
rho = rho*(1000/1)*(1/10^6)*(10^3/1)*(1/0.264);%[g/gal]

%Computing volume of ethanol: Volume = mass/density
V = fuel/rho; %[gal]

%Converting performance from [mi] -> [km].
%[gal] remains the same
perf = perf*(1/0.621);  %[km/gal]

%Calculating distance traveled by the Microjoule: Distance = Performance*Volume
D = perf*V; %[km]

%Outputting the distance as an integer as per the sample output:
fprintf('The distance the Microjoule traveled is %0.0f kilometers.\n',D) %Final Answer