% ENGR 1250 Levi Amaya 7/7/2020
%{
block comment
%}
%housekeeping
clear        %workspace
clc          %command window
close all    %open figure

%F=ma, solve for a

F = 15E+03; %Force N

m =750;     %mass kg
a = F/m;   %acceleration

a1 = a*(0.621/1000)*(3600/1)^2; % m to mi, sec to hr