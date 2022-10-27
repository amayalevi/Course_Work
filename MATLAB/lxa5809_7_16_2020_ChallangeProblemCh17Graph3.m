%{
    ENGR 1250 Levi Amaya 7/16/2020
problem Sumamry: (theoretical) Plot the relationship of heart rate of
exercising adult over time.

Variables:
F normalizing constant [1/min]
t time [min]
HR heart rate [beats/min]

Assumptions: on Earth
%}
clc
clear
close all

F = 0.2;
t = [0:0.1:10];

HR = 135 - 75*exp(-F*t);

%create proper plot
figure('color','w') %white outer background
plot(t,HR,'r --','LineWidth',3)

grid

axis([0 10 50 130])

xlabel('Time (t) [min]')
ylabel('Heart Rate (bpm) [beats/min]','Color','r','FontWeight','bold' )

title('Heart Rate During Exercise, Challenge 17 #3','FontSize',16)

%legend is not needed because of 1 data series