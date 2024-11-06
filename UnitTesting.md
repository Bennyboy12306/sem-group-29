<h1>Unit Testing Document</h1>  

To run unitTests please run AppTest alone, it is connected to Docker app-run-94d container when ran

Done this as unitTests don't have to be run every time the application is utilized, it causes unnecessary bloat


<ul>
This document outlines the plan for the Unit Tests

# Pre-requisite Tests #
To ensure the program functions correctly these tests should be performed first:
1. Validate connection
2. Validate tables

# General #
Tests to validate countries and populations for the rest of the program

1. Validate location 
2. Validate population of location
3. Validate query order: 1 - World. 2 - Continent. 3 - Region... 
4. Calculate in population order: largest to smallest
5. Print calculation

# User Input # 

1. Validate N to be the correct datatype
2. Utilize #General# to validate query
3. Validate #General# query with user query
4. Print result if #General# query is the same as user query
5. Print error if #General# query does not match user query

</ul>