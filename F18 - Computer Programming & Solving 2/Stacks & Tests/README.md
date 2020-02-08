# Programming Assignment 5

You are to write a Java program to solve [problem 66 from Chapter 14](https://proquest.safaribooksonline.com/book/programming/java/9781284141092/chapter-10-object-oriented-programming-part-3-inheritance-polymorphism-and-interfaces/ch10_html#X2ludGVybmFsX0h0bWxWaWV3P3htbGlkPTk3ODEyODQxNDEwOTIlMkZzZWMxNF8xNF83X2h0bWwmcXVlcnk9) of the textbook, except you will be using a linked data structure for the stack instead of an array-based implementation, and you will provide an additional `hasNext` method as was described in class.

Test code for the `ClothingStack` class should use the JUnit testing framework that will be discussed in class in the final two weeks.

This repository has starting point code for the [`ClothingItem`](https://github.com/csc220-mountunion/ProgrammingAssignment5/blob/master/src/clothing/ClothingItem.java) and [`ClothingStack`](https://github.com/csc220-mountunion/ProgrammingAssignment5/blob/master/src/clothing/ClothingStack.java) classes; some additional information is provided in comments therein.

Your score will be based on the following rubric:

| Item | Possible score |
|------|---------------:|
| Initial program structure as provided is followed | 2 |
| Good programming practices are followed | 2 |
| **Every** file has an appropriate header comment | 2 |
| Correct implementation of `ClothingItem` class| 3 |
| Correct implementation of linked structure for `ClothingStack`| 3 |
| Correct implementation **and tests** of `ClothingStack` constructor| 2 |
| Correct implementation **and tests** of `ClothingStack.push` | 2 |
| Correct implementation **and tests** of `ClothingStack.pop` | 2 |
| Correct implementation **and tests** of `ClothingStack.peek` | 2 |
| Correct implementation **and tests** of `ClothingStack.hasNext` | 2 |
| Correct implementation **and tests** of `ClothingStack.toString` | 4 |
| Correct implementation **and tests** of `ClothingStack.itemsOfColor` | 4 |
| Correct implementation **and tests** of `ClothingStack.numberOfItemsWashableAtHighTemperature` | 3 |
| JUnit test framework correctly used | 2 |
| Total | 35 |

Programming Assignment 5 is due Friday, December 7, at class time.
You will turn the assignment in by pushing your branch to the repository, as in Programming Assignments 1 though 3.
