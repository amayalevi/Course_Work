% Cell arrays - different types in 1 variable
% use { } to create it, { } to pull data, { } to combine cell arrayas
clear
clc
close all
% Longer example: student advising appt.
% Data for Cell Array
% 1st row, header: Name          Rank        Reg Cr.   F   S    Su     Major(s)     GPA    Tr    Credits
%2nd row, data : Tuesday Hall  Fresh         15 15  10                    BE Math    3.25               6

std_1 = {'Name',        'Rank', 'Reg Cr.: F S Su', 'Major(s)', 'GPA', 'Tr Credits';
                {'Tuesday','Hall'},  'Fresh', [15 15  10], 'BE Math',    3.25,               6}
            
% 1. What is the student's last name?
last_name = std_1{2,1}{2}   %compound statement

%2. Compute total credits for 12-months
credits = std_1{2,3};
total_credits = credits(1) + credits(2) + credits(3)    %yes sirrrr
% Or use sum()
credits = sum(credits)  %in this case sum(vector)

%3. Compute GPA as a percentage. Assume 4.0 scale.
gpa = std_1{2,5};

gpa_percentage = (gpa/4.00)*100 %Low B Average

%4. Remaining credit: degree plan(140 total)
trans_credits = std_1{2,6};

remaining_credits = 140 - (total_credits + trans_credits)

%done!
