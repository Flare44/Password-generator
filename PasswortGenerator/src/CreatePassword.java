public class CreatePassword {
    public static String generate(String mode, int length) {
        if(mode.equals("secureMode")) {
            String[] sortedPassword = secure(length);
            String output = randomize(sortedPassword);
            return output;
        }

        return "";
    }

    public static String generate(String mode, int length, int amountSmallCharacters, int amountCapitalCharacters, int amountNumbers, int amountSpecialCharacters) {
        if(mode.equals("customMode")) {
            String[] sortedPassword = custom(length, amountSpecialCharacters, amountNumbers, amountSmallCharacters, amountCapitalCharacters);
            String output = randomize(sortedPassword);
            return output;
        }
        return "";
    }

    private static String randomize(String[] unsortedNewPassword) {
        String[] generatedPassword = new String[unsortedNewPassword.length];
        int random;

        for (int i = 0; i < generatedPassword.length; i++) {
            random = (int) (Math.random() * generatedPassword.length);
            if (unsortedNewPassword[random] == "invalid") {
                i--;
            }
            else {
                generatedPassword[i] = unsortedNewPassword[random];
                unsortedNewPassword[random] = "invalid";
            }
        }
        String output = "";
        for(int i = 0; i < generatedPassword.length; i++) {
            output += generatedPassword[i];
        }

        return output;
    }

    private static String[] secure(int passwordLength) {
        String[] symbols = {"!", "$", "%", "&", "#", "?", "-", "_", "*", ",", ";", "+", ".", "=", "~", "^", "(", ")", "{", "}", "[", "]", "|", ":", "/"};
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] smallCharacters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] capitalCharacters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "!", "$", "%", "&", "#", "?", "-", "_", "*", ",", ";", "+", ".", "=", "~",
                "^", "(", ")", "{", "}", "[", "]", "|", ":", "/"};

        String[] newPassword = new String[passwordLength];
        int random;

        for (int i = 0; i < passwordLength / 4; i++) {
            random = (int) (Math.random() * symbols.length);
            newPassword[i] = symbols[random];
        }

        for (int i = passwordLength / 4; i < passwordLength / 4 + passwordLength / 8; i++) {
            random = (int) (Math.random() * numbers.length);
            newPassword[i] = numbers[random];
        }

        for (int i = passwordLength / 4 + passwordLength / 8; i < passwordLength / 4 + passwordLength / 8 + passwordLength / 8; i++) {
            random = (int) (Math.random() * smallCharacters.length);
            newPassword[i] = smallCharacters[random];
        }

        for (int i = passwordLength / 4 + passwordLength / 8 + passwordLength / 8; i < passwordLength / 4 + passwordLength / 8 + passwordLength / 8 + passwordLength / 8; i++) {
            random = (int) (Math.random() * capitalCharacters.length);
            newPassword[i] = capitalCharacters[random];
        }

        for (int i = passwordLength / 4 + passwordLength / 8 + passwordLength / 8 + passwordLength / 8; i < passwordLength; i++) {
            random = (int) (Math.random() * strings.length);
            newPassword[i] = strings[random];
        }

        return newPassword;
    }

    private static String[] custom(int length, int symbolsAmount, int numbersAmount, int smallCharactersAmount, int capitalCharactersAmount) {
        String[] symbols = {"!", "$", "%", "&", "#", "?", "-", "_", "*", ",", ";", "+", ".", "=", "~", "^", "(", ")", "{", "}", "[", "]", "|", ":", "/"};
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] smallCharacters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] capitalCharacters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "!", "$", "%", "&", "#", "?", "-", "_", "*", ",", ";", "+", ".", "=", "~",
                "^", "(", ")", "{", "}", "[", "]", "|", ":", "/"};


        int passwordLength = length;
        int amountSymbols = symbolsAmount;
        int amountNumbers = numbersAmount;
        int amountSmallCharacters = smallCharactersAmount;
        int amountCapitalCharacters = capitalCharactersAmount;
        int random;


        String[] newPassword = new String[passwordLength];

        for (int i = 0; i < amountSymbols; i++) {
            random = (int) (Math.random() * symbols.length);
            newPassword[i] = symbols[random];
        }

        // Numbers are being randomly chosen
        for (int i = amountSymbols; i < amountSymbols + amountNumbers; i++) {
            random = (int) (Math.random() * numbers.length);
            newPassword[i] = numbers[random];
        }

        // Small characters are being randomly chosen
        for (int i = amountSymbols + amountNumbers; i < amountSymbols + amountNumbers + amountSmallCharacters; i++) {
            random = (int) (Math.random() * smallCharacters.length);
            newPassword[i] = smallCharacters[random];
        }

        // Capital characters are being randomly chosen
        for (int i = amountSymbols + amountNumbers + amountSmallCharacters; i < amountSymbols + amountNumbers + amountSmallCharacters + amountCapitalCharacters; i++) {
            random = (int) (Math.random() * capitalCharacters.length);
            newPassword[i] = capitalCharacters[random];
        }

        // Everything else is being randomly chosen
        for (int i = amountSymbols + amountNumbers + amountSmallCharacters + amountCapitalCharacters; i < passwordLength; i++) {
            random = (int) (Math.random() * strings.length);
            newPassword[i] = strings[random];
        }

        return newPassword;
    }
}
