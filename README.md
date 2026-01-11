# 🕹️ Healthy Life Dash

**Healthy Life Dash** is an educational 2D game developed with **Java**.  
The game aims to teach children **healthy and unhealthy eating habits** in a fun and interactive way.

---

## 🎯 Game Purpose

The main goal of the game is to help children:
- Learn which foods are **healthy**
- Understand the effects of **unhealthy foods**
- Develop basic **healthy eating habits**

The target audience is **primary school students**.  
Because the game does **not use text**, it can also be played by children who **cannot read**.  
Instead of text, the game uses **colors, sounds, and movement** to give feedback.

---

## 📸 Gameplay Screenshot

<img width="745" height="742" alt="Gameplay Screenshot"
src="https://github.com/user-attachments/assets/ad1f2af0-65e9-4736-a3d4-08c3ebe1cc42" />

---

## 🎮 How to Play

- The player moves using the **keyboard**
- The player collects foods on the map
- **Healthy foods increase** the sugar level
- **Unhealthy foods decrease** the sugar level
- When the sugar level reaches **100**, the **exit door opens**
- The goal is to reach the exit **before the sugar level becomes zero**
- The player must **avoid enemies**
- If an enemy touches the player, the game ends

---

## 🔄 Game Flow

Start → Play → Level Up → Game Over

- The player enters the level
- Moves, collects food, and avoids enemies
- Sugar level reaches 100 → level up
- Enemy hit or sugar ≤ 0 → game over

---

## 🧩 Game Features

- Multiple levels with **increasing difficulty**
- Healthy and unhealthy food types
- Enemies that follow the player
- Sugar level system
- Visual feedback:
  - **Green screen** → healthy food
  - **Red screen** → unhealthy food
- Background music
- Save and load game progress

---

## 🛠️ Technologies Used

- **Java**
- Java Swing
- Timer (game loop)
- KeyListener (keyboard input)
- Collision detection using `Rectangle.intersects()`
- File handling for save and load system

---

## 🧱 Main Classes

- `Game` – controls the main game loop
- `Player` – handles player movement and actions
- `Enemy` – controls enemy behavior and movement
- `Food` – represents food objects and their effects
- `Level` – manages level logic and difficulty

---

## ⚠️ Problems and Solutions

### Problem 1: Enemy Overlapping
Enemies follow the player.  
At higher levels, when the number of enemies increased, they started to overlap and looked like a single enemy.

**Solution:**  
Enemy collision control was added, so enemies move independently.



## 🚀 Future Improvements

In the future, I plan to add sound effects for food collection and warning situations, more levels with different themes, an online leaderboard for score tracking, and power-ups and bonus rewards for correct and healthy choices.

---

## 👤 Developer

**Mustafa Acar**  
Software Engineering Student  
