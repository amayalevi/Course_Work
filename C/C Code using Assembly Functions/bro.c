// C99
#include <stdlib.h> // EXIT_SUCCESS
#include <stdio.h>  // printf
#include <stdint.h> // C99 uintX_t and intX_t types

extern void uint32ToBinary(char str[], uint32_t x);
extern uint32_t bro32(uint32_t x);
extern uint32_t countOnes32(uint32_t x);

int main(void)
{
    uint32_t a, b, c;
    char str[33]; // 32 bits + null
    a = 0x12345678;
    uint32ToBinary(str, a); 
    printf("a = 0x%08x = %s(base-2)\n", a, str);       

    b = bro32(a);
    uint32ToBinary(str, b); 
    printf("b = 0x%08x = %s(base-2)\n", b, str);       

    c = countOnes32(a);
    printf("The number of 1 bits in 0x%08x is %u\n", a, c);

    return EXIT_SUCCESS;
}


