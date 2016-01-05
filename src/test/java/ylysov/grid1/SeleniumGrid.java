package ylysov.grid1;

import java.io.*;

public class SeleniumGrid {


    public void StartGrid() throws Exception {

        final String dir = System.getProperty("user.dir");

        String projectDir = dir + "\\src\\seleniumGridFiles\\";
        System.out.println("SeleniumGrid is started form: " + projectDir);

        ProcessBuilder pb = new ProcessBuilder(projectDir + "StartGrid.bat");
        pb.directory(new File(projectDir));
        Process p = pb.start();
        Thread.sleep(3000);
    }

}
