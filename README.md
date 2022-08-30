# “Sample” language

### Team: Simple

### Members:

- **Grigorii Kostarev - programmer/tester**
- **Regina Khamatova - programmer/tester**

Our team decided to implement **interpreter** for Sample language. See below core idea, syntax, semantics and list features of this language. 

See our [repo](https://github.com/none-word/SampleInterpreter)

**Content:**

### Core Idea

The language is based on Lua language. It has simple syntax and contain all the features that is needed in our language. Of course, some of them are not necessary for us or are not suitable at all. As an example, we decided to change typing to static.

### Comments

Comments in our language will be the same as in Lua, using “`--`” for line comments and “`--[[`" “`--]]`" for block of comments:

```lua
--example of line comment
--[[
  example of block comment    
--]]
```

### **Variable Definition**

A variable is nothing but a name given to a storage area that our programs can manipulate. It can hold different types of values including functions and tables.

The name of a variable can be composed of letters, digits, and the underscore character. It must begin with either a letter or an underscore. Upper and lowercase letters are distinct because our language is case-sensitive.

A variable definition should have a type and variable name as follows:

```lua
<variable_name> : <type>;
```

Also it can be optionally global:

```lua
<global_specification> <variable_name> : <type>;
```

Some valid examples: 

```lua
--in this case this variables are global
global x : integer;
global y : double;

--in this case this variables are local
x : integer;
y : double;
```

Variables can be initialized in their declaration. The initializer consists of an equal sign followed by a constant expression as follows:

```lua
<global_specification> <variable_name> : <type> = <expression>;
```

Some examples:

```lua
d : integer = 5;              --declaration of d as a local variable. 
global d : integer = 5;         --declaration of d as a global variable.
```

### Defining a function

The general form of function/method:

```lua
function <function_name> (<argument1_name> : <type>, <argument2_name> : <type>, <argument3_name> : <type>,........,<argumentn_name> : <type>) : <type>
	<function_body>
	return <result_variable>;
end;
```

Objects of basic types, objects of custom types, functions can be as argument for functions.

### If else condition

The general form of If else condition :

```lua
if(<boolean_expression>)
then
   <statement(s) will execute if the boolean expression is true>
else
   <statement(s) will execute if the boolean expression is false>
end;
```

### Base types

1. integer, double (numeric types)
2. string (text types)
3. void (unit type)
4. nil (empty type)
5. boolean
6. function (represent methods)

Also our language has special type that can hold anything except nil including functions: **table type.**
Example of table type usage:

```lua
mytable : table = (x: integer, y: double); --declaration of tuple.
global mytable : table = (x: integer, y: double);
```

By default, all the variables will point to nil until they are assigned a value or initialized.

### Type Checker

The interpreter supports type checker to check whether the expression has correct type.
Example:

```lua
function add(x: integer, y: integer): integer
		return x + y;
end;

x : double = 4.5; --x is double
y : integer = 5;  --y is integer
sum : integer = add(x, y); --error as x expected to be integer
```

### Simple Constraint-Based Type Inference

It is possible to let the interpreter annotate the type of variable, function/method and result. Type inference should have “**var**” keyword instead of type as follows:

```lua
<variable_name> : var = <expression>;
```

Example:

```lua
x : var = 5; --x has integer type
function add(x: integer, y: integer): var --function add has return integer type
		return x + y;
end;
```

### User-defined terms and types

In Sample language it is possible to define terms and alias types. 
You can alias terms using **var** as follow:

```lua
<variable_name> : var = <expression>;
```

Example:

```lua
x : var = add(5, 2); --x is integer
y : var = add(5.3, 3.5); --y is double
```

Also, you can alias types using “**type”** keyword instead of type as follows:

```lua
<type_name> : type = <type>;
```

Example:

```lua
mytype : type = string;
```

### Type Ascription

To help interpreter to infer type of variable or function/method it is possible to explicitly write expected type:

```lua
<expected_type_of_expression> : (<expression>)
```

Example:

```lua
y : integer = 4;
x : integer = add(4, integer : (add(y, 4)));
```

### Logical Operators

In Sample language **and**, **or** and **!**(not) logical operators are supported.

### Standard Library

1. To use **arithmetic operations** we will write the arithmetic library, which will contain arithmetic operation functions such as addition, subtraction, multiplication, division (modulo + integer), exponentiation and negation.neg
2. To use **relational operations** we will write the relational library, which will contain relational operation functions such as comparison for equality/inequality.

### Import

You can simply add necessary libraries into code by using **import.**

```lua
import <library>;
```

### First-class functions

Functions in our language can be used as arguments or variables
Example:

```lua
function func_1 (x : func (x1: integer -> integer), y : func (x1 : integer -> boolean)): boolean
    f: integer = 5;
    return y(x(f));
end;
```

### **Nested definitions**

Functions in language can be nested, so that we can write one function in another. The maximum nesting is 2:

```lua
function func1(args) : type
...
	function func2(args) : type
	...
	end;
...
end;
```

### General recursion

It is possible to use recursion in language. The main point is that the recursion must have an end point (condition that stops the recursion):

```lua
function func1(args) : type
...
	if (stop_condition)
	then
		stop_recursion
	else
		continue_recursion
	end;
	func1(args);
...
end;
```

### **Sequencing**

It is supported to use sequencing in Sample language, for example:

```lua
x : var = 5;
y : var = 10;

print(add(x, y));
```

So that the functions will execute by sequence (first add function, then print). 

### Let-binding

We can use let-binding in Sample language:

```lua
<var_name> : <type> = let <var_name_1> = <expression> 
											...
											in <result_expression>
```

Example:

```lua
x = let y = add(2, 4)   --x equals 13
        z = add(4, 6)
        in  add(y, z);
```

### Tuples

Tuples is supported in Sample language. They can be defined as table type:

```lua
<tuple_name> : table = (<first_variable_name>: <type>, <second_variable_name>: <type>);
```

For example:

```lua
mytuple : table = (x: integer, y: integer);
mytuple.x = 5;
mytyple.y = 10;
z : var = mytyple.y;  -- z has type integer and equals 10;
```

## Example of program

Description: this program represents features of our language. Nested definitions, If else statement, Function declaration with multiple arguments, Variable definition, Base types, Type checker, Simple constraint-based type inference, Standard library, General recursion, Variable definition are presented below. There is an explicit description in the comments.

```lua
import standard_library;

function gcd(a : integer, b : integer) : integer  -- Function declaration.
		if (equal(b, 0)) then                         -- If else statement like a
				return a;                                 -- nested definition.
		else
				c : integer = mod(a, b);
				return gcd(b, c);                         -- General recursion.
		end;
end;

function lcm(a : integer, b : integer) : integer
		function gcd(a : integer, b : integer) : integer   -- Nested function
				if (equal(b, 0)) then
						return a;
		    else
						c : integer = mod(a, b); 
				    return gcd(b, c);
		    end;
    end;

		c : var = mul(a, b);
		return div(c, gcd(a, b));
end;

function apply_function_to_lcm(a : integer, b : integer, f : func (a: integer -> integer)) : integer
		return f(lcm(A, B));
end;

x : integer = 40;                                 -- Base types example.
y : var = 35;                                     -- Simple constraint-based type inference.
return(apply_function_to_lcm(x, y, (a: integer) -> {return add_int_1(a)} : integer));         -- First-class functions.
```

## Examples of valid and invalid programs

### Valid

### Invalid

---

```lua
a : integer;
```

```lua
-- Type should be after name of variable
-- and after ':'
integer a;
```

---

```lua
function squaring(a : integer) : integer
	x : var = mul(a, a);
	return x;
end;
```

```lua
-- Function type should be in the end of 
-- declaration and after ':'
integer function squaring(a : integer)
	-- Should be defined type or var
	x = multiply(a, a);
	return x;
end;
```

---

```lua
x : var = 6;
y : var = 6;

if (equal(x, y)) then
	x = add(x, y);
else
	y = mul(x, y);
end;
```

```lua
-- There is no type unsigned_integer 
-- in base types
x : unsigned_integer = 6;
y : unsigned_integer = 6;

-- Condition should be in parentheses
if equal(x, y) then
	x = add(x, y);
else
	y = mul(x, y);
-- Else statement should be ended with 'end'
```

---

```lua
x : integer = 0;
y : integer = 1;

x = y + 2;
```

```lua
x : integer = 0;
-- 1 is not a double
y : double = 1;

-- It is not possible to assign integer
-- variable a double value
x = y + 2.2;
```

---

```lua
tuple : table = (x: integer = 2, y: integer = 3)
x : integer = tuple.x + 1
y : integer = tuple.y - 4;
```

```lua
-- Tuple should be in parentheses
tuple : table 
		= x : integer = 2, y : integer = 3
-- In the right side from let bindings 
-- should be expression
x : integer = 1
-- There is no y variable
-- To access the field of tuple,
-- it is needed 'tuple.y'
y : integer = y - 4;
```