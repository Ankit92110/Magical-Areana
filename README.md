# Magical Arena Game

Magical Arena is a two-player turn-based game where players battle in an arena using their health, strength, and attack values.
Players take turns attacking and defending until one player's health reaches zero.

## Game Rules

1. **Setting Player Attributes**: Each player has attributes: health, strength, and attack.
2. **Turn Order**: The player with lower health attacks first at the start of the match.
3. **Attacking and Defending**:
    - The attacking player rolls an attacking dice.
    - The defending player rolls a defending dice.
    - The damage caused by the attacker is calculated as: `attack value * attacking dice outcome`.
    - The damage defended by the defender is calculated as: `strength value * defending dice outcome`.
    - The defender's health is reduced by the excess damage (if any) caused by the attacker after defense.
4. **End of Game**: The game ends when any player's health reaches zero.

## How to Run the Game

### Prerequisites

- Java Development Kit (JDK) installed.
- Gradle installed or use the Gradle Wrapper provided in the project.

### Running the Game

To run the game, use the following command:

.\gradlew run --args="sample_input/input1.txt"

or you can create your own input file inside same_input folder and pass that one

### Sample Input File Format
Each input file should follow this format:

ADD_PLAYER health strength attack
ADD_PLAYER health strength attack
PLAY

### input1.txt
ADD_PLAYER 0 5 10
ADD_PLAYER 100 10 5
PLAY

### Running Tests
To run the test cases, use the following command:
.\gradlew test

Or 
Run via go inside Test and click on run button

magical-arena/
|
├──sample_input/
|             ├── input1.txt
|             ├── input2.txt
|             ├── input3.txt
|             ├── input4.txt
| 
├── src/
│   ├── main/
│   │   ├── java/
│   │      └── org/example/
│   │         └── Main.java
│   │   
│   └── test/
│       └── java/
│           └── org/example/
│               └── MainTest.java
├── build.gradle
└── README.md
