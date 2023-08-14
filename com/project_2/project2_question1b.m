clear all
close all
clc

M=16;%M-ary number
EbN0dB_Vec=3:2:15;
W=1e6;%Chanell bandwidth
Rs=W;%Symbol rate -> Bandpass
Ts=1/Rs;%Symbol period

%% MPSK Implementation
k=log2(M);
Rb=k*Rs;%Bit rate
Tb=1/Rb;%Bit period

c=1;
while c<=length(EbN0dB_Vec)
    EbN0dB=EbN0dB_Vec(c);
    sim('com_week13_mpsk_sim.slx')
    Pb_sim_MPSK(c)=ErrorVec(1);%Simulated bit error probability
    EbN0=10^(EbN0dB/10);
    EsN0=k*EbN0;
    Ps_theo=2*qfunc(sqrt(2*EsN0)*sin(pi/M));%Probabilty of symbol error
    Pb_theo_MPSK(c)=Ps_theo/k;%Probability of bit error
    c=c+1
end

%% MQAM Implementation
L=log2(M);
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

%% MPSK/MQAM Eb/N0 vs Error Rate (BER) Plot
figure(1)
semilogy(EbN0dB_Vec,Pb_theo_MPSK(1,:),'b-o')
hold on
semilogy(EbN0dB_Vec,Pb_sim_MPSK(1,:),'r*')
semilogy(EbN0dB_Vec,Pb_theo_MQAM(1,:),'k-s')
semilogy(EbN0dB_Vec,Pb_sim_MQAM(1,:),'mx')
grid on
xlabel('E_b/N_0 in dB')
ylabel('Bit Error Rate(BER)')
title('MPAM/MQAM - Eb/N0 vs Error Rate (BER) Curve')
legend('16PSK - Theo.','16PSK - Sim','16QAM - Theo.','16QAM - Sim',Location='southwest')