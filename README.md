This project is a springboot base application, that intends to achieve below functionalities. The functionalities for Task2,Task3 and Task4 are in TaskUtil inside AppUtils directories while the Task1 is a rest service module with and integrated endpoint to process laundry pickup date.
TASK 1
NODE.JS BACKEND DEVELOPER APTITUDE TEST
Assuming you are working on the backend of a laundry company mobile app, users can select the number of times they want the laundry company to pick up their clothes in a month, create an API that:
● Accept pickup day (Monday - Saturday)
● Accept service recurrence (4 times, 2 times or once a month)
● Using today (current day) as the start date, generate the next pickup dates for the subscription ● Return the generated pickup dates in form of an array as the response

Business logic flow
- Validate the give day to be within the specified range Monday-Saturday
- Validate Reoccurence day to be between 1 and 4
- check if give weekday is the same as current week day, then add seven to the calendar up to the number of reoccurence
- If the given week day is more than current weekday substract and add to the calendar
- If the given week day is less than the current weekday keep updating the calendar until it's current weekday, then add the number of counting to the calendar, then continue adding 7th day

TASK 2
Given a string, return the first recurring character in it, or null if there is no recurring character. For example, given the string "acbbac", return "b". Given the string "abcdef", return null.
Logic workflow
- create a list to hold the iterated character
-use forloop to iterate of the splitted character
- if the list contains any character then repeated character found
- If no repeacted character found then return null

TASK 3
Given an array of integers, return a new array where each element in the new array is the number of smaller elements to the right of that element in the original input array. For example, given the array
[3, 4, 9, 6, 1] [1, 1, 2, 1, 0]
● There is 1 smaller element to the right of 3
● There is 1 smaller element to the right of 4
● There are 2 smaller elements to the right of 9
● There is 1 smaller element to the right of 6
● There are no smaller elements to the right of 1

Logic workflow
- create a new array to hold the result, and initialize the size to be equals size of the given array
- create for loop to iterate through array
- for each another inside loop to check if the current item in the first forloop is more than the next item, Increase the counter
-  update the new array index with the value of the counter


TASK 4
Given a sorted list of integers, square the elements and give the output in sorted order. For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].

Logic workflow
- Create a list to hols the multiple of the array during iteration
- iterate over the array and push the square into the created list
- Sort the created list at the end of the iteration 
- Then return another copy of the sorted array