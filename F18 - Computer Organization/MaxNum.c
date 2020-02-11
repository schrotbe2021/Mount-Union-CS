/*Ben Schroth w/ Michael Piotrowski
CSC270 problem 16
Dr. Weber
10/14/18
*/

#include <stdio.h>

#define MAX 100

int maximum(int list[]); 
int size;

int main()  {
    int list[MAX], max, i;
    printf("Enter the size of the array:\n ");
    scanf("%d", &size);
    printf("Enter %d integers: ", size);

    for(i = 0; i < size; i++) {
        scanf("%d", &list[i]);
    }
	
    max = maximum(list);  
    printf("\nLargest element of the array is %d\n\n", max);
  
    return 0;
}

int maximum(int list[]) {
    static int i = 0, max =- 9999;  
    if(i < size) {

        if(max < list[i])
        max = list[i];
        i++;   
        maximum(list);   
    }
    return max;
}