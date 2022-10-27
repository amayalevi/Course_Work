% ENGR 1250 Levi Amaya 7/7/2020
%{
block comment
%}
%housekeeping
clear        %clears workspace
clc          %clears command window
close all    %open figure

%scalars:
a=5;    % scalar

b=10;   % another scalar

c=a+b;  % scalar from other scalars

d=a/b;  % scalar from other scalars

A=pi*a^2;           % calculating area of a circle using a scalar

A=pi*power(a,2);    % power function example

clc     %clear command window

%vectors:

f=[1 2 3 4 5];      % vector

g= [10:10:50];      %[beginning: step size: end point]
                    %10,20,30,ect
                    %to look at a single element f(row,column)
