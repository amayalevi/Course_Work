% ENGR 1250 Levi Amaya 7/9/2020
%8.2 ER 4
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%{
P:Compute Wt of rover [lb-f] on Earth

K: Wm = 700N

U: WE = ?[lb-f]

A:gm= 3.7 [m/s^2]
gE = 9.8 [m/s^2]

E/S: 
w=mg
We = m*gE
Wm = m*gm
m = Wm/gm = 700 N/189.19 kg
wE = m*gE
        = (189.19kg)(9.8 [m/s^2])
        1854.06  N
1854.06(.225/1) = 417.6 [lb-f]


Flowchart:
Start
wM = 700
gM = 3.7
gE = 9.8

Compute mass rover
m = wM/gM

convert wt rover in earth
wE = w(.225/1)

Stop
%}

%{
The program:
clear
clc
close all
LXA5809_Exa1_07092020
%}
wM = 700;
gM = 3.7;
gE = 9.8;

m = wM/gM;

wE = m*gE;

wEc = wE*(.225/1)   %and done!