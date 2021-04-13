# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._

*  All users should be authenticated with a password holding 7 alphanumeric characters,
including 3 capital letters & 2 digits, in order to use the app.
*  Only Specialist Doctor can access client data
*  Support for generating reports. (page 2)

## Usability

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

*  All images/figures should be exported in SVG format
*  English language is the only one supported
*  Application User manual

## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

*  Need to ensure data persistence between two runs of the application

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._


(fill in here )

## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 



(fill in here )


## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._
  
*  Use of Bitbucket Repository
*  Developed in Java
*  Use of recognized coding standards
*  JavaDoc to generate documentation
*  Implementation of Object-Oriented programming practices
*  Unit Test should be implemented using JUnit 4

### Implementation Constraints

_Specifies or constraints the code or construction of a system such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

*  Use of UML Language for diagrams development
*  Developed in Java
*  IDE IntelliJ or Netbeans
*  UI developed in JavaFX 11

### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._


(fill in here )

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

*  Not specified.