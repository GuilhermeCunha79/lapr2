# US 004 - Register a test to be performed

## 1. Requirements Engineering


### 1.1. User Story Description


As a receptionist of the laboratory, I intend to register a test to be performed to a
registered client.



### 1.2. Customer Specifications and Clarifications


**From the specifications document:**

>Typically, the client arrives at one of the clinical analysis laboratories with a lab order prescribed by
a doctor. Once there, a receptionist asks the client’s citizen card number, the lab order (which
contains the type of test and parameters to be measured), and registers in the application the test to
be performed to that client.



**From the client clarifications:**

> **Question:** What are the necessary parameters according to the type of test?

> **Answer:** Each parameter is associated with one category. Each parameter has a Code, a Short Name and a Description. The Code are five alphanumeric characters. The Short Name is a String with no more than 8 characters. The Description is a String with no more than 20 characters."
This answers your question? Moreover, you have US10 saying "As an administrator, I want to specify a new parameter and categorize it".


> **Question:** When the receptionist chooses the test type, should the categories appear, and then when selecting the category, the receptionist can choose the parameters for the test? Or when the Receptionist chooses the test type, should appear all the parameters that it includes immediately?

> **Answer:** Firstly, the receptionist should choose a test type. Then choose a category from a set of categories. Last, the receptionist should choose a parameter.


> **Question:** What are the attributes of a test and the acceptance criteria?

> **Answer:** A test has the following attributes:
Test code : Sequential number with 12 digits. The code is automatically generated.
NHS code: 12 alphanumeric characters.


> **Question:** Since the Client has a Lab Order which contains the type of test and all the parameters to be measured, all the parameters selected by the Receptionist need to be equal to the Lab Order's parameters?

> **Answer:** Yes.


> **Question:** About the other Test attributes, do we need to have in consideration any other criteria? Is the code generated or NHS code optional ?

> **Answer:** All test attributes are mandatory. The test attributes are the following:
Test code : sequential number with 12 digits. The code is automatically generated.
NHS code: 12 alphanumeric characters.

 
> **Question:** when the receptionist is registering a test for a client, the test can have more than one category and many parameters of the chosen categories or it only can have one category?

> **Answer** Each test can have more than one category.


> **Question** I wanted to ask if the NHS code of which test is unique or not.

> **Answer** Yes. 

### 1.3. Acceptance Criteria


* **AC1:** a test can have only one type of test
* **AC2:** a test can have only one client


### 1.4. Found out Dependencies


* There is a dependency to "US 09 - Specify new test type category" since at least a test type must exist to classify the Test being created.

* There is a dependency to "US 10 - Specify a new parameter and categorize it" since at least a parameter must exist to classify the Test being created.

* There is a dependency to "US 11 - Create a parameter category" since at least a parameter category must exist to classify the Test being created.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
    * NHS code
* Selected data:
    * Classifying Parameter
    * Classifying Type Of Test category


**Output Data:**

* List of existing parameters for each type of test categories
* List of existing type of test categories
* List of the types of tests  
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Alternative 1**



**Other alternatives might exist.**

### 1.7 Other Relevant Remarks



## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt



### 2.2. Other Remarks

n/a


## 3. Design - User Story Realization

### 3.1. Rationale


| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
| Step 1  		 |	... interacting with the actor? | CreateTestUI   |  **Pure Fabrication:** there is no reason to assign this responsibility to any other of the existing class in the Domain Model.           |
| 		 |	... coordinating the US? | CreateTestController   |  **Controller**         |
| Step 2		 |	|   |          |
| Step 3		 | ... knows ClientStore?	| Company  |  **IE** Company knows the ClientStore to which is delegation some tasks        |
| 		 | ... knows TestTypeStore?	| Company  |  **IE** Company knows the TestTypeStore to which is delegation some tasks        |
| Step 4		 | |   |         |
| Step 5		 | 	|   |  TODO check this information        |
| Step 6		 | 	|   |  TODO check this information        |
| Step 7		 | 	|   |  TODO check this information        |
| Step 8		 | 	|   |  TODO check this information        |
| Step 9		 | ...savind the typed/selected data? 	| Test  |  **IE:** a Test knows its own data      |
| 		                 |	... instantiating a new Test? | TestStore   | **Creator (R1)** and **HC+LC**: By the application of the Creator (R1) it would be the "Company". But, by applying HC + LC to the "Company", this delegates that responsibility to the "TestStore"   |
|  		 			     |  ... knows TestStore?	 |  Company   |  **IE:** Company knows the TestStore to which it is delegating some tasks |
|  		             |	... validating all data (local validation)? | Test | **IE:** an object knows its data|
| 			  		 |	... validating all data (global validation)? | TestStore | **IE:** knows all the clients| 
| 			  		 |	... saving the test? | TestStore | **IE:** Knows all tests | 
| Step 10  |	... informing operation success?| CreateTestUI  | **IE:** is responsible for user interactions  |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are:

* CreateTestUI
* CreateTestController
* Company

Other software classes (i.e. Pure Fabrication) identified:

* Test
* TestDto
* TypeOfTestMapper
* ParameterMapper
* ParameterStore


## 3.2. Sequence Diagram (SD)






## 3.3. Class Diagram (CD)



# 4. Tests

**Test 1:** Check that it is not possible to create an instance of the Task class with null values.




**Test 2:** Check that it is not possible to create an instance of the Task class with a reference containing less

# 5. Construction (Implementation)


## Class CreateTaskController



## Class Organization





# 6. Integration and Demo

* A new option on the Reception menu options was added.


# 7. Observations







