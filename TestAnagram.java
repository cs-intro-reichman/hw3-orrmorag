import java.util.Arrays;

public class TestAnagram {
    private static int totalTests = 0;
    private static int passedTests = 0;

    public static void main(String[] args) {
        testIsAnagram();
        testPreProcess();
        testRandomAnagram();
        
        System.out.println("\nTotal tests: " + totalTests);
        System.out.println("Passed tests: " + passedTests);
        System.out.println("Success rate: " + (passedTests * 100.0 / totalTests) + "%");
    }

    public static int testIsAnagram() {
        System.out.println("\nTesting isAnagram method:");
        totalTests += 5;

        // Test case 1: Basic anagram
        boolean test1 = isAnagram("silent", "listen");
        System.out.println("Test 1 (basic anagram): " + (test1 ? "PASS" : "FAIL"));
        
        // Test case 2: Different lengths
        boolean test2 = !isAnagram("hello", "world!");
        System.out.println("Test 2 (different lengths): " + (test2 ? "PASS" : "FAIL"));
        
        // Test case 4: Empty strings
        boolean test4 = isAnagram("", "");
        System.out.println("Test 4 (empty strings): " + (test4 ? "PASS" : "FAIL"));
        
        // Test case 5: Complex anagram with spaces
        boolean test5 = isAnagram("William Shakespeare", "I am a weakish speller");
        System.out.println("Test 5 (complex anagram): " + (test5 ? "PASS" : "FAIL"));
        
        // Test case 6: Case sensitivity
        boolean test6 = isAnagram("Silent", "ListeN");
        System.out.println("Test 6 (case sensitivity): " + (test6 ? "PASS" : "FAIL"));

        int passed = (test1 ? 1 : 0) + (test2 ? 1 : 0) + 
                    (test4 ? 1 : 0) + (test5 ? 1 : 0) + (test6 ? 1 : 0);
        passedTests += passed;
        return passed;
    }

    public static int testPreProcess() {
        System.out.println("\nTesting preProcess method:");
        totalTests += 4;

        // Test case 1: Simple lowercase
        boolean test1 = preProcess("abc").equals("abc");
        System.out.println("Test 1 (simple lowercase): " + (test1 ? "PASS" : "FAIL"));
        
        // Test case 2: Preserve spaces
        boolean test2 = preProcess("Hello World!").equals("hello world");
        System.out.println("Test 2 (preserve spaces): " + (test2 ? "PASS" : "FAIL"));
        
        // Test case 3: Convert to lowercase
        boolean test3 = preProcess("HeLLo").equals("hello");
        System.out.println("Test 3 (case conversion): " + (test3 ? "PASS" : "FAIL"));
        
        // Test case 4: Empty string
        boolean test4 = preProcess("").equals("");
        System.out.println("Test 4 (empty string): " + (test4 ? "PASS" : "FAIL"));

        int passed = (test1 ? 1 : 0) + (test2 ? 1 : 0) + (test3 ? 1 : 0) + (test4 ? 1 : 0);
        passedTests += passed;
        return passed;
    }

    public static int testRandomAnagram() {
        System.out.println("\nTesting randomAnagram method:");
        totalTests += 3;
        
        // Test case 1: Check if result is an anagram
        String original = "hello";
        String randomized = randomAnagram(original);
        boolean test1 = isAnagram(original, randomized);
        System.out.println("Test 1 (is anagram): " + (test1 ? "PASS" : "FAIL"));
        
        // Test case 2: Check if same length
        boolean test2 = original.length() == randomized.length();
        System.out.println("Test 2 (same length): " + (test2 ? "PASS" : "FAIL"));
        
        // Test case 3: Check randomness (run multiple times)
        boolean foundDifferent = false;
        String first = randomAnagram("testing");
        for (int i = 0; i < 10; i++) {
            String next = randomAnagram("testing");
            if (!first.equals(next)) {
                foundDifferent = true;
                break;
            }
        }
        System.out.println("Test 3 (randomness): " + (foundDifferent ? "PASS" : "FAIL"));
        
        int passed = (test1 ? 1 : 0) + (test2 ? 1 : 0) + (foundDifferent ? 1 : 0);
        passedTests += passed;
        return passed;
    }

    public static String preProcess(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '.' || ch == ',' || ch == '!' || ch == '?') {
                str = str.substring(0, i) + str.substring(i + 1);
                i --;
            }
        }
        return str;
    }

    public static Boolean isAnagram(String str1, String str2) {
        String processed1 = preProcess(str1);
        String processed2 = preProcess(str2);
        processed1 = processed1.replace(" ", "");
        processed2 = processed2.replace(" ", "");
        if (processed1.length() != processed2.length()) {
            return false;
        }
        char[] arr1 = processed1.toCharArray();
        char[] arr2 = processed2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) { 
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static String randomAnagram(String original) {
        char[] randomized = original.toCharArray();
        int randomIndex = (int)(Math.random() * (randomized.length - 1));
        if (randomized[randomIndex] != randomized[randomIndex + 1]) {
            char temp = randomized[randomIndex];
            randomized[randomIndex] = randomized[randomIndex + 1];
            randomized[randomIndex + 1] = temp;
        }
    
        return new String(randomized);
    }
}