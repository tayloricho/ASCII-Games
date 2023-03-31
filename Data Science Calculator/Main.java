import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class Main {
    public static void main(String[] args) {
        System.out.println(fileImport("University Salary Data.csv", 0, 0));
        interpolater();
    }

    public static double interpolater() {
        return 0;
    }

    public static ArrayList<String> fileImport(String fileRoot, int x, int y) {
        try {
            Scanner sc = new Scanner(new File(fileRoot));
            sc.useDelimiter(",");
            ArrayList<String> dataSet = new ArrayList<String>();
            while (sc.hasNext()) {
                dataSet.add(sc.next());
            }
            sc.close();
            return dataSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
