// Custom exception for invalid marks
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

// Custom exception for failed student
class FailException extends Exception {
    public FailException(String message) {
        super(message);
    }
}

// Student class
class Student {
    private int marks;

    public Student(int marks) {
        this.marks = marks;
    }

    // Method to set marks
    public void setMarks(int marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks should be between 0 and 100.");
        }
        this.marks = marks;
        System.out.println("Marks updated successfully.");
    }

    // Method to check result
    public void checkResult() throws FailException {
        if (marks < 35) {
            throw new FailException("Student has failed.");
        }
        System.out.println("Student has passed.");
    }

    // Method to display marks
    public void displayMarks() {
        System.out.println("Marks: " + marks);
    }
}

// Main class
public class Code3 {
    public static void main(String[] args) {

        Student s = new Student(50);

        try {
            s.displayMarks();
            s.setMarks(80);
            s.checkResult();
        } catch (InvalidMarksException e) {
            System.out.println("Marks Error: " + e.getMessage());
        } catch (FailException e) {
            System.out.println("Result Error: " + e.getMessage());
        }

        try {
            s.setMarks(120);   // Invalid marks
        } catch (InvalidMarksException e) {
            System.out.println("Marks Error: " + e.getMessage());
        }

        s.displayMarks();
    }
}