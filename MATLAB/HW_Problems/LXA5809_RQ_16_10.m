%{
ENGR1250-001 Levi Amaya 7/9/2020

Problem Summary: Chapter 16 Review Question #10
Write a program to convert a temperature provided by 
the user in units of Fahrenheit to units of kelvins [K]. As a 
test case, you may assume the user provides the temperature
of − 129 degrees Fahrenheit [F], which is the world’s lowest 
recorded temperature.

Variables:
Known
T - User provided temperature in degrees Fahrenheit [F]

Assumption: None
%}
%housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%Setting initial value: Temperature
T = -129;   %[F]

%Converting the temperature from Fahrenheit to Kelvin
% [K] = ((100/180)*([F]-32)) + 273
T = (100/180)*(T-32) + 273   %[F] -> [K]. Final answer