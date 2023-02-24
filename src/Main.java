import Calculator.Calculator;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = getReader(args)) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
            Calculator calculator = new Calculator(reader);
            calculator.doCalculating();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static BufferedReader getReader(String[] args) throws FileNotFoundException {
        if (args.length > 0) {
            return new BufferedReader(new FileReader(args[0]));
        } else {
            return new BufferedReader(new InputStreamReader(System.in));
        }
    }
}
//  InputStreamReader comm_stream = new InputStreamReader(args[0]);
//        File comm_file = new File(args[0]);
//        System.out.println("File name: " + comm_file.getName());
//        System.out.println("Parent folder: " + comm_file.getParent());
//
//        if(comm_file.exists())
//            System.out.println("File exists");
//        else
//            System.out.println("File not found");
//
//        System.out.println("File size: " + comm_file.length());
//        if(comm_file.canRead())
//            System.out.println("File can be read");
//        else
//            System.out.println("File can not be read");
//
//        if(comm_file.canWrite())
//            System.out.println("File can be written");
//        else
//            System.out.println("File can not be written");
//    }
//    }
//}