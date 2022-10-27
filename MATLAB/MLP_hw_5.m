clc
clear
close all

% P(D)
%{

D = [0.5:0.1:1.5]; %m
A = pi*((D./2).^2);
rho = 1000*(.00123); %kg/m^3
v = 34; %m/s
P = (1/2).*A*rho*(v^3);

plot(D,P);



I = [.5,1.25,1.5,2.25,3,3.2,3.5];

P =[1.2 8.2 11.8 26 47 53 68];

plot(I,P,'o')

axis([0 3.75 0 70]);
grid

time = [0 0.2 0.4 0.6 0.8 1];
voltage = [0 79.3 102.7 114.4 117.3 119.3];

plot(time,voltage,'rd')
grid
axis([0 1 0 120])

x =38
cos(x)
log(x)
%}
z=100/810;
fprintf('%.3e\n',100000*z);