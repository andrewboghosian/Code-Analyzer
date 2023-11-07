# Code Analyzer

The Code Analyzer is a Java-based tool designed to analyze C++ code within a specified project directory to identify and report instances of "#include pollution." This tool is developed to enhance codebase organization and maintainability by helping developers detect and address issues related to multiple and nested file inclusions in C++ code.

## Features

- **Custom Data Structure**: The Code Analyzer utilizes a custom data structure, a singly linked list, to efficiently manage and analyze C++ files within the project directory. This data structure is at the heart of the tool's analysis capabilities.

- **Regular Expression Matching**: Regular expressions (java.util.regex) are employed to detect and extract #include statements in C++ files. This step is crucial in identifying relationships between included files.

- **Command-Line Interface**: Users can specify the project directory using the `-i` flag via a command-line interface, ensuring flexibility and ease of use. This approach simplifies the tool's usage for developers.

- **Detailed Output Messages**: The application provides clear and informative output messages, helping users understand instances of #include pollution and the relationships between files. This information is invaluable for addressing code quality issues.

- **Dynamic Analysis**: The tool dynamically analyzes C++ files to detect instances of #include pollution, identifying included files and their occurrences in real-time.

- **Inclusion Hierarchy**: It establishes inclusion hierarchies when analyzing C++ files, allowing users to trace direct and indirect inclusions. This feature is essential for tracking the paths of inclusions and identifying root causes of code pollution.

- **Error Handling**: Robust error handling mechanisms are implemented to manage exceptions that might occur during file access and reading, ensuring the tool's reliability.

## Usage

1. Clone this repository or download the Code Analyzer Java source code.
2. Compile the Java source code to create the executable JAR file.
3. Run the tool by executing `java -jar CodeAnalyzer.jar -i /path/to/project_directory`.

Ensure that you have a Java runtime environment installed on your system.

## Results

The Code Analyzer successfully identifies and reports instances of #include pollution, helping developers improve code quality and maintainability. Users benefit from the clear and detailed output messages, which enable them to efficiently address code quality issues.

## Future Enhancements

Future developments may focus on enhancing the user interface for a more intuitive experience and extending the tool's analysis capabilities to provide even more comprehensive insights into code dependencies and potential areas for optimization. These enhancements would make the Code Analyzer an even more valuable tool for software developers.

