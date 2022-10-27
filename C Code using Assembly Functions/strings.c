// C99

#include <stdio.h>  // printf
#include <stdint.h> // C99 uintX_t and intX_t types

extern uint32_t strLength(const char str[]);

// const means the funcion will not write to str... variable is read only
// honor system of immutability
// const is weakly immutable, as you can cast const char* to char*

/* well behaved, only reads str
uint32_t strLength(const char str[])
{
    int i = 0;
    while(*(str++) != '\0') // LDRSB R2, [R1]
        i++;
    return i;
}

well behaved, only reads str
int32_t strLength(const char str[])
{
    int i = 0;
    while(str[i] != '\0') // LDRSB R2, [R1, R0] -> &str[0] + i
        i++;
    return i;
}

// poor program -- breaks immutability
uint32_t strLength(const char str[])
{
    int i = 0;
//    str[0] = '*'; // C prevents this since str is immutable
    char* p = (char*) &str[0]; // break immutability and do bad stuff
    *p = '*';
    // because we write to immutable string, this is weak immutability
    while(str[i] != '\0')
        i++;
    return i;
}
*/

int main(void)
{
    char str[] = "Hello";
    uint32_t length = strLength(str);
    printf("str = %s\n", str);
    printf("len = %u\n", length);
    
 return 0;
}


