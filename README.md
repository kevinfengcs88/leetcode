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
This repository contains `.java` files which have solutions to the LeetCode problems of the respective names. They are not intended to be compiled and ran, as there is no main method, nor does the class name match the file itself. Additionally, if I have multiple solutions for a problem, the corresponding file will have multiple functions (clearly distinguished from helper functions, as the parameters will be the same as the original). Comments will provide additional clarification between solutions.

***

## Table of contents
1. [TwoSum](#TwoSum)
2. [ReverseInteger](#ReverseInteger)

***

## [TwoSum](TwoSum.java)
Two Sum is the quintessential hash table (often called hash map in programming languages) introduction problem. I've written up two solutions, one of which is the naive approach to the problem, solving it in O(n<sup>2</sup>) time. The other is the more optimal approach, solving it in linear, or O(n) time. In Two Sum, you are given an array of integer values, `nums`, and a target value, `target`. The goal is to return indices of the two numbers from `nums` such that they add up to `target`.

In the naive approach, we simply perform a doubly-nested for-loop that iterates over every combination of two indices, until we find two that add up to the target in question. We store these two indices in an array of length 2 and return it. Though quite fast for small input sizes, this becomes much slower, very quickly (exponentially slower). 

In the hash table approach, we only need to loop through the `nums` array once, hence, the O(n) running time. First, we create an empty hash table that will contain key-value pairs, where each key is an integer from `nums`, and their respective values are the corresponding indices. For each element in `nums`, we check if the hash table contains the target value minus the element. If it does exist, that means we've already found our solution. We store the current element's index into one spot in the array we will return, and the value of the key `target - nums[i]` (target value minus the element) goes into the other spot in the array. We return the array. If the hash table does not contain the aforementioned subtraction expression, we place the current element with its corresponding index into the hash table. At the end of the function, we return the resulting array, so a return always occurs.

## ReverseInteger
