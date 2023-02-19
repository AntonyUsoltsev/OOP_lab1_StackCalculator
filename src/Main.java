import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = null;

        if (args.length > 0) {
            String filename = args[0];
            try {
                reader = new BufferedReader(new FileReader(filename));
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                return;
            }
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                // process each line of data here
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
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