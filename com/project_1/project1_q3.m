clear all
close all
clc

%% Recording Audio

%Message: “We find joy in the simplest things.“

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
% filename='message3.wav';%Name the file
% audiowrite(filename,m,Fs);
% play(recObj);
[m,Fs]=audioread("message3.wav");%To use audio without recording again and again

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

%% USB Modulation

fc=8000;%Carrier frequency

s_dsb=m.*cos(2*pi*fc*t');% Implement DSB-SC
m_h=imag(hilbert(m));%Hilbert Transform, phase delay by -pi/2
s_usb=m.*cos(2*pi*fc*t')-m_h.*sin(2*pi*fc*t');%Implement USB Modulation

%Use Spectrum Analyzer instead of Fourier Transform by FFt
% sa=dsp.SpectrumAnalyzer('SampleRate',Fs,'PlotAsTwoSidedSpectrum',true,'NumInputPorts',3,'ChannelNames',{'Message Spectrum','DSB Spectrum','USB Spectrum'});
% sa(m,s_dsb,s_usb);
% release(sa);

%% Add Channel Noise 

% N=1e-6;%1 uW noise power
N=1e-3;%1 mW noise power
w=sqrt(N)*randn(size(s_usb));
s_usb=s_usb+w;%Noisy QAM signal

%% USB Demodulation
r=2*cos(2*pi*fc*t').*s_usb;
fre_r=fftshift(fft(r,n));%Compute the fourier transform.
figure(3)
subplot(211)
stem(f,abs(fre_r)/n,'bo');
xlabel('Frequency')
title('(a)')
grid on

%Employ LPF
f_cutoff=5000;%Cut off frequency greater than fm1=50 because we need to keep signal 1.
f_stop=7500;%Stop frequency smaller than fm2=150 because we need to get rid of signal 2.
lpfilt=designfilt('lowpassfir','PassbandFrequency',f_cutoff,'StopbandFrequency',f_stop,'SampleRate',Fs);%Designing filter.
% fvtool(lpfilt)%Display the filter.

m_rec=filter(lpfilt,r);%Gives us the recovered message
fre_mrec=fftshift(fft(m_rec,n));%Compute the fourier transform.

figure(3)
subplot(212)
stem(f,abs(fre_mrec)/n,'bo');
xlabel('Frequency')
title('(b)')
grid on

figure(4)
stem(f,abs(fre_m)/n,'bo');
hold on
stem(f,abs(fre_mrec)/n,'ro');
grid on
legend('Original Message Spectrum','Recovered Message Spectrum')
xlabel('Frequency')

%Listen the Original Message and the Recovered Signal
%soundsc(m,Fs);%Original Message
%soundsc(m_rec,Fs);%Recovered Message










