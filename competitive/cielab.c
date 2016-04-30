#include <stdio.h>
 
int main()
{
  long int  a=0,b=0,c=0;
  
  scanf("%ld %ld",&a,&b);
 
  c = a - b;
  (c % 10 == 9) ? c-- : c++;
  
  printf("%ld",c);
  
    return 0;
}