<<<<<<< HEAD
package edu.purdue.singh387.madhacks;
import java.io.*;
import java.util.*;

public class DBHandler {
	public DBHandler(){}
=======
import java.io.*;
import requests.requests;
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tester2.testing;

public class DBHandler {
>>>>>>> eea89aff726d88ebd472e7251faf67189e6e6ff5
	private String WatsonKey = null;
	public static void main(String[] args){
		DBHandler db = new DBHandler();
		// db.returnInfo("20171007_220733.jpg");
		// System.out.println(db.classifyPhoto("20171007_220739.jpg"));
		db.returnInfo("20171007_220733.jpg");

	}

	public void loadKey(){
<<<<<<< HEAD
		/*try {
=======
		try {
>>>>>>> eea89aff726d88ebd472e7251faf67189e6e6ff5
			FileReader fileReader = new FileReader("KEYFILE.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			WatsonKey = bufferedReader.readLine();
			System.out.println(WatsonKey);
			bufferedReader.close();
		} catch (FileNotFoundException ex){
			System.out.println("Key missing");
			System.exit(1);
		} catch (IOException ex){
			System.out.println("Key missing");
			System.exit(1);
<<<<<<< HEAD
		}*/
		WatsonKey = "4681c8c52739fba90f6b6266093c3228a7b0fde8";
	}

	public ArrayList<String> returnInfo(String filename){
=======
		}
	}

	public String returnInfo(String filename){
>>>>>>> eea89aff726d88ebd472e7251faf67189e6e6ff5
		//	Load the Watson API key
		loadKey();
		return findMedicalInfo(classifyPhoto(filename));
	}

	public String classifyPhoto(String filename){
		//	Specify post parameters
		String params2[][] = new String[][]{
			{"version","2016-05-20"},
			{"owners", "[\"me\",\"IBM\"]"},
			{"api_key", WatsonKey}
			};
		String name = null;

		//	Create classifications:
		requests r = new requests();
		try {
			name = r.send(params2, "https://watson-api-explorer.mybluemix.net/visual-recognition/api/v3/classify", filename);
		} catch(Exception e){
			System.out.println("Error In Post Request.");
		}

		name = findName(name);
		return name;

	}
<<<<<<< HEAD
	public ArrayList<String> findMedicalInfo(String name){
=======
	public String findMedicalInfo(String name){
>>>>>>> eea89aff726d88ebd472e7251faf67189e6e6ff5
		String firstName = null;
		String lastName = null;

		if (name.equals("Chris")){
			firstName = "Jason";
			lastName  = "Argonaut";
		// } else if (name.equals("Hari")){
		// 	firstName = "Emily";
		// 	lastName = "Williams";
		// } else if (name.equals("Karina")){
		// 	firstName = "James";
		// 	lastName = "Kirk";
		} else {
			firstName = "Waffles";
			lastName = "Ragsdale";
		}

		//	Specify get parameters
		String params2[][] = new String[][]{
			{"given",firstName},
			{"family", lastName}
			};

		String ID = null;
		//	Create classifications:
		requests r = new requests();
		try {
			ID = r.get(params2, "https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Patient");
		} catch(Exception e){
			System.out.println("Error In Post Request.");
		}
		ID = findID(ID);
		// System.out.println(ID);
		
		String salientData = null;

		String params3[][] = new String[][]{{"patient",ID}};
		try {
			salientData = r.get(params3, "https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/AllergyIntolerance");
		} catch(Exception e){
			System.out.println("Error In Get Request.");
		}

		testing t = new testing();

		ArrayList<String> parsedData = new ArrayList<String>();
		parsedData.add("ALLERGIES:");

		for (int i = 0; i < t.stringFinder3(salientData).size(); i++){
			if (!(t.stringFinder3(salientData).get(i).equals("Have a comment"))){
				parsedData.add(t.stringFinder3(salientData).get(i));
			}
		}
		// parsedData.add(t.stringFinder3(salientData));

		// try {
		// 	salientData = r.get(params3, "https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/MedicationOrder");
		// } catch(Exception e){
		// 	System.out.println("Error In Get Request.");
		// }

		// if (!(t.stringFinder3(salientData).get(0).equals("Resource request returns no results."))){
		// 	parsedData.add("MEDITCATIONS:");
		// 	for (int i = 0; i < t.stringFinder3(salientData).size(); i++){
		// 		parsedData.add(t.stringFinder3(salientData).get(i));
		// 	}
		// }

		try {
			salientData = r.get(params3, "https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Condition");
		} catch(Exception e){
			System.out.println("Error In Get Request.");
		}
		if (!(t.stringFinder3(salientData).get(0).equals("Resource request returns no results."))){
			parsedData.add("CONDITIONS:");
			for (int i = 0; i < t.stringFinder3(salientData).size(); i++){
				parsedData.add(t.stringFinder3(salientData).get(i));
			}
		}

		for (int i = 0; i < parsedData.size(); i++){
			System.out.println(parsedData.get(i));
		}

<<<<<<< HEAD
		return parsedData;
=======
		return salientData;
>>>>>>> eea89aff726d88ebd472e7251faf67189e6e6ff5
	}

	public static String findName(String s) {
        // String ans = "";
        Integer i = 1000;
        if(s.indexOf("1.000")<0)
        {
	        while (s.indexOf(i.toString()) < 0 && i>0) {
	            i = i - 1;
	        }
        }
        if(i>500&&s.indexOf("classname")>=0)
        {
    		return "Chris";
    	}
    	else
    	return "noChris";
    }
     public static String findID(String s) {
        String id;
        String[] idTemp= s.split("\"id\":\"");
        String[] idTemp2=idTemp[1].split("\"");
        id = idTemp2[0];
        System.out.println(id);
        return id;
    }
}




