#include <stdio.h>
#include <stdlib.h>

unsigned char myPixels[47][62][3]; // multi-dimensional array definition. use in line 16 and line 50
int width, height;

int main()
{
    imageReadWrite();
    printf("{");
    for (int x = 0; x < height; ++x)
    {
        printf("{");
        for (int y = 0; y < width; ++y)
        {
            printf("{%d, %d, %d}",myPixels[x][y][0],myPixels[x][y][1],myPixels[x][y][2]);
            if(y < width-1)
                printf(", ");
        }
        printf("}");
        if(x < height-1)
            printf(",\n");
        else
            printf("\n");
    }
    printf("};\n");
    return 0;
}

void imageReadWrite(){

    FILE *fIn = fopen("tiger.bmp", "rb"); // you have to change the file name here.

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

