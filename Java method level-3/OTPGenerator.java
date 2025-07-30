
public class OTPGenerator {

    // Method to generate a 6-digit OTP
    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);  // Ensures OTP is between 100000 and 999999
    }

    // Method to generate 10 OTPs
    public static int[] generateMultipleOTPs(int count) {
        int[] otps = new int[count];
        for (int i = 0; i < count; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }

    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false; // Duplicate found
                }
            }
        }
        return true;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] otpList = generateMultipleOTPs(10);

        System.out.println("Generated OTPs:");
        for (int otp : otpList) {
            System.out.println(otp);
        }

        boolean isUnique = areOTPsUnique(otpList);
        System.out.println("\nAre all OTPs unique? " + (isUnique ? "Yes ✅" : "No ❌"));
    }
}
