%{

%}
%housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

f = 'dog';
g = 'rat';

I = [g,f];
I(2)

J = {g,f};
J(2)

%different types of variables

b=[1 2 3 ];

M = {f,b};
%CEll Arrays can also be stored :[]
N = {M,g};

P = {f,b};
%non-opened cell
R= P(1);
R
%opening the cell
T =P{1};
T
%opened the cell and store in a
a = P{2};
a
c= a(2:3);
c
%C-C-Combo command
S = P{2}(2:3);
S

