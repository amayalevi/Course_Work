%housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

b=25;
c=0.79;
n=b/c;
name = 'Bob';

%pint string
fprintf('%s\n',name);

%   \t is tab
fprintf('\t%s\n',name);

%C-C-Combo
fprintf('%s\t\t%0.2f\n\n',name,n);

%Sentence
fprintf('It took %s %0.2f minutes to complete service.\n',name,n);

name = 'Harry';
%Harry is just as fast
fprintf('It took %s %0.2f minutes to complete service.\n',name,n);