import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            fWriter.write(data);
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

    public String userDataToCSVString(Usuario user) {
        StringBuilder csvString = new StringBuilder();
        csvString.append(user.getName() + ",");
        csvString.append(user.getPassword() + ",");
        if (!user.getContactosEmergencia().isEmpty()) {
            for (Contacto contacto : user.getContactosEmergencia()) {
                csvString.append(contacto.getNombre() + ",");
                csvString.append(contacto.getNumero() + ",");
            }
            csvString.deleteCharAt(csvString.toString().length() - 1);
        } else {
            csvString.append("None");
        }
        return csvString.toString();
    }

    public ArrayList<Usuario> getUserListFromCSVFile(File file) {
        ArrayList<Usuario> userList = new ArrayList<Usuario>();
        for (String line : readDataFromCSVFile(file)) {
            String[] values = line.trim().split(",");
            ArrayList<Contacto> contactos = new ArrayList<Contacto>();
            if (values[2] != "None" && values.length > 3) {
                for (int i = 2; i < values.length; i += 2) {
                    contactos.add(new Contacto(values[i], Long.parseLong(values[i + 1])));
                }
            }
            userList.add(new Usuario(values[0], values[1], contactos.toArray(new Contacto[contactos.size()])));
        }
        return userList;
    }
}