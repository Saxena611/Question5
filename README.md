# Question5

Data Structure used : STACK
Algorithm           : Balancing Parenthesis

Approach:

Maintain two stacks i.e one for the values and other for the operands.
Start of with opening braces and reach out to the closing braces.
Once reached start evaluating the expression in the reverse order till
the opening braces is reached again.
Also , come with logics required to let the program follow BODMAS rule.

Concept:

1.Input is the form of String converted it into an array inorder to traverse.
2.If , a the variable is number or operand put them into their respective stacks.
3.In case you get a opening bracket push it to the stack.
4.Look for the closing bracket.
5.Once found , pop an operand from operand_stack and pop 2 values contionusly
  from the value_stack inorder to perform calculation i.e operation().
6.Push the output to the stack and discard opening bracket.
7.In case we get a operator as a value then till the time you get another 
  operator which is slightly low in precedence keep poping out from
  the operand and perform check() i.e precedence checker.
8.In case you find the exact match pop out two values from it's stack
  and perform operations.
9.In case any of the two stacks does not remain empty perform the repeated 
  operations.
/-------------------------------------------------------------------------/
