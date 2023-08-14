clear all
close all
clc

%% MFSK Implementation

W=[1e4,(1e4)/2,(1e4)/3];%Chanell bandwidth to make Data Rate -> 10kbps

M_Vec=[2 4 8];
EbN0dB_Vec=2:10;

c=1;
while c<=length(M_Vec)
    M=M_Vec(c);%M-ary number
    Rs=W(c);%Symbol rate -> Bandpass
    Ts=1/Rs;%Symbol period
    k=log2(M);
    Rb=k*Rs;%Bit rate -> Data rate
    Tb=1/Rb;%Bit period

    b=1;
    while b<=length(EbN0dB_Vec)
        EbN0dB=EbN0dB_Vec(b);
        sim('com_week13_mfsk_sim.slx')
        % Simulated Bit Error Probability-display(ErrorVec(1)) & Theoretical Bit Error Probability-display(Pb);
        Pb_sim_MFSK(c,b)=ErrorVec(1);%Simulated bit error probability
        EbN0=10^(EbN0dB/10);
        EsN0=k*EbN0;
        Ps_theo=((M-1)/2)*exp(-EsN0/2);%Probabilty of symbol error
        Pb_theo_MFSK(c,b)=((M/2)/(M-1))*Ps_theo;%Probability of bit error
        b=b+1;
    end

    c=c+1;
end
%% MFSK Eb/N0 vs Error Rate (BER) Plot
figure(1)
semilogy(EbN0dB_Vec,Pb_theo_MFSK(1,:),'b-o')
hold on
semilogy(EbN0dB_Vec,Pb_theo_MFSK(2,:),'k-s')
semilogy(EbN0dB_Vec,Pb_theo_MFSK(3,:),'m-v')
semilogy(EbN0dB_Vec,Pb_sim_MFSK(1,:),'r*')
semilogy(EbN0dB_Vec,Pb_sim_MFSK(2,:),'rx')
semilogy(EbN0dB_Vec,Pb_sim_MFSK(3,:),'r+')
xlabel('E_b/N_0 in dB')
ylabel('Bit Error Rate(BER)')
title('MFSK - Eb/N0 vs Error Rate (BER) Curve')
legend('BFSK Simulated BER.', 'BFSK Theoritical BER.','4FSK Simulated BER.', '4FSK Theoritical BER.','8FSK Simulated BER.', '8FSK Theoritical BER.',Location='southwest')

