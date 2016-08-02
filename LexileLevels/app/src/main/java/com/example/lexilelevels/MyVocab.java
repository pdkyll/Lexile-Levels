package com.example.lexilelevels;

/**
 * Created by facebook on 8/2/16.
 */

import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
    import java.util.Scanner;
    import java.util.StringTokenizer;

// Example code to read a textfile and
// analyze vocabulary
public class MyVocab {
        static int vocabCnt[] = new int[13];  // 0=kindergarten, 12=Senior HS
        static int greatestLevel;

        public static void main() {

            // Step 1. Print Banner
            System.out.println("Starting Vocab Analyzer!");
            System.out.println("Sample Book: Dracula");

            // Step 2. Read the Text File into a string
            File sourceFile = new File("assets/dracula.txt");
            String bookStr = readTextFile2String(sourceFile);

            // Step 3. Divide book string into words
            ArrayList<String> words = tokenize(bookStr);

            // Step 4. Compare the words to known vocabulary
            compareWords(words);

            // Step 5. Print the vocabulary histogram
            System.out.println("Source text has " + words.size() + " words");
            System.out.println("Vocabulary Count:");
            for (int i = 0; i < 13; i++) {
                System.out.println("Grade " + i + ": " + vocabCnt[i]);
            }
            Arrays.sort(vocabCnt);
            greatestLevel = vocabCnt[vocabCnt.length-1];
            System.out.println("All Done");
        }

        // String Tokenizer
        public static ArrayList<String> tokenize(String bookStr) {
            ArrayList<String> words = new ArrayList<String>();

            // tokenizing algorithm
            StringTokenizer st = new StringTokenizer(bookStr);
            while (st.hasMoreTokens()) {
                //System.out.println(st.nextToken());
                words.add(st.nextToken());
            }
            return words;
        }

        // Compare the vocabulary words
        public static void compareWords(ArrayList<String> sourceWords) {
            for (int i = 0; i < sourceWords.size(); i++) {
                for (int level = 0; level < 13; level++) {
                    for (int idx = 0; idx < vocabLevel[level].length; idx++) {
                        if (sourceWords.get(i).equals(vocabLevel[level][idx])) {
                            vocabCnt[level]++;
                        }
                    }
                }
            }

        }

        /**
         * Read a file to a single String
         * @param filename the file to extract
         * @return a string containing the entire contents of the file
         */
        //public static String readTextFile2String(String filename) {
        public static String readTextFile2String(File filename) {
            // Is there a better way to do this?
            StringBuilder file = new StringBuilder();
            try {
                BufferedReader in =
                        new BufferedReader(
                                new FileReader(filename));
                for (int myChar = 0; (myChar = in.read()) != -1; ) {
                    file.append((char)myChar);
                }
                in.close();
                return file.toString();
            }
            catch(IOException x) {
                System.err.println("Could not find file named " + filename);
            }
            return null;
        }

        // The standard vocabulary is an array of arrays of strings
        public static String vocabLevel[][] = {

                { // Level 0 = Kindergarten
                        "a",
                        "cat",
                        "the"
                },
                { // Level 1 = 1st grade
                        "if",
                        "where",
                        "home"
                },
                // Note: all 2-to-12 level words from WordlyWise 3000
                { // Level 2 = 2nd grade
                        "calf",
                        "claw",
                        "couple",
                        "cushion"
                },
                { // Level 3 = 3rd grade
                        "cylinder"
                },
                { // Level 4 = 4th grade
                        "benefit"
                },
                { // Level 5 = 5th grade
                        "accustom"
                },
                { // Level 6 = 6th grade
                        "affection",
                        "appeal"
                },
                { // Level 7 = 7th grade
                        "abate",
                        "acknowledge"
                },
                { // Level 8 = 8th grade
                        "avid",
                        "brusque"
                },
                { // Level 9 = 9th grade (Freshman)
                        "bewail",
                        "destitute"
                },
                { // Level 10 = 10th grade (Sophomore)
                        "asperity",
                        "bane"
                },
                { // Level 11 = 11th grade (Junior)
                        "apocryphal",
                        "arcane",
                        "convene",
                        "expedient",
                        "exude",
                        "gesticulate",
                        "imperturbable",
                        "increment",
                        "levity",
                        "mortify",
                        "periphery",
                        "raconteur",
                        "reiterate",
                        "subterfuge",
                        "vacillate"
                },
                { // Level 12 = 12th grade (Senior)
                        "acolyte",
                        "bibulous",
                        "coalesce",
                        "covert",
                        "declaim",
                        "delineate",
                        "demagogue",
                        "encomium",
                        "obdurate",
                        "prescience",
                        "protagonist",
                        "sedulous",
                        "trenchant",
                        "utopia",
                        "valedictory"
                }
        };

    }

