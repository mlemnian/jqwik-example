# jqwik-example

This is a mini example to demonstrate the usage of jqwik. It provides a simple (faulty) implemented Adder class and 
a dedicated AdderSpec class to test the different properties an Addition should fulfill:
* commutativity
* associativity
* distributivity
* neutral element is zero
* adding the inverse is zero (`a + -a == 0`)
* successor property (`add(a, 3) == add(add(add(a,1),1),1)`)

## Execution
The test execution is done via maven (wrapper):

```./mvnw test```
