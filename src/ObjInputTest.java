import java.util.Scanner;

public class ObjInputTest {
    public static void main(String[] args) {
        // Instantiate using your default constructor
        SafeInputObj sio = new SafeInputObj();

        System.out.println("==================================================");
        System.out.println("          STARTING SAFEINPUTOBJ TESTS             ");
        System.out.println("==================================================");

        // 1. Test getNonZeroLenString
        System.out.println("\n--- Testing getNonZeroLenString ---");
        String testStr = sio.getNonZeroLenString("Enter your favorite movie");
        System.out.println("Returned value: " + testStr);

        // 2. Test getInt
        System.out.println("\n--- Testing getInt ---");
        int testInt = sio.getInt("Enter any integer");
        System.out.println("Returned value: " + testInt);

        // 3. Test getRangedInt
        System.out.println("\n--- Testing getRangedInt ---");
        int testRangedInt = sio.getRangedInt("Enter an age", 1, 120);
        System.out.println("Returned value: " + testRangedInt);

        // 4. Test getDouble
        System.out.println("\n--- Testing getDouble ---");
        double testDouble = sio.getDouble("Enter a decimal value");
        System.out.println("Returned value: " + testDouble);

        // 5. Test getRangedDouble
        System.out.println("\n--- Testing getRangedDouble ---");
        double testRangedDouble = sio.getRangedDouble("Enter a GPA", 0.0, 4.0);
        System.out.println("Returned value: " + testRangedDouble);

        // 6. Test getYNConfirm
        System.out.println("\n--- Testing getYNConfirm ---");
        boolean testYN = sio.getYNConfirm("Are you ready to submit your assignment?");
        System.out.println("Returned value: " + testYN);

        // 7. Test getRegExString (Matches your exact method name)
        System.out.println("\n--- Testing getRegExString ---");
        String testRegEx = sio.getRegExString("Enter a UC Student ID (M followed by 8 digits)", "^[mM]\\d{8}$");
        System.out.println("Returned value: " + testRegEx);

        System.out.println("\n==================================================");
        System.out.println("             ALL TESTS COMPLETED                  ");
        System.out.println("==================================================");
    }
}
