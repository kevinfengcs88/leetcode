# LeetCode Solutions
This repository contains source code for all of my solutions to LeetCode in **Java**. They are completely original; any similarities to solutions on the Internet or on the LeetCode forums are mere coincidence.

## Why I created this repository
Back when I started submitting solutions to LeetCode questions in 2021, I considered uploading my solutions to GitHub; a quick Google search proved that others did the same. After giving this option some consideration, I concluded it to be unnecessary, as LeetCode automatically maintains submissions in their database. As time passed and I continued to solve LeetCode problems, I found myself looking more and more at the LeetCode forums for solutions and falsely convincing myself that I would have thought of the same solution (having not seen the answer).

This concept is discussed frequently in *A Mind for Numbers* by Barbara Oakley. *A Mind for Numbers* is a book that teaches readers how to learn more effectively, particularly when it comes to topics in math and science, although the learning techniques can be applied to anything. In chapter 4, Professor Oakley (almost a Pokémon reference) distinguishes true learning from "understanding," and how illusions of learning may trick us into believing that we have learned something. For example, reading a textbook solution may convince you that you've learned something, when in reality, your brain will often rationalize (which is likely no exception with LeetCode) your ability to have arrived at the same conclusion/solution.

I decided to start solving LeetCode problems "honestly" by imposing these restrictions upon myself:
- I can search for Java syntax
- I can search for big picture programming concepts, like algorithms or data structures (only high level, NOT the problem itself)
- I can check the LeetCode forums for the problem **once, and only once** I have submitted an accepted solution (ej. to improve big O)

I've also written a [Medium article](https://medium.com/nerd-for-tech/avoiding-leetcode-forums-5a052ecf25c0) about this repository.

