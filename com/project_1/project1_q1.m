clear all
close all
clc

%% Recording Audio

%Message: "Use a pencil to write the first draft.”

Fs=40000;%40 kHz
td=1/Fs;

% nBits=16;% Number of bits to represent each sample
% nChannels=1;%Mono Channel
% ID=-1;%Default audio input device
% recObj=audiorecorder(Fs,nBits,nChannels,ID);
% disp('Start speaking message for 4 seconds.');
% recordblocking(recObj,4);
% disp('End of Recording the message.');
% myRecording=getaudiodata(recObj);
% m=getaudiodata(recObj);
% filename='message.wav';%Name the file
% audiowrite(filename,m,Fs);
% play(recObj);
[m,Fs]=audioread("message.wav");%To use audio without recording again and again

n=size(m,1);%Length of the message
t=(0:n-1)/Fs;%Total time in seconds
f=(-(n-1)/2:(n-1)/2)*(Fs/n);%Frequency range
fre_m=fftshift(fft(m,n));%Compute the Fourier Transform of message m1(y-axis)

figure(1)
plot(t,m)%Time domain
grid on
xlabel('Time - Second')
ylabel('Amplitude of Audio Signal')

figure(2)
stem(f,abs(fre_m)/n)%Frequency domain
grid on
xlabel('Frequency - Hz')
ylabel('Frequency Response of Audio Signal')

%% Sampling

fs=4000;%Sampling rate.
ts=1/fs;%Sampling period
N=ts/td;%N should be an integer: Ts in theory.
m_out=downsample(m,N);%Down Sampling
m_out=upsample(m_out,N);%Up Sapmling

figure(3)
plot(t,m)
hold on
stem(t,m_out,'r')
grid on
xlim([0.75 0.76])
xlabel('Time')
legend('Original Singal','Sampled Signal','Location','southeast')

%Use Spectrum Analyzer instead of Fourier Transform by FFt
% sa=dsp.SpectrumAnalyzer('SampleRate',Fs,'PlotAsTwoSidedSpectrum',true,'NumInputPorts',2,'ChannelNames',{'Original Signal','Sampled Signal'});
% sa(m,m_out);
% release(sa);

%% Design LPF for Reconstruction

fre_mout=fftshift(fft(m_out,n));%Compute the Fourier Transform of sampled message m_out

f_cutoff=5000;%Cut off frequency greater than fm1=5 kHz because we need to keep signal 1.
f_stop=7500;%Stop frequency smaller than fm2=7.5 kHz because we need to get rid of signal 2.
lpfilt=designfilt('lowpassfir','PassbandFrequency',f_cutoff,'StopbandFrequency',f_stop,'SampleRate',Fs);%Designing filter.
%fvtool(lpfilt)%Display the filter.

m_rec=N*filter(lpfilt,m_out);%Gives us the recovered message

figure(4)
plot(t,m)
hold on
plot(t,m_rec)
grid on
% xlim([0.75 0.76])%To examine small interval
xlabel('Time - Second')
ylabel('Amplitude')
legend('Original Message','Recovered Message')

fre_mrec=fftshift(fft(m_rec,n));%Compute the fourier transform.

figure(5)
stem(f,abs(fre_m)/n,'b-s')
hold on
stem(f,abs(fre_mrec)/n,'r-o')
grid on
% xlim([-1e1 1e1])%To examine small interval
xlabel('Frequency - Hz')
ylabel('Frequency Response')
legend('Original Signal Spectrum','Sampled Signal Spectrum')

%Listen the Original Message and the Recovered Signal
%soundsc(m,Fs);%Original Message
%soundsc(m_out,Fs);%Recovered Message



