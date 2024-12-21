# Computer Professionals Program at MIU (ASD - Final Project)

## Project Overview
The **Advanced Software Design (ASD) Final Project** focuses on developing a framework to support multiple applications, including a **Banking System** and a **Credit Card Processing System**. Students will implement reusable patterns, frameworks, and architectures while designing scalable and maintainable software.

---

## Requirements

### Part 1: Banking System
- **Use Cases:**
  - Create a personal or company account (checking or savings).
  - Deposit and withdraw money.
  - Add interest.
  - Generate account reports.
- **Features:**
  - Email notifications for transactions exceeding $500 or resulting in negative balances.
  - Support for multiple accounts per customer.
  - Transaction history tracking.
- **Design Deliverables:**
  - Class diagrams for all entities and relationships.
  - Sequence diagrams for major use cases.

### Part 2: Credit Card Processing System
- **Use Cases:**
  - Create a credit card account.
  - Deposit money and charge accounts.
  - Add interest.
  - Generate monthly billing reports.
- **Features:**
  - Three credit card types (Gold, Silver, Bronze) with different interest rates and payment plans.
  - Email notifications for charges over $400.
  - Transaction history tracking.
- **Design Deliverables:**
  - Class diagrams for all entities and relationships.
  - Sequence diagrams for major use cases.

### Part 3: Framework Development
- Design a **Framework** to support both applications using:
  - **Account Pattern** for managing accounts.
  - **Party Pattern** for managing entities like customers and companies.
  - **Observer Pattern** for notifications and updates.
- Abstract common operations into reusable components.

### Part 4: Implementation
- Develop code organized into three packages:
  1. **framework**
  2. **banking**
  3. **creditcard**
- Build and test basic functionality for both applications.

---

## Extra Credit Opportunities
1. **Rules Engine:** Add general rules for accounts and transactions (e.g., fraud alerts for large charges).
2. **Persistence Layer:** Implement database storage using the **Façade Pattern**.
3. **Extend Framework:** Include a third application, such as an **online bookstore** with product categories and payment options.
4. **Visual Composition:** Create a visual tool for building applications from the framework.

---

## Deliverables
- UML diagrams for classes and sequences.
- Descriptions of design patterns used.
- Explanation of framework plug points and extensibility.
- Source code for framework and applications.

---

## Prerequisites
- Completion of **CS 401 (Modern Programming Practices)** or faculty approval.
- Proficiency in Java and Object-Oriented Programming principles.

---

## Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/anhvu2889/miu-cs525-asd-final-project
   ```
2. Open the project in your preferred IDE.
3. Compile and run Java programs:
   ```bash
   javac src/<file-name>.java
   java src/<file-name>
   ```
4. Execute unit tests:
   ```bash
   java -cp .:junit-platform-console-standalone.jar org.junit.platform.console.ConsoleLauncher --scan-classpath
   ```

---

## Contributing
Contributions are welcome! Follow these steps to contribute:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes with a descriptive message.
4. Submit a pull request for review.

---

## Contact
For questions or suggestions, please reach out to the course instructor or create an issue in the repository.

