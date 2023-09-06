# Sierpinski Triangle:
Objective: Draw the Sierpinski Triangle using recursion.
## Instructions:
1. Start with an equilateral triangle facing upwards.
2. Connect the midpoints of the triangle's sides, forming 4 smaller equilateral triangles inside.
3. The triangle in the center is removed (leaving a hole).
4. Repeat the above steps recursively for the three remaining triangles.
5. Continue this process for a predetermined number of iterations.
- Bonus Challenge: Allow for customization of the initial triangle's size and iteration depth. Extend the concept to create a Sierpinski Carpet.
## Style and Documentation
- Follow naming convention for variables and methods, and recommended indentation.
- Methods should be indented 4 spaces from class declaration
- Statements inside methods should be indented 4 spaces from method header
- Document your program following Javadoc format
- Include a header at the beginning of your program that has:
	- description of the program
	- your name as @author
	- date (@since)
	- Describe each one of the methods, such as @param and @return

Sample Output
```
               * 
              * * 
             *   * 
            * * * * 
           *       * 
          * *     * * 
         *   *   *   * 
        * * * * * * * * 
       *               * 
      * *             * * 
     *   *           *   * 
    * * * *         * * * * 
   *       *       *       * 
  * *     * *     * *     * * 
 *   *   *   *   *   *   *   * 
* * * * * * * * * * * * * * * *
```

# Design
Because we are dealing with a Sierpinski Triangle that is graphed onto asterisks, we can notice that any equilateral triangle can be represented as sequences of $n = {1,2,3,...,n}$, like so for $n = 8$:
```
*
**
***
****
*****
******
*******
********
```
By removing asterisks and adding spaces in between 