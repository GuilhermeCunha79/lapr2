# US 011 - To create a new parameter category

## 1. Requirements Engineering


### 1.1. User Story Description


As an administrator, I want to specify a new parameter category.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	"Regardless, such tests rely on measuring one 
    or more parameters that can be grouped/organized by categories."
>
>   “Blood tests are frequently characterized by measuring several parameters which for presentation/reporting purposes are organized 
 by categories. For example, parameters such as the number of Red Blood Cells (RBC), White Blood Cells (RBC) and Platelets (PLT) are 
 usually presented under the blood count (Hemogram) category.”


**From the client clarifications:**

> **Question:** What are the information related to a Parameter Category?
>  
> **Answer:** Each category has a name, unique code. There are no subcategories.


### 1.3. Acceptance Criteria


* **AC1:** All required fields must be filled.
* **AC2:** Each category must have a name, a unique code.
* **AC3:** When creating a new category with the same name and code as one previously registered in the system, 
the application should deny the operation and inform the user to change the parameters or discard the operation.
* **AC4:** Code must be unique having 4 to 8 chars (TP ESOFT) ???

### 1.4. Found out Dependencies

* No dependencies were found.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* Parameter category name.
	* Parameter category code.
	
* Selected data:
	* (none)

**Output Data:**
* Success or failure in the operation.

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
| Step 1: Start new parameter category |... interacting with the actor? | CreateNewParameterCategoryUI    | UI Layer is always responsible for user interactions |         
| Step 2: Ask for the data |... requesting data needed? | CreateNewParameterCategoryUI | UI Layer is responsible for user interaction |
| Step 4: Create new parameter category |... send command to create new parameter category? | CreateNewParameterCategoryController | Controller makes the bridge between UI layer and Domain Layer| 
| Step 5: Initiate store process|... start the store process for the parameter category being created? | Company | HC+LC: Company delegates some of its responsibilities to other classes |      
| Step 6: Create new parameter category |... instantiating new parameter category? | ParameterCategoryStore | Creator: R1/2 |      
| Step 7: Save Data |... saving the introduced data? | ParameterCategory  | IE: instance of object created has its own data.  |
| Step 8: Validate parameter category |... validating all data (local validation)? | ParameterCategoryStore | IE: knows its own data.| 
| Step 9: Present data to user |...requesting confirmation for data introduced? | CreateNewParameterCategoryUI | UI Layer is responsible for user interaction |
| Step 11: Save parameter category |... send command to save the created parameter category? | CreateNewParameterCategoryController | Controller makes the bridge between UI layer and Domain Layer| 
| Step 12: Save parameter category |... saving the created parameter category? | ParameterCategoryStore | IE: stores all parameter category created| 
| Step 13: Validate parameter category globally |... validating all data at global level? | ParameterCategoryStore | IE: Company Knows all existing Parameter Category| 
| Step 14: Add parameter category |... add created parameter category to the list? | ParameterCategoryStore | IE: Responsible to add new Parameter Categories to the list| 
| Step 15: Operation success |... informing operation success?| CreateNewParameterCategoryUI | UI Layer is responsible for user interactions.  | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * ParameterCategory
 * ParameterCategoryStore

Other software classes (i.e. Pure Fabrication) identified: 

 * NewParameterCategoryUI  
 * CreateNewParameterCategoryController


## 3.2. Sequence Diagram (SD)


![UC11_SD](UC11_SD.svg)


## 3.3. Class Diagram (CD)


![UC11_CD](UC11_CD.svg)

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the NewParameterCategory class with same parameters as an existing parameter category - AC3.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Task instance = new Task(null, null, null, null, null, null, null);
	}
	

**Test 2:** Check that it is not possible to create an instance of the NewParameterCategory class with no parameters assigned to it - AC1.

	@Test(expected = IllegalArgumentException.class)
		public void ensureReferenceMeetsAC2() {
		Category cat = new Category(10, "Category 10");
		
		Task instance = new Task("Ab1", "Task Description", "Informal Data", "Technical Data", 3, 3780, cat);
	}




# 5. Construction (Implementation)


## Class CreateTaskController 

		


## Class Organization




# 6. Integration and Demo 




# 7. Observations






