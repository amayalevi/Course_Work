%{
Covid-19 Symptom Checker
Conditional - allow computer to answer yes/no question
y/n,t/f,1/0

Flowchart: 2 branches
%}
clc
clear
close all
%Covid-19 symptoms, behavior
msk = input('Wearing mask? y/n : ', 's');
%strcmp(A,'compare string') - String compare , case sensitive
%strcmpi(A,'compare string') - string compare, NOT case sensitive
if strcmpi(msk(1),'n')
    entr = 'no'
%elseif is one word
elseif strcmpi(msk(1),'y')
    entr = 'ok'
else
    entr ='wait'
end
temp = input('temporal temp scan [deg F] : ') ;
if temp < 0
    warning('No neg temps. Taking abs value....')
    temp = abs(temp)
end
if temp>105
    error('Dangerous temp, Call 9-1-1!')
end
dc= input('Dry cough? y/n :' , 's' ) ;

sb = input('shortness breath ? y/n ;', 's');

ts = input('Loss of taste/smell? y/n :', 's');

swc = input('Sudden onset shakes with chills? y/n :', 's');
% method 1 : default at top
tres = ' neg '
if strcmpi(dc(1),'y')
    if strcmpi(sb(1),'y')
        if temp >=100.4
            if strcmpi(swc(1),'y')
            tres = 'pos'
            end
        end
    end
end
%method 2: compound test, default at bottom
if((strcmpi(dc(1),'y')) && (strcmpi(sb(1),'y'))&& temp >=100.4)
    c19 = 'sym cov'
else
    c19 = 'pre-sym'
end
%Customized messages: error(), warning()