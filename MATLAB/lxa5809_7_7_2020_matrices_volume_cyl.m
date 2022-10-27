% ENGR 1250 Levi Amaya 7/7/2020

% housekeeping
clear        %workspace
clc          %clear command window
close all    %open figure

%matrices - solving for volume of cylinder
%1st row : heights in cm
%2nd row: diam in cm

meas =  [2:1:5;
                1 2 3 4 ];
%pull 1st h, 1st d
h3 = meas(1,1);     %(row,column)
dia = meas(2,1);
r3 = dia*3/2;
v3 = pi*r3^2*h3;

%picl all values & number crunch
h4 = meas(1,:); %****tricky! whole row
dia4 = meas(2,:);
r4 = dia4/2;
v4 = pi*r4.^2.*h4; % Sucess!