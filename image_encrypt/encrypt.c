#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*Assigning Copied Arrays*/
unsigned char copy_array1[47][62][3];

/*Assigning Given Arrays*/
int array_13[13] = { 12, 121, 88, 158, 22, 87, 81, 240, 204, 20, 47, 139, 197 };
int array_42[42] = {166, 99, 142, 92, 180, 89, 147, 217, 213, 98, 105, 189, 61, 58, 243, 43, 4, 230, 45, 7, 29, 223, 188, 40, 135, 114, 205, 234, 199, 103, 16, 232, 149, 225, 52, 8, 214, 133, 86, 183, 202, 222};
int array_45[45] = {239, 223, 133, 225, 217, 253, 221, 10, 14, 138, 254, 136, 40, 186, 32, 74, 169, 41, 63, 235, 12, 111, 98, 229, 52, 244, 35, 5, 11, 6, 97, 29, 108, 43, 105, 250, 65, 173, 18, 149, 232, 134, 88, 141, 220};
int array_40[40] = {101, 221, 46, 187, 134, 254, 125, 2, 93, 189, 182, 44, 151, 30, 166, 105, 253, 213, 251, 58, 88, 160, 76, 109, 140, 218, 90, 78, 7, 80, 150, 28, 94, 73, 227, 186, 53, 243, 156, 167};

/*Assigning Given The Pixels for Specifically Defined for Messages*/
int pixels_for_13[13][2]= {{1, 3}, {29, 30}, {9, 40}, {36, 9}, {23, 15}, {21, 8}, {3, 5}, {2, 4}, {37, 59}, {5, 6}, {42, 58}, {28, 51}, {25, 54} };
int pixels_for_42[42][2] = {{33, 15}, {39, 34}, {38, 43}, {3, 4}, {34, 22}, {42, 46}, {7, 14}, {4, 5}, {19, 25}, {7, 23}, {23, 8}, {3, 1}, {33, 25}, {1, 6}, {34, 59}, {35, 48}, {32, 48}, {45, 4}, {30, 1}, {39, 11}, {19, 28}, {25, 22}, {34, 1}, {40, 54}, {42, 10}, {26, 0}, {39, 8}, {28, 44}, {42, 43}, {3, 56}, {11, 19}, {13, 58}, {1, 53}, {6, 52}, {14, 31}, {44, 37}, {1, 17}, {29, 54}, {31, 38}, {40, 49}, {42, 39}, {18, 31}};
int pixels_for_45[45][2] = {{6, 56}, {25, 16}, {2, 3}, {25, 59}, {44, 33}, {22, 11}, {20, 18}, {37, 17}, {26, 39}, {19, 39}, {15, 51}, {18, 50}, {37, 6}, {31, 15}, {9, 10}, {24, 48}, {7, 5}, {39, 47}, {25, 2}, {28, 24}, {6, 38}, {0, 4}, {30, 36}, {11, 59}, {5, 36}, {22, 26}, {3, 26}, {40, 37}, {42, 46}, {34, 27}, {22, 52}, {42, 8}, {34, 5}, {25, 61}, {14, 31}, {14, 59}, {42, 13}, {13, 52}, {28, 19}, {17, 25}, {37, 44}, {34, 0}, {6, 4}, {45, 51}, {13, 49} };
int pixels_for_40[40][2] = {{20, 58}, {3, 2}, {27, 23}, {30, 20}, {31, 51}, {1, 5}, {24, 57}, {25, 13}, {9, 4}, {42, 14}, {45, 35}, {4, 45}, {4, 1}, {25, 45}, {5, 29}, {42, 57}, {13, 5}, {8, 24}, {14, 30}, {7, 5}, {32, 14}, {24, 46}, {8, 34}, {32, 40}, {4, 4}, {12, 16}, {31, 48}, {30, 58}, {11, 5}, {42, 31}, {13, 30}, {26, 56}, {1, 34}, {22, 4}, {25, 52}, {30, 50}, {23, 4}, {25, 15}, {10, 9}, {30, 21}};

/*Defining Terms For Read and Store Process*/
unsigned char myPixels[47][62][3]; // multi-dimensional array definition. use in line 16 and line 50
int width, height;

int encrypted_msg_int_13[13];/*ASCII Values of Encyrpted Message!*/
unsigned char encrypted_msg_char_13[13]="Hello, World!";

