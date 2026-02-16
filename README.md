# 🖥️ Hack Assembler (Nand2Tetris Project 6)

A high-performance, **Two-Pass Assembler** implemented in Java for the Hack Computer Architecture. This tool translates symbolic Hack assembly language (`.asm`) into 16-bit binary machine code (`.hack`).



## 🌟 Key Features
- **Two-Pass Translation:** Efficiently resolves forward-referencing labels using a preliminary pass.
- **Dynamic Symbol Management:** Handles predefined symbols (R0-R15, SCREEN, KBD), labels, and auto-allocates memory for user variables starting from RAM address 16.
- **Modular OOP Design:** Built with a clean separation of concerns:
    - `Parser`: Breaks down instructions into components.
    - `Code`: Generates binary patterns for mnemonics.
    - `SymbolTable`: Maintains a mapping of names to memory addresses.
- **Integrated Test Suite:** Includes a custom `FileComparator` tool for automated verification.

---

## 📂 Project Structure
| File | Responsibility |
| :--- | :--- |
| `HackAssembler.java` | The main driver that executes Pass 1 and Pass 2. |
| `Parser.java` | Handles logic for reading and stripping comments/whitespace. |
| `Code.java` | The "Dictionary" that converts mnemonics to binary strings. |
| `SymbolTable.java` | Stores and retrieves memory addresses for symbols. |
| `FileComparator.java` | Utility to compare program output with expected results. |

---

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher.

### Compilation
Compile all source files at once:
```bash
javac *.java

# 🖥️ Hack Assembler (Nand2Tetris Project 6)

A high-performance, **Two-Pass Assembler** implemented in Java for the Hack Computer Architecture. This tool translates symbolic Hack assembly language (`.asm`) into 16-bit binary machine code (`.hack`).

---

## 🚀 Usage
Run the assembler on any `.asm` file from your terminal:

```bash
java HackAssembler YourProgram.asm
Note: This will automatically generate a machine-executable YourProgram.hack file in the same directory.

🧪 Testing with FileComparator
To ensure 100% accuracy, I implemented a custom comparison tool that ignores formatting and focuses purely on the logical bits.

Running the Test:
Open FileComparator.java and set the paths for your output (.hack) and the official comparison file.

Compile and run:

Bash
javac FileComparator.java
java FileComparator
Output ✅:identical.

Output ❌:wrong

🛠️ Technical Details
The assembler follows the standard Hack CPU specifications:

1. A-Instructions
Formatted as a 16-bit word starting with 0, followed by a 15-bit address:
0vvvvvvvvvvvvvvv

2. C-Instructions
Formatted as a 16-bit word starting with 111, followed by the control bits:
111 + comp (7 bits) + dest (3 bits) + jump (3 bits).

3. Labels & Symbols
Handled via a Two-Pass strategy:

Pass 1: Scans the code and stores the address of the next instruction for every label (LABEL) in the SymbolTable.

Pass 2: Translates instructions, replacing label and variable symbols with their actual memory addresses.

📂 Project Structure
HackAssembler.java: Main entry point and orchestration.

Parser.java: Logic for parsing commands and stripping comments.

Code.java: Converts mnemonics to binary strings.

SymbolTable.java: Manages labels, predefined symbols, and variables.

FileComparator.java: Automated testing utility.
