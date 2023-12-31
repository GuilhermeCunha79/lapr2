# US 09 - Specify a new type of test

## 1. Requirements Engineering


### 1.1. User Story Description

* As an administrator, I want to specify a new type of test and its collecting methods.

### 1.2. Customer Specifications and Clarifications 
*From the Specification Document:*

>"Each test is characterized by an internal code, an NHS
code, a description that identifies the sample collection method, the date and time when the samples
were collected, the date and time of the chemical analysis, the date and time of the diagnosis made
by the specialist doctor, the date and time when the laboratory coordinator validated the test, and the
test type (whether it is blood test or Covid test)."

>"Despite being out of scope, the system should be developed having in mind the need to
easily support other kinds of tests (e.g., urine). Regardless, such tests rely on measuring one
or more parameters that can be grouped/organized by categories."

*From the client clarifications:*

> **Question:** In the US9 what do you mean by the collecting methods and  what collecting methods  are available?
>
> **Answer:** To make a Covid test you need a swab to collect a sample. To make a blood test you need sample tubes and a syringe.
>When the administrator (US9) specifies a new type of test, the administrator also specifies the method to collect a sample.
> The administrator introduces a brief description for each collecting method.

>**Question:** Does a type of test holds any attribute besides its name and collecting methods?
>
>**Answer:** The attributes for a new test type are:
            Code: five alphanumeric characters. The code is not automatically generated.
            Description: a string with no more than 15 characters.
            Collecting Method: a string with no more than 20 characters.
            Each test type should have a set of categories. Each category should be chosen from a list of categories.
            From a previous post: "Each category has a name and a unique code. There are no subcategories."


### 1.3. Acceptance Criteria

* **AC1:** All required fields must be filled in.
* **AC2:** The collecting method description needs the materials used and have no more than 20 characters.
* **AC3:** The code must have 5 alphanumeric characters written.
* **AC4:** The Description must have no more than 15 characters.
* **AC5:** There exists only one collection method per test type.


### 1.4. Found out Dependencies
 
 UC11:As an administrator, I want to specify a new parameter category.

### 1.5 Input and Output Data

**Input Data:**
* Typed data:
    *code
    *description
    *collecting method
    
* Selected data:
    *Category
 