int encrypted_msg_int_42[42];
unsigned char encrypted_msg_char_42[42]="Meet me at out ordinary place. 4 pm sharp!";

int encrypted_msg_int_45[45];
unsigned char encrypted_msg_char_45[45]="Hostile attack will be happened at mid-night.";

int encrypted_msg_int_40[40];
unsigned char encrypted_msg_char_40[40]="No homework for tomorrow but stay tuned!";

int getInput(){
    char msg[300];
    int counter=0;
    printf("Enter the message you want to encrypt (Must be 255 character long at most)\n");
    scanf("%[^\n]",msg);
    while(1){
        for(int i=0;msg[i]!='\0';i++){
            counter++;
        }
        if(counter>255 || counter==0){
            printf("%d\n",counter);
            scanf("%[^\n]",msg);
            counter=0;
            continue;
        }
        printf("%s\n",msg);
        printf("Message length is %d.\n",counter);
        printf("To be Encyrpted Message : {");
        for(int j=0;j<counter-1;j++){
            printf(" %d,",msg[j]);
            }
        printf(" %d }\n",msg[counter-1]);
        return counter;
    }
}

int getRed(){
    int targetRed;
    printf("Enter the Target Red Value (must be between 0-255): \n");
    scanf("%d",&targetRed);
    while(1){
        if(targetRed==13||targetRed==42||targetRed==45||targetRed==40||targetRed>255||targetRed<1){
            printf("Invalid entry.");
            scanf("%d",&targetRed);
            continue;
        }
        return targetRed;
    }
}

void swap(int* a,int* b){
    int temp=*a;
    *a=*b;
    *b=temp;
}

void my_bubble(int arr[],int length){
    int i,j;
    for(i=0;i<length-1;i++)
        for(j=0;j<length-1-i;j++)
            if(arr[j]>arr[j+1])
                swap(&arr[j],&arr[j+1]);
    printf("random array sorted : {");
    for(int i=0;i<length-1;i++)
        printf(" %d,",arr[i]);
    printf(" %d }\n",arr[length-1]);

}

int select_pic(){
    int selection;
    printf("Which image do you want to use?\n");
    printf("(Enter 1 : tiger.bmp , 2 : sunflower.bmp , 3 : pineapple.bmp , 4 : elephant.bmp)\n");
    scanf("%d",&selection);
    printf("choice: %d\n",selection);

    return selection;

}

void my_search(unsigned char arr[47][62][3], int target){
    for(int i=0;i<47;i++){
        for(int j=0;j<62;j++){
            if(arr[i][j][0]-target==0){
                copy_array1[i][j][0]=target+1;
                copy_array1[i][j][1]=arr[i][j][1];
                copy_array1[i][j][2]=arr[i][j][2];
                }
            else{
                copy_array1[i][j][0]=arr[i][j][0];
                copy_array1[i][j][1]=arr[i][j][1];
                copy_array1[i][j][2]=arr[i][j][2];
                }
        }
    }
}

void sorted_arrays(int length){
    switch(length){
        case 13:
            my_bubble(array_13, 13);
            break;
        case 42:
            my_bubble(array_42, 42);
            break;
        case 45:
            my_bubble(array_45, 45);
            break;
        case 40:
            my_bubble(array_40, 40);
            break;
    }
}

void char2int(){
    for(int i=0;i<13;i++)
            encrypted_msg_int_13[i]=encrypted_msg_char_13[i];
    for(int i=0;i<42;i++)
            encrypted_msg_int_42[i]=encrypted_msg_char_42[i];
    for(int i=0;i<45;i++)
            encrypted_msg_int_45[i]=encrypted_msg_char_45[i];
    for(int i=0;i<40;i++)
            encrypted_msg_int_40[i]=encrypted_msg_char_40[i];
}

