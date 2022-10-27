%{
ENGR1250-001 Levi Amaya 7/24/2020
    
Problem Summary: 
    There is currently an effort in the United States to replace 
    incandescent light bulbs with more energy-efficient technologies, including 
    compact fluorescent lights (CFLs) and light-emitting diodes (LEDs). The lumen
    [lm] is the SI unit of luminous flux, a measure of the perceived power of light. 
    Luminous flux is adjusted to reflect the varying sensitivity of the human eye to 
    different wavelengths of light.
    To test the power usage, you run an experiment and measure the following
    data. Create a proper plot of these data, with electrical consumption (EC) on
    the ordinate.
    On the graph, use solid blue circles for incandescent bulbs, solid red squares
    for CLFs, and open black diamonds for LEDs.

Variables:
    LF_INC = Luminous Flux in lumens [lm]
    INC = Electrical consumption of Incandescent light bulbs in Watts [W]

    LF_CFL = Luminous Flux in lumens [lm]
    CFL = Electrical consumption of compact fluorescent lights in Watts [W]

    LF_LED = Luminous Flux in lumens [lm]
    LED = Electrical consumption of light-emitting diodes in Watts [W]

Assumptions:
    None

%}
%Housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

% Initializing variables as vectors
LF_INC = [80 400 600 750 1400];    %[lm] 
INC = [16 38 55 68 105];   %[W]

LF_CFL = [200 400 750 1250 1400]; %[lm] 
CFL = [5 10 18 27 33];   %[W]

LF_LED = [80 200 400 600 750]; %[lm] 
LED = [1.7 3 6 9 12];   %[W]

%Setting plot background color
figure('color','w');

%Creating 1st plot of LF_INC(x-axis) and INC(y-axis)
plot(LF_INC,INC,'o b','MarkerFaceColor','b', 'MarkerSize',7) 

hold on %Keep previous plots

%Creating 1st plot of LF_CFL(x-axis) and CFL(y-axis)
plot(LF_CFL,CFL,'s r','MarkerFaceColor','r', 'MarkerSize',8) 

%Creating 1st plot of LF_LED(x-axis) and INC(y-axis)
plot(LF_LED,LED,'d k', 'MarkerSize',7) 

%enabling grid lines
grid on

%Setting the axis domain and range:
 axis([0 1500 0 110]);
 
 %Increasing grid lines
 set(gca,'Xtick',0:100:1500, 'YTick',0:10:110)
 
 %Creating axis labels
 xlabel('Luminous Flux (LF) [lm]', 'FontSize',14);
 ylabel('Electrical Consumption (EC) [W]', 'FontSize',14);
 
 %Adding Title
title({'Electrical Consumption of components','based on Luminous Flux'}, 'FontSize',16);

%Adding the legend
legend('Incandescent (EC)','CFD (EC)','LED (EC)','Location','NorthWest');    %Final Answer