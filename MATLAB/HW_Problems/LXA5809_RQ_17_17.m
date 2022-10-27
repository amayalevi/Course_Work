%{
ENGR 1250-001 Levi Amaya 08/14/2020

Problem Summary:

    PARTS A and B ONLY

    In a turbine, a device used for mixing, the power required depends
    on the size and shape of the impeller. In the lab, we have collected
    the following data:

    a. Create a proper plot of the power (P, ordinate) versus the
    diameter (D) assuming the data are experimental.

    b. Use polyfit to determine a power relationship for the data
    set and graph the resulting trendline along with the
    experimental data.

Variables:
    Known:
        Diameter = The impeller diameter data in feet [ft]
        Power = The turbine power lab data in horsepower [hp]
        x_pf = The range of values of the independent variable for the trendline function in feet [ft]

    Unknown:
        Coeff = Trendline coefficients stored in a vector.
        m = The independent variable power coefficient for the trendline function.
        b = The independent variable coefficient for the trendline function.
        y_pf = The calculated dependent variable values for the trendline function in horsepower [hp]
        TE = The Trendline equation saved as a String.

Assumptions:
    None

%}
%Housekeeping
clc
clear
close all

%Initializing known variables
Diameter = [0.5 0.75 1 1.5 2 2.25 2.5 2.75];%[ft]
Power =     [0.004 0.04 0.13 0.65 3 8 18 22];%[hp]

% Part a:

%Plotting the experimental data:
figure('color','w');

plot(Diameter,Power,'s k','MarkerFaceColor','k','MarkerSize',8);

grid on    %Setting grid lines

axis([0 3 -1 23]);%Setting the axis domain and range

%Labeling the axis
xlabel('Diameter (D) [ft]','FontSize',14);
ylabel('Power (P) [hp]','FontSize',14)

%Adding plot title
title('Power Required Based on Impeller Diameter','FontWeight','bold','FontSize',14);

% Part b:

%Finding Trendline coefficients:
Coeff = polyfit(log10(Diameter),log10(Power),1);

%Setting Trendline coefficients:
m = Coeff(1);
b = power(10,Coeff(2));

%Setting trendline function variables:
x_pf = [0.5: 0.1 : 2.8];
y_pf = b*x_pf.^m;

hold on    %To keep previous plot

%Plotting trendline:
plot(x_pf,y_pf,'b -')

%Making the trendline equation string:
TE = sprintf('P = %0.4f*D^{%0.4f}',b,m);

%Printing trendline to plot
text(1.25,10,TE,'EdgeColor','b','FontSize',11);%Final answer