%{
ENGR1250-001 Levi Amaya 7/24/2020

Problem Summary:
    You will not download data from a file.
    Instead, create the cell array Name and create the matrix CurData, as described in the problem.
    Note: Ask the user to select a voltage value from a menu. Store the scalar in the variable Volt.
    Then, continue code writing Matlab code through to the printed report for Component Holtz100.

Variables:
Known:
    Name = cell array containing the component names
    CurData = matrix holding Voltage and Current data of the
    components in Voltage [V] and milliamps [mA] respectively.
Unknown:
    Volt = user selected voltage value in Volts [V]
    component = user selected component from Name list.
    Power = Power from all voltages for the chosen component in Watts [W]
    A = user chosen currents for the component in milliamps[mA]


Assumptions: 
    The user selects one of the 5 voltages in the menu.
    The user selects one of the 3 components in the menu.
%}
%Housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%Initializing variables:
Name = {'Holtz100','Lever014','Dillard202'};
CurData = [5 7 10 12 15;128 142 165 180 212;18 20 23 25 30;260 285 333 368 428];    %1st row in [V], 2nd-4th row in [mA]

%Setting component to user selected option:
component = menu('Select a component : ',Name);

%Setting chosen currents to 'A' 
A = [CurData((component+1),:)]; %[mA]

%Converting chosen currents from [mA] -> [A]
A = A.*(1/1000);    %[A]

%Computing Power with component currents and Voltages: P = V*I
Power = CurData(1,:).*A;    %[W]

%Setting Voltage to Volt
Volt = menu('Select a Voltage : ',5, 7, 10, 12, 15);  %[V]

%Printing Report Summary:
fprintf('Component %s\n\tVoltage = %0.0f V\n\tCurrent = %0.3f A\n\tPower = %0.2f W\n',Name{component},CurData(1,Volt),A(Volt),Power(Volt)); %Final Answer
