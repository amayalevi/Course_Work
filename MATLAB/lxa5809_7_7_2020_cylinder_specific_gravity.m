% ENGR 1250 Levi Amaya 7/7/2020
% scalar and vectors - finding SG of a cylinder

% housekeeping
clear        %workspace
clc          %command window
close all    %open figure

m = 75;         %g
h = [10 11.5];  %cm
h1 = [10:1:100]; %use : within [] to generate data. [
                % [starting value: step-size: stopping]
dia = 25;       %diameter
r = dia/2;      %radius

V = pi*r^2*h;   %volume
V1 = pi*power(r,2)*h1; % built-in funtion power(a,b)
dens1 = m./V;    % yes, pls do m/v(1,1) & m/v(1,2). element-wise math or term-by-term

