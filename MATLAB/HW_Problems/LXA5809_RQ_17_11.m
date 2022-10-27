%{
ENGR 1250-001 Levi Amaya 08/07/2020

Problem Summary:
    You are part of an engineering firm on contract with the U.S.
    Department of Energy’s Energy Efficiency and Renewable Energy task
    force to develop a program to help consumers measure the efficiency
    of their home appliances. Your job is to write a program that
    measures the efficiency of stove-top burners. Before using your
    program, the consumer will place a pan of room-temperature water
    on the stove (with + gallon of water), record the initial room
    temperature in units of degrees Fahrenheit, turn on the burner, and
    wait for it to boil. When the water begins to boil, the consumer will
    record the time in units of minutes it takes for the water to boil.
    Finally, the consumer will look up the power for the burner provided
    by the manufacturer.

    The output of your program should look like the following output,
    where the highlighted values are example responses typed by the
    user into your program. Note that your code should line up the
    energy and power calculations as shown. In addition, your code must
    display the efficiency as a percentage with one decimal place and
    must include a percent symbol.

Variables:
    Known:
        SH_water  = Specific heat of water in calories per gram degree Celsius [cal/g deg C]
        V_water     = Volume of water that gets boiled in gallons [gal]
        rho_water  = Density of water in kg per cubed meter [kg/m^3]
        mass          = Mass of the water in kilograms [kg]
        boiling_temp = The boiling point of water in degrees Fahrenheit [deg F]

    Unknown: 
        temp            = Initial room temperature of the water in degrees Fahrenheit [deg F]
        delta_temp = The difference in temperature from the water's boiling point and the initial temperature in degrees Fahrenheit [deg F]
        time             = Time it takes for the water to boil in minutes [min]
        name           = the brand name and model of the stove saved as a character array
        power_rating = The power rating of the stove-top burner in Watts [W]
        power_used  = The power used by the burner in Watts [W]
        Q                    = Energy required for the water to boil in Joules [J]
        efficiency      = The efficiency of the stove in energy use. [-]
        
Assumptions:
    The starting temperature of the water is at or below boiling temp.

%}
%Housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%Initializing known variables
SH_water = 1;%[cal/g deg C]
V_water = 1;%[gal]
rho_water = 1000;%[kg/m^3]
boiling_temp = 212;%[deg F]

%Displaying program title:
fprintf('Household Appliance Efficiency Calculator: Stove\n\n');

%Setting temp equal to user provided amount in degrees Fahrenheit
temp = input('Type the initial room temperature of the water [deg F] : ');%[deg F]

%Setting time equal to user provided amount in minutes
time = input('Type the time it takes the water to boil [min] : ');%[min]

%Setting name equal to user provided input
name = input('Type the brand name and model of your stove : ','s');

%Setting power rating equal to user provided amount in Watts
power_rating = input('Type the power of the stove-top burner [W] : ');%[W]

%Converting volume of water from [gal] ->[L] -> [mL] ->[cm^3] -> [m^3]
V_water = V_water*(1/0.264)*(10^3/1)*(1/10^6);%[m^3]

%Computing mass of the water in kilograms: m = rho*volume
mass = rho_water*V_water;%[kg]

%Converting Specific Heat of water from [cal/g deg C] to [J/kg deg C]
SH_water = SH_water*(1/0.239)*(10^3/1);%[J/kg deg C]

%Calculating the change in temperature of the water in degrees Fahrenheit: delta T = T1 - T0
delta_temp = boiling_temp - temp;%[deg F]

%Converting delta temp from [deg F] to [deg C]
delta_temp = delta_temp*(1/1.8);%[deg C]

%Computing energy used to boil the water in Joules: Q = m*Cp*delta-T
Q = mass*SH_water*delta_temp;%[J]

%Converting time from minutes to seconds:
time = time*(60/1);%[s]

%Computing power used by the burner in Watts: W = J/s
power_used = Q/time;%[W]

%Computing burner efficiency: efficiency = output/input
efficiency = power_used/power_rating;%[-]

%Converting efficiency from a decimal to a percentage: decimal*100 = %
efficiency = efficiency*100;%[-]

%Outputting the results:
fprintf('\nEnergy required:\t\t%0.0f J\n',Q);
fprintf('Power used by burner:\t\t%0.0f W\n\n',power_used);
fprintf('Burner efficiency for a %s stove: %0.1f%%\n',name,efficiency); %Final answer