# Programming Assignment 2

This repository is used as a way to provide to students
a starting point for CSC 220 Programming Assignment 2,
as well as a way to turn in the assignment.
Programming Assignment 2 is based on
the `UtilityCustomer` class hierarchy described in
[Programming Project](http://proquest.safaribooksonline.com/9781284141092/sec10_10_7_html#sec10-10-7)
55 from Chapter 10 of the textbook,
with the following changes:
+ The data used to initialize the objects in the `ArrayList<UtilityCustomer>` list will come from a file called **customers.txt**. There is a [sample](https://github.com/csc220-mountunion/ProgrammingAssignment2/blob/master/customers.txt) of this file in the top level of the repository folder structure; you can see that each line has an account id, the type of customer, and the amount of gas or electricity that was consumed.  I recommend you use the `java.util.Scanner` class to read the data in.
+ Before the program steps through the list and prints out each customer's information (account number and bill),
the list should be sorted so that the smallest bill comes first.
Do not write the sort method yourself, use [`java.util.Collections.sort`](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#sort-java.util.List-java.util.Comparator-) to do it for you;
you will have to provide a `Comparator` so that the `sort` method will know how to compare two `UtilityCustomer` objects.

As in [Programming Assignment 1](https://github.com/csc220-mountunion/ProgrammingAssignment2/blob/master/README-PA1.md)
, the package structure started in the repository must be followed, including both the names and contents of the packages.

Your score will be based on the following rubric:

| Item | Possible score |
|------|---------------:|
| `UtilityCustomer` class hierarchy is properly declared according to the specifications in Programming Assignment 1 and the textbook | 6 |
| Package structure is the same as that originally provided in the master branch of the repository | 2 |
| Good programming practices, including naming and indentation conventions, as well as proper use of access modifiers such as `private` and `protected`, are followed | 3|
| Every file has an appropriate header comment | 2 |
| The client reads data from **customers.txt** to instantiate `UtilityCustomer` objects and inserts them into `customerList` | 5 |
| The client uses `Collections.sort` to sort `customerList` so that the customer with the smallest bill comes first | 5 |
| The client steps through `customerList` and prints the bill amount and customer id for each customer in the list | 2|
| Total | 25|
|Exra credit: the bill amounts and customer ids are displayed in the client's FXML pane instead of the Java console | 3 |

Programming Assignment 2 is due Wednesday, October 3, at class time.
You will turn the assignment in by pushing your branch to GitHub. **Note Well:** this will not be possible until class time of the day that it's due, and it will *only* be possible to do this during class that day.
