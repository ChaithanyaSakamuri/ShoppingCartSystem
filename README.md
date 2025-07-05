# Shopping Cart System

A Java implementation of a shopping cart system using arrays and linked lists.

## Features
- Add items to cart
- Remove items from cart
- Update item quantities
- Calculate total price
- Save/Load cart data to/from files

## Project Structure
```
ShoppingCartSystem/
├── src/
│   ├── models/
│   │   ├── Item.java
│   │   ├── CartItem.java
│   │   └── ShoppingCart.java
│   ├── utils/
│   │   └── FileHandler.java
│   └── Main.java
```

## How to Run
1. Clone this repository
2. Compile: `javac src/*.java src/models/*.java src/utils/*.java -d bin`
3. Run: `java -cp bin Main`
