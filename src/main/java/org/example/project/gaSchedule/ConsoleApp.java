package org.example.project.gaSchedule;


import org.example.project.gaSchedule.algorithm.Cso;
import org.example.project.gaSchedule.model.Configuration;
import org.example.project.gaSchedule.model.Schedule;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class ConsoleApp
{
    public static void main(String[] args)
    {
    	try {
			final String FILE_NAME = args.length > 0 ? args[0] : "GaSchedule.json";
	        final long startTime = System.currentTimeMillis();

	        Configuration configuration = new Configuration();
	        File targetFile = new File(System.getProperty("user.dir") + "/" + FILE_NAME);
	        if(!targetFile.exists())
	        	targetFile = new File(new File(ConsoleApp.class.getResource("/").toURI()).getParentFile() + "/" + FILE_NAME);
			//configuration.parse(targetFile);
			configuration.loadFromDatabase();
	        Cso<Schedule> alg = new Cso<>(new Schedule(configuration), 2,
					2, 80, 3);


			System.out.println("Run program");
	        alg.run(9999, 0.999);
	        
	        String htmlResult = HtmlOutput.getResult(alg.getResult());
	
	        String tempFilePath = System.getProperty("java.io.tmpdir") + FILE_NAME.replace(".json", ".htm");
	        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFilePath))))
	        {
	            writer.write(htmlResult);
	            writer.flush();
	        }
	
	        double seconds = (System.currentTimeMillis() - startTime) / 1000.0;
	        System.out.println(String.format("\nCompleted in %f secs.", seconds));
	        if (Desktop.isDesktopSupported()) {
	            try {
	                Desktop.getDesktop().open(new File(tempFilePath));
	            } catch (Exception ex) {
	                // no application registered for html
	            }
	        }
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
