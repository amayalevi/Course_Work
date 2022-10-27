%{
ENGR 1250-001 Levi Amaya 08/07/2020

Problem Summary:
    You want to create a graph showing the relationship of an ideal gas
    between pressure (P) and temperature (T).

    Allow the initial temperature to be 270 kelvin. The range of
    temperatures to be modeled ranges from 270 to 480 kelvin.
    Control the scale of the abscissa so the range is shown from 250 to
    500 kelvin.

    Model two gases:
        Nitrogen (formula,N2; molecular weight, 28 grams per mole),
        using a 12-liter tank with an initial pressure of 2.5 atmospheres.
        Oxygen (formula,O2; molecular weight, 32 grams per mole),
        using a 15-liter tank with an initial pressure of 4 atmospheres.

    After drawing the graph for nitrogen and oxygen, model a third gas,
    with information entered by the user. Assume the volume is 12 liters.

    Add the user-entered gas to the graph, showing the pressure over the
    range of temperatures from 270 to 480 kelvin.

Variables:
    Known:
        temp_initial = The initial temperature of the gases in Kelvin [K]
        temp_range = The range of temperature of the gases in Kelvin [K]
        MW_Nitrogen =  The molecular weight of nitrogen in grams per mole [g/mol]
        MW_Oxygen = The molecular weight of oxygen in grams per mole [g/mol]
        V_Nitrogen = The tank volume of the nitrogen gas in liters [L]
        V_Oxygen = The tank volume of the oxygen gas in liters [L]
        P_Nitrogen = The initial pressure of the nitrogen gas in atmospheres [atm]
        P_Oxygen= The initial pressure of the oxygen gas in atmospheres [atm]
        R = The gas constant in atmosphere liters per mole Kelvin [atm L/mol K]
        V_user = User provided gas's volume in liters [L]
    Unknown:
        n_Nitrogen = The number of moles of nitrogen in the tank [mol]
        n_Oxygen = The number of moles of Oxygen in the tank [mol]
        pressure_N_ordinate = The calculated values for the pressure of the nitrogen gas in atmospheres [atm]
        pressure_O_ordinate = The calculated values for the pressure of the oxygen gas in atmospheres [atm]
        name_user = User provided gas's name
        P_user = The user provided initial pressure of the gas in atmospheres [atm]
        temp_user = The user provided temperature of interest in Kelvin [K]
        n_user = The number of moles of the user provided gas [mol]
        P_interest_user = the pressure of the user provided gas at the temperature of interest in units of atmospheres [atm]
        pressure_user = The calculated values for the pressure of the user provided gas in atmospheres [atm]

Assumptions:
    User inputs are valid.

%}
%Housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%Initializing known variables:
temp_initial = 270;%[K]
temp_range  = [270:1:480];%[K]
MW_Nitrogen =  28;%[g/mol]
MW_Oxygen = 32;%[g/mol]
V_Nitrogen = 12;%[L]
V_Oxygen = 15;%[L]
P_Nitrogen = 2.5;%[atm]
P_Oxygen= 4;%[atm]
R = 0.08206;%[atm L/mol K]
V_user = 12;%[L]

%Computing the number of moles of Nitrogen in the tank: n = P*V/R*T
n_Nitrogen = (P_Nitrogen*V_Nitrogen)/(R*temp_initial);%[mol]
%Computing the number of moles of Oxygen in the tank: n = P*V/R*T
n_Oxygen = (P_Oxygen*V_Oxygen)/(R*temp_initial);%[mol]

%Computing the range of pressures for the nitrogen gas with respect to temperature in atmospheres: P = n*R*T/V
pressure_N_ordinate = (n_Nitrogen*R*temp_range)/V_Nitrogen;%[atm]

%Computing the range of pressures for the oxygen gas with respect to temperature in atmospheres: P = n*R*T/V
pressure_O_ordinate = (n_Oxygen*R*temp_range)/V_Oxygen;%[atm]

%Setting the figure for the plot
figure('color','w');

%Plotting the Nitrogen values
plot(temp_range,pressure_N_ordinate,'-- b','LineWidth',2);

hold on;% To keep the 1st plot

%Plotting the Oxygen values
plot(temp_range,pressure_O_ordinate,': r','LineWidth',3);

%Setting the abscissa and ordinate ranges
axis([250 500 0 8]);

grid on    %For grid lines

%Setting the axis labels
xlabel('Temperature (T) [K]','FontSize',12);
ylabel('Pressure (P) [atm]','FontSize',12);

%Setting the plot title
title('Pressure Change of Nitrogen in a Tank');

%Setting the plot legend
legend('Nitrogen','Oxygen','Location','SouthEast');

%Setting name for user provided gas
name_user = input('Enter the name of the gas : ','s');

%Setting user provided initial pressure of the gas in atmospheres
P_user = input('Enter the initial pressure [atm] : ');%[atm]

%Setting user provided temperature of interest in Kelvin
temp_user = input('Enter the temp of interest [K] : ');% [K]

%Computing the number of moles of the user provided gas:  n = P*V/R*T
n_user = (P_user*V_user)/(R*temp_initial);%[mol]

%Computing the pressure of the user provided gas at the temperature of interest in units of atmospheres: P = n*R*T/V
P_interest_user = (n_user*R*temp_user)/V_user;%[atm]

%Outputting the user provided gas info:
fprintf('At a temperature of %0.0f Kelvin, %s has a\npressure of %0.1f atm.\n',temp_user,name_user,P_interest_user);

%Computing the pressure values of the user provided gas for plotting in units of atmospheres: P = n*R*T/V
pressure_user = (n_user*R*temp_range)/V_user;%[atm]

%Plotting the user provided gas:
plot(temp_range,pressure_user,'- g','LineWidth',2);

%Adding user provided gas to the legend
legend('Nitrogen','Oxygen',name_user,'Location','SouthEast');%Final answer