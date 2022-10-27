clear 
clc
close all
%{
Mass = 6;
Q = [24 52 60];
DT = [3 7 8];
Heat =[5:80];

Coef = polyfit(Q,DT,1);

m = Coef(1);
b = Coef(2);

Cp = 1/(m*Mass);

%​fprintf(​'The specific heat of this material is​ %.3f J/(kg ​K).\n'​,Cp);

DeltaT = m*Heat + b;

plot(Q,DT,'rd',Heat,DeltaT,'r-');
grid

Temperature = [15 20 25];
CarbonFilm = [10.050 10.048 10.045];
DopedSilicon = [10.15 9.85 9.48];

p = plot(Temperature, CarbonFilm,'o', Temperature,DopedSilicon,'x');
axis([14 26 9.4 10.2]);
legend('CF','DS')
grid

CarbonFilmFit = polyfit(Temperature,CarbonFilm,1);
fprintf('R = %0.4f + %0.4f*T\n\n',CarbonFilmFit(2),CarbonFilmFit(1))

DopedSiliconFit =polyfit(Temperature,DopedSilicon,1);
fprintf('R = %0.4f + %0.4f*T\n',DopedSiliconFit(2),DopedSiliconFit(1))

Temperature = [275 281 294 309 315];
DiodeA =[827 526 205 66 52];
DiodeB =[2125 1538 803 376 306];
DiodeC =[254 172 78 31 25];
plot(Temperature,DiodeA,'o',Temperature,DiodeB,'s',Temperature,DiodeC,'d');
axis([270 320 0 2250]);
grid
legend('A','B','C')
%polyfitting
Temperature = Temperature-275;
DiodeAFit = polyfit(Temperature,log(DiodeA),1);
fprintf('ID = %.0f*exp(%.3f*(T-275)) mA\n',exp(DiodeAFit(2)),DiodeAFit(1));

DiodeBFit = polyfit(Temperature,log(DiodeB),1);
fprintf('ID = %.0f*exp(%.3f*(T-275)) mA\n',exp(DiodeBFit(2)),DiodeBFit(1));

DiodeCFit = polyfit(Temperature,log(DiodeC),1);
fprintf('ID = %.0f*exp(%.3f*(T-275)) mA\n',exp(DiodeCFit(2)),DiodeCFit(1));

T =4;
A =-6;
if T/2>2
    A =A*-1;
else T/2<=2
    A =A+12;
end
%}

