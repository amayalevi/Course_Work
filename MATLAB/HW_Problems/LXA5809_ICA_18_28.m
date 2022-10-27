%{
ENGR 1250-001 Levi Amaya 08/14/2020

Problem Summary:
    The following input statement is part of a silly program designed to flummox
    freshmen.

    BS=input('How long is a battleship? (Type "true" or
    "false"): ','s');

    Write a short segment of MATLAB code that will accomplish the following
    task:

    - If the user typed either “true” or “false” with ANY combination of upper
    and lowercase characters, display the message “Surely you jest.” in the
    command window.

    - If the user typed anything other than the word “true” or the word “false,”
    an error message stating “INVALID ENTRY” should appear and the
    program should terminate.

Variables:
    Known:
        BS = Variable that receives user provided input as a string.
%}
%Housekeeping
clc
clear
close all

%Initializing known variable
BS = input('How long is a battleship? (Type "true" or "false"): ', 's');

%Setting output message based on user input:
if(strcmpi(BS,'true') || strcmpi(BS,'false'))%if user enters either 'true' or 'false'
    fprintf('Surely you jest.\n');%display message
else %if false
    error('INVALID ENTRY');%Display error message and terminate program
end%Final answer