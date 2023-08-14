clear all
close all
clc

%% Recording Audio

%Message 1: "The two met while playing on the sand."
%Message 2: "This is a grand season for hikes on the road.”

Fs=40000;%40 kHz
td=1/Fs;

% nBits=16;% Number of bits to represent each sample
% nChannels=1;%Mono Channel
% ID=-1;%Default audio input device
% recObj=audiorecorder(Fs,nBits,nChannels,ID);
% 
% disp('Start speaking first message for 4 seconds.');
% recordblocking(recObj,4);
% disp('End of Recording the first message.');
% myRecording=getaudiodata(recObj);
% m1=getaudiodata(recObj);
% filename='message1.wav';%Name the file
% audiowrite(filename,m1,Fs);
% play(recObj);
[m1,Fs]=audioread("message1.wav");%To use audio without recording again and again

% disp('Hit enter to record the second message.');
% pause
% disp('Start speaking second message for 4 seconds.');
% recordblocking(recObj,4);
% disp('End of Recording the second message.')
% myRecording=getaudiodata(recObj);
% m2=getaudiodata(recObj);
% filename='message2.wav';%Name the file
% audiowrite(filename,m2,Fs);
[m2,Fs]=audioread("message2.wav");%To use audio without recording again and again

n=size(m1,1);%Length of the message
t=(0:n-1)/Fs;%Total time in seconds
f=(-(n-1)/2:(n-1)/2)*(Fs/n);%Frequency range
fre_m1=fftshift(fft(m1,n));%Compute the Fourier Transform of message m1(y-axis)

n=size(m2,1);%Length of the message
t=(0:n-1)/Fs;%Total time in seconds
f=(-(n-1)/2:(n-1)/2)*(Fs/n);%Frequency range
fre_m2=fftshift(fft(m2,n));%Compute the Fourier Transform of message m2(y-axis)

figure(1)
subplot(211)
plot(t,m1)%Time domain
grid on
xlabel('Time - Second')
ylabel('Amplitude of Audio Signal')
ylim([-1.25 1.25])
title('(a)')
subplot(212)
plot(t,m2)%Time domain
grid on
xlabel('Time - Second')
ylabel('Amplitude of Audio Signal')
ylim([-1.25 1.25])
title('(b)')

figure(2)
subplot(211)
stem(f,abs(fre_m1)/n)%Frequency domain
grid on
xlabel('Frequency - Hz')
ylabel('Frequency Response of Audio Signal')
title('(a)')
subplot(212)
stem(f,abs(fre_m2)/n)%Frequency domain
grid on
xlabel('Frequency - Hz')
ylabel('Frequency Response of Audio Signal')
title('(b)')

%% QAM Modulation

fc=8000;% Carrier frequency
s_qam=m1.*cos(2*pi*fc*t')+m2.*sin(2*pi*fc*t');

%Use Spectrum Analyzer instead of Fourier Transform by FFt
% sa=dsp.SpectrumAnalyzer('SampleRate',Fs,'PlotAsTwoSidedSpectrum',true,'NumInputPorts',3,'ChannelNames',{'Message 1','Message 2','QAM'});
% sa(m1,m2,s_qam);
% release(sa);

%% Add Channel Noise 

% N=1e-6;%1 uW noise power
N=1e-3;%1 mW noise power
w=sqrt(N)*randn(size(s_qam));
s_qam=s_qam+w;%Noisy QAM signal

%% QAM Demodulation

x1=2*cos(2*pi*fc*t').*s_qam;
x2=2*sin(2*pi*fc*t').*s_qam;

%Employ LPF 1
f_cutoff=5000;%Cut off frequency greater than fm1=50 because we need to keep signal 1.
f_stop=7500;%Stop frequency smaller than fm2=150 because we need to get rid of signal 2.
lpfilt1=designfilt('lowpassfir','PassbandFrequency',f_cutoff,'StopbandFrequency',f_stop,'SampleRate',Fs);%Designing filter.
% fvtool(lpfilt1)%Display the filter 1.

%Employ LPF 2
f_cutoff=5000;%Cut off frequency greater than fm1=50 because we need to keep signal 1.
f_stop=7500;%Stop frequency smaller than fm2=150 because we need to get rid of signal 2.
lpfilt2=designfilt('lowpassfir','PassbandFrequency',f_cutoff,'StopbandFrequency',f_stop,'SampleRate',Fs);%Designing filter.
% fvtool(lpfilt2)%Display the filter 2.

mrec1=filter(lpfilt1,x1);%Gives us the recovered message 1
mrec2=filter(lpfilt2,x2);%Gives us the recovered message 2

n=length(m1);
f=(-(n-1)/2:(n-1)/2)*(Fs/n);%Generate discreate frequency vector
fre_m1=fftshift(fft(m1,n));%Compute the fourier transform.
fre_m2=fftshift(fft(m2,n));%Compute the fourier transform.
fre_mr1=fftshift(fft(mrec1,n));%Compute the fourier transform.
fre_mr2=fftshift(fft(mrec2,n));%Compute the fourier transform.

figure(3)
stem(f,abs(fre_m1)/n,'bo');
hold on
stem(f,abs(fre_mr1)/n,'ro');
legend('Original Message 1 Spectrum','Recovered Message 1 Spectrum')
xlabel('Frequency')
grid on

figure(4)
stem(f,abs(fre_m2)/n,'bo');
hold on
stem(f,abs(fre_mr2)/n,'ro');
legend('Original Message 2 Spectrum','Recovered Message 2 Spectrum')
xlabel('Frequency')
grid on

%Listen the Original Message and the Recovered Signal
%soundsc(m1,Fs);%Original Message 1
%soundsc(m2,Fs);%Original Message 2
%soundsc(mrec1,Fs);%Recovered Message 1
%soundsc(mrec2,Fs);%Recovered Message 2
