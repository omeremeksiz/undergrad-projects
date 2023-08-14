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

% Last Modified by GUIDE v2.5 23-May-2023 19:44:08

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


% --- Executes on button press in find.
function find_Callback(hObject, eventdata, handles)
% hObject    handle to find (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
[filename,pathname]=uigetfile({'*.wav'},'File Selector');
handles.fullpathname=strcat(pathname,filename);
set(handles.loadPath,'String',handles.fullpathname);
guidata(hObject,handles)

% --- Executes on button press in record.
function record_Callback(hObject, eventdata, handles)
% hObject    handle to record (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
%% Record and Save Audio
set(handles.light,'BackgroundColor','red');
Fs=40000;%40 kHz
td=1/Fs;
nBits=16;% Number of bits to represent each sample
nChannels=1;%Mono Channel
ID=-1;%Default audio input device
recObj=audiorecorder(Fs,nBits,nChannels,ID);
recordblocking(recObj,4);
myRecording=getaudiodata(recObj);
m=getaudiodata(recObj);
filename=get(handles.recordPath,'String');%Name the file
audiowrite(filename,m,Fs);
set(handles.light,'BackgroundColor','green');

guidata(hObject,handles)

% --- Executes on button press in listenRecord.
function listenRecord_Callback(hObject, eventdata, handles)
% hObject    handle to listenRecord (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
set(handles.light,'BackgroundColor','white');
filename=get(handles.recordPath,'String');
[m,Fs]=audioread(filename);%To use audio without recording again and again
soundsc(m,Fs);
guidata(hObject,handles)

% --- Executes on button press in listenLoad.
function listenLoad_Callback(hObject, eventdata, handles)
% hObject    handle to listenLoad (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
filename=get(handles.loadPath,'String');
[m,Fs]=audioread(filename);%To use audio without recording again and again
soundsc(m,Fs);
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

%% Sliders
% --- Executes on slider movement.
function slider9_Callback(hObject, eventdata, handles)
% hObject    handle to slider9 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider


% --- Executes during object creation, after setting all properties.
function slider9_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slider9 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background.
if isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor',[.9 .9 .9]);
end


% --- Executes on slider movement.
function slider7_Callback(hObject, eventdata, handles)
% hObject    handle to slider7 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider


% --- Executes during object creation, after setting all properties.
function slider7_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slider7 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called


% --- Executes on slider movement.
function slider16_Callback(hObject, eventdata, handles)
% hObject    handle to slider16 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider


% --- Executes during object creation, after setting all properties.
function slider16_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slider16 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background.
if isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor',[.9 .9 .9]);
end

% --- Executes on slider movement.
function slider17_Callback(hObject, eventdata, handles)
% hObject    handle to slider17 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider


% --- Executes during object creation, after setting all properties.
function slider17_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slider17 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background.
if isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor',[.9 .9 .9]);
end
%% Sliders

function listen(hObject, handles)
global player;
[handles.y,handles.Fs] = audioread(handles.fullpathname);
handles.Volume=get(handles.slider17,'value');
handles.g1=get(handles.slider7,'value');
handles.g3=get(handles.slider9,'value');
handles.g10=get(handles.slider16,'value');
set(handles.text23, 'String',handles.g1);
set(handles.text25, 'String',handles.g3);
set(handles.text34, 'String',handles.g10);

cut_off=200;
orde=16;
a=fir1(orde,cut_off/(handles.Fs/2),'low');
y1=handles.g1*filter(a,1,handles.y);

f3=400;
f4=1500;
b2=fir1(orde,[f3/(handles.Fs/2) f4/(handles.Fs/2)],'bandpass');
y3=handles.g3*filter(b2,1,handles.y);

cut_off2=15000;
c=fir1(orde,cut_off2/(handles.Fs/2),'high');
y10=handles.g10*filter(c,1,handles.y);

handles.yT=y1+y3+y10;
player = audioplayer(handles.Volume*handles.yT, handles.Fs);
player.UserData=handles.yT;

subplot(2,1,1);
plot(handles.y);
% xlim([1200 3000])
xlabel('Frequency')
ylabel('Amplitude')
subplot(2,1,2);
plot(handles.yT);
% xlim([1200 3000])
xlabel('Frequency')
ylabel('Amplitude')

guidata(hObject,handles)

% --- Executes on button press in listenControl.
function listenControl_Callback(hObject, eventdata, handles)
% hObject    handle to listenControl (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global player;
listen(hObject, handles); 
play(player);
guidata(hObject,handles)


% --- Executes on button press in pauseControl.
function pauseControl_Callback(hObject, eventdata, handles)
% hObject    handle to pauseControl (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global player;
listen(hObject, handles); 
pause(player);
guidata(hObject,handles)


% --- Executes on button press in resetControl.
function resetControl_Callback(hObject, eventdata, handles)
% hObject    handle to resetControl (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
set(handles.slider7,'value',0);
set(handles.slider9,'value',0);
set(handles.slider16,'value',0);



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
