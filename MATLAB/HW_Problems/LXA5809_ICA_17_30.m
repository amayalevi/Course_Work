%{
ENGR 1250-001 Levi Amaya 08/14/2020

Problem Summary:
    If an object is heated, the temperature of the body will increase. The energy
    (Q) associated with a change in temperature is a function of the mass
    of the object (m) and the specific heat (Cp). In an experiment, heat is applied
    to the end of an object, and the temperature change at the other end of the
    object is recorded. This leads to the following equation.

    An unknown material with a mass of = 5 kilograms is tested in the lab, yielding
    the following results. Use the polyfit function to determine the specific
    heat of this material and store the final result in the variable.

    Create a proper plot of the data. Add a linear trendline, showing the resulting
    trendline equation, on the graph for a change in temperature over a range of
    energy from 5 joules to 70 joules.

Variables:
    Known:
        mass = mass of the material in kilograms [kg]
        Q = Heat energy of the material in Joules [J]
        delta_T = Temperature of the material in Kelvin [K]
        x_pf = The range of values of the independent variable for the trendline function in Joules [J]

    Unknown:
        Cp = Specific heat of the material in Joules per kilogram Kelvin [J/kg K]
        Coeff = Trendline coefficients stored in a vector
        m = The independent variable coefficient for the trendline function.
        b = The y-intercept for the trendline function.
        y_pf = The calculated dependent variable values for the trendline function in Kelvin [K]
        TE = The Trendline equation saved as a String.

Assumptions: The experiment was done under ideal conditions.
    
%}
%Housekeeping
clc
clear
close all

% Initializing known variables:
mass = 5;%[kg]
Q = [17 40 58];%[J]
delta_T =[2 5 7];%[K]

%Plotting the test data (delta T) with respect to (Q)
figure('color','w');

plot(Q,delta_T,'s k','MarkerFaceColor','k','MarkerSize',10)

grid on    %Setting grid lines

axis([0 75 0 9]);%Setting the axis domain and range

%Labeling the axis
xlabel('Heat Energy Applied (Q) [J]','FontSize',13);
ylabel('Temperature Change (delta T) [K]','FontSize',13)

%Adding plot title
title('Change in Temperature with Respect to Heat Energy','FontWeight','bold','FontSize',14);

%Finding Trendline coefficients:
Coeff = polyfit(Q,delta_T,1);

%Setting Trendline coefficients:
m = Coeff(1);
b = Coeff(2);

%Setting trendline function variables:
x_pf = [5 : 0.1 : 70];%[K]
y_pf = m*x_pf + b;%[J]

hold on    %To keep previous plot

%Plotting trendline:
plot(x_pf,y_pf,'b -')

%Making the trendline equation string:
TE = sprintf('delta T = %0.4f*Q - %0.4f',m,abs(b));

%Printing trendline to plot
text(40,4,TE,'EdgeColor','b','FontSize',11);

%Computing the Specific Heat of the material: m*Q = Q/mass*Cp => m = 1/mass*Cp => Cp = 1/mass*m
Cp = 1/(m*mass);%[J/kg K] Final answer