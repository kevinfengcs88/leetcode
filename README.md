# LeetCode Solutions
This repository contains source code for all of my solutions to LeetCode in **Java**. They are completely original; any similarities to solutions on the Internet or on the LeetCode forums are mere coincidence.

## Why I created this repository
Back when I started submitting solutions to LeetCode questions in 2021, I considered uploading my solutions to GitHub; a quick Google search proved that others did the same. However, I realized it to be unnecessary, as LeetCode automatically maintains submissions in their database. As time passed and I continued to solve LeetCode problems, I found myself looking at the forums for solutions and falsely convincing myself that I would have thought of the same solution. 

This concept is discussed frequently in *A Mind for Numbers* by Barbara Oakley. *A Mind for Numbers* is a book that teaches readers how to learn more effectively, particularly when it comes to topics in math and science, although the learning techniques can be applied to anything. In chapter 4, Professor Oakley (almost a Pokémon reference) distinguishes true learning from "understanding," and how illusions of learning may trick us into believing that we have learned something. For example, reading a textbook solution may convince you that you've learned something, when in reality, your brain will often rationalize (which is likely no exception here) your ability to have arrived at the same conclusion/solution.

I decided to start solving LeetCode problems "honestly" by imposing these restrictions upon myself:
- I can search for Java syntax
- I can search for big picture programming concepts, like algorithms or data structures (only high level, NOT the problem itself)
- I can check the LeetCode forums for the problem **once, and only once** I have submitted an accepted solution (ej. to improve big O)

## Structure of this repository/code
This repository contains `.java` files which have solutions to the LeetCode problems of their respective names, minus the spaces. They are not intended to be compiled and ran, as there is no main method, nor does the class name match the file itself. In the rare case that I have multiple solutions for a problem, there will be multiple functions in that file, denoted by comments as separate solutions. Otherwise, multiple functions in a file indicates that there is/are (a) helper function(s) that are used in the solution. The order of the problems that follow is arbitrary.

***

