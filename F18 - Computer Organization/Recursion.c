/*Ben Schroth w/ Michael Piotrowski
CSC270 problem 16
Dr. Weber
10/14/18
*/

#include <stdio.h>
 
int fib(num);

int main() {
    int num;
    int answer;
 
    printf("Enter a number: ");
    scanf("%d", &num);
    if (num < 0) {
        printf("Cannot do operation.\n");
    }
    else
    {
        result = fibonacci(num);
        printf("The %d number in fibonacci sequence is %d.\n", num, answer);
    }
    return 0;
}


int fib(int num) {
    if (num < 2) {
		return num;
        return(fib(num - 1) + fib(num - 2));
    }
}
