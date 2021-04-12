# OO Analysis #

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development". 


### _Conceptual Class Category List_ ###

**Business Transactions**

*  Test 

---

**Transaction Line Items**

*  Blood Samples
*  General Samples

---

**Product/Service related to a Transaction or Transaction Line Item**

*  Parameter

---

**Transaction Records**

*  

--- 

**Roles of People or Organizations**

*  ManyLabs
*  NHS
*  Client
*  Receptionist
*  Lab Coordinator
*  Medical Lab Technician
*  Specialist Doctor
*  Clinical Chemistry Technologist
*  Admin
*  Employee

---

**Places**

*  Labs
*  Chemical Labs
*  Headquarters
*  Application

---

**Noteworthy Events**

*  Chemical Analysis
*  Test Request
*  Write Reports & diagnosis

---

**Physical Objects**

*  Samples

---

**Descriptions of Things**

*  Type of Test
*  Category

---

**Catalogs**

*  

---

**Containers**

*  

---

**Elements of Containers**

*  

---

**Organizations**

*  ManyLabs (company)
*  NHS

---

**Other External/Collaborating Systems**

*  External Barcode Generator

---

**Records of finance, work, contracts, legal matters**

*  NHS Reports 

---

**Financial Instruments**

*  

---

**Documents mentioned/used to perform some work**

*  Lab Order
*  Citizen Card
*  Reports
*  Diagnosis

---

###**Rationale to identify associations between conceptual classes**

An association is a relationship between instances of objects that indicates a relevant connection and that is worth of remembering, or it is derivable from the List of Common Associations: 

+ **_A_** is physically or logically part of **_B_**
+ **_A_** is physically or logically contained in/on **_B_**
+ **_A_** is a description for **_B_**
+ **_A_** known/logged/recorded/reported/captured in **_B_**
+ **_A_** uses or manages or owns **_B_**
+ **_A_** is related with a transaction (item) of **_B_**
+ etc.



| Concept (A) 		|  Association   	|  Concept (B) |
|----------	   		|:-------------:    |------:       |
| Many Labs  	    | has    		 	| Employees |
| Employees  	    | has    		 	| Admin  |
| Employees  	    | has    		 	| Specialist Doctor |
| Employees  	    | has    		 	| Lab Coordinator |
| Employees  	    | has    		 	| Receptionist |
| Employees  	    | has    		 	| Medical Lab Technician |
| Doctor  	        | performs    		| Tests |
| Test   	        | has    		 	| Report |
| Test   	        | has    		 	| Diagnosis |
| Test              | has               | Type of test |
| Test   	        | has    		 	| Sample |
| Receptionist  	| add 		 	    | Client |
| Receptionist  	| register 		    | Test |
| Admin             | add new type      | Test |
| Client  	        | request 		 	| Test |
| Medical Lab Technician | collect      | Sample |
| Medical Lab Technician | works at     | Lab |
| Chemical Lab    | perform      | Chemical analyses |
| Chemical Lab    | receive      | Samples |
| Headquarters    | has      | Chemical lab |
| Lab Coordinator | validates 		 	| Report |


## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![DM.svg](DM.svg)



