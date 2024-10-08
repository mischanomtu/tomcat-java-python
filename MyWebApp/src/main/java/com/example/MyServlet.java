package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Use ProcessBuilder to execute the Python script
        ProcessBuilder processBuilder = new ProcessBuilder("python3", "/opt/python/script.py");
        processBuilder.redirectErrorStream(true); // Merge error stream with output

        try {
            Process process = processBuilder.start();

            // Capture the output of the script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                // Send the output of the Python script as the response
                response.getWriter().println("Python Script Output: " + output.toString());
            } else {
                response.getWriter().println("Python script failed with exit code " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            response.getWriter().println("Error running Python script: " + e.getMessage());
        }
    }
}
