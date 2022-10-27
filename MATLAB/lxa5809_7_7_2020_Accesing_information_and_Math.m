% ENGR 1250 Levi Amaya 7/7/2020

%housekeeping
clear        %clears workspace
clc            %clears command window
close all   %open figure

%Accesing information and Math

f= [10:5:50];
a= [2 5;6 7];
i= [1 3;4 5];
j= [4 5;6 7;8 9];

j(1,2) =10;     %change an element of a matrix

%x= j(2,3);  <--- this is out of bounds, will not work (No column 3) in 'j'

x = j(3,2);     %within bounds

V = pi*(j(1,1)^2)*j(1,2)    %math example