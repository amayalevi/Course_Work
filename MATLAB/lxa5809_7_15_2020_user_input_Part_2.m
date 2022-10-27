%{

%}
%housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

Dept = menu('Select the department of service','Shipping','Receiving', 'Computing','Billing','Service');

%The choice gets saved as a NUMBER, 1-5
%So shipping would make Dept = 1;
Dept
%No choice = 0!!!

%Cell arrays!
L = {'Shipping', 'Receiving', 'Computing', 'Billing', 'Service'};
Dept = menu('Enter the department of service',L);
Dept

%Printing the string ussaing the selected department
A= L{Dept};
A