%{

%}
clc
clear
close all
%Part 1
V = [ 19 27 40 57 64 ]; % x: Voltage (V) [mV]
curr = [0.05, 0.21, 3.2, 51, 230 ]; % y: Current (I) [A]
%
figure('color','w')
plot(V, curr , 'd k', 'MarkerFaceColor', 'k')
grid on
%axis( )
xlabel('Voltage (V) [mV]' )
ylabel('Current (I) [A] ]' )
%title( )
%legend( ) - not needed

%Part 2 - Theoretical part, exponential model
c = polyfit(V,log(curr),1);
m = c(1);
b = exp(c(2));

%y = be^(mx)
x_pf = [19:1:64];
y_pf = b*exp(m*x_pf);

hold on
plot(x_pf,y_pf,'g -.','LineWidth',2)

TE = sprintf('Current = %0.4f * e^{%0.3f}',b,m);
text(25,200,TE,'EdgeColor','g')