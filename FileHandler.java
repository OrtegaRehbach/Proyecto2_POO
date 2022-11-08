import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler {

    public FileHandler() {

    }
    
    public File createCSVFile(String pathName) {
        return new File(pathName);
    }

    public String[] readDataFromCSVFile(File csvFile) {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(csvFile));
            String st;
            ArrayList<String> strArray = new ArrayList<String>();
            while ((st = buffReader.readLine()) != null) {
                strArray.add(st);
            }
            buffReader.close();
            return strArray.toArray(new String[strArray.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean writeDataToCSVFile(File file, String data) {
        try {
            FileWriter fWriter = new FileWriter(file);
            fWriter.write(data + "\n");
            fWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean appendDataToCSVFile(File file, String data) {
        try {
            FileWriter fWriter = new FileWriter(file, true);
            fWriter.write(data + "\n");
            fWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean appendDataToCSVFile(File file, Usuario user) {
        return appendDataToCSVFile(file, userDataToCSVString(user));
    }

    private String userDataToCSVString(Usuario user) {
        String csvString = "";
        csvString += user.getName() + ",";
        csvString += user.getPassword() + ",";
        if (!user.getContactosEmergencia().isEmpty()) {
            for (Contacto contacto : user.getContactosEmergencia()) {
                csvString += contacto.getNombre() + ",";
                csvString += contacto.getNumero() + ",";
            }
        } else {
            csvString += "None";
        }
        return csvString;
    }
}