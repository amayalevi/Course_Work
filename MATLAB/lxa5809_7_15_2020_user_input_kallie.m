% Data input from user
clear
clc
close all
% Built-in function: input()
New_reg = input('Enter credits: [F,Sp,Su] =>  ');

%String input
Tell_advisor = input('Type not to Advisor:   ','s');

%Built-in function menu()
options = {'fr', 'soph', 'jr', 'sr'};
yr_num = menu('Choose ranking',options);
%the choosen rank
yr_name = options{yr_num}