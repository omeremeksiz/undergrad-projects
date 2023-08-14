function varargout = audioEqualizer(varargin)
% AUDIOEQUALIZER MATLAB code for audioEqualizer.fig
%      AUDIOEQUALIZER, by itself, creates a new AUDIOEQUALIZER or raises the existing
%      singleton*.
%
%      H = AUDIOEQUALIZER returns the handle to a new AUDIOEQUALIZER or the handle to
%      the existing singleton*.
%
%      AUDIOEQUALIZER('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in AUDIOEQUALIZER.M with the given input arguments.
%
%      AUDIOEQUALIZER('Property','Value',...) creates a new AUDIOEQUALIZER or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before audioEqualizer_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to audioEqualizer_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help audioEqualizer

% Last Modified by GUIDE v2.5 07-Jun-2023 23:42:50

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @audioEqualizer_OpeningFcn, ...
                   'gui_OutputFcn',  @audioEqualizer_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before audioEqualizer is made visible.
function audioEqualizer_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to audioEqualizer (see VARARGIN)

% Choose default command line output for audioEqualizer
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes audioEqualizer wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = audioEqualizer_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% GUI Implementation Functions %

%% Record & Load Panels 
% --- Executes on button press in find.
function find_Callback(hObject, eventdata, handles)
% hObject    handle to find (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
[filename,pathname]=uigetfile({'*.wav'},'File Selector');%Search to find .wav files
handles.fullpathname=strcat(pathname,filename);%Concatenate pathname and file name as an fullpathname
set(handles.loadPath,'String',handles.fullpathname);%Set fullpathname to load panel static text so that user can see
guidata(hObject,handles)

% --- Executes on button press in record.
function record_Callback(hObject, eventdata, handles)
% hObject    handle to record (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
%% Record and Save Audio
set(handles.light,'BackgroundColor','red');%Turn on red light to indicate recording is started
Fs=44100;%Sampling frequency -> 44.1kHz
td=1/Fs;%Sampling period
nBits=16;% Number of bits to represent each sample
nChannels=1;%Mono Channel
ID=-1;%Default audio input device
recObj=audiorecorder(Fs,nBits,nChannels,ID);
recordblocking(recObj,5);
m=getaudiodata(recObj);
filename=get(handles.recordPath,'String');%Name the file
audiowrite(filename,m,Fs);
set(handles.light,'BackgroundColor','green');%Turn on green light to indicate recording is stopped

guidata(hObject,handles)

% --- Executes on button press in listenRecord.
function listenRecord_Callback(hObject, eventdata, handles)
% hObject    handle to listenRecord (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
set(handles.light,'BackgroundColor','white');%Turn on white light to indicate not recording
filename=get(handles.recordPath,'String');%Get filename from record panel edit text box
[m,Fs]=audioread(filename);%To use audio without recording again and again
soundsc(m,Fs);%To listen recorded audio
guidata(hObject,handles)

% --- Executes on button press in listenLoad.
function listenLoad_Callback(hObject, eventdata, handles)
% hObject    handle to listenLoad (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
filename=get(handles.loadPath,'String');%Get filename from load panel static text box
[m,Fs]=audioread(filename);%To use audio without recording again and again
soundsc(m,Fs);%To listen loaded audio
guidata(hObject,handles)

function recordPath_Callback(hObject, eventdata, handles)
% hObject    handle to recordPath (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of recordPath as text
%        str2double(get(hObject,'String')) returns contents of recordPath as a double


% --- Executes during object creation, after setting all properties.
function recordPath_CreateFcn(hObject, eventdata, handles)
% hObject    handle to recordPath (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end
%% Record & Load Panels

%% Sliders
% --- Executes on slider movement.
function slider2_Callback(hObject, eventdata, handles)
% hObject    handle to slider2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider


% --- Executes during object creation, after setting all properties.
function slider2_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slider2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background.
if isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor',[.9 .9 .9]);
end


% --- Executes on slider movement.
function slider4_Callback(hObject, eventdata, handles)
% hObject    handle to slider4 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider


% --- Executes during object creation, after setting all properties.
function slider4_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slider4 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called


% --- Executes on slider movement.
function slider3_Callback(hObject, eventdata, handles)
% hObject    handle to slider3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider


% --- Executes during object creation, after setting all properties.
function slider3_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slider3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background.
if isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor',[.9 .9 .9]);
end

% --- Executes on slider movement.
function slider17_Callback(hObject, eventdata, handles)
% hObject    handle to slider7 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider


% --- Executes during object creation, after setting all properties.
function slider17_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slider7 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background.
if isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor',[.9 .9 .9]);
end


% --- Executes on slider movement.
function slider1_Callback(hObject, eventdata, handles)
% hObject    handle to slider1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider


% --- Executes during object creation, after setting all properties.
function slider1_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slider1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background.
if isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor',[.9 .9 .9]);
end


% --- Executes on slider movement.
function slider5_Callback(hObject, eventdata, handles)
% hObject    handle to slider5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider


% --- Executes during object creation, after setting all properties.
function slider5_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slider5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background.
if isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor',[.9 .9 .9]);
end


% --- Executes on slider movement.
function slider6_Callback(hObject, eventdata, handles)
% hObject    handle to slider6 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider


% --- Executes during object creation, after setting all properties.
function slider6_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slider6 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background.
if isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor',[.9 .9 .9]);
end

%% Sliders

%% Control & Save Panels
function listen(hObject, handles)
global player;
[handles.y,handles.Fs] = audioread(handles.fullpathname);
handles.Volume=get(handles.slider17,'value');%Get value from volume slider
handles.g1=get(handles.slider1,'value');%Get value from 20-60Hz slider
handles.g2=get(handles.slider2,'value');%Get value from 60-200Hz slider
handles.g3=get(handles.slider3,'value');%Get value from 200-600Hz slider
handles.g4=get(handles.slider4,'value');%Get value from 600-3000Hz slider
handles.g5=get(handles.slider5,'value');%Get value from 3-8kHz slider
handles.g6=get(handles.slider6,'value');%Get value from >8kHz slider
set(handles.text23, 'String',handles.g1);%Set db value of 20-60Hz box 
set(handles.text25, 'String',handles.g2);%Set db value of 60-200Hz box
set(handles.text34, 'String',handles.g3);%Set db value of 200-600Hz box
set(handles.text41, 'String',handles.g4);%Set db value of 600-3000Hz box
set(handles.text42, 'String',handles.g5);%Set db value of 3-8kHz box
set(handles.text43, 'String',handles.g6);%Set db value of >8kHz box

%Low Pass Filter
% cut_off=200;
% orde=16;
% a=fir1(orde,cut_off/(handles.Fs/2),'low');
% y1=handles.g1*filter(a,1,handles.y);

orde=16;

%20-60Hz
f1=20;
f2=60;
b1=fir1(orde,[f1/(handles.Fs/2) f2/(handles.Fs/2)],'bandpass');
y1=handles.g1*filter(b1,1,handles.y);

%60-200Hz
f3=60;
f4=200;
b2=fir1(orde,[f3/(handles.Fs/2) f4/(handles.Fs/2)],'bandpass');
y2=handles.g2*filter(b2,1,handles.y);

%200-600Hz
f5=200;
f6=600;
b3=fir1(orde,[f5/(handles.Fs/2) f6/(handles.Fs/2)],'bandpass');
y3=handles.g3*filter(b3,1,handles.y);

%600-3000Hz
f7=600;
f8=3000;
b4=fir1(orde,[f7/(handles.Fs/2) f8/(handles.Fs/2)],'bandpass');
y4=handles.g4*filter(b4,1,handles.y);

%3-8kHz
f9=3000;
f10=8000;
b5=fir1(orde,[f9/(handles.Fs/2) f10/(handles.Fs/2)],'bandpass');
y5=handles.g5*filter(b5,1,handles.y);

%>8kHz
cut_off2=8000;
c=fir1(orde,cut_off2/(handles.Fs/2),'high');
y6=handles.g6*filter(c,1,handles.y);

handles.yT=y1+y2+y3+y4+y5+y6;
player = audioplayer(handles.Volume*handles.yT, handles.Fs);
player.UserData=handles.Volume*handles.yT;

n=size(handles.y,1);%Length of the message
t=(0:n-1)/handles.Fs;%Total time in seconds
f=(-(n-1)/2:(n-1)/2)*(handles.Fs/n);%Frequency range
fre_m=fftshift(fft(handles.y,n));%Compute the Fourier Transform of message m1(y-axis)
fre_mout=fftshift(fft(handles.Volume*handles.yT,n));%Compute the Fourier Transform of message m1(y-axis)

subplot(2,1,1);
stem(f,abs(fre_m)/n,'b-s')
grid on
xlabel('Frequency - Hz')
ylabel('Frequency Response')
subplot(2,1,2);
stem(f,abs(fre_mout)/n,'r-o')
grid on
xlabel('Frequency - Hz')
ylabel('Frequency Response')

% subplot(2,1,1);
% plot(handles.y);%Original audio
% xlabel('Time')
% ylabel('Amplitude')
% subplot(2,1,2);
% plot(handles.yT);%Adjusted audio
% xlabel('Time')
% ylabel('Amplitude')

guidata(hObject,handles)

% --- Executes on button press in listenControl.
function listenControl_Callback(hObject, eventdata, handles)
% hObject    handle to listenControl (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global player;
global cond;
cond=true;
listen(hObject, handles); 
play(player);
guidata(hObject,handles)


% --- Executes on button press in pauseControl.
function pauseControl_Callback(hObject, eventdata, handles)
% hObject    handle to pauseControl (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global player;
global cond;
if cond==true
    listen(hObject, handles); 
end
pause(player);
guidata(hObject,handles)


% --- Executes on button press in resetControl.
function resetControl_Callback(hObject, eventdata, handles)
% hObject    handle to resetControl (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
set(handles.slider1,'value',0);
set(handles.slider2,'value',0);
set(handles.slider3,'value',0);
set(handles.slider4,'value',0);
set(handles.slider5,'value',0);
set(handles.slider6,'value',0);
set(handles.slider17,'value',5);
set(handles.text23, 'String',0);
set(handles.text25, 'String',0);
set(handles.text34, 'String',0);
set(handles.text41, 'String',0);
set(handles.text42, 'String',0);
set(handles.text43, 'String',0);
guidata(hObject,handles)


function savePath_Callback(hObject, eventdata, handles)
% hObject    handle to savePath (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of savePath as text
%        str2double(get(hObject,'String')) returns contents of savePath as a double


% --- Executes during object creation, after setting all properties.
function savePath_CreateFcn(hObject, eventdata, handles)
% hObject    handle to savePath (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in save.
function save_Callback(hObject, eventdata, handles)
% hObject    handle to save (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global player;
Fs=get(player,'SampleRate');
y=get(player,'UserData');
filename=get(handles.savePath,'String');%Name the file
audiowrite(filename,y,Fs);
guidata(hObject,handles)
%% Control & Save Panels

%% Three Sound Effects
% --- Executes on button press in reverb.
function reverb_Callback(hObject, eventdata, handles)
% hObject    handle to reverb (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global player;
global cond;cond=false; %To distinguish whether the pause request comes from the audio effect or the audio equalizer
[handles.y,handles.Fs] = audioread(handles.fullpathname);

fs=44100;%Sampling frequency
decayTime=2;%Decay time in seconds
mixLevel=0.5;%Reverb mix level (0 to 1)
delayTimes=[0.05 0.1 0.2];%Delay times in seconds
attenuations= [0.5 0.3 0.2];%Attenuation factors for each delay

%Create an empty reverb filter
reverbFilter=zeros(1,round(fs*decayTime));

%Design individual delay filters
for i=1:length(delayTimes)
    delaySamples=round(fs*delayTimes(i));
    attenuation=attenuations(i);
    reverbFilter(delaySamples+1)=attenuation;
end

%Normalize the reverb filter
reverbFilter=reverbFilter/max(abs(reverbFilter));

originalAudio=handles.y;%Replace with your original audio signal

%Apply reverb effect
reverbAudio=conv(originalAudio, reverbFilter, 'same');

%Mix original and reverb audio signals
mixedAudio=originalAudio+mixLevel*reverbAudio;

handles.yT=mixedAudio;
player = audioplayer(handles.yT, handles.Fs);
player.UserData=handles.yT;
play(player)

n=size(handles.y,1);%Length of the message
t=(0:n-1)/handles.Fs;%Total time in seconds
f=(-(n-1)/2:(n-1)/2)*(handles.Fs/n);%Frequency range
fre_m=fftshift(fft(handles.y,n));%Compute the Fourier Transform of message m1(y-axis)
fre_mout=fftshift(fft(mixedAudio,n));%Compute the Fourier Transform of message m1(y-axis)

subplot(2,1,1);
stem(f,abs(fre_m)/n,'b-s')
grid on
xlabel('Frequency - Hz')
ylabel('Frequency Response')
subplot(2,1,2);
stem(f,abs(fre_mout)/n,'r-o')
grid on
xlabel('Frequency - Hz')
ylabel('Frequency Response')

guidata(hObject,handles)

% --- Executes on button press in delay.
function delay_Callback(hObject, eventdata, handles)
% hObject    handle to delay (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global player;
global cond;cond=false; %To distinguish whether the pause request comes from the audio effect or the audio equalizer 
[handles.y,handles.Fs] = audioread(handles.fullpathname);

fs=44100;%Sampling frequency
delayTime=0.5;%Delay time in seconds
delayGain=1;%Delay gain (0 to 1)

%Calculate the number of samples for the delay
delaySamples=round(fs*delayTime);

%Create the delay filter
delayFilter=zeros(1,delaySamples);
delayFilter(1)=delayGain;

originalAudio=handles.y;%Replace with your original audio signal

%Apply the delay effect
delayedAudio=conv(originalAudio,delayFilter,'same');

%Mix the original and delayed audio signals
mixedAudio=originalAudio + delayedAudio;

handles.yT=mixedAudio;
player=audioplayer(handles.yT, handles.Fs);
player.UserData=handles.yT;
play(player)

n=size(handles.y,1);%Length of the message
t=(0:n-1)/handles.Fs;%Total time in seconds
f=(-(n-1)/2:(n-1)/2)*(handles.Fs/n);%Frequency range
fre_m=fftshift(fft(handles.y,n));%Compute the Fourier Transform of message m1(y-axis)
fre_mout=fftshift(fft(mixedAudio,n));%Compute the Fourier Transform of message m1(y-axis)

subplot(2,1,1);
stem(f,abs(fre_m)/n,'b-s')
grid on
xlabel('Frequency - Hz')
ylabel('Frequency Response')
subplot(2,1,2);
stem(f,abs(fre_mout)/n,'r-o')
grid on
xlabel('Frequency - Hz')
ylabel('Frequency Response')

% subplot(2,1,1);
% plot(handles.y);%Original audio
% xlabel('Time')
% ylabel('Amplitude')
% subplot(2,1,2);
% plot(mixedAudio);%Adjusted audio
% xlabel('Time')
% ylabel('Amplitude')

guidata(hObject,handles)

% --- Executes on button press in chorus.
function chorus_Callback(hObject, eventdata, handles)
% hObject    handle to chorus (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global player;
global cond;cond=false; %To distinguish whether the pause request comes from the audio effect or the audio equalizer
[handles.y,handles.Fs] = audioread(handles.fullpathname);


fs=44100;%Sampling frequency
delayTime=0.03;%Maximum delay time in seconds
modulationDepth=0.005;%Modulation depth in seconds
modulationRate=1;%Modulation rate in Hz

%Calculate the number of samples for the maximum delay time
maxDelaySamples=round(fs*delayTime);

%Calculate the number of samples for the modulation depth
modulationDepthSamples=round(fs*modulationDepth);

%Calculate the modulation phase increment
modulationPhaseIncrement=2*pi*modulationRate/fs;

%Number of chorus filters
numFilters=3;

%Initialize the chorus filters
chorusFilters=zeros(numFilters,maxDelaySamples);

%Design each chorus filter with a slightly varied delay time
for i = 1:numFilters
    delaySamples=maxDelaySamples-modulationDepthSamples*sin(i*modulationPhaseIncrement);
    chorusFilters(i,1:delaySamples)=1;
end

originalAudio=handles.y;%Replace with your original audio signal

%Pad the original audio signal to match the length of chorus filters
paddedOriginalAudio=[originalAudio;zeros(maxDelaySamples,1)];

%Apply the chorus effect
chorusAudio=zeros(size(paddedOriginalAudio));
for i=1:numFilters
    chorusAudio=chorusAudio+conv(paddedOriginalAudio,chorusFilters(i, :),'same');
end

%Mix the original and chorus audio signals
mixedAudio=originalAudio+chorusAudio(1:length(originalAudio));

soundsc(mixedAudio,handles.Fs);
audiowrite("testout.wav",mixedAudio,handles.Fs);
% handles.yT=mixedAudio;
% player = audioplayer(handles.yT, handles.Fs);
% player.UserData=handles.yT;
% play(player) 
% Data trim issue exists while saving audio

n=size(handles.y,1);%Length of the message
t=(0:n-1)/handles.Fs;%Total time in seconds
f=(-(n-1)/2:(n-1)/2)*(handles.Fs/n);%Frequency range
fre_m=fftshift(fft(handles.y,n));%Compute the Fourier Transform of message m1(y-axis)
fre_mout=fftshift(fft(mixedAudio,n));%Compute the Fourier Transform of message m1(y-axis)

subplot(2,1,1);
stem(f,abs(fre_m)/n,'b-s')
grid on
xlabel('Frequency - Hz')
ylabel('Frequency Response')
subplot(2,1,2);
stem(f,abs(fre_mout)/n,'r-o')
grid on
xlabel('Frequency - Hz')
ylabel('Frequency Response')

% subplot(2,1,1);
% plot(handles.y);%Original audio
% xlabel('Time')
% ylabel('Amplitude')
% subplot(2,1,2);
% plot(mixedAudio);%Adjusted audio
% xlabel('Time')
% ylabel('Amplitude')

guidata(hObject,handles)
%% Three Sound Effects