**Output Data:**
*(In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![UC9_SSD](UC9_SSD.svg)

### 1.7 Other Relevant Remarks

n/a

## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![UC9_MD](UC9_MD.svg)

### 2.2. Other Remarks

n/a


## 3. Design - User Story Realization 

### 3.1. Rationale
**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
| Step 1: Specify a New Type of test  |... interacting with the actor? | SpecifyANewTypeOfTestUI    | UI Layer is always responsible for user interactions |         
| Step 2: Requests necessary data |... requesting data needed? | SpecifyANewTypeOfTestUI | UI Layer is responsible for user interaction |
| Step 4: Create new type of test |... send command to create new type of test? | SpecifyANewTypeOfTestController | Controller makes the bridge between UI layer and Domain Layer|
| Step 5: Initiate store process|... start the store process for the type of test being created? | Company | HC+LC: Company delegates some of its responsibilities to other classes |      
| Step 6: Create new type of test |... instantiating new type of test? | TypeOfTestStore | Creator: R1/2 |      
| Step 7: Save Data |... saving the introduced data? | TypeOfTest  | IE: instance of object created has its own data.  |
| Step 8: Validate type of test |... validating all data (local validation)? | TypeOfTestStore | IE: knows its own data.|
| Step 9: Present data to user |...requesting confirmation for data introduced? | SpecifyANewTypeOfTestUI | UI Layer is responsible for user interaction |
| Step 11: Save type of test |... send command to save the created type of test? | SpecifyANewTypeOfTestController | Controller makes the bridge between UI layer and Domain Layer|
| Step 12: Save type of test |... saving the created type of test? | TypeOfTestStore | IE: stores all type of test created|
| Step 13: Validate type of test globally |... validating all data at global level? | TypeOfTestStore | IE: Company Knows all existing Type of Test|
| Step 14: Add type of test |... add created type of test to the list? | TypeOfTestStore | IE: Responsible to add new Type of Test to the list|
| Step 15: Operation success |... informing operation success?| SpecifyANewTypeOfTestUI | UI Layer is responsible for user interactions.  |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * TypeOfTest
 * TypeOfTestStore

Other software classes (i.e. Pure Fabrication) identified: 

 * SpecifyANewTypeOfTestUI
 * SpecifyANewTypeOfTestController
 
## 3.2. Sequence Diagram (SD)


![UC9_SD](UC9_SD.svg)


## 3.3. Class Diagram (CD)


![UC9_CD](UC9_CD.svg)

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of a NewTypeOfTest class with null values.

    (expected = NullPointerException.class)
    public void ensureNullTypeOfTestIsNotCreated() {
       new TypeOfTest(null, null, null, null);
    }



**Test 2:** Check that it is not possible to get an instance of a NewTypeOfTest class with values assigned to another.


    public void ensureCannotCreateSameTOTTwice() {
        Listpc.add(pc);
        ctrl.createANewTypeOfTest("33452", "IE", "CM", Listpc);
        ctrl.saveTypeOfTest();
        ctrl.createANewTypeOfTest("33452", "IE", "CM", Listpc);
        assertFalse(ctrl.saveTypeOfTest());
    }



# 5. Construction (Implementation)


## Class SpecifyANewTypeOfTestController

    public SpecifieANewTypeOfTestController(TypeOfTestStore totStore){
        this.tots = totStore;
        this.tot = null;
    }

   
    public SpecifieANewTypeOfTestController() {
        this(App.getInstance().getCompany().getTypeOfTestStore());
    }

   
    public boolean createANewTypeOfTest(String code, String description, String colectingmethod,  List<ParameterCategory> parameterCategoryList){
        this.tot = this.tots.createTypeOfTest( code, description, colectingmethod, parameterCategoryList);
        return tots.validateTypeOfTest(tot);
    }


    
    public TypeOfTest getTot(){
        return this.tot;
    }

   
    public boolean saveTypeOfTest(){
        return this.tots.saveTypeOfTest(tot);
    }


 
    public List<ParameterCategory> getCategoryList(){
        return App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryList();
    }


## Class TypeOfTest

    public TypeOfTest(String code, String description, String collectingMethod, List<ParameterCategory> parameterCategoryList){
        setCode(code);
        setDescription(description);
        setCollectingMethod(collectingMethod);
        this.parameterCategoryList = new ArrayList<>(parameterCategoryList);
    }

    public String getCode() { return code; }

    
    public String getDescription() { return description; }

    
    public String getCollectingMethod() { return collectingMethod; }

   
    public void setCode(String code) {
        CommonMethods.codeValidation(code);
        this.code = code;
    }
    
    public void setDescription(String description) {
        if (description == null)
            throw new NullPointerException(Constants.STRING_DESCRIPTION + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException(Constants.STRING_DESCRIPTION + Constants.STRING_BLANK_EXEPT);
        if (description.length() > DESCRIPTION_LENGTH)
            throw new IllegalArgumentException(Constants.STRING_DESCRIPTION + " cannot have more than 15 characters.");
        this.description = description;
    }

   
    public void setCollectingMethod(String collectingMethod) {
        if (collectingMethod == null)
            throw new NullPointerException(STRING_COLLECTING_METHODS + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(collectingMethod))
            throw new IllegalArgumentException(STRING_COLLECTING_METHODS + Constants.STRING_BLANK_EXEPT);
        if (collectingMethod.length() > COLLECTING_METHOD_LENGTH)
            throw new IllegalArgumentException(STRING_COLLECTING_METHODS + Constants.STRING_NOT_MORE_THAN_20);
        this.collectingMethod = collectingMethod;
    }

    
    @Override
    public String toString() {
        return String.format("Type of Test:%nCode: %s%nDescription: %s%nCollecting Method: %s%n%s", this.code, this.description, this.collectingMethod, printCategories());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TypeOfTest newTot = (TypeOfTest) obj;
        return code.equals(newTot.code) || description.equals(newTot.description) &&
                collectingMethod.equals(newTot.collectingMethod);
    }


    
    private String printCategories(){
        if(parameterCategoryList != null && parameterCategoryList.size()>0){
            String output = String.format("Parameter Category(ies):%n");
            for (ParameterCategory category : parameterCategoryList) {
                output = output.concat(category.toString());
            }
            return output;
        }else {
            return ("No Categories");
        }
    }
    

## Class SpecifyANewTypeOfTestUI

    @Override
    public void run() {
        ctrl = new SpecifieANewTypeOfTestController();

        boolean created = createTypeOfTest();
        if (created) {
            System.out.println("Type of test was created!");
        }
    }

    private boolean createTypeOfTest() {
        boolean done = false;
        do {
            try {
                String code = Utils.readLineFromConsole("Introduce type of test code: ");
                String description = Utils.readLineFromConsole("Introduce type of test description: ");
                String collectingMethod = Utils.readLineFromConsole("Introduce type of test colecting method: ");

                List<ParameterCategory> categoryList = ctrl.getCategoryList();
                if (categoryList.isEmpty()) {
                    System.out.println("\nThere is no parameter categories in the system.\nPlease create one first!");
                    return false;
                } else {
                    System.out.println();
                    List<String> displayCatList = new ArrayList<>();
                    for (ParameterCategory category : categoryList) {
                        displayCatList.add(category.getName());
                    }
                    ArrayList<ParameterCategory> listOfSelectedCategories = new ArrayList<ParameterCategory>();
                    int option = Utils.showAndSelectIndex(displayCatList, "Choose Category:");
                    while (option != -1) {

                        ParameterCategory selectedCategory;
                        selectedCategory = categoryList.get(option);

                        listOfSelectedCategories.add(selectedCategory);

                        displayCatList.remove(option);
                        if (Objects.requireNonNull(Utils.readLineFromConsole("Add another category: (Y or N)")).equalsIgnoreCase("y"))
                            option = Utils.showAndSelectIndex(displayCatList, "Choose Category:");
                        else
                            option =-1;
                    }

                    boolean created = ctrl.createANewTypeOfTest(code, description, collectingMethod, listOfSelectedCategories);
                    if (created) {
                        System.out.println("Confirm Type of test: ");
                        System.out.println(ctrl.getTot().toString());
                        if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                            done = true;
                            return ctrl.saveTypeOfTest();
                        } else {
                            System.out.println("\nOperation cancelled");
                            return false;
                        }
                    }
                }
                System.out.println("Error: Duplicated Type of Test:");
                return false;
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        } while (!done);
        return false;
    }


## Class TypeOfTestStore

    public TypeOfTest createTypeOfTest(String code, String description, String colectingmethod, List<ParameterCategory> parameterCategoryList){
    return new TypeOfTest(code, description, colectingmethod, parameterCategoryList);
    }

  
     
    public boolean saveTypeOfTest(TypeOfTest tot){
        if(validateTypeOfTest(tot)){
           return addTypeOfTest(tot);
        }
        return false;
    }


   
    public boolean addTypeOfTest(TypeOfTest tot) {
        if (tot != null && validateTypeOfTest(tot)){
                return this.typeOfTestList.add(tot);
        }
        return false;
    }


  
    public boolean validateTypeOfTest(TypeOfTest tot) {
        for (TypeOfTest typeTe : typeOfTestList){
            if(typeTe.equals(tot)){
                return false;
            }
        }
        return true;
    }

    
    public List<TypeOfTest> getTypeOfTestList() {
        return new ArrayList<>(typeOfTestList);
    }


# 6. Integration and Demo 
 
* Type of Test specification option put in AdminUI

# 7. Observations

 No observations.