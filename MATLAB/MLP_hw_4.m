clc
clear
close all

Words={'The','red','bee'};

Nums = {10,23;-10,-5};

Alphabet{1}='a':'z';

Nums(1,1);
Nums{1,2}= 'BOGUS';

%7e
Stuff = {[1 3 5;2 8 4],'Goofball',{41}};

R = Stuff{3}{1}/18;

%f
Stuff{2}(2:5)=[];

%g
Prod = Stuff{1}(1,:).*Stuff{1}(2,:);

%8
RCData = {'R [ohms]' 'C [farads]' 'Initial Vc' 'Final Vc'};

RCData{1,5} = 'Time Required';

%RCData{2,5} = ;

%13
Type = input('This', 's');
%14
clc
clear
close all

MCost=300;% machine cost in​ dollars/day 
WRate=35;% widgets​ produced/day 
OCost= 10000;​% operating cost in​ dollars/day 
WPrice 48.62​;​%%sales price in​ dollars/widget 
Days = 70​;	​% number of days the machine operates 
WName​'Sonic ​Pliers';​% name of the widget produced 

TCost = MCost+​OCost; 
​fprintf(​'Total Cost per​ Day: ​$%0.2f\n'​,TCost) 
NumW=WRate*​Days; 
​fprintf(​'A total of​ %.0f %s was produced in​ %0.0f ​days.\n'​,NumW,WName,Days) 
Income=NumW*​WPrice; 
​fprintf(​'These will sell at​ $%0.2f each for a total of ​$%0.0f.\n'​,WPrice,Income) 
​fprintf(​'This will make a profit of ​$%0.2f.\n'​,Income-TCost*​Days) 




