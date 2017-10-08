package edu.purdue.singh387.madhacks;
import java.io.*;
import java.util.*;

public class DBHandler {
	public DBHandler(){}
	private String WatsonKey = null;
	private String WatsonKey2 = null;
	private String WatsonKey3 = null;
	public static void main(String[] args){
		DBHandler db = new DBHandler();
		db.returnInfo("20171007_220733.jpg");

	}

	public void loadKey(){
		WatsonKey = "4681c8c52739fba90f6b6266093c3228a7b0fde8";
		WatsonKey2 = "f0d276084588faceb4cf5735156d43c9767aebba";
		WatsonKey3 = "6b45a92a603ffb162fd5d12e0ba18cc89e6ac90d";
	}

	public ArrayList<String> returnInfo(String filename){
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

		name = findName(name, "Chris");
		if (name.equals("Chris")) return name;
		String params3[][] = new String[][]{
			{"version","2016-05-20"},
			{"owners", "[\"me\",\"IBM\"]"},
			{"api_key", WatsonKey2}
			};

		requests r2 = new requests();
		try {
			name = r2.send(params3, "https://watson-api-explorer.mybluemix.net/visual-recognition/api/v3/classify", filename);
		} catch(Exception e){
			System.out.println("Error In Post Request.");
		}
		name = findName(name, "Hari");
		if (name.equals("Hari")) return name;

		String params4[][] = new String[][]{
			{"version","2016-05-20"},
			{"owners", "[\"me\",\"IBM\"]"},
			{"api_key", WatsonKey3}
			};
		requests r3 = new requests();
		try {
			name = r3.send(params4, "https://watson-api-explorer.mybluemix.net/visual-recognition/api/v3/classify", filename);
		} catch(Exception e){
			System.out.println("Error In Post Request.");
		}
		name = findName(name, "Hari");

		return name;

	}
	public ArrayList<String> findMedicalInfo(String name){
		String firstName = null;
		String lastName = null;

		if (name.equals("Chris")){
			firstName = "Jason";
			lastName  = "Argonaut";
		else if (name.equals("Hari")){
			firstName = "Emily";
			lastName = "Williams";
		} else if (name.equals("Shrehit")){
			firstName = "James";
			lastName = "Kirk";
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
		return parsedData;
	}

	public static String findName(String s, String who) {
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
    		return who;
    	}
    	else
    	return "no"+who;
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




