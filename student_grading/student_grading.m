clear;clc;
students_data=readmatrix('Exams_table.txt');


for i=1:1:length(students_data)
    r_exam1=students_data(i,2).*0.25;
    r_exam2=students_data(i,3).*0.20;
    r_lab=students_data(i,4).*0.15;
    r_final=students_data(i,5).*0.40;
    total_grades(i)=round(r_exam1+r_exam2+r_lab+r_final);
end
total_grades=total_grades';

ff_counter=0;
ff_note_toplam=0;
for i=1:length(students_data)
    if students_data(i,4)<10
        ff_note_toplam=ff_note_toplam+total_grades(i);
        ff_counter=ff_counter+1;
    elseif students_data(i,4)>=10 && students_data(i,5)<35
        ff_note_toplam=ff_note_toplam+total_grades(i);
        ff_counter=ff_counter+1;
    end
end


arithmetic_mean=(sum(total_grades)-ff_note_toplam)./(length(students_data)-ff_counter);


ort_dahil_ind=find(students_data(:,4)>=10 & students_data(:,5)>=35);
total_variance=0;
for j=1:(length(students_data)-ff_counter)
    
    variance=((total_grades(ort_dahil_ind(j))-arithmetic_mean).^2);
    total_variance=total_variance+variance;
end
standart_deviation=(total_variance./((length(students_data)-ff_counter)-1)).^0.5;


CC=arithmetic_mean;


numberof_AA=0;
numberof_BA=0;
numberof_BB=0;
numberof_CB=0;
numberof_CC=0;
numberof_DC=0;
numberof_DD=0;
numberof_FD=0;
numberof_FF=ff_counter;
for k=1:(length(students_data)-ff_counter)
if total_grades(ort_dahil_ind(k))>=CC+standart_deviation*2
    numberof_AA=numberof_AA+1;
elseif total_grades(ort_dahil_ind(k))>=CC+standart_deviation*1.5
    numberof_BA=numberof_BA+1;
elseif total_grades(ort_dahil_ind(k))>=CC+standart_deviation*1
    numberof_BB=numberof_BB+1;
elseif total_grades(ort_dahil_ind(k))>=CC+standart_deviation/2
    numberof_CB=numberof_CB+1;
elseif total_grades(ort_dahil_ind(k))>=CC
    numberof_CC=numberof_CC+1;
elseif total_grades(ort_dahil_ind(k))>=CC-standart_deviation/2  
    numberof_DC=numberof_DC+1;
elseif total_grades(ort_dahil_ind(k))>=CC-standart_deviation*1
    numberof_DD=numberof_DD+1;
elseif total_grades(ort_dahil_ind(k))>=CC-standart_deviation*1.5
    numberof_FD=numberof_FD+1;
else 
    numberof_FF=numberof_FF+1;
end
end

% OVERALL GRADE DİSTRİBUTİON
success_students=numberof_AA+numberof_BA+numberof_BB+numberof_CB+numberof_CC+numberof_DC+numberof_DD+numberof_FD;
failed_students=numberof_FF;


inp=0;
cont=1;
while cont
    data_type=input('Please Enter 1 For Overall Grade Distribution or Enter 2 For Grade Information:','s');
    data_type=str2num(data_type);
    if data_type==1
        disp('You have selected Overall Grade Distribution')
        disp('Please wait, this process may take a while...')
        inp=1;
        cont=0;
        break
    elseif data_type==2
        disp('You have selected Grade Information for an Individual')
        disp('Please wait, this process may take a while...')
        inp=2;
        cont=0;
        break
    else 
        disp('You Entered Invalid Inputs Please Try Again...')
        continue
    end   
end


