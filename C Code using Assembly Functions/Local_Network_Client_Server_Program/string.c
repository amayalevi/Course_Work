#include <stdlib.h>          // EXIT_ codes
#include <stdbool.h>         // bool
#include <stdio.h>           // printf, scanf
#include <string.h>          // strlen, strcmp

int main()
{
char test[10] = "A1";

char input[10];
fgets(input,sizeof(input),stdin);
input[strcspn(input,"\n")] =0;

printf("hardcoded length = %d\n",strlen(test));
printf("input length = %d\n",strlen(input));

return 0;
}
