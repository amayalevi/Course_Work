#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
/*
#define COUNT 9

void uint23ToBinaryString(char str[], uint32_t x)
{
    uint32_t index;
    uint32_t mask = 0x400000;
    for (index = 0; index < 23; index++)
    {
	if (x & mask)
	    str[index] = '1';
	else
	    str[index] = '0';
	mask >>= 1;
     }
     str[23] = '\0';
}
*/
extern void prodF64(double z[], const double x[], const double y[], uint32_t count);//done
extern float int32ToFloat(int32_t x);//done
extern float dotpF32(const float x[], const float y[], uint32_t count);//done
extern double minF64(const double x[], uint32_t count);

int main()
{
uint32_t count = 4;
double x[] = {0,5,-15.0,33};
double z = minF64(x,count);
printf("Min: %f\n",z);
/*
uint32_t count = 3;
float x[] = {1,0,2};
const float y[] = {3,4,-5};
float z = dotpF32(x,y,count);
printf("Dot Product: %f\n",z);
/*
int32_t x = -33;
float y = int32ToFloat(x);
printf("%f\n",y);
/*
// If x = {10, 20, 30}, y = {5, 10, 5}, and count = 3, then z = {50, 200, 150}
uint32_t count = 3;
double x[] = {11,22,33};
double y[] = {5,10,5};
double z[count];
prodF64(z,x,y,count);

for(uint32_t i = 0;i < count;i++)
printf("%lf ",z[i]);

    int i;
    uint32_t value;
    uint32_t s;
    uint32_t e;
    uint32_t f;
    char str[24];
    float x[COUNT] = {4194304.0 + 0.5, 1.0625, 0.4, (256.0 + 1/512.0), 2.000976562, 0.3333333333333,
                      1024, 1024 + 1/8192.0, 1024 + 1/16384.0};
    printf("Float value           Hex         S  E    F\n");
    for (int i = 0; i < COUNT; i++)
    {
        value = *((uint32_t*)&x[i]);
        s = value >> 31;
        e = (value >> 23) & 0xFF;
        f = value & 0x7FFFFF;
        uint23ToBinaryString(str, f);
        printf("%20.10f  0x%08x  %1d  %3d  %s\n", x[i], value, s, e, str);
    }

*/
    return EXIT_SUCCESS;
}

