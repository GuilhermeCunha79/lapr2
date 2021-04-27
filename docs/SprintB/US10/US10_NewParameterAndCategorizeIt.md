# US 006 - To specify a new parameter and categorize it

## 1. Requirements Engineering


### 1.1. User Story Description


As an administrator, I want to specify a new parameter and categorize it.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	"...the system should be developed having in mind the need to easily support other kinds of tests..."
>
>   "...such tests rely on measuring one or more parameters that can be grouped/organized by categories..."



**From the client clarifications:**

> **Question:** Which data is needed to create a new parameter?
>  
> **Answer:** Each parameter is associated with one category. Each parameter has a Code, a Short Name and a Description.
>
> **Question:** What rules does the parameter's data need to follow in order to be accepted? 
>
> **Answer:** The Code are five alphanumeric characters. The Short Name is a String with no more than 8 characters. 
>The Description is a String with no more than 20 characters.


### 1.3. Acceptance Criteria

* **AC1:** The parameter created must be associated with a category.
* **AC2:** The new parameter needs to have a short name, a code and a description to be created.
* **AC3:** The parameter's code is composed by 5 alphanumeric characters.
* **AC4:** The parameter's short name is a string with no more than 8 characters.
* **AC5:** The parameter's description is a string with no more than 20 characters.


### 1.4. Found out Dependencies

There is dependency with the US11 - Create New Parameter Category, because in order to create a new parameter the system 
must have at least one category, so the admin can categorize the new parameter.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
    *   Parameter's Short Name (8 chars max)
    *   Parameter's Description (20 chars max)
    *   Parameter's Code (5 alphanumeric chars)    
	
* Selected data:
    *   Category

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)


![UC11_SSD](UC11_SSD.svg)


### 1.7 Other Relevant Remarks




## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![UC11_MD](UC11_MD.svg)

### 2.2. Other Remarks

n/a


## 3. Design - User Story Realization 

### 3.1. Rationale


| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
|

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Employee
 * Parameter

Other software classes (i.e. Pure Fabrication) identified: 

 * ParameterCreationAndCategorizationUI  
 * ParameterCreationAndCategorizationController


## 3.2. Sequence Diagram (SD)


![UC11_SD](UC11_SD.svg)


## 3.3. Class Diagram (CD)


![UC11_CD](UC11_CD.svg)

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of a Parameter without having a category assigned to it. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Task instance = new Task(null, null, null, null, null, null, null);
	}
	

**Test 2:** Check that it is not possible to create an instance of a parameter without having named it. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureReferenceMeetsAC2() {
		Category cat = new Category(10, "Category 10");
		
		Task instance = new Task("Ab1", "Task Description", "Informal Data", "Technical Data", 3, 3780, cat);
	}




# 5. Construction (Implementation)


## Class CreateTaskController 

		public boolean createTask(String ref, String designation, String informalDesc, 
			String technicalDesc, Integer duration, Double cost, Integer catId)() {
		
			Category cat = this.platform.getCategoryById(catId);
			
			Organization org;
			// ... (omitted)
			
			this.task = org.createTask(ref, designation, informalDesc, technicalDesc, duration, cost, cat);
			
			return (this.task != null);
		}


## Class Organization


		public Task createTask(String ref, String designation, String informalDesc, 
			String technicalDesc, Integer duration, Double cost, Category cat)() {
		
	
			Task task = new Task(ref, designation, informalDesc, technicalDesc, duration, cost, cat);
			if (this.validateTask(task))
				return task;
			return null;
		}



# 6. Integration and Demo 



# 7. Observations






