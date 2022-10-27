%{
ENGR1250-001 Levi Amaya 7/24/2020

Problem Summary: 
    The specific gravity of acetic acid (vinegar) is 1.049. 
    Write a MATLAB program to display the density of acetic acid in units 
    of pounds-mass per cubic foot, grams per cubic centimeter, kilograms 
    per cubic meter, and slugs per liter. Incorporate each value into a 
    sentence with appropriate text, each sentence on a new line. 
    All numeric values should be given to two decimal places.

Variables:
    Known:
    SG = Specific gravity of acetic acid (vinegar) [-]
    rho_w = density of water in kilograms per cubic meter [kg/m^3]

    Unknown:
    d   = Density of acetic acid in kilograms per cubic meter [kg/m^3]
    d1 = Density of acetic acid in pounds-mass per cubic foot [lb-m/ft^3]
    d2 = Density of acetic acid in grams per cubic centimeter [g/cm^3]
    d3 = Density of acetic acid in slugs per liter [slug/L]

Assumptions:
    None

%}
%Housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures


% Initializing variables
SG = 1.049; %[-]
rho_w = 1000;   %[kg/m^3]

% Computing density of acetic acid: rho(acid) = SG(acid) * rho(water)
d = SG*rho_w;   %[kg/m^3]

% Converting density from [kg] -> [lb-m] and [m^3] -> [ft^3]
d1 = d*(2.205/1)*((1/3.28)^3);  % [lb-m/ft^3]

% Outputting the density of acetic acid in pounds-mass per cubic foot [lb-m/ft^3]
fprintf('The density of acetic acid in units of pounds-mass per cubic foot [lb-m/ft^3] : %0.2f \n',d1)

% Converting density of acetic acid from [kg] -> [g] and [m^3] -> [cm^3]
d2 = d*(1000/1)*((1/100)^3);    %[g/cm^3]

% Outputting the density of acetic acid in grams per cubic centimeter [g/cm^3]
fprintf('The density of acetic acid in units of grams per cubic centimeter [g/cm^3] : %0.2f \n',d2)

%Outputting the density of acetic acid in kilograms per cubic meter [kg/m^3]
fprintf('The density of acetic acid in units of kilograms per cubic meter [kg/m^3] : %0.2f \n',d)

% Converting density of acetic acid from [kg] -> [lb-m] -> [slug] and [m^3] -> [cm^3] -> [mL] -> [L]
d3 = d*(2.205/1)*(1/32.2)*((1/100)^3)*(1000/1); %[slug/L]

%Outputting the density of acetic acid in slugs per liter [slug/L]
fprintf('The density of acetic acid in units of slugs per liter [slug/L] : %0.2f \n',d3) %Final answer