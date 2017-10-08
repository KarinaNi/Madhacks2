package edu.purdue.singh387.madhacks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class testing {

    public static void main(String[] args) {
        String input = "é\"resourceType\":\"Bundle\",\"type\":\"searchset\",\"total\":3,\"link\":°é\"relation\":\"self\",\"url\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/AllergyIntolerance?patient=Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB\"è§,\"entry\":°é\"fullUrl\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/AllergyIntolerance/TBwnNbrAqC0Qw5Ha7AFT-2AB\",\"link\":°é\"relation\":\"self\",\"url\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/AllergyIntolerance/TBwnNbrAqC0Qw5Ha7AFT-2AB\"è§,\"search\":é\"mode\":\"match\"è,\"resource\":é\"resourceType\":\"AllergyIntolerance\",\"recordedDate\":\"2015-08-24T23:11:36Z\",\"status\":\"confirmed\",\"criticality\":\"CRITL\",\"id\":\"TBwnNbrAqC0Qw5Ha7AFT-2AB\",\"onset\":\"2012-11-07T00:00:00Z\",\"recorder\":é\"display\":\"MOORE, SEAN\",\"reference\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Practitioner/TItWfhjChtlo0pFh9nzctSQB\"è,\"patient\":é\"display\":\"Jason Argonaut\",\"reference\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Patient/Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB\"è,\"substance\":é\"text\":\"PENICILLIN G\",\"coding\":°é\"system\":\"http://www.nlm.nih.gov/research/umls/rxnorm/\",\"code\":\"7980\",\"display\":\"PENICILLIN G\"è,é\"system\":\"http://fdasis.nlm.nih.gov\",\"code\":\"Q42T66VG0C\",\"display\":\"PENICILLIN G\"è§è,\"reaction\":°é\"certainty\":\"confirmed\",\"onset\":\"2012-11-07T00:00:00Z\",\"manifestation\":°é\"text\":\"Hives\"è§,\"note\":é\"text\":\"Severity low enough to be prescribed if needed.\"èè§,\"note\":é\"text\":\"Severity low enough to be prescribed if needed.\"èèè,é\"fullUrl\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/AllergyIntolerance/TPcWiBG2h2E114Vh0sRT8fQB\",\"link\":°é\"relation\":\"self\",\"url\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/AllergyIntolerance/TPcWiBG2h2E114Vh0sRT8fQB\"è§,\"search\":é\"mode\":\"match\"è,\"resource\":é\"resourceType\":\"AllergyIntolerance\",\"recordedDate\":\"2015-11-07T20:55:10Z\",\"status\":\"confirmed\",\"criticality\":\"CRITL\",\"id\":\"TPcWiBG2h2E114Vh0sRT8fQB\",\"onset\":\"2010-05-02T00:00:00Z\",\"recorder\":é\"display\":\"MOORE, SEAN\",\"reference\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Practitioner/TItWfhjChtlo0pFh9nzctSQB\"è,\"patient\":é\"display\":\"Jason Argonaut\",\"reference\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Patient/Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB\"è,\"substance\":é\"text\":\"SHELLFISH-DERIVED PRODUCTS\",\"coding\":°é\"system\":\"http://hl7.org/fhir/ndfrt\",\"code\":\"N0000007624\",\"display\":\"SHELLFISH-DERIVED PRODUCTS\"è§è,\"reaction\":°é\"certainty\":\"confirmed\",\"onset\":\"2010-05-02T00:00:00Z\",\"manifestation\":°é\"text\":\"Itching\"è§è§èè,é\"fullUrl\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/AllergyIntolerance/TKebKfLXzu6Sp.LY-IpvpmQB\",\"link\":°é\"relation\":\"self\",\"url\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/AllergyIntolerance/TKebKfLXzu6Sp.LY-IpvpmQB\"è§,\"search\":é\"mode\":\"match\"è,\"resource\":é\"resourceType\":\"AllergyIntolerance\",\"recordedDate\":\"2015-11-07T20:56:34Z\",\"status\":\"confirmed\",\"criticality\":\"CRITH\",\"id\":\"TKebKfLXzu6Sp.LY-IpvpmQB\",\"onset\":\"2014-03-07T00:00:00Z\",\"recorder\":é\"display\":\"MOORE, SEAN\",\"reference\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Practitioner/TItWfhjChtlo0pFh9nzctSQB\"è,\"patient\":é\"display\":\"Jason Argonaut\",\"reference\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Patient/Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB\"è,\"substance\":é\"text\":\"STRAWBERRY\",\"coding\":°é\"system\":\"http://www.nlm.nih.gov/research/umls/rxnorm/\",\"code\":\"892484\",\"display\":\"STRAWBERRY\"è,é\"system\":\"http://fdasis.nlm.nih.gov\",\"code\":\"4J2TY8Y81V\",\"display\":\"STRAWBERRY\"è§è,\"reaction\":°é\"certainty\":\"confirmed\",\"onset\":\"2014-03-07T00:00:00Z\",\"manifestation\":°é\"text\":\"Anaphylaxis\"è§è§èè§è";
        stringFinder3(input);
    }

    public static ArrayList<String> stringFinder3(String s) {

        String ans="";
        ArrayList<String> ansArr=new ArrayList<String>();
        //Set<String> hs = new HashSet<String>();
        String[] TempAns= s.split("\"text\":\"");
        for(int i=1;i<TempAns.length;i++)
        {
            String TempAns2[]=TempAns[i].split("\"");
            ans=TempAns2[0];
            ansArr.add(ans);
        }
        for(int i=1;i<ansArr.size();i++)
        {
            if(ansArr.get(i).equals(ansArr.get(i-1)))
            {
                    ansArr.remove(i);
                    i--;
            }
        }
        return ansArr;
    }

}
