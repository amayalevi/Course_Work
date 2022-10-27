%{
ENGR1250-001 Levi Amaya 7/17/2020
 
Problem Summary: 2.	An unmanned X-43A scramjet test
 vehicle has achieved a maximum speed of Mach number
 9.68 in a test flight over the Pacific Ocean. Mach number
 is defined as the speed of an object divided by the speed
 of sound. Assuming the speed of sound is 343 meters per
 second, write a MATLAB program to determine speed in 
units of miles per hour. Your program should ask the user 
to provide the speed as Mach number and return the speed
 in miles per hour in a formatted sentence, displayed as an
 integer value, as shown in the following sample output.

Sample Input/Output:

'Enter the speed as a Mach number: 9.68'
'The speed of the plane is 7425 mph.'

Variables:
mach = mach speed(provided from input) [-]
v_sound = speed of sound in [m/s] 
v = speed of object [mph]

Assumptions: None

%}
%Housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%Initializing speed of sound constant
v_sound = 343; % [m/s]

%Setting mach = to user provided number
mach = input('Enter the speed as a Mach number: '); %[-]

%Computing object speed v(object) = (mach speed)*v(sound)
v = mach*v_sound;   %[m/s]

%Converting m -> mi and s ->h
v = v*(0.621/1000)*(3600/1);    %[mi/h]

%Outputting result as an integer
fprintf('The speed of the plane is %0.0f mph.\n',v) %Final Answer