## Table of contents
1. [TwoSum](#TwoSum)
2. [ReverseInteger](#ReverseInteger)

## [TwoSum](TwoSum.java)
Two Sum is the quintessential hash table (often called hash map in programming languages) introduction problem. I've written up two solutions, one of which is the naive approach to the problem, solving it in O(n<sup>2</sup>) time. The other is the more optimal approach, solving it in linear, or O(n) time. In Two Sum, you are given an array of integer values, `nums`, and a target value, `target`. The goal is to return indices of the two numbers from `nums` such that they add up to `target`.

In the naive approach, we simply perform a doubly-nested for-loop that iterates over every combination of two indices, until we find two that add up to the target in question. We store these two indices in an array of length 2 and return it. Though quite fast for small input sizes, this becomes much slower, very quickly (exponentially slower). 

In the hash table approach, we only need to loop through the `nums` array once, hence, the O(n) running time. First, we create an empty hash table that will contain key-value pairs, where each key is an integer from `nums`, and their respective values are the corresponding indices. For each element in `nums`, we check if the hash table contains the target value minus the element. If it does exist, that means we've already found our solution. We store the current element's index into one spot in the array we will return, and the value of the key `target - nums[i]` (target value minus the element) goes into the other spot in the array. We return the array. If the hash table does not contain the aforementioned subtraction expression, we place the current element with its corresponding index into the hash table. At the end of the function, we return the resulting array, so a return always occurs.

## [ReverseInteger](ReverseInteger.java)
Reverse Integer is a fairly simple problem that, in some form, is often taught in introductory computer science courses. Given an integer, we are told to return it, reversed. The only troublesome part of solving this problem in Java is that the maximum integer value is 2147483647 and the minimum integer value is -2147483647. This is troublesome because we cannot simply use division and modulo operators on integers and then return the value; we have to perform some type of check or incorporate some logic that avoids potential reversed results that exceed the maximum/minimum integer values of the Java language. 

Though we could perform some slightly convoluted logic on [integers wrapping from maximum to minimum values](https://stackoverflow.com/questions/5131131/what-happens-when-you-increment-an-integer-beyond-its-max-value), we could also simply bypass the integer limits by defining our return variable as type long. The solution itself is fairly self-explanatory. While `x` is not equal to 0, we set result to itself, times 10, plus `x` modulo 10. We also divide `x` by 10 in each iteration of the loop. This effectively stores the reversed integer in the long `result`. If this value goes out of the boundaries of Java's integer range, then we return 0 as the problem specified. Otherwise, cast `result` to an int, and return that. 

## [PalindromeNumber](PalindromeNumber.java)
Palindrome Number is a very simple problem when taking advantage of Java strings. We have to determine whether or not an integer is a palindrome. First, we convert the input integer to a string. There are multiple ways of doing this, but here I used the `String.valueOf` method. We can simply grab each character of the input string, arrange them in reverse order, and then determine if the input string is equivalent to the reversed string (remember to use `.equals` rather than `==`).

However, LeetCode suggests that you try and craft a solution that does not involve converting the input integer to a string, so I've included a solution for that as well. We use the same logic from [ReverseInteger](##ReverseInteger), although using a long for the resulting reversed integer is not necessary, as this problem does not require checking for integer overflow. Another slight difference is that we have to store the original input, `x`, in a variable (`original`) for comparison at the end, since we divide `x` by 10 until it equals 0. 

We also immediately return false if the input integer is negative, as negative "palindromes" will actually be equivalent to the original input integer. In other words, a value like -121 will be reversed as -121, which, by "numeric" definition, verifies that the original input was a palindrome. But LeetCode uses a "string" definition of palindrome, stating that -121 should read as 121- in reverse. Thus, -121 should not be considered a palindrome in our function.

## [MaximumDepthofBinaryTree](MaximumDepthofBinaryTree.java)
Maximum Depth of Binary Tree is a problem that requires very few lines of code to solve, so long as you use recursion. Given the root node of a binary tree, we have to determine what the maximum depth of the three is (including the root node). To solve this problem, we first need to ask ourselves what needs to happen at a high level (notice how reading just the first line of code to this solution makes little sense). We have to realize that we're not looking for the maximum depth of just any tree, but a *binary* tree. This means that the maximum depth will be found by following one of the root's two branches (left or right) down to its deepest leaf. In other words, we've already found the recursive call that needs to happen.

The recursive call will be 
```
return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
```
, as we want the maximum depth between the left and right branches. We add 1 because we need to include the root node. Other than that, it's just a matter of making the recursive calls stop before any NullPointerExceptions occur (or just have the recursion go on forever for that matter). So at the start of the function, we add 
```
if (root == null) return 0;
```
to stop the recursion once we hit the leaves of the tree. Keep in mind that the `root` variable refers to the node being passed into the recursive function; it only refers to the true root of the tree for the very first call.

## [BinaryTreeInorderTraversal](BinaryTreeInorderTraversal.java)
Binary Tree Inorder Traversal is another recursive problem, although a little lengthier than the previous [MaximumDepthofBinaryTree](##MaximumDepthofBinaryTree). In this problem, we have to return a list of integers that correlates to an inorder traversal of a binary tree (we are given the root node, of course). This solution also includes the usage of a recursive helper functions that actually does the recursion, while the main function simply calls the recursive function for the initial call. Because we need to return an ArrayList of the node's values when we perform an inorder traversal, this ArrayList must also be passed through each recursive call.

We define `result` as the ArrayList that will hold all of the node's values (of type Integer). We then call the recursive function `inOrder` with two parameters: the root node and the `result` ArrayList. However, we haven't implemented anything in the `inOrder` function, so let's do that. Firstly, note that the function header of `inOrder` has a return type of void. We want this recursive function to simply alter the ArrayList that is being passed through it. This also allows us to have statements that return nothing, which is evident in the first line of code. Just like in [MaximumDepthofBinaryTree](##MaximumDepthofBinaryTree), we need a return statement to break the recursion in the case of a null node (leaf). But this time, we can have an empty return statement:
```
if (root == null) return;
```
After that, we implement the logic of an inorder traversal (left, root, right) by making a recursive call on `inOrder` for `root.left`, adding the the value of `root` to the `result` ArrayList, and then making a recursive call on `inOrder` for `root.right`. Lastly, we return `result` in the main function, `inorderTraversal`.

## [ValidParentheses](ValidParentheses.java)
Valid Parentheses, in some variation, is used to introduce the [stack](https://www.geeksforgeeks.org/stack-data-structure/) data structure to computer science students. The idea is to determine whether or not a string of parentheses characters is balanced. A balanced string means that all open brackets are closed by the same type of brackets and that open brackets are closed in the correct order. To do this, we utilize a stack, which is a LIFO data structure (last in, first out). Due to its LIFO nature, the stack allows us to keep track of the most recent item that was added to the stack and remove it (the pop method).

Though the solution looks like a lot of code, it's mostly just spacing and accommodating for the three different types of brackets. We first define a stack, which I've simply called `stack` here. We then loop through the string, pushing on a character so long as it is one of the three types of opening brackets. We also use the `continue` keyword because we don't want the function to unnecessarily execute the portion of code that checks for improper closing brackets.

Speaking of which, we need to perform some checks to determine if we need to return a value of false. First of all, the stack could potentially be empty if there were no opening brackets. If this is the case, we return false. Otherwise, we pop the top element off the stack, call it `curr` and incorporate it into the next three if-statements, in which we check if brackets are being closed improperly. For example, if a '(' bracket is being closed by a ']' bracket, we return false. We code this out for every possible combination of improper closing brackets.

If the code runs through the whole loop without returning false, then we should just return true, right? Not necessarily. If the stack is not empty, then the string is not balanced (remaining brackets in the string). If the stack is empty, then we do return true. This is why we simply perform the following return statment at the end of the solution:
```
return stack.isEmpty();
```
