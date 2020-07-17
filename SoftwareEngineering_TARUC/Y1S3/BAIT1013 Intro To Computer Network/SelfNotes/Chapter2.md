# Chapter 2 - Network Protocols and Communications

## 2.1 Rules of Communications

### Elements of Communications

#### 1. Message sources, or sender

People or devices that need to sends a message to another indivuals or device.

#### 2. Destination, or receiver

Receives the message and interprets it.

#### 3. A Channel

Consists of media that provides a pathway for messages to travel from source to destination.

### Segmentation

* Divide the data into smaller, more manageable pieces which are called **Segments**.

* Allow many conversation to be interleaved on the network, giving each user a part of the bandwidth - **Multiplexing**.

* Increase reliability of network commmunications.

## 2.2 Network Protocols and Standards

### Network Protocols

* A **protocol** is a formal description of a set of rules and convetions to govern on a particular aspect on how a device communicates on a network.

* A **protocol suite** is a group of inter-related protocols that are neccessary to perform a communication function.

### OSI Model

| Data Unit | Layers       |
|-----------|--------------|
| Data      | Application  |
| Data      | Presentation |
| Data      | Session      |
| Segments  | Transport    |
| Packets   | Network      |
| Frames    | Data Link    |
| Bits      | Physical     |

#### The benefits of layered model

* Fosters competition because products from different vendors can work together.

* Prevents technology or capability changes in one layer from affecting other layers above and below.

* Provids a common language to describe networking functions and capabilities.

### Protocol Model vs Reference Model

> ....

#### Comparing OSI and TCP/IP Model

> ....

#### OSI Reference Model - Layer 7 (Application)

The application layer contains *protocols used for process-to-process communications*.

Example of Layer 7 Applications: E-mail, FTP, Telnet, HTTP, etc.

#### OSI Reference Model - Layer 6 (Presentation)

To **ensure the information** from sender's application layer **can be read by receiver's application layer**.

* Translate multiple data formats into a common format.

* Responsible for encryption and decrption.

Example of Layer 6 Common Standards: JPEG, PNG, MP4, MIDI, MPEG

#### OSI Reference Model - Layer 5 (Session)

**Establishes, manages and terminates sessions** between two communication hosts.

#### OSI Reference Model - Layer 4 (Transport)

The transport layer defines services to **segment, transfer and reassemble the data** for individual communications between the end devices.

Example of Layer 4 Protocols: Transmission Control Protocol (TCP), User Datagram Protocol (UDP), Sequenced Packet Exchange (SPX)

#### OSI Reference Model - Layer 3 (Network)

Responsible for delivery of individual packets from **source to destination (host-to-host delivery *across multiple network*)**.

* Concerned with **logical addressing** such as IP address, routing, packetizing, fragmenting.

Example of Layer 3 Protocols: IP, IPX (Internetwork Packet Exchange)

Example of Layer 3 Devices: Layer 3 Switches, Routers

#### OSI Reference Model - Layer 2 (Data Link)

Responsible for delivery of data across a physical link **(host-to-host delivery *within the same network*)**.

* Concerned with **physical addressing** such as MAC address, network topology.

Example of Layer 2 Protocols: Ethernet, Token Ring, Frame Relay

Example of Layer 2 Devices: Bridges, Switches, NICs

#### OSI Reference Model - Layer 1 (Physical)

Defines the electrical, mecahnical, procedural and functional specifications for actiating, maintaining and deactivating the physical link between end systems.

* Concerned with **raw bits transmission**.

Attributes: Voltage levels, Physical data rates, maximum transmission distances, physical connectors.

Example of Layer 1 Devices: Repeaters, Hubs