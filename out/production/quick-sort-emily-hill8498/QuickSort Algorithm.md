# Quick Sort Algorithm Project

## Summary
In this project, we'll implement the Quick Sort algorithm in Java. Quick Sort is an efficient, comparison-based sorting algorithm that uses a divide-and-conquer strategy, similar to **Merge Sort**. 

## Project Requirements

The Quick Sort is built upon several different function calls, not all of which are recursive.

In short, Quick Sort essentially chooses a single value from the existing array to work as a "pivot". Using this pivot, we roughly sort each item in the array into a "left side" and a "right side". We continue to do this recursively on smaller and smaller portions of the array, each with a new pivot, until our array is so small that the values we sort must be within their "correct" position.

After that, we simply have to filter the newly sorted left and right halves back together into the full array, eventually resolving back to the array we started with, now sorted.

### Core Components
___
### 1. int **partition(int[] arr, int low, int high)**
   - This method selects the "pivot" in our array. There are a few ways we can select a pivot:
	   - Choose the highest, lowest, or middle index in the array to act as a pivot.
	   - Randomly choose a position in the array to act as a pivot.
	   - "The Median of Threes" - Select the median value from the lowest, highest, or middle index of the array. *( This pivot can potentially give us the best possible runtime, as it attempts to give us a value that's close to the true median of all the values stored in the array.  )*
   - Rearranges elements such that:
     - Elements less than the pivot are placed to the left
     - Elements greater than the pivot are placed to the right
     - **Hint:** For this, exclude the pivot value by swapping it to one end of the array *before* you do the partitioning. It will eventually be filtered into its rightful position once a new pivot is selected.
   - Returns the final position of the pivot element

### 2. void swap(int[] arr, int i, int j)
- This function simply takes two indices, i and j, and swaps them around with a temp variable, just like the swap done in a Bubble Sort. It is the helper method for **partition** 
### 3. void quickSort(int[] arr, int low, int high) 
- This is the main sorting algorithm that will use partition() to roughly organize the array, and we'll recursively call quicksort() on the left and right partitions to sort with finer granularity.
- Use the partition function to arrange this part of the array.
- Call quick sort on the left and right arrays, divided now by the pivot's final location.

### Testing
___
Not just for having additional cases, but also for you to determine any errors, we'll be implementing testing for this project. 

For this project, include a directory called **testing** that has screenshots of the following:
- The result of your sort on a random 10 item list.
- The result of your sort on a random 50 item list.
- The result of your sort on an empty list.
	- For efficiency purposes, you may want to check the size of the array in your main before calling the quicksort. No sense in attempting to sort a list of -none- length.

### Things to Remember
___
1. Structure your solution with clear separation of responsibilities:
	1. The partition logic should be distinct from the recursive sorting logic, not all one function. 
2. What value becomes the pivot is not necessarily important. There are some more efficient methods, but the important part here is that you actually complete the sort. Consider starting with a random or end-pivot, and once you have the sort working, go back and implement more efficient pivots.
3. **Documentation, Documentation, Documentation:** This is a classic recursive sorting algorithm that many CS professionals learn in their progression to mastery. Your comments should clearly indicate what's going on and be written in *your* narrative voice. Rote copying may sometimes slip by, but the only one you're really harming is yourself.

## Evaluation
___
Your implementation will be evaluated based on the following:
- [ ] Function
	- [ ] Includes the three methods described above.
	- [ ] Performs the sort correctly.
- [ ] Efficiency & Readability
	- [ ] Code is well organized and readable (variable name standard, no huge jumbled of function calls).
	- [ ] Code does not make any unnecessary calls and doesn't include redundant information.
- [ ] Documentation
	- [ ] Testing screenshots included.
	- [ ] Sufficiently commented.
	- [ ] Author's name & date at the top of the program.
	- [ ] Accurate *.java* filenames
