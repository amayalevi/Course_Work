%{
ENGR1250-001 Levi Amaya 7/17/2020

Problem Summary: When one tries to stop a car, both the reaction
time of the driver and the braking time must be considered. Create
a proper plot of the following data.

Variables:
v = Vehicle speed in miles per hour [mi/h]
d_r = Distance based on driver reaction in meters [m]
d_b = Distance based on driver braking in meters [m]

Assumptions: None

%}
%Housekeeping
clc
clear
close all

%Initializing variables as vectors
v = [20:10:70]; %[mi/h]
d_r = [6:3:21];    %[m]
d_b = [6 14 24 38 55 75];   %[m]

%Setting graph background
figure('color','w');

%Plotting first set of points
plot(v,d_r,'o r', 'MarkerFaceColor','r', 'MarkerSize',10);

%Keeping the 1st plot 
hold on

%Plotting 2nd set of points
plot(v,d_b,'s b ','MarkerFaceColor','b', 'MarkerSize',10);

%Setting axis domain and range
axis([10 80 0 80]);

%Adding grid lines
grid on

%Adding axis labels
xlabel('Vehicle Speed (v) [mph]', 'FontSize',13);  %using [mph] instead of [mi/h] as per the table
ylabel('Distance (d) [m]', 'FontSize',13);

%Adding Title
title({'Driver Stopping Distance','Based on Vehicle Speed'},'FontSize',16);

%Adding the legend
legend('Reaction (d)','Braking (d)','Location','NorthWest');    %Final Answer