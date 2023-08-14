clear all
close all
clc

M=16;%M-ary number
EbN0dB_Vec=3:2:15;
W=1e6;%chanell bandwidth -> 1 MHz
Rs=W;%Symbol rate -> Bandpass
Ts=1/Rs;%Symbol period

%% MPAM Implementation
L=log2(M);
Rb=L*Rs;%Bit rate -> 4MHz
Tb=1/Rb;%Bit period
c=1;
while c<=length(EbN0dB_Vec)
    EbN0dB=EbN0dB_Vec(c);
    sim('com_week12_mpam_sim.slx')
    Pb_sim_MPAM(c)=ErrorVec(1);%Simulated bit error probability
    EbN0=10^(EbN0dB/10);
    Ps=(2*(M-1)/M)*qfunc(sqrt((6*log2(M)/((M^2)-1))*EbN0));%Probabilty of symbol error
    Pb_theo_MPAM(c)=Ps/log2(M);%Probability of bit error
    c=c+1;
end
%% MQAM Implementation
m=sqrt(M);% Used for Pb of m-PAM 
b=1;
while b<=length(EbN0dB_Vec)
    EbN0dB=EbN0dB_Vec(b);
    sim('com_week12_mqam_sim.slx')
    Pb_sim_MQAM(b)=ErrorVec(1)
    EbN0=10^(EbN0dB/10);
    Ps=(2*(m-1)/m)*qfunc(sqrt((6*log2(m)/((m^2)-1))*EbN0));%Probabilty of symbol error
    Pb_theo_MQAM(b)=Ps/log2(m);%Probability of bit error
    b=b+1;
end

%% MPAM/MQAM Eb/N0 vs Error Rate (BER) Plot
figure(1)
semilogy(EbN0dB_Vec,Pb_theo_MPAM(1,:),'b-o')
hold on
semilogy(EbN0dB_Vec,Pb_sim_MPAM(1,:),'r*')
semilogy(EbN0dB_Vec,Pb_theo_MQAM(1,:),'k-s')
semilogy(EbN0dB_Vec,Pb_sim_MQAM(1,:),'mx')
grid on
xlabel('E_b/N_0 in dB')
ylabel('Bit Error Rate(BER)')
title('MPAM/MQAM - Eb/N0 vs Error Rate (BER) Curve')
legend('16PAM - Theo.','16PAM - Sim','16-QAM - Theo.','16-QAM - Sim',Location='southwest')


