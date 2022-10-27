#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <stdbool.h>

extern uint64_t addU32_U64(uint32_t x, uint32_t y);
extern int64_t addS64(int64_t x, int64_t y);
extern int32_t convertS8ToS32(int8_t x) ;
extern int32_t convertU16ToS32(uint16_t x);
extern int16_t maxS16(int16_t x, int16_t y) ;
extern uint32_t maxU32(uint32_t x, uint32_t y) ;
extern bool isGreaterThanU16(uint16_t x, uint16_t y) ;
extern bool isGreaterThanS16(int16_t x, int16_t y);
extern int32_t shiftRightS32(int32_t x, uint8_t p) ;
extern uint16_t shiftU16(uint16_t x, int8_t p);
extern bool isEqualU16(uint16_t x, uint16_t y);

int main()
{
int16_t x=76;
int16_t y=-77;
uint32_t z;

printf("x = %d\n",x);
printf("y = %d\n",y);

if(isGreaterThanS16(x,y))
printf("True\n");
else
printf("False\n");

//z = maxU32(x,y);
//printf("z = %d\n",z);

return 0;
}
