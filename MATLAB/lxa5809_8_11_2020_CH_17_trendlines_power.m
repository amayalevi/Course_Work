%{
%}
clc
clear
close all
%Part 1 : plot data - experimental
V = [ 0.7 1.4 3.6 4.9 8.0 ]; % Volume (V) [m^3]
SG = [ 0.0081, 0.0039, 0.0014, 0.00099, 0.00052 ]; % specific gravity (SG) [ - ]
figure('color','w')
plot(V, SG , 'o b', 'MarkerFaceColor', 'blue')
grid on
%axis( )
xlabel('Volume (V) [m^3]' )
ylabel('specific gravity (SG) [ - ]' )
%title( )
%legend( ) - not needed
%part 2, theoretical part, trendline power
c = polyfit(log10(V),log10(SG),1)
%y=b*x^m
m = c(1);
b = 10^c(2);

%trendline
x_pf = [0.7:0.1:8.0];
y_pf = b*x_pf.^m;

%plotting
hold on
plot(x_pf,y_pf,'- r','LineWidth',2);

%Adding text, ^{} for superscript
TE = sprintf('SG = %0.1E *V^{%0.0f} ',b,m);%SG = 0.0056*V^-1
text(3,7E-03,TE,'EdgeColor','k')