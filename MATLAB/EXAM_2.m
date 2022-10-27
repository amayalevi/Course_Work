%ENGR 1250-001 Levi Amaya 08/06/2020
clc
clear
close all

Materials = {'Aluminum','Steel','Titanium';
                        2.8,    8.0,    4.62;%SG
                        6.968,2.685,7.024};%[$/kg]
                    
SG_water = 1000;%kg/m^3
                    
Diam = input('Enter the diameter of desired rod [in] : ');%in

L = input('Enter the length of desired rod [in] : ');%in

MC = menu('Enter the material you wish to have',Materials{1,:});

Diam_meters = Diam*(2.54/1)*(1/100);%m

L_meters=L*(2.54/1)*(1/100);%m

V =pi*(Diam_meters/2)^2*L_meters ;%[m^3]

rho_material = Materials{2,MC}*SG_water;%kg/m^3

Mass = V*rho_material;%kg

Cost = Mass*Materials{3,MC};

FName = input('Enter the user''s first name: ','s');

fprintf('\n%s chose a rod with diameter of %0.1f\ninches and a length of %0.1f inches made of\n%s. This will result in a total mass\nof %0.3f kg. The cost will be %0.2f.\n',FName,Diam,L,Materials{1,MC},Mass,Cost);

Vrod=[0.05,         0.1,         0.15,      0.2,       0.25,     0.3;%diamteter
           0.000713,0.00285,0.00641,0.0114,0.0178,0.0256];%cost
       
 figure('color','w');
 
 plot(Vrod(1,:),Vrod(2,:),'k o','MarkerSize',16,'MarkerFaceColor','k');
 
 grid on;
 
 axis([0 0.4 0 0.03]);
 
 xlabel('Diameter of Rods (D) [m]','FontSize',15,'FontWeight','bold');
 
 ylabel('Cost (C) [dollars]','FontSize',15,'FontWeight','bold');