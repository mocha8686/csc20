package moviedatabase.io;

import java.io.*;

public class File {
    private final String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public String read() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder res = new StringBuilder();
            String next = reader.readLine();
            while (next != null) {
                res.append(next).append("\n");
                next = reader.readLine();
            }
            return res.toString().trim();
        }
    }

    public void write(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }

    public void append(String content) throws IOException {
        String fileContent = read().trim();
        fileContent += "\n" + content;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(fileContent);
        }
    }

    public String getFileName() {
        return fileName;
    }
}
