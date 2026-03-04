# Coffee Machine Simulator ☕

A robust, console-based Java application that simulates the internal logic of a professional coffee machine. This project demonstrates Clean Code principles, Object-Oriented Programming (OOP), and automated Unit Testing.

## 🚀 Features
The machine handles complex state management for the following actions:
- **Buy**: Choose between Espresso, Latte, or Cappuccino. The system automatically checks for sufficient ingredients.
- **Fill**: Replenish water, milk, coffee beans, and disposable cups.
- **Take**: Withdraw the accumulated cash from the machine.
- **Remaining**: Display a detailed status report of current resources.
- **Clean**: A mandatory cleaning cycle is required after every 10 cups to ensure hygiene.

## 🛠 Tech Stack
- **Java 25 (LTS)**: Utilizing modern features like Records and enhanced Switch expressions.
- **Maven**: For dependency management and build automation.
- **JUnit 5**: Comprehensive test suite for business logic validation.

## 🏗 Architecture & Design
The project was refactored from a monolithic script into a modular architecture to improve **Testability** and **Scalability**:
- **Core Logic (`CoffeeMachine`)**: A "pure" logic class that manages resources and state without direct Console I/O.
- **Representation Layer (`CoffeeMachineApp`)**: Handles user interaction and command processing.
- **Data Model (`Coffee`)**: Uses Java Records for immutable and concise ingredient definitions.
- **Outcome Mapping (`BuyResult`)**: Enums are used to communicate machine states clearly.

## 🚦 Getting Started

### Prerequisites
- **JDK 25** or higher
- **Maven 3.9+**

### Installation & Build
1. Clone the repository:
   ```bash
   git clone [https://github.com/oleksandr-sydorskyi/coffee-machine.git](https://github.com/oleksandr-sydorskyi/coffee-machine.git)
