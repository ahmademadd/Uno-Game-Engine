# UNO Game Engine


_By Ahmad Emad_  
- **YouTube Video**: [Watch Here](https://www.youtube.com/watch?v=ZRmgn5XnIGI)  
- **Documentation**: [Click Here](Uno%20Game%20Engine%20Documentation.pdf).
- **Email**: [ahmademad995.ae@gmail.com](mailto:ahmademad995.ae@gmail.com)

## Overview
The **UNO Game Engine** is a flexible and extensible backend for creating and managing UNO games. Designed with **object-oriented principles** and **design patterns**, it allows developers to implement their own versions of UNO with minimal effort. The engine ensures **clean architecture**, **scalability**, and **maintainability**.

## Features
- **Object-Oriented Design (OOP)**: Implements **Encapsulation, Inheritance, Polymorphism, and Abstraction**.
- **Design Patterns**: Utilizes **Singleton, Factory Method, and other patterns** for maintainability.
- **Adherence to SOLID Principles**: Ensures flexibility and modularity.
- **Customizability**: Developers can extend the game by introducing new card types without modifying existing code.
- **Core UNO Mechanics**: Supports standard UNO rules including number cards, action cards, and wild cards.

## Project Structure
```
├── src
│   ├── Cards
│   │   ├── Card.java
│   │   ├── ActionCard.java
│   │   ├── NumberedCard.java
│   │   ├── WildCards.java
│   │   ├── WildDrawFour.java
│   │   ├── ActionCard.java
│   │   ├── DrawTwo.java
│   │   ├── ReverseCard.java
│   │   ├── SkipCard.java
│   │   ├── Wild.java
│   │   ├── CardAction.java
│   │   ├── Colors.java
│   ├── Game
│   │   ├── Game.java
│   │   ├── Deck.java
│   │   ├── DisplayCards.java
│   │   ├── DiscardPile.java
|   ├── Exceptions
|   |   ├── DuplicatePlayerNames.java
|   |   ├── IllegalNumOfPlayers.java
│   ├── CustomGame
|   |   ├── CustomGame.java
|   |   ├── WildSetAllCardsColors.java
│   ├── Players
│   │   ├── Players.java
│   └── GameDriver.java
```

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/ahmademadd/Uno-Game-Engine
   ```
2. Navigate to the project directory:
   ```sh
   cd uno-game-engine
   ```
3. Compile and run the project (for Java projects):
   ```sh
   javac -d bin src/**/*.java
   java -cp bin Main
   ```

## How to Use
- **Create object of type Game** by extending `Game` and implementing method play().
- **Add new game features** by implementing methods or overriding methods.
- **Create custom cards** by extending `Card`, `WildCards`, or `ActionCard` then centralizes your card creation in CardFactory, lastely use deck.addToDeck().
- **Start the game** by calling method startGame() within play().
 
## Design Principles & Patterns
- **SOLID Principles**: Ensures clean, maintainable, and scalable code.
- **Singleton Pattern**: Used in `Deck`, `DiscardPile`, and `Players` to enforce single instances.
- **Factory Method Pattern**: Centralizes card creation.

## Contributing
1. Fork the repository.
2. Create a new branch:
   ```sh
   git checkout -b feature-new-card
   ```
3. Commit your changes:
   ```sh
   git commit -m "Added a new action card"
   ```
4. Push to the branch:
   ```sh
   git push origin feature-new-card
   ```
5. Submit a pull request.

## Contact
For any questions or issues, feel free to open an issue on GitHub or contact [Ahmad Emad] at [ahmademad995.ae@gmail.com].

