% ENGR 1250-001 Levi Amaya 8/4/2020
% Challenge #4,  Ch 17 I/O
%{
    NO BLOCK HEADERS IN EXAMS
%}

%Housekeeping
clc
clear
close all

%Cahllenge Question #4

G= {'Earth','Mars','Venus';
        9.81,   3.71,   8.87};

planet = menu('Choose a palnet',G{1,:});

% gravitational constant

g = G{2,planet}; 

p_length = input('Enter the pendulum length in meters [m] : ');

%frequency
f = 2*pi*sqrt(p_length/g);

%output
fprintf('On %s, a %0.1f meter pendulum has a frequency of %0.2f Hz\n',G{1,planet}, p_length,f);
%done