%{ 
ENGR1250-001 Levi Amaya  7/9/2020 

Problem Summary: Chapter 16 Review Question #6 
An unmanned X-43A scramjet test vehicle has achieved
a maximum speed of Mach number 9.68 in a test flight 
over the Pacific Ocean. Mach number is defined as the 
speed of an object divided by the speed of sound. 
Assuming the speed of sound is 343 meters per second[m/s], 
write a MATLAB program to determine the record speed 
in units of miles per hour.

Variables:
v = speed of the vehicle in "mach"

Assumptions: None

%}
%housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%Set initial values: speed
v = 9.68;    %in "mach" speed

%converting object speed: v(object) = v(mach)*speed(sound)
v = v*343;  %[m/s]

%Converting m -> mi and s ->h
v = v*(0.621/1000)*(3600/1)    %[mi/h]. Final Answer