// Solution 1: Hospital Lab Integration
// Pattern: Adapter

// Target Interface
interface PatientReport {
    void getPatientReport();
}

// Existing Lab APIs (Adaptees)
class LabA {
    void getBloodReport() {
        System.out.println("LabA: Blood report fetched");
    }
}

class LabB {
    void fetchLabResults() {
        System.out.println("LabB: Lab results fetched");
    }
}

// Adapter
class LabAdapter implements PatientReport {
    private LabA labA;
    private LabB labB;

    LabAdapter(String labType) {
        if (labType.equalsIgnoreCase("LabA")) {
            labA = new LabA();
        } else if (labType.equalsIgnoreCase("LabB")) {
            labB = new LabB();
        }
    }

    public void getPatientReport() {
        if (labA != null) {
            labA.getBloodReport();
        } else if (labB != null) {
            labB.fetchLabResults();
        }
    }
}

// Client
public class HospitalAdapterDemo {
    public static void main(String[] args) {
        PatientReport report1 = new LabAdapter("LabA");
        report1.getPatientReport();

        PatientReport report2 = new LabAdapter("LabB");
        report2.getPatientReport();
    }
}
