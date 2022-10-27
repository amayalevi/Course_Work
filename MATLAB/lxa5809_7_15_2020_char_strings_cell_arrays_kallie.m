%Review
% Scalar: use = to assign value. use var name to "call" from worlspace
% Vector: use [] to form it, () to access values, [] to combine
% Matrix: use [] to form it, () to access values, [] to combine
% Strings: use ' ' (not " ") to form it, () to access values, [] to combine


clear 
clc
close all
% Strings, example
x = 'ENGR 1250    ' %13 char
x1 = "ENGR 1100" %1 string

%pull data
x_p = x(1)
x_p = x(1:4)
x1_p = x1(1)%Cannot pull the 1st char, only the whole string

%Cell array - different data types in 1 variable
%use {} to create it, {} to pull data, {}  to combine cell arrays
%Example cell #1: potato chip vendors
%brims, lays, great value, 
%bbq plain, sco,
%sizes 4 6 16 
%<= vendors, flavors, bag
chips = {'brims', 'lays', 'GV';
            'BBQ', 'Plain', 'sco';
            4               6       16 }
 %data extraction, we want 2nd chip size
 %3rd row, 2nd column
 %c1 becomes a 1x1 cell array
  c1 = chips(3,2)
  
  %use {} NOT () to retrieve data from cell
  c2 = chips{3,2}   %BOOM Baby, we got the value