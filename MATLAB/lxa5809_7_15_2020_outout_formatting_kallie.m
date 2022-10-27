%Formatted output ...to Command Window
clear
clc
close all
%{
Built-in function fprintf()
Print advising report

%Student Hall is a fr with GPA 81.25.
%   Student will earn 40 total credits
%   with 94 credits left in her degree plan.
%>>
%}

%we'll use %f %e and %s only for this course
last_name = 'Hall';
GPA_avg = 81.25;
rank = 'fr';
credits = 40;
credits_remaining = 94;

fprintf('Student %s is a %s with GPA %0.2f %%.\n\n', last_name,rank,GPA_avg);
fprintf('\t Student will earn %0.0f total credits \n    ',credits);
fprintf('\t with %0.0e credits left in her degree plan. \n',credits_remaining);
