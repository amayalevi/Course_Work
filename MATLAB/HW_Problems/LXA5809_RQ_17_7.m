%{
ENGR1250-001 Levi Amaya 7/24/2020

Problem Summary: 
   Write a program containing the following elements:

    Create a cell array containing the material names and specific heat data from Table A.
    Ask the user to select a material from a menu.
    Ask the user to enter the mass in grams [g] of the selected material. (scalar).  For example:
                       Enter mass[g] :

    Ask the user to enter the initial temp in Celsius [deg C] of the selected material. (scalar) For example:
                       Enter initial temperature [deg C] :

    Each property of glycerol given in Table B must be assigned to its own variable.
    Compute the thermal energy in Joules [J] that must be removed from the material. 
    Track your units!
    Calculate the volume of fluid needed in gallons [gal] to cool the rod to 50 deg C, 
    assuming both the fluid and the rod are at this final temperature at the end of the 
    cooling process. Track your units!
    Using the appropriate variables, write a formatted output statement to the user, 
    similar to the final output shown in the text. The numerical formats and spacing 
    should match exactly as shown.

Variables:
Known:
    material_data = cell array of metal names and their respective Specific heat in Joule per kilogram Kelvin [J/(kg K)]
    gly_SH = Specific Heat of glycerol in Joule per kilogram Kelvin [J/(kg K)]
    gly_SG = Specific Gravity of glycerol [-]
    gly_temp_0 = Initial temperature of the glycerol in degrees Fahrenheit [deg F]
    rho_w = density of water in kilograms per cubic meter [kg/m^3]
Unknown:
    material = user selected material.
    material_SH = Specific heat of selected material in Joule per kilogram Kelvin [J/(kg K)]
    mass = provided by the user in grams [g]
    temp_0 = initial temperature of the material provided by the user in degrees Celsius [deg C]
    Q = Thermal energy that's removed from the material in Joules [J]
    delta_temp = change in temperature of the material in degrees Celsius [deg C]
    gly_delta_temp = change in temperature of glycerol in Kelvin [K]
    gly_mass = mass of glycerol in kilograms [kg]
    rho_gly = density of glycerol in kilograms per cubic meter [kg/m^3]
	gly_V = Volume of glycerol in cubic meter [m^3]
    
Assumptions: 
    There is no loss of energy.
    Inital temperature of the material is at least 50 degrees Celsius or
    higher.
    The user selects one of the 4 materials in the menu.
%}
%Housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%Initializing variables:
material_data = {'Aluminum',897;'Cadmium',231;'Iron',450;'Tungsten',134}; %Col 1 = Name, Col 2 = Specific Heat in [J/kg K]
gly_SH = 2400;  %[J/(kg K)]
gly_SG = 1.261; %[-]
gly_temp_0 = 75; %[deg F]
rho_w =1000;    %[kg/m^3]

%Using a menu for the user to select the material
material = menu('Please select a material from the menu: ','Aluminum','Cadmium','Iron','Tungsten');

%Setting mass equal to user provided amount in grams:
mass = input('Enter mass[g] : ');   %[g]

%Setting initial temperature to user provided quantity:
temp_0 = input('Enter initial temperature [deg C] : ');    %[deg C]

%Converting mass from [g] -> [kg]
mass = mass*(1/1000); %[kg]

%Computing delta temperature(change in temp) of the material in degree Celsius
% delta T = (T2 - T1) . Absolute value is used since we only want the amount of energy.
delta_temp = abs(50 - temp_0);  %[deg C]

%No conversion needed for delta_temp since 1 [deg C] = 1 [K]. (In temperature ratios)
% delta_temp [deg C] -> [K]

%Setting Specific Heat of selected material to material_SH
material_SH = material_data{material,2}; %[J/(kg K)]

%Computing the energy(Heat) removed from the material in Joules. Q = m*Cp*T(delta)
Q = mass*material_SH*delta_temp;% [J]

%Converting initial temperature of the glycerol from [deg F] -> [deg C]
% deg C = (100(deg F-32))/180
gly_temp_0 = (100*(gly_temp_0 - 32))/180;   %[deg C]

%Computing delta temperature of glycerol in degrees Celsius
% delta T = (T2 - T1) . Absolute value is used since we only want the amount of energy.
gly_delta_temp = abs(50 - gly_temp_0);  %[deg C]

%No conversion needed for gly_delta_temp since 1 [deg C] = 1 [K]. (In temperature ratios)
% gly_delta_temp [deg C] -> [K]

%Computing mass of glycerol in kilograms. m = Q/cp*T(delta)
gly_mass = Q/(gly_SH*gly_delta_temp);    %[kg]

%Computing density of glycerol in kilograms per cubic meter. rho(gly) = SG(gly)*rho(water)
rho_gly = gly_SG*rho_w; %[kg/m^3]

%Computing Volume of glycerol in cubic meters. V = mass/density
gly_V = gly_mass/rho_gly ;   %[m^3]

%Converting Volume of glycerol from [m^3] ->[cm^3] ->[L] -> [gal]
gly_V = gly_V*(10^6/1)*(1/1000)*(0.264/1);  %[gal]

%Outputting results of the program:
fprintf('For the %0.1f kg %s rod with an initial\ntemperature of %0.0f [deg C]\n',mass,material_data{material,1},temp_0);
fprintf('\tEnergy Removed [J]\t\t%0.1e\n',Q);
fprintf('\tGlycerol Volume [gal]\t\t%0.2f\n',gly_V);  %Final Answer