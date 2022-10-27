%{
Drew Reiter and Levi Amaya ENGR-1250-001 07/28/20

Problem Statement: Create a program that allows the user to analyze the return on
investment for different materials selected for a new elephant enclosure wall, considering
all cost and revenue.

Variables:
SA - surface area of the enclosure wall [ft^2]
T - thickness of the enclosure wall [ft]
V - volume of the enclosure wall [ft^3]
Fc - fixed cost [$]
Ec - energy cost [$/week]
Lc - operational labor cost [$/week]
Mc - maintenance cost [$/week]
LFc - landfill cost [$/week]
Wy - number of operating weeks per year [weeks]
Y - number of years for analysis [years]
Ap - admission price per person [$/person]
Npw - number of people visiting per week [persons]
Dw - expected donations per week [$/week]
Vcw - variable cost per week [$/week]
Tcy - total cost each year [$] 
Ry - revenue each year [$]
Py - profit each year [$] 
BE - breakeven point [months]

Assumptions:
User selects a material from the menu.
User inputs are valid quantities.
%}

clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%Set input variables and constants
SA=3000;%[ft^2]

%Create material data cell array
mat={'Concrete',16,30,96000,900,5,5;'Wood',23,53,115000,800,12,11;'Adobe',18,42,68000,600,6,5};

%Prompt user to select material from menu
selection=menu('Select material:',mat{:,1});

%Convert thickness of wall from [in] to [ft]
T=mat{selection,2}/12;

%Calculate volume of wall in [ft^3]
V=SA*T;

%Calculate total fixed cost = [(Wall volume)*(Material cost)] + (Miscellaneous construction materials) + [(Labor cost)*(Number of Laborers)*(Number of weeks of construction)]
Fc=V*mat{selection,3}+mat{selection,4}+mat{selection,5}*mat{selection,6}*mat{selection,7};%[$]

%Prompt user to input operational (variable) cost info
Ec=input('(Operational Costs and Schedule)\nEnergy cost [$/week]: ');
Lc=input('Labor cost [$/week}: ');
Mc=input('Maintenance cost [$/week]: ');
LFc=input('Landfill cost [$/week]: ');
Wy=input('Number of operating weeks per year: ');
Y=input('Number of years for analysis: ');

%Prompt user to input revenue info
Ap=input('\n(Anticipated Public Interest and Donations)\nPrice of admission per person [$/person]: ');
Npw=input('Number of people visiting per week: ');
Dw=input('Expected donations per week [$/week]: ');

%Calculate total variable cost per week =(Energy + Labor + Maintenance + Landfill )
Vcw=Ec+Lc+Mc+LFc;%[$/week]

%Calculate total operating cost each year = (weekly variable costs)*(operation weeks)*[amount of years]
Ocy=Vcw*Wy*[0:Y];

%Calculate total revenue each year = (admission price)*(weekly visitors)*(weeks of operation)*[amount of years] + (weekly donations)*(weeks of operations)*[amount of years]
Ry=Ap*Npw*Wy*[0:Y]+Dw*Wy*[0:Y];

%Calculate total profit each year = (yearly revenue) - (yearly operational costs) - (fixed cost)
Py=Ry-Ocy-Fc;

%Calculate breakeven point [years] = (fixed cost)/(yearly revenue - yearly variable cost)
BE=Fc/(Ap*Npw*Wy+Dw*Wy-Vcw*Wy);

%Convert breakeven point from [years] to [months]
BE=BE*12;

%Calculate breakeven revenue for plotting = (weekly revenue)*(break even years)
Ry_BE=(Ap*Npw*Wy+Dw*Wy)*(BE/12);

%Calculate one-time donation amount required to breakeven in 7 months = (yearly costs)*(7/12) - (yearly revenue)*(7/12)
D=Fc+Vcw*Wy*(7/12)-Ap*Npw*Wy*(7/12);

%Display summary of calculation results
fprintf(['\nMaterial: %s \n\tOperating %0.0f weeks per year will generate per year:',... 
    '\n\t\tRevenue:\t$%0.0f',...
    '\n\t\tCost:\t\t$%0.0f',...
    '\n\tThe breakeven time is %0.2f months',...
    '\n\tThe total profit after %0.0f years is $%0.3e.\n'],mat{selection},Wy,Ry(2),Ocy(2),BE,Y,Py(Y))

%Display calculated one-time donation amount
fprintf('\nIt will take a one-time donation of $%0.2f to breakeven in 7 months.\n',D)

%Plot graph of revenue and total cost vs number of years for analysis
figure('Color','white')
plot( [0:Y],Ocy+Fc,[0:Y],Ry)
hold on
plot(BE/12,Ry_BE,'.k','MarkerSize',25)
title(['Breakeven Anaylsis of ',mat{selection},' Enclosure'])
legend('Total Cost','Revenue','Breakeven Point','Location','northwest')
xlabel('Operating Years (Y) [years]')
ylabel('Total Cost (Tc) [$] or Revenue (R) [$]')
grid on

%Plot graph of revenue with respect to years
figure('Color','white')
plot([0:Y],Py)
hold on
plot(BE/12,0,'.k','MarkerSize',25)
title(['Yearly Profit Anaylsis of ',mat{selection},' Enclosure'])
legend('Profit','Breakeven Point','Location','northwest')
xlabel('Operating Years (Y) [years]')
ylabel('Profit (P) [$]')
grid on