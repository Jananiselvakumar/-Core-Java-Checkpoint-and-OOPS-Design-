import java.util.Scanner;

abstract class Doctor {
    double consultationCharge;

    Doctor(double charge) {
        consultationCharge = charge;
    }

    abstract String getDoctorType();

    double calculateTotalBill(double testCharges) {
        return consultationCharge;
    }
}

class GeneralPhysician extends Doctor {
    GeneralPhysician() {
        super(500.0);
    }

    String getDoctorType() {
        return "General Physician";
    }
}

class Specialist extends Doctor {
    Specialist() {
        super(1000.0);
    }

    String getDoctorType() {
        return "Specialist";
    }
}

class EmergencyDoctor extends Doctor {
    EmergencyDoctor() {
        super(1500.0);
    }

    String getDoctorType() {
        return "Emergency Doctor";
    }

    double calculateTotalBill(double testCharges) {
        return consultationCharge + testCharges;
    }
}

public class Hospital-Billing-System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int type = sc.nextInt();
        double testCharges = sc.nextDouble();

        Doctor d;

        if (type == 1) {
            d = new GeneralPhysician();
        } else if (type == 2) {
            d = new Specialist();
        } else {
            d = new EmergencyDoctor();
        }

        System.out.println("Doctor Type: " + d.getDoctorType());
        System.out.printf("Consultation Charge: %.2f%n", d.consultationCharge);
        System.out.printf("Test Charges: %.2f%n", testCharges);
        System.out.printf("Total Bill: %.2f%n", d.calculateTotalBill(testCharges));

        sc.close();
    }
}