if inp==1
    fid=fopen('class_info.txt','wt');
    fprintf(fid,'Number of Received AA Letter Grade: %.0f \n',numberof_AA);
    fprintf(fid,'Number of Received BA Letter Grade: %.0f \n',numberof_BA);
    fprintf(fid,'Number of Received BB Letter Grade: %.0f \n',numberof_BB);
    fprintf(fid,'Number of Received CB Letter Grade: %.0f \n',numberof_CB);
    fprintf(fid,'Number of Received CC Letter Grade: %.0f \n',numberof_CC);
    fprintf(fid,'Number of Received DC Letter Grade: %.0f \n',numberof_DC);
    fprintf(fid,'Number of Received DD Letter Grade: %.0f \n',numberof_DD);
    fprintf(fid,'Number of Received FD Letter Grade: %.0f \n',numberof_FD);
    fprintf(fid,'Number of Received FF Letter Grade: %.0f \n',numberof_FF);
    fprintf(fid,' \n');
    fprintf(fid,'Number of Failed Students: %.0f \n',failed_students);
    fprintf(fid,'Number of Successful Students: %.0f \n',success_students);
    system('notepad class_info.txt');
    
    % PİE CHART of Letter Grades Disribution
    letter_grades_dis=[numberof_AA,numberof_BA,numberof_BB,numberof_CB,numberof_CC,numberof_DC,numberof_DD,numberof_FD,numberof_FF];
    subplot(2,2,1)
    pie(letter_grades_dis,{'AA','BA','BB','BC','CC','DC','DD','FD','FF'});
    title('Pie Chart of Letter Grades');
    % Histograms of Letter Grades Distribution
    subplot(2,2,2)
     hold on
        histogram(total_grades,[0,CC-standart_deviation*1.5-0.001]) 
        histogram(total_grades,[CC-standart_deviation*1.5,CC-standart_deviation*1-0.001]) 
        histogram(total_grades,[CC-standart_deviation*1,CC-standart_deviation/2-0.001]) 
        histogram(total_grades,[CC-standart_deviation/2,CC-0.001])
        histogram(total_grades,[CC,CC+standart_deviation/2-0.001])
        histogram(total_grades,[CC+standart_deviation/2,CC+standart_deviation*1])
        histogram(total_grades,[CC+standart_deviation*1,CC+standart_deviation*1.5])
        histogram(total_grades,[CC+standart_deviation*1.5,CC+standart_deviation*2-0.001])
        histogram(total_grades,[CC+standart_deviation*2,100.1])
    title('Histogram of Grades Distribuiton')
    subplot(2,2,[3,4])
    bar(1:104,total_grades);
    title('Bar Graph of Grades Distribution')
    hold on
    plot(xlim,[arithmetic_mean arithmetic_mean],'r')
elseif inp==2
     while true
         disp('Press -1 to Exit the Program...')
        student_ID=input('Please Enter Your ID Number:','s');
        student_ID=str2num(student_ID);

        
        if student_ID==-1
            disp('You Quit the Program...')
            break
        end
        
        indices=find(students_data(:,1)==student_ID);
        if length(indices)~=0
            if students_data(indices,4)<10 || students_data(indices,5)<35
                letterGrade_student='FF';
            elseif total_grades(indices)>=CC+standart_deviation*2
                letterGrade_student='AA';
            elseif total_grades(indices)>=CC+standart_deviation*1.5
                letterGrade_student='BA';
            elseif total_grades(indices)>=CC+standart_deviation*1
                letterGrade_student='BB';
            elseif total_grades(indices)>=CC+standart_deviation/2
                letterGrade_student='CB';
            elseif total_grades(indices)>=CC
                letterGrade_student='CC';
            elseif total_grades(indices)>=CC-standart_deviation/2
                letterGrade_student='DC';
            elseif total_grades(indices)>=CC-standart_deviation*1
                letterGrade_student='DD';
            elseif total_grades(indices)>=CC-standart_deviation*1.5
                letterGrade_student='FD';
            else 
                letterGrade_student='FF';
            end

            
%             VALID STUDENT'S ID

             student_ID=num2str(student_ID);
             textName=[student_ID,'.txt']; 
             % open a file for writing
             file_ID = fopen(textName, 'wt'); % 
             fprintf(file_ID,'Each Exam Grade for Student Number %8.0f \n',str2num(student_ID));
             fprintf(file_ID,'Letter Grade : %s \n',letterGrade_student);
             fprintf(file_ID,'Exam 1 Grade: %.0f Exam 2 Grade: %.0f Lab Grade: %.0f Final Exam Grade: %.0f   Total Grade: %.0f Average Mean of Class: %.0f \n',[students_data(indices,[2:5]),total_grades(indices),arithmetic_mean]);
             disp('You can access the your outputs in the text file named the student number you entered.')
        else
            disp('The Number You Entered is Not in the List, Try Again...')
             
        end
     end
end