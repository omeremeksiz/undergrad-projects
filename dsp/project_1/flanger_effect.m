clear all
close all
clc

[data, Fs]=audioread("guitarClean.wav");%Importing guitarClean.wav file
%plot(data)%Plot of the guitarClean.wav file data
%soundsc(data,fs)%Listen to the guitarClean.wav audio

% Simple Flanger Effect
lfo_freq = 1/3;% LFO Freq (Hz)
lfo_amp = 0.004;% LFO Amp (sec)
lfo = 2+sawtooth(2*pi*lfo_freq*(1:length(data))/Fs,0.5); % Generate triangle wave
indedata = round((1:length(data))-Fs*lfo_amp*lfo);% Read-out indedata
indedata(indedata<1) = 1;% Clip delay
indedata(indedata>length(data)) = length(data);
y=data;% Input Signal
for j=1:length(data)% For each sample
  y(j) = y(j)+data(indedata(j));% Add delayed signal
end

%See the difference after filtering
subplot(2,1,1)
plot(data)
title("Original Audio Signal")
subplot(2,1,2)
plot(y)
title("Filtered Audio Signal")

%soundsc(y,Fs)%Observe flanger effect in output audio singal
audiowrite('flangereffect.wav',y,Fs);