%{
Assumptions: on Earth
%}

clc
clear 
close all

%Ch17 Plotting Challnge Problems Graph_1
%Initialize data vectors
P = [ 13, 23, 37, 47, 59, 79 ];

V1 = [2.5, 2.95, 3.3, 3.55, 3.7, 3.9] ;

V2 = [3.5, 4.95, 6.3, 7.55, 8.7, 9.9 ];

%Create proper plot of data series
%Setting the figure for the plot
figure('color','w');

plot(P,V1,'red s','MarkerFaceColor','r','MarkerSize',12)

hold on    %To keep previous plot

plot(P,V2,'o k','MarkerFaceColor','k')

grid on    %Setting grid lines

%Changing the axis, [Xmin Xmax Ymin Ymax]
axis([0 100 0 12]);%Setting the axis domain and range

%Labeling the axis
xlabel('Power (P) [W]');
ylabel('Velocity (V) [m/s]')

%Adding plot title
title('Challange graph CH17 Gr1','FontWeight','bold','color','b','FontSize',18);

%adding a legend
legend('Vendor1','Vendor2','Location','NorthWest')
%the legend can be modified if needed by using cell arrays and set()
% ex. LT = {'Vendor1','Vendor2'}
% L = legend(LT,'Location','NorthWest')
% ex. resizing and color: set(L,'TextColor','b','FontSize',16,'Color','w')


%adding/limiting the tickmarks to the axis
%correlates with the axis() command
%gca = grab current axis
%Amount of lines can be changed here!
%for example:  set(gca,'Xtick',0:5:100, 'YTick',0:1:12)
set(gca,'Xtick',0:10:100, 'YTick',0:2:12)

%fplot is forbidden!!!!