# Guide to UML Diagram

**UML** - Unified Modeling Language

## How to draw an UML Diagram

### 1. Create a Problem Statement/Scenario

* eg. BRJ Makmak is planning to roll out its Ordering System to ease the work of their waiters, and overall increasing the productivity of staffs. Other than that, customers are able to order food quickly and able to pay with various payment methods such as e-wallet.

### 2. Identify the classes

* CRC Cards (Classess, Responsibilities and Collaborators)

<table>
  <tr>
    <th colspan="2">Class Name</th>
  </tr>
  <tr>
    <td>Responsibilities</td>
    <td>Collaborators</td>
  </tr>
</table>

#### Example for Makmak Ordering System

<table>
  <tr>
    <th colspan="2">Customer</th>
  </tr>
  <tr>
    <td>Order a food</td>
    <td>Order, Menu</td>
  </tr>
  <tr>
    <td>Make payment</td>
    <td>Order, Payment</td>
  </tr>
</table>

### 3. Add Attributes and Methods

* Public (+)
* Private (-)
* Protected (#)
* Package (~)
* Drived (/)
* Static (_)

#### Example for Customer class

<table>
  <tr>
    <th>Customer</th>
  </tr>
  <tr>
    <td>- id: int</td>
  </tr>
</table>

### 4. Disocvering Class Relationships

#### Types of Class Relationships

![UML Class Relationships](https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Uml_classes_en.svg/300px-Uml_classes_en.svg.png)

* Association
* Aggregation
* Composition
* Dependency
* Inheritance

#### Association (Relationship)

![Types of Association](https://d2h0cx97tjks2p.cloudfront.net/blogs/wp-content/uploads/sites/2/2018/05/Types-of-Association.png)

* **IS-A**
* **HAS-A**
  * Aggregation
  * Composition

##### Cardinality/Multiplicity

![Cardinality Example](https://cdn-images.visual-paradigm.com/guide/uml/uml-class-diagram-tutorial/11-associations-with-different-multiplicies.png)

Cardinality is expressed in terms of:

* One to one
* One to many
* Many to many

#### Association

**Association** represents a *general binary* relationship that descirbes an activity between two classes.

![Association Example](https://i.ibb.co/64wXVnF/image.png)

Relationship shown above can be described as:

* A student taking a course is an association between the **Student** class and the **Course** class.
* A faculty member teaching a course is an association between the **Faculty** class and the **Course** class.

![How to draw an association](https://i.ibb.co/gSsg0VT/image.png)

above is an example of how an association between two classes is drawn.

![Association in code](https://i.ibb.co/WFB8FjK/image.png)

Visualizing an association in Java code. An association is usually represented as a **data field** in the class.

![Further example of Association](https://i.ibb.co/sVMGNG0/image.png)

The relationship allows objects to call methods in other objects.

![Object references](https://i.ibb.co/bPkCJ0S/image.png)

![Another example - Lecturer teach Course](https://i.ibb.co/m0G77Xk/image.png)

Both examples above are **one-directional** association.

![Bidirectional Relationship Example](https://i.ibb.co/KzPBMM2/image.png)

This above example is a representation of **bidirectional**(many-to-many) association.

**Association** - [Example Source Code](https://github.com/marcustut/CS-Learning/tree/master/SoftwareEngineering_TARUC/Y1S3/BACS2023%20Object%20Oriented%20Programming/Teaching%20Materials/Lecture5Example/src/Association)

#### Aggregation (Has-A) (Independant)

Aggregation is a special type of association that models a **whole-part relationship** between aggregate and its parts.

![Aggregation Example](https://i.ibb.co/yfG73vY/image.png)

For example, the College class is made up of one or more student. In aggregation, the contained classes(Student) are **never totally dependant** on the lifecycle of the container. Here, the college class will remain even if the student is not available. (weak relationship)

![Aggregation Example 2](https://i.ibb.co/jVhzTds/image.png)

><u>**Aggregration**</u> is a special form of association, which represents an **ownership**(has-a) relationship between two classes.

* **"A student has an address"** is an <u>**Aggregation**</u> relationship between the *Student* class and the *Address* class, this is because an address may be shared by several students.

##### Why do we need Aggregation?

* To maintain code re-usability
  * Suppose there are two other classes College and Staff. In order to maintain Sutdent's address, College address and Staff's address we don't need to use the same code again and again.

> **Student** *Has-A* **Address** (Has-a relationship between student and address)<br>
**College** *Has-A* **Address** (Has-a relationship between college and address)<br>
**Staff** *Has-A* **Address** (Has-a relationship between staff and address)

##### Representing Aggregation in Code (define a new data field)

![Aggregation in Code](https://i.ibb.co/nfcrNRR/image.png)

this above image show how we implement Aggregation in code.

![Aggregation Example in Code](https://i.ibb.co/QK1t9BT/image.png)

```java
public class Person {
  private Person[] supervisors;
}
```

If a person has several supervisors, we may use an array to store the supervisors.

#### Composition (Has-A) (Dependant)

Composition is a special type of association which denotes strong ownership between two classes when one class is a part of another class.

![Composition Example](https://i.ibb.co/kc20BHz/image.png)

For example, if college is composed of classes student. The <u>college could contain many students, while each student belongs to only one college</u>. So, **if college is not functioning all the students also removed.** (strong relationship)

![Composition Example 2](https://i.ibb.co/jVhzTds/image.png)

>If an object is **exclusively owned** by an aggregated object, the relationship between the object and its aggregated object is referred to as <u>**Composition**</u>.

* **"A student has a name"** is a <u>**Composition**</u> relationship between the *Student* class and the *Name* class.

##### Representing Composition in Code (creating a new object)

```java
public class Car {
  private Engine carEngine = new Engine();
}
```

#### Aggregation vs Composition

![Aggregation Example 2](https://i.ibb.co/jVhzTds/image.png)

><u>**Aggregration**</u> is a special form of association, which represents an **ownership**(has-a) relationship between two classes.
>If an object is **exclusively owned** by an aggregated object, the relationship between the object and its aggregated object is referred to as <u>**Composition**</u>.

* **"A student has an address"** is an <u>**Aggregation**</u> relationship between the *Student* class and the *Address* class, this is because an address may be shared by several students.
* **"A student has a name"** is a <u>**Composition**</u> relationship between the *Student* class and the *Name* class.

|Aggregation|Composition|
|-----------|-----------|
| Aggregation indicates a relationship where the child   can exist separately from their parent class. Example: Automobile (Parent) and Car(Child). So, if   you delete the Automobile, the child Car still exist.  | Composition display relationship where the child will  never exist independent of the parent. Example: House  (parent) and Room (child). Rooms will never separate  into a House. |

#### Inheritance (Is-A)

Taxonomic relationship between a more general classifier and a more specific classifier. (Parent and Child)

* Each instance of the specific classifier is also an indirect of the general classifier. (Extends)
* The specific classifer inherits the feature of the more general classifier.

Examples(UML):

![Inheritance Example](https://i.ibb.co/CvMWNCB/image.png)
![Inheritance Example 2](https://i.ibb.co/KLtTdjQ/image.png)

##### Representing Inheritance in Code (extends parent class)

```java
public class Proton extends Car {
  private String model;

  public void ProtonStartDemo() {
    Engine ProtonEngine = new Engine();
    ProtonEngine.start();
  }
}
```

#### Dependency

Dependency describes a relationship between two classes where one (called **client**) uses the other (called **supplier**).

![Dependency Example](https://i.ibb.co/njFVKyw/image.png)

Calendar - **Client**<br>
Date - **Supplier**

* The Calendar class uses Date by setting calendar with a specified Date object. The relationship between Calendar and Date can be described using <u>dependency</u>.

![Dependency Example 2](https://i.ibb.co/RhMGKJ3/image.png)

* Dependency indicates a semantic relationship between two or more elements.
* The dependency from <u>*CourseSchedule*</u> to <u>*Course*</u> exists because <u>*Course*</u> is used in both the add and remove operations of <u>*CourseSchedule*</u>.

##### Representing Dependency in Code (using a method in client class)

```java
public abstract class Calendar {
  public void setTime(Date d) {
    // something here
  }
}
```

* The method contains a parameter of the supplier class type.
  * The **Calendar** class has the **setTime(Date)** method that sets a new time in the calendar.
