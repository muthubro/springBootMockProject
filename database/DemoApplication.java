/**
 * Contains code to populate the database
 * 
 * Note: Replace the value of variable fileLocation with the location of the file
 */

package com.accelerate.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.accelerate.demo.model.MobileFoodFacilityPermit;
import com.accelerate.demo.repository.MobileFoodFacilityPermitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private MobileFoodFacilityPermitRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String fileLocation = "d:/Work/Dash/new.csv";		// Replace this with the file location
		String line;

		try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
			int count = 0;
			
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

				Long locationId = null;
				Long cnn = null;
				Double x = null;
				Double y = null;
				Double latitude = null;
				Double longitude = null;
				Integer priorPermit = null;

				for (int i = 0; i < row.length; i++) {
					row[i] = trim(row[i]);
				}
				
				if (!row[0].isEmpty())
					locationId = Long.parseLong(row[0]);

				if (!row[3].isEmpty())
					cnn = Long.parseLong(row[3]);

				if (!row[11].isEmpty())
					x = Double.parseDouble(row[11]);

				if (!row[12].isEmpty())
					y = Double.parseDouble(row[12]);

				if (!row[13].isEmpty())
					latitude = Double.parseDouble(row[13]);

				if (!row[14].isEmpty())
					longitude = Double.parseDouble(row[14]);

				if (!row[20].isEmpty())
					priorPermit = Integer.parseInt(row[20]);

				DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				Date noiSent = new Date();
				if (!row[17].equals("")) {
					noiSent = format.parse(row[17]);
				}
				Date approved = new Date();
				if (!row[18].equals("")) {
					approved = format.parse(row[18]);
				}
				Date expirationDate = new Date();
				if (!row[21].equals("")) {
					expirationDate = format.parse(row[21]);
				}

				format = new SimpleDateFormat("yyyy-MM-dd");
				Date received = new Date();
				if (!row[19].equals("")) {
					received = format.parse(row[19]);
				}

				MobileFoodFacilityPermit permit = new MobileFoodFacilityPermit(locationId, row[1], row[2], cnn, 
																				row[4], row[5], row[6], row[7], 
																				row[8], row[9], row[10], 
																				x, y, latitude, longitude, 
																				row[16], row[17], noiSent, approved, 
																				received, priorPermit, expirationDate);
				repository.save(permit);
				count++;
			}
			System.out.println(count);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private String trim(String string) {
		return string.substring(1, string.length()-1);
	}

}
