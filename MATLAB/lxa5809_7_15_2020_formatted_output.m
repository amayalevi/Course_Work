%housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

a=6;
b=25;
c=0.79;
m=a/b;
n=b/c;

% we will be using %f
%as always, \n is newspace

fprintf('%f\n',a);    %6 decimal point

fprintf('%f\n',n);    %6 decimal point

fprintf('%f\n\n',n);    %2 newlines

%decimal number controls the # of decimal places
fprintf('%0.3f\n',n);    %3 decimal point

fprintf('%0.1f\n',n);    %1 decimal point

fprintf('%0.0f\n',n);    %no decimal, notice that it automatically rounds the number

%leading zero is not applicable in this course

%Scientific notation
fprintf('%0.2e\n',n);   %2 decimal places and base 10 power

fprintf('%0.2E\n',n);   %Big E means the same thing, only looks different
