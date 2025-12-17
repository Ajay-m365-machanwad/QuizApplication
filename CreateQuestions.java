import java.io.FileWriter;
import java.io.IOException;

public class CreateQuestions {
    public static void main(String[] args) {
        // --- DATA DATASET: 50 Unique Java Questions ---
        String[] prompts = {
            "Who invented Java?",
            "What is the size of an int variable?",
            "What is the default value of a boolean?",
            "Which keyword is used to create a subclass?",
            "Which component compiles, debugs and executes Java?",
            "What is the extension of a Java bytecode file?",
            "Which of these is NOT a Java keyword?",
            "What is the parent class of all classes in Java?",
            "Which concept creates multiple methods with the same name?",
            "Which loop is best when the number of iterations is known?",
            "What is the size of a double variable?",
            "Which keyword is used to access the parent class?",
            "String in Java is...",
            "Which collection allows duplicate elements?",
            "Which interface does NOT allow duplicate elements?",
            "How do you start a thread in Java?",
            "Which keyword stops the execution of a loop?",
            "Which keyword creates a constant variable?",
            "What is the default value of an object reference?",
            "Which operator is used to compare two values?",
            "Which class is used to read input from the console?",
            "What does JVM stand for?",
            "Which method is the entry point of a Java program?",
            "Which keyword handles exceptions?",
            "Which block always executes in exception handling?",
            "What is the size of a char in Java?",
            "Which package is imported by default?",
            "Which keyword is used to define an interface?",
            "Which of these is a marker interface?",
            "Can a class implement multiple interfaces?",
            "Can a class extend multiple classes?",
            "What is the return type of the constructor?",
            "Which keyword creates an object?",
            "What is the superclass of Exception?",
            "Which method returns the length of a string?",
            "Which operator is instanceOf?",
            "What is a NullPointerException?",
            "Which keyword restricts access to class members?",
            "Which data type is used to store true/false?",
            "Which statement returns a value from a method?",
            "What is the default value of int?",
            "Which keyword is used for inheritance?",
            "What is polymorphism?",
            "Which is a valid declaration of main?",
            "What is the range of a byte?",
            "Which class is thread-safe?",
            "Which method converts an object to a string?",
            "What is the size of a float?",
            "Which keyword creates a package?",
            "Which operator is used for logical AND?"
        };

        String[][] options = {
            {"James Gosling", "Guido van Rossum", "Dennis Ritchie", "Bjarne Stroustrup"},
            {"8 bit", "16 bit", "32 bit", "64 bit"},
            {"true", "false", "null", "0"},
            {"implements", "extends", "super", "this"},
            {"JVM", "JIT", "JDK", "JRE"},
            {".java", ".class", ".txt", ".js"},
            {"static", "Boolean", "void", "private"}, // Boolean is wrapper class, not keyword
            {"String", "Object", "System", "Class"},
            {"Overriding", "Overloading", "Inheritance", "Encapsulation"},
            {"while", "do-while", "for", "foreach"},
            {"32 bit", "64 bit", "16 bit", "8 bit"},
            {"this", "super", "parent", "base"},
            {"Mutable", "Immutable", "Volatile", "Dynamic"},
            {"Set", "List", "Map", "Tree"},
            {"List", "Set", "Vector", "ArrayList"},
            {"run()", "start()", "init()", "execute()"},
            {"continue", "break", "return", "exit"},
            {"static", "final", "const", "abstract"},
            {"0", "null", "false", "undefined"},
            {"=", "==", "<>", "><"},
            {"Buffer", "Scanner", "Input", "Reader"},
            {"Java Variable Machine", "Java Virtual Machine", "Java Visual Machine", "None"},
            {"start()", "main()", "run()", "init()"},
            {"try", "catch", "throw", "final"},
            {"catch", "finally", "try", "throw"},
            {"8 bit", "16 bit", "32 bit", "64 bit"},
            {"java.util", "java.lang", "java.io", "java.net"},
            {"class", "interface", "implements", "abstract"},
            {"Runnable", "Serializable", "List", "Collection"},
            {"Yes", "No", "Maybe", "Sometimes"},
            {"Yes", "No", "Sometimes", "Depends"},
            {"int", "void", "None", "Object"},
            {"create", "new", "make", "instantiate"},
            {"Throwable", "Error", "Object", "Runtime"},
            {"size()", "length()", "getSize()", "len()"},
            {"Comparison", "Type Comparison", "Logical", "Arithmetic"},
            {"Runtime Exception", "Compile Time", "Error", "IO Exception"},
            {"public", "private", "protected", "void"},
            {"int", "boolean", "char", "string"},
            {"get", "return", "send", "output"},
            {"1", "0", "-1", "null"},
            {"implements", "extends", "inherit", "super"},
            {"Data Hiding", "Many Forms", "Code Reuse", "None"},
            {"public void main", "public static void main", "void main", "static main"},
            {"-128 to 127", "0 to 255", "-32k to 32k", "None"},
            {"ArrayList", "Vector", "LinkedList", "HashMap"},
            {"toString()", "getString()", "parse()", "valueOf()"},
            {"32 bit", "64 bit", "16 bit", "8 bit"},
            {"import", "package", "include", "use"},
            {"&", "&&", "||", "|"}
        };

        String[] answers = {
            "a", "c", "b", "b", "c",
            "b", "b", "b", "b", "c",
            "b", "b", "b", "b", "b",
            "b", "b", "b", "b", "b",
            "b", "b", "b", "a", "b",
            "b", "b", "b", "b", "a",
            "b", "c", "b", "a", "b",
            "b", "a", "b", "b", "b",
            "b", "b", "b", "b", "a",
            "b", "a", "a", "b", "b"
        };

        try {
            FileWriter writer = new FileWriter("questions.txt");

            System.out.println("Generating 200 Java questions...");

            // Loop 200 times
            for (int i = 0; i < 200; i++) {
                // Use modulo (%) to cycle through the 50 unique questions repeatedly
                int index = i % prompts.length; 
                
                writer.write(prompts[index] + "\n");      // The Question
                writer.write(options[index][0] + "\n");   // Option A
                writer.write(options[index][1] + "\n");   // Option B
                writer.write(options[index][2] + "\n");   // Option C
                writer.write(options[index][3] + "\n");   // Option D
                writer.write(answers[index] + "\n");      // The Answer Key
            }

            writer.close();
            System.out.println("Success! 'questions.txt' now contains 200 Java questions.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}