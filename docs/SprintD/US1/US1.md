# US 008 -  Register a new clinical analysis laboratory

## 1. Requirements Engineering


### 1.1. User Story Description

As a client, I want to access the application to view the results of the tests I have
performed.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>

**From the client clarifications:**

> **Question:** 

> **Answer:** 


> **Question:** 
  
> **Answer:** 


> **Question:** 

> **Answer:** 


> **Question:** 

> **Answer:** 


> **Question** 

> **Answer** 


> **Question** 
 
> **Answer**


> **Question** 

> **Answer** 


> **Question** 

> **Answer** 

### 1.3. Acceptance Criteria

* **AC1:** The client tests must be shown ordered from the most recent to the oldest one.
* **AC2:** The test results are shown only after the client has selected a test.
* **AC3:** 
* **AC4:** 
* **AC5:** 
* **AC6:** 


### 1.4. Found out Dependencies


### 1.5 Input and Output Data


**Input Data:**

* 
* 
* 
* 
* 
	
**Selected data**
* 


**Output Data:**
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)


### 1.7 Other Relevant Remarks
* n/a.

## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 




### 2.2. Other Remarks

n/a


## 3. Design - User Story Realization 

### 3.1. Rationale

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
   | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* 
* 
* 

Other software classes (i.e. Pure Fabrication) identified: 

* 
* 


## 3.2. Sequence Diagram (SD)




## 3.3. Class Diagram (CD)



# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of a  without all attributes assigned to it. 

     
**Test 2:** Check that it is not possible to create an instance of a  with a  
      
   

**Test 3:** Check that it is not possible to create an instance of an Address with a name with more than 30 characters. (AC4)

   

**Test 3:** Check that it is not possible to create an instance of a Clinical Analysis Laboratory with a LaboratoryID with more than 5 characters. (AC5)

                                

**Test 4:** Check that it is not possible to create an instance of a Clinical Analysis Laboratory with a Phone Number with more than 11 characters. (AC2)

    

**Test 5:** Check that it is not possible to create an instance of a Clinical Analysis Laboratory with a Tin Number with more than 10 characters. (AC3)
                             
    


# 6. Integration and Demo 



# 7. Observations

No observations.





