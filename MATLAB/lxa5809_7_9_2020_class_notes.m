% ENGR 1250 Levi Amaya 7/9/2020
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

meas = [2:1:5;1 2 3 4];
%pull 1st h, 1st d
h3 = meas(1,1);
dia3 = meas(2,1);
r3 = dia3/2;
v3 = pi*r3^2*h3;

%pick all values & number crunch
h4 = meas(1,:); %tricky! whole row, Colon (:) operator
dia4 = meas(2,:);
r4 = dia4/2;
v4 = pi*r4.^2.*h4 % sucess using dot operator

%pull a subset of data from measurements

power(16,8)