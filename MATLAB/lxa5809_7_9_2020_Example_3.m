% ENGR 1250 Levi Amaya 7/9/2020
%Example 3
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%matrix
meas = [2:1:5;1 2 3 4];

%pulling 4 values?
K = meas(1:2 , 3:4);

%adding a row '5'
meas(5, :) = 22;

%adding a row '7'
meas(7,:) = 55;

%adding a column
meas(:, 10) = 31;

%Deleting 6th row
meas(6,:) = [];

%Deleting columns 6-8
meas(:,6:8) = [];

