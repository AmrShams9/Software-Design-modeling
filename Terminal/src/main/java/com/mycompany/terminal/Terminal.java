/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.terminal;

/*
 * تعليق: هذا هو ملف Java يمثل نموذج لمحطة عمل تشغيلية (Terminal). 
 * الملف يحتوي على العديد من الدوال والتعليمات التي تمكن المستخدم من التفاعل مع النظام عبر سطر الأوامر.
 * يتيح للمستخدم إدخال أوامر مثل "cd" لتغيير الدليل الحالي، "ls" لعرض محتوى الدليل الحالي، "echo" لعرض نص، والعديد من الأوامر الأخرى.
 * يمكن أيضًا توجيه مخرجات الأوامر إلى ملف باستخدام العلامة (>) وإعادة توجيه الإخراج.
 * يحتوي الكود على تعليقات باللغة الإنجليزية لشرح الأجزاء المختلفة من الكود.
 */

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Terminal {
    class Parser {
    private String commandName;
    private String[] args;

    public Parser() {
        commandName = null;
        args = null;
    }

    public boolean parse(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        String[] inputParts = input.split("\\s+");
        if (inputParts.length == 0) {
            return false;
        }

        commandName = inputParts[0];
        if (inputParts.length > 1) {
            args = new String[inputParts.length - 1];
            System.arraycopy(inputParts, 1, args, 0, args.length);
        } else {
            args = new String[0];
        }

        return true;
    }

    public String getCommandName() {
        return commandName;
    }

    public String[] getArgs() {
        return args;
    }
}
    private Parser parser;
    private Path currentDirectory;
    private List<String> commandHistory;

    public Terminal() {
        // Initialize the terminal with default properties
        this.parser = new Parser();
        this.currentDirectory = Paths.get(System.getProperty("user.dir"));
        this.commandHistory = new ArrayList<>();
    }

    // Choose and execute the appropriate command based on the user input
public void chooseCommandAction(String input) {
    if (parser.parse(input)) {
        String commandName = parser.getCommandName();
        String[] commandArgs = parser.getArgs();

        commandHistory.add(input); // Add the command to the history

        switch (commandName) {
            case "history":
                history();
                break;
            case "pwd":
                String result = getCurrentDirectory();
                System.out.println(result);
                break;
            case "cd":
                changeDirectory();
                break;
            case "ls":
                listDirectory();
                break;
            case "lsr":
                listDirectoryRecursively();
                break;
            case "echo":
                echoText(String.join(" ", commandArgs));
                break;
            case "wc":
                if (commandArgs.length == 1) {
                    wordCount(commandArgs[0]);
                } else {
                    System.err.println("Usage: wc <filename>");
                }
                break;
            case "cp":
                if (commandArgs.length == 2) {
                    copyFile(commandArgs[0], commandArgs[1]);
                } else {
                    System.err.println("Usage: cp <sourceFile> <destinationFile>");
                }
                break;
            case "mkdir":
                createDirectories(commandArgs);
                break;
            case "rmdir":
                switch (commandArgs[0]) {
                    case "*":
                        removeEmptyDirectories();
                        break;
                    default:
                        removeDirectory(commandArgs[0]);
                        break;
                }
                break;
            case "touch":
                createFile(commandArgs[0]);
                break;
            case "rm":
                removeFile(commandArgs[0]);
    break;
     case ">": // Handle redirection to file
                if (commandArgs.length == 2) {
                    redirectOutputToFile(commandArgs[0], commandArgs[1]);
                } else {
                    System.err.println("Usage: > sourceCommand fileName");
                }
            break;
            case "cat":
    if (commandArgs.length == 1) {
        catSingleFile(commandArgs[0]);
    } else if (commandArgs.length == 2) {
        catTwoFiles(commandArgs[0], commandArgs[1]);
    } else {
        System.err.println("Usage: cat <filename> OR cat <filename1> <filename2>");
    }
    break;
    case ">>":
    if (commandArgs.length == 2) {
        appendToFile(commandArgs[0], commandArgs[1]);
    } else {
        System.err.println("Usage: >> <source> <destination>");
    }
    break;
            case "exit":
                System.out.println("Exiting the terminal.");
                System.exit(0); // Terminate the program
                break;
            default:
                System.err.println("Command not recognized");
        }
    } else {
        System.err.println("Invalid input");
    }
}

    // Change the current directory
    public void changeDirectory() {
        String[] args = parser.getArgs();

        if (args.length == 1) {
            Path newDirectory = currentDirectory.resolve(args[0]);

            try {
                if (Files.isDirectory(newDirectory)) {
                    currentDirectory = newDirectory.toRealPath();
                } else {
                    System.err.println("Directory not found: " + newDirectory);
                }
            } catch (IOException e) {
                System.err.println("Error changing directory: " + e.getMessage());
            }
        } else {
            System.err.println("Usage: cd <directory>");
        }
    }

    // List files and directories in the current directory
    public void listDirectory() {
    try {
        // Get a directory stream of all entries (both files and directories) in the current directory
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(currentDirectory);

        for (Path entry : directoryStream) {
            if (Files.isDirectory(entry)) {
                // Check if the entry is a directory
                System.out.println("Directory: " + entry.getFileName());
            } else if (Files.isRegularFile(entry)) {
                // Check if the entry is a regular file
                System.out.println("File: " + entry.getFileName());
            }
        }

        directoryStream.close(); // Close the directory stream when done to release resources
    } catch (IOException e) {
        System.err.println("Error listing directory: " + e.getMessage());
    }
}


    private void catSingleFile(String fileName) {
    try {
        Path filePath = currentDirectory.resolve(Paths.get(fileName));

        if (Files.isRegularFile(filePath)) {
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                System.out.println(line);
            }
        } else {
            System.err.println("File not found: " + filePath);
        }
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
    }
}
    private void catTwoFiles(String fileName1, String fileName2) {
    try {
        Path filePath1 = currentDirectory.resolve(Paths.get(fileName1));
        Path filePath2 = currentDirectory.resolve(Paths.get(fileName2));

        if (Files.isRegularFile(filePath1) && Files.isRegularFile(filePath2)) {
            List<String> lines1 = Files.readAllLines(filePath1);
            List<String> lines2 = Files.readAllLines(filePath2);

            for (String line : lines1) {
                System.out.println(line);
            }

            for (String line : lines2) {
                System.out.println(line);
            }
        } else {
            System.err.println("File not found: " + (Files.isRegularFile(filePath1) ? filePath2 : filePath1));
        }
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
    }
}



    // Get the current working directory
    public String getCurrentDirectory() {
        String currentDir = currentDirectory.toString();
        commandHistory.add("pwd");
        return currentDir;
    }

    // Display the given text
    public void echoText(String text) {
        System.out.println(text);
    }

    // Display the command history
    public void history() {
        int count = 1;
        for (String command : commandHistory) {
            System.out.println(count + " " + command);
            count++;
        }
    }

    // Create one or more directories
    public void createDirectories(String... directories) {
        for (String dir : directories) {
            Path dirPath = currentDirectory.resolve(Paths.get(dir));
            try {
                Files.createDirectories(dirPath);
                System.out.println("Created directory: " + dirPath);
            } catch (IOException e) {
                System.err.println("Error creating directory: " + e.getMessage());
            }
        }
    }
    public void wordCount(String fileName) {
    try {
        Path filePath = currentDirectory.resolve(Paths.get(fileName));

        if (Files.isRegularFile(filePath)) {
            long lineCount = 0;
            long wordCount = 0;
            long charCount = 0;

            try (BufferedReader reader = Files.newBufferedReader(filePath)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                    charCount += line.length();
                }
            }

            System.out.println(lineCount + " " + wordCount + " " + charCount + " " + fileName);
        } else {
            System.err.println("File not found: " + filePath);
        }
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
    }
}

    /** Count lines, words, and characters in a file
    public void wordCount(String fileName) {
        try {
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] words = line.split("\\s+");
                wordCount += words.length;
                charCount += line.length();
            }
            reader.close();

            System.out.println(lineCount + " " + wordCount + " " + charCount + " " + fileName);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }**/
    
    
    

    // List files and directories recursively
    public void listDirectoryRecursively() {
    try {
        // Recursively walk through the current directory, including subdirectories
        Files.walk(currentDirectory)
             .forEach(entry -> {
                 if (Files.isDirectory(entry)) {
                     // Check if the entry is a directory
                     System.out.println("Directory: " + entry.getFileName());
                 } else if (Files.isRegularFile(entry)) {
                     // Check if the entry is a regular file
                     System.out.println("File: " + entry.getFileName());
                 }
             });
    } catch (IOException e) {
        System.err.println("Error listing directory recursively: " + e.getMessage());
    }
}



    // Copy a file from source to destination
    public void copyFile(String sourceFileName, String destinationFileName) {
        Path sourcePath = Paths.get(sourceFileName);
        Path destinationPath = Paths.get(destinationFileName);

        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully: " + sourceFileName + " -> " + destinationFileName);
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    // Remove a directory if it is empty
    public void removeDirectory(String directory) {
        Path dirPath = currentDirectory.resolve(Paths.get(directory));

        try {
            if (Files.isDirectory(dirPath)) {
                if (isEmptyDirectory(dirPath)) {
                    Files.delete(dirPath);
                    System.out.println("Directory removed: " + dirPath);
                } else {
                    System.err.println("Directory is not empty: " + dirPath);
                }
            } else {
                System.err.println("Directory not found: " + dirPath);
            }
        } catch (IOException e) {
            System.err.println("Error removing directory: " + e.getMessage());
        }
    }

    // Remove all empty directories in the current directory
    public void removeEmptyDirectories() {
    try {
        // Recursively walk through the current directory and its subdirectories
        Files.walk(currentDirectory)
            // Filter to select only directories (excluding files)
            .filter(Files::isDirectory)
            // Filter to select only empty directories
            .filter(this::isEmptyDirectory)
            // Sort the selected directories in reverse order (deeper directories first)
            .sorted(Comparator.reverseOrder())
            // For each empty directory, attempt to delete it
            .forEach(directory -> {
                try {
                    // Delete the empty directory
                    Files.delete(directory);
                    // Print a message indicating the directory has been removed
                    System.out.println("Directory removed: " + directory);
                } catch (IOException e) {
                    // Handle and print an error message if there is an issue while deleting
                    System.err.println("Error removing directory: " + e.getMessage());
                }
            });
    } catch (IOException e) {
        // Handle and print an error message if there is an issue while traversing directories
        System.err.println("Error traversing directories: " + e.getMessage());
    }
}


    // Check if a directory is empty
    private boolean isEmptyDirectory(Path dirPath) {
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(dirPath)) {
            return !dirStream.iterator().hasNext();
        } catch (IOException e) {
            System.err.println("Error checking if directory is empty: " + e.getMessage());
            return false;
        }
    }

    // Create a new file in the current directory
    public void createFile(String filePath) {
        Path fileToCreate = currentDirectory.resolve(Paths.get(filePath));

        try {
            Files.createFile(fileToCreate);
            System.out.println("File created: " + fileToCreate);
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    // Remove a file in the current directory
   public void removeFile(String fileName) {
    // Create a Path object for the file to be removed by resolving it with the current directory
    Path filePath = currentDirectory.resolve(Paths.get(fileName));

    try {
        // Check if the resolved path points to a regular file
        if (Files.isRegularFile(filePath)) {
            // If it's a regular file, attempt to delete it
            Files.delete(filePath);
            // Print a message indicating the file has been removed
            System.out.println("File removed: " + filePath);
        } else {
            // If the resolved path is not a regular file, print an error message
            System.err.println("File not found: " + filePath);
        }
    } catch (IOException e) {
        // Handle any IOException that might occur during the deletion process
        System.err.println("Error removing file: " + e.getMessage());
    }
}

 private void redirectOutputToFile(String sourceCommand, String fileName) {
    try {
        ProcessBuilder processBuilder;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            // For Windows, use "cmd" to run the command via the shell
            processBuilder = new ProcessBuilder("cmd", "/c", sourceCommand);
        } else {
            // For Unix-like systems, use "/bin/bash" to run the command via the shell
            processBuilder = new ProcessBuilder("/bin/bash", "-c", sourceCommand);
        }

        processBuilder.directory(currentDirectory.toFile()); // Set the working directory

        File outputFile = new File(fileName);
        processBuilder.redirectOutput(outputFile);

        Process process = processBuilder.start();
        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Command executed and output redirected to " + fileName);
        } else {
            System.err.println("Command exited with code: " + exitCode);
        }
    } catch (IOException | InterruptedException e) {
        System.err.println("Error executing the command: " + e.getMessage());
    }
}




    private void appendToFile(String sourceFileName, String destinationFileName) {
    Path sourcePath = currentDirectory.resolve(Paths.get(sourceFileName));
    Path destinationPath = currentDirectory.resolve(Paths.get(destinationFileName));

    try {
        if (Files.isRegularFile(sourcePath)) {
            List<String> lines = Files.readAllLines(sourcePath);

            try {
                Files.write(destinationPath, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Appended content to file: " + sourceFileName + " -> " + destinationFileName);
            } catch (IOException e) {
                System.err.println("Error appending to file: " + e.getMessage());
            }
        } else {
            System.err.println("Source file not found: " + sourcePath);
        }
    } catch (IOException e) {
        System.err.println("Error reading the source file: " + e.getMessage());
    }
}



    // Main method to run the terminal
    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Enter a command: ");
            try {
                String input = reader.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the terminal.");
                    break;
                }

                terminal.chooseCommandAction(input);
            } catch (IOException e) {
                System.err.println("Error reading input: " + e.getMessage());
            }
        }
    }
}
