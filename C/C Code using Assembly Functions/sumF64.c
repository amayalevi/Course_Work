// C99

#include <stdio.h>  // printf
#include <stdint.h> // C99 uintX_t and intX_t types

extern double sumF64(const double x[], uint32_t count);

#define COUNT 3
int main(void)
{
    double x[COUNT] = {1.1, 2.2, 3.3};
    double sum = sumF64(x, COUNT); 
    printf("Sum of elements in x is %lf\n", sum);
    
    return 0;
}


