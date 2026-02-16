Hack Assembler (Nand2Tetris) 💻🔢
A robust, Java-based Two-Pass Assembler built for the Hack Computer Architecture. This project is a core part of the "Nand to Tetris" journey, bridging the gap between symbolic assembly language and executable machine binary.

🚀 Features
Two-Pass Logic: Correctly handles forward references (Labels) by resolving symbols in the first pass and generating binary in the second.

Symbol Management: Includes a dynamic SymbolTable to manage predefined symbols (R0-R15, SCREEN, KBD), labels, and user-defined variables (starting from RAM address 16).

Modular Design: Clean OOP structure separating the Parser, Code (binary generator), and SymbolTable.

Built-in Test Suite: Features a custom FileComparator to verify the accuracy of the generated .hack files against official comparison files.

📂 Project Structure
HackAssembler.java: The main entry point that orchestrates the assembly process.

Parser.java: Handles file reading and encapsulates access to the input code.

Code.java: Translates Hack mnemonics into their binary representations.

SymbolTable.java: Manages the mapping between symbolic names and numeric addresses.

FileComparator.java: A utility tool for automated testing.

🛠️ Installation & Usage
Compilation
Compile all Java files using javac:

Bash
javac *.java
Running the Assembler
To translate an assembly file (.asm) into binary (.hack), run:

Bash
java HackAssembler Path/To/YourProgram.asm
The assembler will automatically generate a file named YourProgram.hack in the same directory.

🧪 Testing with FileComparator
Precision is key in systems programming. To ensure the generated binary matches the official Hack specifications exactly, I've included a FileComparator tool.

How it works:
Whitespace Agnostic: The tool automatically strips all whitespaces and newlines before comparison to ensure it focuses purely on the binary logic.

Automated Check: Compares your output with the expected .hack result.

How to use:
Update the file paths in FileComparator.java.

Compile and run:

Bash
javac FileComparator.java
java FileComparator
It will output:

✅ SUCCESS: Files are identical.

❌ FAILURE: Differences found.

🎯 Future Goals
This project serves as a foundation for understanding Low-Level Software Engineering and Compiler Design. My next steps involve exploring more complex optimizations and building the Virtual Machine (VM) translator for the Hack platform.
