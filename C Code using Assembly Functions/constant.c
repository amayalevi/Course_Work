// C99

#include <stdio.h>  // printf
#include <stdint.h> // C99 uintX_t and intX_t types

uint32_t getConstantU32();
int32_t getConstantS32();

int main(void)
{
    uint32_t a = getConstantU32();
    int32_t b = getConstantS32();
    printf("a = 0x%08x\n", a);
    printf("a = %u\n", a);
    printf("b = %d\n", b);
        
    return 0;
}

