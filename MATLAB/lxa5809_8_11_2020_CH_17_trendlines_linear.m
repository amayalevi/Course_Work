%{
1. Curve fitting
2. plot the data

1.Find m & b
2.genertae data
3.plot data line
4.Linearize
-
Linear = mx+b
We need vectors for y and x, matlab finds m and b
-
For power model: y bx^m
log10(y)=m*log10(x)+log10(b)
b = 10^log_10*b
-
exponential: y=be^mx
lny= mx + ln(b)
b=e^ln(b)
%}
clc
clear
close all
%Part 1 - Plot data
t = [ 0.1, 1.4, 3.6, 4.9, 8.0 ]; % Time (t) [min]
P = [ 13800, 11100, 8900, 7300, 4000 ]; % Pressure (P) [Pa]
figure('color','w')
plot(t,P, 'red s', 'MarkerFaceColor', 'r')
grid on
%axis( )
xlabel('Time (t) [min]' )
ylabel('Pressure (P) [Pa]' )
%title( )
%legend( ) - not needed

%Part 1 - theoretical part - Linear model
%polyfit(x,y,n) where n is the power of the function
c = polyfit(t,P,1);
m = c(1);
b = c(2); 

x_pf = [0.1:0.1:8.0];
y_pf = m*x_pf + b;

hold on;

plot(x_pf,y_pf, 'g --', 'LineWidth',2);

%Trendline eq: P = -1.197E03*t + 1.3327
%Making the trendline equation string:
TE = sprintf('P = %.2f t + %0.2f ',m,b);

%Printing trendline to plot
text(4,12000,TE,'EdgeColor','b');
