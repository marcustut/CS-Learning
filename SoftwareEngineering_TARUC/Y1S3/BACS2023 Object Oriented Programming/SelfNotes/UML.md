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

#### Aggregation

Aggregation is a special type of association that models a **whole-part relationship** between aggregate and its parts.

![Aggregation Example](https://i.ibb.co/yfG73vY/image.png)

For example, the College class is made up of one or more student. In aggregation, the contained classes(Student) are **never totally dependant** on the lifecycle of the container. Here, the college class will remain even if the student is not available.

![Aggregation Example 2](https://i.ibb.co/jVhzTds/image.png)

><u>**Aggregration**</u> is a special form of association, which represents an **ownership**(has-a) relationship between two classes.

>If an object is **exclusively owned** by an aggregated object, the relationship between the object and its aggregated object is referred to as <u>**Composition**</u>.

* **"A student has a name"** is a <u>**Composition**</u> relationship between the *Student* class and the *Name* class.
* **"A student has an address"** is an <u>**Aggregation**</u> relationship between the *Student* class and the *Address* class, this is because an address may be shared by several students.

![Aggregation in Code](https://i.ibb.co/nfcrNRR/image.png)

this above image show how we implement Aggregation in code.
