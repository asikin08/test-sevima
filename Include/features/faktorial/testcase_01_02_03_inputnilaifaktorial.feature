
@tag
Feature: faktorial
  Testcase number 01 - 03 to scenario faktorial.

  @tag1
  Scenario Outline: User input nilai faktorial with <bilangan>
    Given Open browser
    When 	Input value faktorial <bilangan>
    And 	Tap hitung faktorial the button
    Then  Validation after input faktorial <validation>
    
    Examples: 
			|	bilangan	| validation 	|
			|	integer		| Success			|
			|	decimal		|	Failed			|
			|	simbol		|	Failed			|