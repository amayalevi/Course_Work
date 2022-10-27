%{
ENGR 1250-001 Levi Amaya 07/30/2020

Problem Summary:

    Our engineering team has been asked by a local zoo to create a new viewing habitat for its baby elephants.
    Write a breakeven analysis program so they can compare the possible options.

Variables:

    Known:
    construction_materials = Cell Array containing the three different types of construction materials and all the details for each type (Concrete, Wood, and Adobe).
        column values:    Material | Thickness of Wall | Material Cost | Miscellaneous Construction Materials | Labor Cost |Number of Laborers | Number of Weeks of Construction
        column units:       Type | Inches [in] | Dollar per cubic foot [$/ft^3] | Dollar [$] | Dollar per per-week [$/(person week)] | (people) | (weeks)
    wall_SA = Total surface area of the walls in square feet [ft^2]

Unknown:

Fixed Cost variables:
    material                      = User chosen material between concrete, wood, or Adobe. The choice is stored as a integer from 1-3(It's assumed that a choice is made).
    wall_thickness           = User chosen wall thickness in inches [in]
    material_cost            = User chosen material cost in dollars per cubic foot [$/ft^3]
    miscellaneous_CM  = User chosen miscellaneous construction materials cost in dollars [$]
    labor_cost_FC         = User chosen labor cost(Construction/Fixed cost) in dollars per person for a week [$/person*week]
    laborers                     = User chosen Number of laborers as an integer quantity [people]
    construction_weeks = User chosen Number of weeks of construction as an integer quantity [weeks]
    fixed_cost                 = The total fixed cost of the construction in dollars [$]
    wall_volume              = The wall volume calculated in cubic feet [ft^3]

Variable cost variables:
    energy_cost             = User provided energy cost in dollars per week [$/week] 
    labor_cost_VC        = User provided labor cost(Operational/Variable cost) in dollars per week [$/week] 
    maintenance_cost  = User provided maintenance cost in dollars per week [$/week] 
    landfill_cost              = User provided landfill cost in dollars per week [$/week] 
    weeks_operation    = User provided number of weeks per year that the zoo will operate [weeks]
    years                        = User provided number of years for analysis(Only for years of operation) [years]

Revenue variables:
    admission_price = User provided price of admission in dollars per person [$/person]
    visitors                  = User provided number of people per week that will visit the zoo [people/week]
    donations             = User provided amount of expected donations in dollars per week [$/week]

Assumptions:
    A choice is made from the material selection menu.

%}

%Housekeeping
clear        %clears workspace
clc            %clears command window
close all   %clears open figures

%Initializing fixed cost variables:

%Initializing construction_materials with the material types and correspnding information:
%Type | [in] | [$/ft^3] | [$] | [$/(person week)] | (people) | (weeks)
construction_materials = {'Concrete',16, 30, 96000,   900, 5,   5; 
                                             'Wood',     23, 53, 115000, 800,12, 11;
                                             'Adobe',   18,  42, 68000,   600, 6,   5};
%Setting  material equal to the row number corresponding to the material chosen by the user:
material = menu('Please select a material : ',construction_materials{:,1});

%Setting surface area of the walls in square feet:
wall_SA = 3000; %[ft^2]

%Setting chosen wall thickness in inches:
wall_thickness = construction_materials{material,2};%[in]

%Converting wall thickness units from [in] -> [ft]
wall_thickness = wall_thickness*(1/12); %[ft]

%Setting chosen material cost in dollars per cubic foot:
material_cost = construction_materials{material,3};% [$/ft^3]

%Setting chosen Miscellaneous Construction Materials cost in dollars:
miscellaneous_CM = construction_materials{material,4};%[$]

%Setting chosen Labor Cost(Construction/Fixed Cost) in dollars per person for a week:
labor_cost_FC = construction_materials{material,5};%[$/person*week]

%Setting chosen Number of Laborers:
laborers = construction_materials{material,6};%[people]

%Setting chosen Number of weeks of construction: 
construction_weeks = construction_materials{material,7};%[weeks]

%Computing wall volume = (wall thickness)*(wall surface area)
wall_volume = wall_thickness*wall_SA;%[ft^3]

%Computing total fixed cost = [(Wall volume)*(Material cost)] + (Miscellaneous construction materials) + [(Labor cost)*(Number of Laborers)*(Number of weeks of construction)]
fixed_cost =((wall_volume)*(material_cost))+(miscellaneous_CM)+((labor_cost_FC)*(laborers)*(construction_weeks));%[$]

%Initializing variable cost variables:

%Setting user provided energy cost in dollars per week: 
energy_cost = input('Enter the weekly energy cost [$/week] : ');%[$/week] 

%Setting user provided labor cost(Operational/Variable cost) in dollars per week:
labor_cost_VC =  input('Enter the weekly labor cost [$/week] : ');%[$/week]  

%Setting user provided maintenance cost in dollars per week:
maintenance_cost = input('Enter the weekly maintenance cost [$/week] : ') ;%[$/week]  

%Setting user provided landfill cost in dollars per week:
landfill_cost = input('Enter the weekly landfill cost [$/week] : ');%[$/week]  

%Setting user provided number of weeks of operation:
weeks_operation =  input('Enter the number of weeks of operation : ');%[weeks] 

%Setting user provided number of years for analysis:
years =  input('Enter the number of years for analysis : ');%[years]

%Initializing revenue variables:

%Setting user provided price of admission in dollars per person:
admission_price =  input('Enter the admission price per person [$/person] : ');%[$/person] 

%Setting user provided number of people per week that will visit the zoo:
visitors = input('Enter the weekly number of people visiting the zoo : ');%[people/week]

%Setting user provided amount of expected donations in dollars per week :
donations =  input('Enter the weekly amount of expected donations  [$/week] : ');%[$/week]




