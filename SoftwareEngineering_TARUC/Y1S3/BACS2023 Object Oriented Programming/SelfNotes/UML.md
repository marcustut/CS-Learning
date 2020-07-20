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