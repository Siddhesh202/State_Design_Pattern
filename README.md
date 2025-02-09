# ATM Machine Project

## Overview

This project simulates the behavior of an ATM machine using a state pattern. The ATM machine transitions through various states such as reading card details, reading cash withdrawal details, dispensing cash, and ejecting the card. Each state is represented by a class that implements the `State` interface.

## Project Structure

- **src/ATMMachine/state**: Contains the state classes and the `State` interface.
- **src/ATMMachine/apis**: Contains the `BackendAPI` class which simulates backend operations.
- **src/ATMMachine/enums**: Contains the `ATMState` enum which defines the possible states of the ATM.
- **src/ATMMachine/factory**: Contains the `CardManagerFactory` class which provides the appropriate `CardManagerService` based on the card type.
- **src/ATMMachine/models**: Contains the `ATM` and `Card` classes which represent the ATM machine and the card respectively.
- **src/ATMMachine/service**: Contains the `CardManagerService` class which provides services related to card validation and withdrawal amount validation.

## State Classes

### `ReadyForTransactionState`
- **Purpose**: Represents the state where the ATM is ready to start a new transaction.
- **Key Methods**:
  - `initTransaction()`: Initializes a new transaction and transitions to `ReadCardDetailsAndPinState`.

### `ReadCardDetailsAndPinState`
- **Purpose**: Represents the state where the ATM reads the card details and PIN.
- **Key Methods**:
  - `readCardDetailsAndPin(Card card, String pin)`: Validates the card and PIN. If valid, transitions to `ReadingCashWithdrawDetailsState`. Otherwise, transitions to `EjectingCardState`.

### `ReadingCashWithdrawDetailsState`
- **Purpose**: Represents the state where the ATM reads the cash withdrawal details.
- **Key Methods**:
  - `readCashWithdrawDetails(Card card, int transactionID, double amount)`: Validates the withdrawal amount. If valid, transitions to `DispensingCashState`. Otherwise, transitions to `EjectingCardState`.

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Build and run the project.

## Dependencies

- Java 11 or higher
- IntelliJ IDEA 2023.3.6

## License

This project is licensed under the MIT License.
