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
Reverse Integer is a fairly simple problem that, in some form, is often taught in introductory computer science courses. The only troublesome part of solving this problem in Java is that the maximum integer value is 2147483647 and the minimum integer value is -2147483647. This is troublesome because we cannot simply use division and modulo operators on integers and then return the value; we have to perform some type of check or incorporate some logic that avoids potential reversed results that exceed the maximum/minimum integer values of the Java language. 

Though we could perform some slightly convoluted logic on [integers wrapping from maximum to minimum values](https://stackoverflow.com/questions/5131131/what-happens-when-you-increment-an-integer-beyond-its-max-value), we could also simply bypass the integer limits by defining our return variable as type long. The solution itself is fairly self-explanatory. While `x` is not equal to 0, we set result to itself, times 10, plus `x` modulo 10. We also divide `x` by 10 in each iteration of the loop. This effectively stores the reversed integer in the long `result`. If this value goes out of the boundaries of Java's integer range, then we return 0 as the problem specified. Otherwise, cast `result` to an int, and return that. 

## [PalindromeNumber](PalindromeNumber.java)
Palindrome Number is a very simple problem when taking advantage of Java strings. First, we convert the input integer to a string. There are multiple ways of doing this, but here I used the `String.valueOf` method. We can simply grab each character of the input string, arrange them in reverse order, and then determine if the input string is equivalent to the reversed string (remember to use `.equals` rather than `==`).

However, LeetCode suggests that you try and craft a solution that does not involve converting the input integer to a string, so I've included a solution for that as well. We use the same logic from [ReverseInteger](##ReverseInteger), although using a long for the resulting reversed integer is not necessary, as this problem does not require checking for integer overflow. Another slight difference is that we have to store the original input, `x`, in a variable (`original`) for comparison at the end, since we divide `x` by 10 until it equals 0. 

We also immediately return false if the input integer is negative, as negative "palindromes" will actually be equivalent to the original input integer. In other words, a value like -121 will be reversed as -121, which, by "numeric" definition, verifies that the original input was a palindrome. But LeetCode uses a "string" definition of palindrome, stating that -121 should read as 121- in reverse. Thus, -121 should not be considered a palindrome in our function.