void set_Pixels(int length, int red){
    switch(length){
        case 13:
            for(int i=0;i<length;i++){
                unsigned char *ptr=&copy_array1[pixels_for_13[i][0]][pixels_for_13[i][1]][0];
                unsigned char *ptr1=&copy_array1[pixels_for_13[i][0]][pixels_for_13[i][1]][1];
                unsigned char *ptr2=&copy_array1[pixels_for_13[i][0]][pixels_for_13[i][1]][2];
                *ptr=red;
                *ptr1=encrypted_msg_int_13[i];
                *ptr2=array_13[i];
                }
            break;
        case 42:
            for(int i=0;i<length;i++){
                unsigned char *ptr=&copy_array1[pixels_for_42[i][0]][pixels_for_42[i][1]][0];
                unsigned char *ptr1=&copy_array1[pixels_for_42[i][0]][pixels_for_42[i][1]][1];
                unsigned char *ptr2=&copy_array1[pixels_for_42[i][0]][pixels_for_42[i][1]][2];
                *ptr=red;
                *ptr1=encrypted_msg_int_42[i];
                *ptr2=array_42[i];
                }
            break;
        case 45:
            for(int i=0;i<length;i++){
                unsigned char *ptr=&copy_array1[pixels_for_45[i][0]][pixels_for_45[i][1]][0];
                unsigned char *ptr1=&copy_array1[pixels_for_45[i][0]][pixels_for_45[i][1]][1];
                unsigned char *ptr2=&copy_array1[pixels_for_45[i][0]][pixels_for_45[i][1]][2];
                *ptr=red;
                *ptr1=encrypted_msg_int_45[i];
                *ptr2=array_45[i];
                }
            break;
        case 40:
            for(int i=0;i<length;i++){
                unsigned char *ptr=&copy_array1[pixels_for_40[i][0]][pixels_for_40[i][1]][0];
                unsigned char *ptr1=&copy_array1[pixels_for_40[i][0]][pixels_for_40[i][1]][1];
                unsigned char *ptr2=&copy_array1[pixels_for_40[i][0]][pixels_for_40[i][1]][2];
                *ptr=red;
                *ptr1=encrypted_msg_int_40[i];
                *ptr2=array_40[i];
                }
            break;
    }
}

void print_function(unsigned char arr[47][62][3]){
    printf("{");
    for (int x = 0; x < 9; ++x)
    {
        printf("{");
        for (int y = 0; y < 8; ++y)
        {
            printf("{%d, %d, %d}",copy_array1[x][y][0],copy_array1[x][y][1],copy_array1[x][y][2]);
            if(y < 8-1)
                printf(", ");
        }
        printf("}");
        if(x < 9-1)
            printf(",\n");
        else
            printf("\n");
    }
    printf("};\n");
    printf("Message has been successfully encrypted.");
}

/*!READ AND STORE RGB VALUES!*/

void imageReadWrite(char pic[]){

    FILE *fIn = fopen(pic, "rb"); // you have to change the file name here.

    if (!fIn)
    {
        printf("File error.\n");
    }

    unsigned char header[54];
    fread(header, sizeof(unsigned char), 54, fIn);

    width = *(int*)&header[18];
    height = abs(*(int*)&header[22]);

    //printf("w:%d h:%d \n", width, height);
    for (int x = 0; x < height; ++x)
    {
        for (int y = 0; y < width; ++y)
        {
            fread(myPixels[x][y], 3, 1, fIn); // pass your multi-dimensional array variable as an input.
        }
    }
    fclose(fIn);
}
/*!ENDING OF READ AND STORE SECTION!*/

int main()
{
    int msgLength=getInput();
    int targetRed=getRed();

    /*Sorting Given Arrays and Matching Given Arrays and Message Length.*/
    /*Creating Arrays Include ASCII Values of Given Messages.*/
    sorted_arrays(msgLength);
    char2int();

    /*Selecting Pictures */
    int selection=select_pic();
    if(selection==1)
        imageReadWrite("tiger.bmp");
    else if(selection==2)
        imageReadWrite("sunflower.bmp");
    else if(selection==3)
        imageReadWrite("pineapple.bmp");
    else if(selection==4)
        imageReadWrite("elephant.bmp");

    /*Finding Pixels with Target Red Values and Changing those Values*/
    /*Hiding the Message Length and Target Red Value in Pixel (0,0)*/
    myPixels[0][0][0]=msgLength;
    myPixels[0][0][1]=targetRed;

    my_search(myPixels, targetRed);

    /*Changing RGB Values of Pictures!!by using hide_info function!!*/
    set_Pixels(msgLength, targetRed);
    print_function(copy_array1);
    return 0;
}
