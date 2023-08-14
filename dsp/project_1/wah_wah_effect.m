clear all
close all
clc

[data, Fs]=audioread("guitarClean.wav");%Importing guitarClean.wav file
%plot(data)%Plot of the guitarClean.wav file data
%soundsc(data,fs)%Listen to the guitarClean.wav audio

% Simple Wah Effect
lfo_freq = 1;
lfo_min = 200;
lfo_max = 2000;
lfo = sawtooth(2*pi*lfo_freq*(1:length(data))/Fs,0.5);
lfo = 0.5*(lfo_max-lfo_min)*lfo+(lfo_min+lfo_max)/2;  % Shift/Scale Triangle wave
depth = 2;
y = zeros(1,length(data));
for j=3:length(data)
  [b,a] = iirpeak(2*lfo(j)/Fs,2*lfo(j)/Fs/depth);
  y(j) = b(1)*data(j)+b(2)*data(j-1)+b(3)*data(j-2)-a(2)*y(j-1)-a(3)*y(j-2);
end

%See the difference after filtering
subplot(2,1,1)
plot(data)
title("Original Audio Signal")
subplot(2,1,2)
plot(y)
title("Filtered Audio Signal")
%soundsc(y,Fs)%Observe wah wah effect in output audio singal
audiowrite('wahwaheffect.wav',y,Fs);