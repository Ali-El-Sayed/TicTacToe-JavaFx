# TicTacToe-JavaFx

![IMG-20240102-WA0005](https://github.com/Ali-El-Sayed/TicTacToe-JavaFx/assets/63204358/83ba845b-66c3-46c5-827e-1167cdf0ea01)
![IMG-20240102-WA0008](https://github.com/Ali-El-Sayed/TicTacToe-JavaFx/assets/63204358/a93b8a51-cca3-498a-bd64-9a374adffa57)
![IMG-20240102-WA0007](https://github.com/Ali-El-Sayed/TicTacToe-JavaFx/assets/63204358/80e9f5d3-2955-4880-8ad4-4ee7a451f61e)
![IMG-20240102-WA0006](https://github.com/Ali-El-Sayed/TicTacToe-JavaFx/assets/63204358/2111750b-578a-4fb3-9cfa-473d6b590c60)
![IMG-20240102-WA0010](https://github.com/Ali-El-Sayed/TicTacToe-JavaFx/assets/63204358/3524ce80-3adb-47d2-a6ce-0142e8e49076)



## Overview

This is a simple and customizable Tic Tac Toe desktop game developed in JavaFX. The game supports both offline and online modes, allowing users to play against an AI opponent or compete with others over a network.

## Features

- **Offline Mode:**
  - Single-player mode against a computer opponent with three difficulty levels.
  - Two-player mode for local games.

- **Online Mode:**
  - Multiplayer mode that requires a server application.
  - Users can connect to the server to play against each other.

## Requirements

- Java 8 or later
- JavaFX

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/tic-tac-toe.git
   cd tic-tac-toe
   ```

2. Compile and run the game:

   ```bash
   javac Main.java
   java Main
   ```

## Offline Mode

### Single Player

In single-player mode, you can play against the computer. The computer has three difficulty levels: easy, medium, and hard.

```java
// Example: Launching the game with easy difficulty
GameLauncher.launchSinglePlayer(GameDifficulty.EASY);
```

### Two Players

In two-player mode, two players can play on the same machine. Simply launch the game without specifying difficulty.

```java
// Example: Launching the game for two players
GameLauncher.launchTwoPlayer();
```

## Online Mode

### Server

1. Run the server application:

   ```bash
   java ServerMain
   ```

2. Share the server IP address with other players.

### Client

1. Run the client application:

   ```bash
   java ClientMain
   ```

2. Enter the server IP address when prompted.

## Customization

You can customize the game settings, such as board size, winning conditions, and more, by modifying the configuration file (`config.properties`).

## Contributing

Feel free to contribute to the project by opening issues or submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

- Inspired by the classic Tic Tac Toe game.

Enjoy playing the Tic Tac Toe game! If you encounter any issues or have suggestions, please let us know by opening an issue.


## Overview

This is a simple and customizable Tic Tac Toe desktop game developed in JavaFX. The game supports both offline and online modes, allowing users to play against an AI opponent or compete with others over a network.

## Features

- **Offline Mode:**
  - Single-player mode against a computer opponent with three difficulty levels.
  - Two-player mode for local games.

- **Online Mode:**
  - Multiplayer mode that requires a server application.
  - Users can connect to the server to play against each other.

## Requirements

- Java 8 or later
- JavaFX

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/tic-tac-toe.git
   cd tic-tac-toe
   ```

2. Compile and run the game:

   ```bash
   javac Main.java
   java Main
   ```

## Offline Mode

### Single Player

In single-player mode, you can play against the computer. The computer has three difficulty levels: easy, medium, and hard.

```java
// Example: Launching the game with easy difficulty
GameLauncher.launchSinglePlayer(GameDifficulty.EASY);
```

### Two Players

In two-player mode, two players can play on the same machine. Simply launch the game without specifying difficulty.

```java
// Example: Launching the game for two players
GameLauncher.launchTwoPlayer();
```

## Online Mode

### Server

1. Run the server application:

   ```bash
   java ServerMain
   ```

2. Share the server IP address with other players.

### Client

1. Run the client application:

   ```bash
   java ClientMain
   ```

2. Enter the server IP address when prompted.

## Customization

You can customize the game settings, such as board size, winning conditions, and more, by modifying the configuration file (`config.properties`).

## Contributing

Feel free to contribute to the project by opening issues or submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

- Inspired by the classic Tic Tac Toe game.

Enjoy playing the Tic Tac Toe game! If you encounter any issues or have suggestions, please let us know by opening an issue.
