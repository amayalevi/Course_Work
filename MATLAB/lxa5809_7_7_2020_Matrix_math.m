% ENGR 1250 Levi Amaya 7/7/2020

%housekeeping
clear        %clears workspace
clc            %clears command window
close all   %open figure

%Matrix math

h = a*i;    %matrix multiplication

% V=pi*f^3 <--- will not work
V= pi*f.^3  %correct way, dot operator goes before the math expression

V=pi*power(f,3)     % power function dosen't need dot operator, it automatically goes term by term
