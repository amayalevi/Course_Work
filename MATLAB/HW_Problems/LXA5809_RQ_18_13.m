%{
ENGR 1250-001 Levi Amaya 08/14/2020

Problem Summary:
    Humans can see electromagnetic radiation when the wavelength is
    within the spectrum of visible light. Create a program to determine if
    a user-specified wavelength [nanometer, nm] is one of the six
    spectral colors listed in the following chart. 
    
    Your program should ask
    the user to enter a wavelength, then indicate in which spectral color
    the given wavelength falls or state if it is not within the visible
    spectrum.

Variables:
    Unknown:
        wavelength = User provided wavelength of "light" in nanometers [nm]

Assumptions:
    User input is valid.
    Where there is a value that's shared between two colors of spectral light, the higher range of 
    color includes that value and the lesser doesn't (For example, wavelength of 635nm falls under RED and not ORANGE).
%}
%Housekeeping
clc
clear
close all

%Initializing variables:
wavelength = input('Enter a wavelength in [nanometer, nm] : ');%[nm]

%Checking if the wavelength falls under the spectrum of visible light
if (wavelength >= 635 && wavelength <= 700)% If  635 < wavelength < 700
   fprintf('The wavelength is part of the RED spectrum of visible light.\n');%Display message
elseif (wavelength >= 590 && wavelength <= 635)% If  590 < wavelength < 635
   fprintf('The wavelength is part of the ORANGE spectrum of visible light.\n');%Display message
elseif (wavelength >= 560 && wavelength <= 590)% If  560 < wavelength < 590
   fprintf('The wavelength is part of the YELLOW spectrum of visible light.\n');%Display message
elseif (wavelength >= 490 && wavelength <= 560)% If  490 < wavelength < 560
   fprintf('The wavelength is part of the GREEN spectrum of visible light.\n');%Display message
elseif (wavelength >= 450 && wavelength <= 490)% If  450 < wavelength < 490
   fprintf('The wavelength is part of the BLUE spectrum of visible light.\n');%Display message
elseif (wavelength >= 400 && wavelength <= 450)% If  400 < wavelength < 450
   fprintf('The wavelength is part of the VIOLET spectrum of visible light.\n');%Display message
else%If none of the above apply to wavelength
    fprintf('The wavelength is not within the visible spectrum.\n');%Display message
end%Final answer