## Structure of this repository/code
This repository contains `.java` files which have solutions to the LeetCode problems of their respective names, minus the spaces. They are not intended to be compiled and ran, as there is no main method and the files generate [BOM characters](https://stackoverflow.com/questions/1992933/illegal-character-when-trying-to-compile-java-code) upon creation. In the rare case that I have multiple solutions for a problem, there will be multiple functions in that file, denoted by comments as separate solutions. Otherwise, multiple functions in a file indicates that there is/are (a) helper function(s) that are used in the solution. The order of the problems that follow is arbitrary.

***

## Table of contents
1. [TwoSum](#TwoSum)
2. [ReverseInteger](#ReverseInteger)
3. [PalindromeNumber](#PalindromeNumber)
4. [MaximumDepthofBinaryTree](#MaximumDepthofBinaryTree)
5. [BinaryTreeInorderTraversal](#BinaryTreeInorderTraversal)
6. [ValidParentheses](#ValidParentheses)
7. [BuildArrayfromPermutation](#BuildArrayfromPermutation)
8. [ConcatenationofArray](#ConcatenationofArray)
9. [ReverseString](#ReverseString)
10. [DeleteNodeinaLinkedList](#DeleteNodeinaLinkedList)
11. [ReverseLinkedList](#ReverseLinkedList)
12. [SingleNumber](#SingleNumber)
13. [SubrectangleQueries](#SubrectangleQueries)
14. [SubtracttheProductandSumofDigitsofanInteger](#SubtracttheProductandSumofDigitsofanInteger)
15. [HowManyNumbersAreSmallerThantheCurrentNumber](#HowManyNumbersAreSmallerThantheCurrentNumber)
16. [PlusOne](#PlusOne)

## [TwoSum](TwoSum.java)
Two Sum is the quintessential introductory hash table problem. I've written up two solutions, one of which is the naive approach to the problem, solving it in O(n<sup>2</sup>) time. The other is the more optimal approach, solving it in linear, or O(n) time. In Two Sum, you are given an array of integer values, `nums`, and a target value, `target`. The goal is to return indices of the two numbers from `nums` (these two numbers will always exist with LeetCode's test cases) such that they add up to `target`.

In the naive approach, we simply perform a double for-loop that iterates over every combination of two indices, until we find the two that add up to the target in question. We store these two indices in an array of length 2 and return it. Though quite fast for small input sizes, this becomes much slower, very quickly (exponentially slower as input size increases). 

In the hash table approach, we only need to loop through the `nums` array once, hence, the O(n) running time. First, we create an empty hash table that will contain key-value pairs, where each key is an integer from `nums`, and their respective values are the corresponding indices. For each element in `nums`, we check if the hash table contains the target value minus the element. If it does exist, that means we've already found our solution. We store the current element's index into the array to be returned, and the value of the key `target - nums[i]` (target value minus the element) is stored into the array as well (whichever index that is not occupied by the current element's index). We return the array. If the hash table does not contain the aforementioned subtraction expression, we place the current element with its corresponding index into the hash table. At the end of the function, we return the resulting array, so a return always occurs.

## [ReverseInteger](ReverseInteger.java)
Reverse Integer is a problem that, in some form, is often taught in introductory computer science courses. Given an integer, we have to return it with its digits reversed. The only troublesome part of solving this problem in Java is that the maximum integer value is 2147483647 and the minimum integer value is -2147483647. This is a slight annoyance because we cannot simply use division and modulo operators on integers and then return the value; we have to perform some type of check or incorporate some logic that avoids reversed results that exceed the maximum/minimum integer values of the Java language. 

Though we could perform some [integers wrapping from maximum to minimum values](https://stackoverflow.com/questions/5131131/what-happens-when-you-increment-an-integer-beyond-its-max-value) logic, we could also simply bypass the integer limits by defining our return variable as type long. The solution itself is fairly self-explanatory. While `x` is not equal to 0, we set result to itself, times 10, plus `x` modulo 10. We also divide `x` by 10 in each iteration of the loop. This effectively stores the reversed integer in the long `result`. If this value goes out of the boundaries of Java's integer range, then we return 0 as the problem specified. Otherwise, cast `result` to an int, and return that. 

## [PalindromeNumber](PalindromeNumber.java)
In Palindrome Number, we have to determine whether or not an integer is a palindrome. First, we convert the input integer to a string. There are a few ways of doing this, but here I used the `String.valueOf` method. We can simply grab each character of the input string, arrange them in reverse order, and then determine if the input string is equivalent to the reversed string (remember to use `.equals` rather than `==`).

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
Binary Tree Inorder Traversal is another recursive problem, although a little lengthier than the previous [MaximumDepthofBinaryTree](##MaximumDepthofBinaryTree). In this problem, we have to return a list of integers that correlates to an inorder traversal of a binary tree (we are given the root node, of course). This solution also includes the usage of a recursive helper function that actually does the recursion, while the main function simply calls the recursive function for the initial call. Because we need to return an ArrayList of the node's values when we perform an inorder traversal, this ArrayList must also be passed through each recursive call.

We define `result` as the ArrayList that will hold all of the node's values of type Integer. We then call the recursive function `inOrder` with two parameters: the root node and the `result` ArrayList. However, the `inOrder` method currently doesn't have any functionality. To make it useful, we should first consider what the return type of the `inOrder` should be. Since we want this recursive function to simply alter the ArrayList that is being passed through it, the return type should be void. This also allows us to have statements that return nothing, which is evident in the first line of code. Just like in [MaximumDepthofBinaryTree](##MaximumDepthofBinaryTree), we need a return statement to break the recursion in the case of a null node (leaf). But this time, we can have an empty return statement:
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

## [BuildArrayfromPermutation](BuildArrayfromPermutation.java)
Build Array from Permutation is a classic O(n) problem that quite literally provides you with the solution in the problem's description. The idea is that given an array of integers, `nums`, return a new array of integers built as a zero-based permutation of `nums`. If this doesn't make sense, don't worry. LeetCode provides you with the answer, funnily enough. Here's a quote directly from the website: "build an array `ans` of the **same length** where `ans[i] = nums[nums[i]]`."

Although we already have the solution now, let's break down what `nums[nums[i]]` really means. So `nums[i]`, which is the index for the whole expression `nums[nums[i]]`, is a value itself, built off of the index, `i`. So it's just index-ception, if that makes any sense. We're using values, built off of indices, as indices. 

The solution is very simple. We create an integer array with the same length as `nums`. I call mine `result` even though LeetCode told me to call it `ans` because I am a true advocate of anarchy. We then loop through `result` and just copy + paste the line that LeetCode gave us. In my case, each iteration of the loop executes `result[i] = nums[nums[i]]`. Finally, return the `result` array. 

## [ConcatenationofArray](ConcatenationofArray.java)
Concatenation of Array is similar to [BuildArrayfromPermutation](BuildArrayfromPermutation.java) in the sense that LeetCode spoonfeeds you the solution. In this problem we are given an integer array `nums` and we have to return another array, `ans`, where `ans[i] == nums[i]` and `ans[i + n] == nums[i]` where `n` is equal to the length of the `nums` array. It sounds a bit convoluted, but that's just because LeetCode's abstract explanation is unnecessarily complicated. Taking a look at the example inputs and outputs that LeetCode provides, however, makes it much simpler. The `ans` array should just be the `nums` array, but repeated for a length of `2n`. So if the `nums` array is `[1, 2, 5]`, then the `ans` array should be `[1, 2, 5, 1, 2, 5]`.

To solve this problem, we define `ans` (I've given up my anarchic ways) as an array of length `nums.length * 2` and then perform a double loop (I used a for-loop nested in a while-loop) that fills the `ans` array. In my implementation, each for-loop goes through the `nums` array, while the outer loop (while-loop) goes through the `ans` array. This solution is generalized, meaning that it would work for an `ans` array of any size, so long as that size is `nums.length` multiplied by some positive integer. Due to the parameters of the question, however, we are forced to hard code the length of the `ans` array to be double that of the `nums` array. At the end, we return `ans`. 

## [ReverseString](ReverseString.java)
Reverse String is an excellent test of basic in-place array manipulation. In this problem, we are tasked with reversing an input string, `s`, which is formatted as an array of characters. We have to do this in-place with only O(1) extra memory. As you can already guess, the O(1) extra memory will be dedicated to a temporary character variables used while performing swap operations in the array, `s`. If we weren't required to execute this in-place, then swapping wouldn't be necessary.

First, we define a character, `temp`, which will store the value of one of the characters in `s` that we want to swap. Speaking of swapping, we want to only swap up until half of the length of `s`, minus 1 (this is inclusive). This works for both odd and even length arrays. We use a for-loop to accomplish this, with `i` incrementing from 0 until `s.length/2 - 1`. For each iteration of the loop, we store `s[i]` into `temp`, then store `s[s.length - i - 1]` into `s[i]`, and finally, store `temp` into `s[s.length - i - 1]`. We use the `s.length - i - 1` because we need an expression that dynamically computes the opposing index that we want each character (at index `i`) to be swapped with. `s.length` goes out of bounds, so we subtract 1 from it, and then we subtract `i` to get the exact index of the opposing character.

For example, in the string "hello," the character 'h' is at index 0 (which is `i`), and the character 'o' is at index 4. We can get 4 based off of `i` by taking `s.length`, which is 5, subtracting 1 (to get the index in legal array bounds), and finally subtracting `i` (so we subtract 0). 5 - 1 - 0 = 4. As we are doing this in-place, we do not have to return anything (also affirmed by the void return type of the function header). 

## [DeleteNodeinaLinkedList](DeleteNodeinaLinkedList.java)
Delete Node in a Linked List is a small twist on the traditional way to delete a node from a linked list. Normally, if you need to delete a node from a linked list, you just set the `next` reference of the previous node of the node to be deleted to be `.next.next`. In other words, if a linked list looked like this: `A -> B -> C` and you wanted to delete node B, you would perform something like `A.next = A.next.next`. 

As the problem's title implies, we need to delete a node from a singly-linked list. However, we are not given a reference to the head of the linked list, and instead, we are given a reference to the node that is to be deleted. This also means that we do not have a reference to the node prior to the node that is to be deleted. In terms of lines of code, this means our solution is going to be twice as long as if we did have a reference to the head or the node prior to the node to be deleted!

There is a simple workaround to only having a reference to the node that needs to be deleted. If we set the `.val` of the node to the next node's value and then change the current node's `.next` reference to be `.next.next`, then the node is effectively deleted.

## [ReverseLinkedList](ReverseLinkedList.java)
Reverse Linked List is a problem that can be solved in several, fundamentally different ways. Given the head of a singly-linked list, we have to reverse the list and also return the reversed list. We could cheat a little bit by using a stack and rebuilding an entirely new linked list, but considering that the problem states that we have to "reverse the list" rather than "build a new linked list," I made a solution that does the former.

The overarching concept of solving this problem is that we need three separate pointers at all times. We call these three pointers `prev`, `head` (already defined by the function header), and `next`. As it sounds like, they reference nodes in that order (although not at all times, since the function moves pointers around). We start by pointing `prev` to null, and beginning a loop that only terminates once `head` is null. In the loop, we create the `next` node and set that to `head.next`. Since we want to reverse the linked list, the `.next` reference of `head` should point towards null (it becomes the new tail of the linked list). Another way to think about this is if linked lists' arrows face toward the right, then we want all the arrows to face the left. 

After that, we set `prev` to `head` and `head` to `next`. This step effectively pushes both `prev` and `head` forward one node. `next` is not "incremented" forward, as that occurs at the beginning of each loop iteration. Eventually, one iteration of the loop will cause the `next` node to point to null, as `head.next` will point to null (meaning the code is currently working on the original tail of the linked list). Since `head` is set to `next` at the end of the loop, `head` will also point to null, and the loop will terminate before it can perform another iteration.

Since both `head` and `next` point to null, `prev` is the only pointer that still points to a node, and it is precisely pointing to the new head of the reversed linked list. We return `prev` at the end of the solution.

## [SingleNumber](SingleNumber.java)
Single Number is a very similar problem to [TwoSum](#TwoSum), as they can both use hash table solutions. Given an integer array, `nums`, we have to return the one element that only appears once (the rest of the elements all appear exactly twice). Using a hash table to keep track of how many times each element appears would seem like the obvious solution. However, one stipulation that LeetCode makes is that your solution must not only run in O(n) time, but also take up constant extra space, or O(1) extra space. A hash table would take up O(n) extra space.

I've included two solutions in the file, one of which utilizes a Java HashMap that would otherwise be a good solution had LeetCode's stipulation about using O(1) extra space not existed. Regardless, this first solution still demonstrates good problem-solving skills by avoiding a naive O(n<sup>2</sup>) solution, so I'll still provide explanations for both.

For the first solution, we create a HashMap that takes `<Integer, Integer>` key-value pairs. We then loop through the `nums` array, adding entries depending on whether or not the HashMap already contains `nums[i]` as a key. If the HashMap already contains the key, then we set 2 as the value, otherwise, we set 1 as the value. We then exit the loop and then get the only key for which the HashMap has a value of 1 for.

Since there is no `getKey()` function in the HashMap's library, we have to create our own function that relies on the `getKey()` function that pertains to `Map.Entry` objects. In the `getKey()` helper function, we loop through each `entry` object in the iterable object created by the `entrySet()` method. If the value we pass into the helper function is the same as the value of the current `entry` object, then we return the key of the current `entry` object. We return null if the value `V` does not exist in the `entrySet`. If any of this sounds confusing, you can reference [this article](https://www.techiedelight.com/get-map-key-from-value-java/), which lists several different ways to get a key from a value in a Java HashMap (the first method is the helper function I just explained).

But we can do better than this. To code up a solution that only takes an extra O(1) space, we have to limit ourselves to using variables/data structures that do not take up space as a function of `nums.length`. This solution is very short, so I feel that it's appropriate to paste the entirety of the code below:
```
int result = 0;
for (int i = 0; i < nums.length; i++) result ^= nums[i];
return result; 
```
Most of this code is extremely basic&mdash;the first line defines an integer set to 0, the last line returns that integer, and the middle line iterates through the `nums` array. That's because all the magic that actually solves the problem occurs everytime the loop runs. To be specific, `result ^= nums[i]` is the line of code that does everything. But what does `^=` mean? What does it accomplish for this problem in particular?

`^` is the Java bitwise XOR operator (usually `^` in other programming languages as well). [Bitwise operators](https://www.programiz.com/java-programming/bitwise-operators) compare bits of two operands and output a value depending on the type of bitwise operator that is being used. In the case of XOR, if two bits are different (0 and 1 or 1 and 0), it returns 1. Otherwise, if the two bits are the same (0 and 0 or 1 and 1), it returns 0. For all the integers in `nums`, we can chain together one long XOR expression using `^=` to our `result` variable and then return it. So in the case of the first example on LeetCode, we would want to compute `2^2^1`, or in the case of the second example on LeetCode, we would want to compute `4^1^2^1^2`.

Why does this work? Well, with the bitwise XOR operator, if two numbers are the same, then they will effectively "cancel out" each other as the expression returns 0. `0 ^ foo`, where `foo` is any integer that is not 0, will always return `foo`. See where this is going? All of the integers that appear twice will negate each other, computing to 0, which is XORed against `foo`, ultimately returning `foo`. If you want a visual explanation, I would recommend checking out this [timestamped video from TECH DOSE](https://youtu.be/krgK0UlfNYY?t=201).

The `^=` operator effectively chains the integer on its right-hand side to the expression its left-hand side. We iterate through all of the elements in `nums`, which, by the nature of the bitwise XOR operator, leaves the one element that only appears once in `result`. At the end of the function, we return `result`. 

## [SubrectangleQueries](SubrectangleQueries.java)
Subrectangle Queries is the first OOP (object-oriented programming) problem that we encounter in LeetCode (sorting by acceptance rate from high to low). Unlike other algorithm problems, we aren't tasked with coding up a solution to a function that will solve a specific problem. Instead, we have to implement a class that fulfills the "Subrectangle Query library." This is broken down into three separate functions that we have to complete. The first is a constructor, the second is a function, `updateSubrectangle` that will update a subrectangle in the given matrix, and the third is a function, `getValue`, that will simply return the element at a specific index (indicated by `row` and `col`).

For the constructor method, we simply have to "link" the 2D matrix, `rectangle` parameter to a private 2D matrix. I've called this private matrix `r`. `updateSubrectangle` must update all values in a subrectangle with the integer `newValue`. Since the test cases are 0-indexed (just like any array in Java), we just need to use a double for-loop that iterates through all of the elements of the subrectangle and replaces them with `newValue`. The outer loop will iterate through the rows, ranging from `row1` (the starting row index) to `row2` (the ending row index). We have to be careful with the termination condition of this for-loop, as it needs to be inclusive of the `row2` index. If we don't include the `row2` index, then the subrectangle that we select will be one row too short. The same logic applies to columns, so `col2` must be included in the inner for-loop. Inside the inner for-loop, we just need to set `r[i][j]` to `newValue`, where `i` is the outer for-loop counter, and `j` is the inner for-loop counter.

Lastly, the `getValue` function consists of returning the item in `r` at row `row` and column `col`. This is achieved in one line with:
```
return r[row][col];
```

## [SubtracttheProductandSumofDigitsofanInteger](SubtracttheProductandSumofDigitsofanInteger.java)
Subtract the Product and Sum of Digits of an Integer is a ridiculously long name for a coding problem; typing out the name may prove to be more difficult than solving the actual problem itself. In this problem, we are tasked with returning an expression:
```
product - sum
```
where `product` is the product of the input integer, `n`'s digits, and `sum` is the sum of `n`. I've included two solutions for this problem. The first one utilizes string conversion (which is the simplest method) and the second one avoids using any strings.

In the first solution, we convert `n` into a string and store it into `s1`. We create two integer variables, `product` and `sum`, which are initialized to 1 and 0, respectively. `product` is initialized to 1, since setting it to 0 would cause any multiplicative expression to evaluate to 0. `sum` is initialized to 0 as it won't encounter the same problem. We then loop through `s1`, storing the integer version of the current character in `s1` in `temp`. Though the following expression is a little long, we can break it down starting from the middle:
```
Integer.parseInt(String.valueOf(s1.charAt(i)))
```
First, we get the character at index `i` in the string, `s1`. We take that character and get the string value of it using the `String.valueOf` method. We do this so that we can convert it to an integer with the `Integer.parseInt` method. The resulting integer can be multiplied with `product` or added to `sum`, which is exactly what is done in the next portion of the loop. Once we loop through the entirety of `s1`, we return `product - sum`.

In the second solution, we can't simply loop through a string and multiply/add each integer-converted character to the `product` and `sum` variables, so we have to obtain the digits as integers and store them into an array.

To store the digits into an array, we have to determine the length of the array. There are a few ways of doing this. I would highly recommend taking a look at [this article from Baeldung](https://www.baeldung.com/java-number-of-digits-in-int#:~:text=Perhaps%20the%20easiest%20way%20of,int%20length%20%3D%20String.), which goes over a few ways on finding the number of digits of an integer in Java. The article goes over five different methods, starting from least efficient to most efficient (in terms of speed and memory). Funnily enough, the first method involves converting the integer to a string and taking the length of that resulting string. Since that takes additional memory to be allocated and because we are avoiding strings in this solution, I ended up using the logarithmic approach.

By taking the log (base 10) of `n` and adding 1 to it, we can get the length of the integer. This length can then be used to define the size of the `digits` array. Just like in the previous solution, we initialize `product` and `sum` as integers equal to 1 and 0, respectively. To fill the `digits` array, we define an index variable `i`, and loop while `n` is not equal to 0. We add `n % 10` to `digits` at index `i`, divide `n` by 10, and increment `i` by 1. After filling the `digits` array, we loop through it, multiplying or adding the elements to `product` and `sum` respectively. Lastly, we return `product - sum`. 

## [HowManyNumbersAreSmallerThantheCurrentNumber](HowManyNumbersAreSmallerThantheCurrentNumber.java)
Continuing with the theme of ridiculously long problem names, How Many Numbers Are Smaller Than the Current Number asks us to return an array of integers such that for each entry in `nums`, `nums[i]`, the resulting array contains the count of numbers that are smaller than (not less than or equal to, but strictly less than) the current number. For example, with an input `nums` of [8, 1, 2, 2, 3], the correct output is [4, 0, 1, 1, 3]. The first entry of `nums`, 8, has 4 entries that are smaller than it. The second entry of `nums`, 1, has 0 entries that are smaller than it, and so on and so forth. 

The naive solution involves a double for-loop, giving it a big O of O(n<sup>2</sup>). We first define an array `result` of the same size as `nums`. Both the outer loop (incrementer variable `i`) and the inner loop (incrementer variable `j`) will iterate through all of the elements in `nums`, with the inner loop counting how many elements are smaller than the outer loop's current element. The inner loop performs this count by determining whether an element is smaller than the current element. If this is the case, then the value at `result[i]` gets incremented by 1. After we exit the double for-loop, we return `result`.

To improve our big O, we'll write up a solution that utilizes a HashMap. This time, when we initialize the array to be returned, `result`, we make it a copy of the `nums` array. This can be achieved with the `.clone()` method, although a [potentially faster option is to use `System.arraycopy()`](https://stackoverflow.com/questions/7179251/is-there-any-reason-to-prefer-system-arraycopy-over-clone). We then sort `result` with Java's built-in sorting method, `Arrays.sort()`. This method uses a [dual-pivot quicksort](https://www.javatpoint.com/how-to-sort-an-array-in-java#:~:text=User%20Defined%20Method-,Using%20the%20sort()%20Method,(n%20log(n)).), so the complexity is O(nlogn). Sorting the array will effectively give us the counts of elements that are smaller than "current elements." For example, the sorted version of [8, 1, 2, 2, 3] is [1, 2, 2, 3, 8]. Here's the general template that we can follow to understand what information this sorted array gives us for this problem:

The first instance of element `n` is located at index `m`. This means there are `m` number of elements that are strictly smaller than `n`. For example, the element 1 in the example array is located at index 0, and as such, we know that there are 0 elements smaller than 1 in the array. For the element 2, we notice that there are two occurrences; we are only concerned with the first one in our sorted array. The first instance of 2 is found at index 1, meaning there is 1 element smaller than 2, and so on and so forth. But how can we make sure that our HashMap only contains the information regarding the first occurrence of an element and ignores all other occurrences? We can use the `putifAbsent()` method, which will only put a key-value pair into the HashMap if it does not already exist. The traditional `put` method will override the value of a key-value pair if it already exists in the HashMap, which we do not want to occur here.

We define our HashMap, which will hold `<Integer, Integer>` key-value pairs. Next, we loop through the items in `result` (the loop termination references `nums.length`, which is the same as `result.length`, so either one works here) and store `result[i], i` key-value pairs in the HashMap if `result[i]` does not already exist in the HashMap. Now we just have to take these HashMap values and place them in the correct indices of the array to be returned. Since we no longer need the sorted version of the `nums` array, and also because creating a new array would require additional memory allocation, we'll store the results in the sorted array, `result`. We loop through `result`, placing the value of the key `nums[i]` for each `result[i]`. This will place the correct values corresponding to the order of elements in the original `nums` array. Lastly, we return `result`. 

## [PlusOne](PlusOne.java)
Plus One is a fairly easy problem that requires us to add one to an integer and return it. The catch is that we're given this number in an array representation, `digits`, and we have to return the answer as an array representation as well. The reason why the array representation stipulation can end up being somewhat troublesome is because `digits.length` can be as much as 100. As a result, we will inevitably deal with test cases involving integers far greater than what Java can handle with regular primitive ints. This is only really a problem if we decide to convert the array into an integer, add one to it, and then convert it back into an array for the final result to be returned. To avoid the complications of going over `Integer.MAX_VALUE`, our solution will deal strictly with integers in array representation.

I found it easiest to write out all the possible cases that we can encounter (I don't mean literally every single possible integer), of which there are only three types (these will be formatted as "input" -> "output"):

1. 21 -> 22
We simply need to add one to the last digit and return the array
2. 999 -> 1000 
We have to turn every 9 into a 0, create a new array of size `digits.length + 1`, set `digits[0]` to 1, and then return that new array
3. 8999 -> 9000
We have to turn every 9 into a 0, and also revert back to the same behavior of the first case and increment the "first" (iterating from the ones digit to the largest digit) digit that is not a 9

This is a little tricky because we have to make sure that our code distinguishes between case #2 and case #3 properly. The easiest way to do this (as I already hinted in the description of what we should do for case #3) is to use the same logic from case #1. In other words, while traversing from right to left (ones digit to the largest digit), when we encounter the first digit that is not a 9, increment it by one and return the array. If you consider any number whose digits do not entirely consist of 9s, then we won't have to allocate additional memory for what is to be returned, as the number will still consist of the same number of digits.

We loop through all the digits from right to left, and if we encounter any digit that is not a 9, we simply increment that digit by 1 and return `digits`. In the case that the digit is a 9, we set that digit to 0. After this for loop executes, we already have proper logic for both cases #1 and #3. Now all we have to do is consider case #2. Case #2 will be handled after the loop terminates (ie. we have iterated through every single digit). Knowing that a return statement would have already been hit if just a single digit was NOT a 9, then we know that only arrays consisting entirely of 9s will break out of the loop without having encountered the return statement. Thus, we simply create a new array that is of length `digits.length + 1`, set `digits[0]` to 1, and then return that. The remaining elements will be initialized to 0, which is exactly what we want. An input of 9 should output 10, an input of 99 should output 100, an input of 999 should output 1000, and so on and so forth. Even though we could append the modified `digits` array, which at this point is all 0s, initializing a new array and not touching indices 1 through `digits.length + 1` accomplishes the same thing.