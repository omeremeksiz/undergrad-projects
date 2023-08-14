clear;clc;
student_numbers=[20200001:1:20200104]';
exam_notes(:,[2:5]) = round(0+(100-0).*rand(104,4));
exam_notes(:,1)=student_numbers;
writematrix(exam_notes,'Exams_table.txt')


