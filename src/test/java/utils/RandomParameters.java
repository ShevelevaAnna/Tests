package utils;

import java.util.ArrayList;
import java.util.Random;

class RandomParameters {
    /**
     * метод осуществляет генерацию пароля по следующей схеме:
     * 1 символ - латинская буква "а";
     * 2 символ - рандомная буква киррилицы;
     * 3 символ - рандомная цифра;
     * 4 символ - рандомная прописная латинская буква;
     * 5 и далее - рандомные строчные латинские буквы.
     * @param numberLetters количество рандомных строчных латинских букв
     * @return password
     */
    static String randomPassword(int numberLetters){
        StringBuilder password = new StringBuilder();
        Random rand = new Random();
        password.append(DataRandom.ASCII_LATIN_a.getData());
        password.append((char) (rand.nextInt(2 * DataRandom.CYRILLIC_ALPHABET.getData()) + DataRandom.ASCII_CYRILLIC_A.getData()));
        password.append((char) (rand.nextInt(DataRandom.NUMBER_DIGITS.getData()) + DataRandom.ASCII_NUMBER_ZERO.getData()));
        password.append((char) (rand.nextInt(DataRandom.LATIN_ALPHABET.getData()) + DataRandom.ASCII_LATIN_A.getData()));
        for (int i = 0; i < numberLetters; i++){
            password.append((char) (rand.nextInt(DataRandom.LATIN_ALPHABET.getData()) + DataRandom.ASCII_LATIN_a.getData()));
        }
        return password.toString();
    }

    /**
     * метод осуществляет генерацию слова по следующей схеме:
     * 1 символ - латинская буква "а";
     * 2 и далее - рандомные строчные латинские буквы.
     * @param numberLetters количество рандомных строчных латинских букв
     * @return
     */
    static String randomWord(int numberLetters){
        StringBuilder word = new StringBuilder();
        Random rand = new Random();
        word.append(DataRandom.ASCII_LATIN_a.getData());
        for (int i = 0; i < numberLetters; i++){
            word.append((char) (rand.nextInt(DataRandom.LATIN_ALPHABET.getData()) + DataRandom.ASCII_LATIN_a.getData()));
        }
        return word.toString();
    }

    /**
     * метод осуществляет генерацию рандомного интереса
     * @return
     */
    static ArrayList<Integer> randomInterests(int countInterest){
        Random rand = new Random();
        ArrayList<Integer> interests = new ArrayList<>();
        int currentCountInterest = countInterest;
        while (currentCountInterest > 0){
            interests.add(rand.nextInt(DataRandom.NUMBER_INTERESTS.getData())+1);
            if(interests.get(countInterest - currentCountInterest) == DataRandom.SELECT_ALL_INTEREST.getData()) {
                interests.remove(countInterest - currentCountInterest);
                continue;
            }
            for (int i = 0; i < (countInterest - currentCountInterest); i++){
                if(interests.get(countInterest - currentCountInterest).equals(interests.get(i))) {
                    interests.remove(countInterest - currentCountInterest);
                    currentCountInterest++;
                    break;
                }
            }
            currentCountInterest--;
        }
        return interests;
    }

    /**
     * метод осуществляет выбор рандомного домена
     * @return
     */
    static int randomDomain(){
        Random rand = new Random();
        int domain = rand.nextInt(DataRandom.NUMBER_DOMAIN.getData() - 1)+2;
        return domain;
    }
}
