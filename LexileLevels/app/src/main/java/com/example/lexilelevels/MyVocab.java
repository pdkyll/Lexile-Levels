package com.example.lexilelevels;

/**
 * Created by facebook on 8/2/16.
 */

import android.content.res.AssetManager;
import android.util.Log;

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
            //File sourceFile = new File("android.resource://lexilelevels/assets/","dracula.txt");
            String bookStr = "DRACULA\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                                DRACULA\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                                  _by_\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                              Bram Stoker\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                        [Illustration: colophon]\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                                NEW YORK\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                            GROSSET & DUNLAP\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                              _Publishers_\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "      Copyright, 1897, in the United States of America, according\n" +
                    "\n" +
                    "                   to Act of Congress, by Bram Stoker\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                        [_All rights reserved._]\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                      PRINTED IN THE UNITED STATES\n" +
                    "\n" +
                    "                                   AT\n" +
                    "\n" +
                    "               THE COUNTRY LIFE PRESS, GARDEN CITY, N.Y.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                                   TO\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                             MY DEAR FRIEND\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                               HOMMY-BEG\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "DRACULA\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "CHAPTER I\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "JONATHAN HARKER'S JOURNAL\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "(_Kept in shorthand._)\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_3 May. Bistritz._--Left Munich at 8:35 P. M., on 1st May, arriving at\n" +
                    "\n" +
                    "Vienna early next morning; should have arrived at 6:46, but train was an\n" +
                    "\n" +
                    "hour late. Buda-Pesth seems a wonderful place, from the glimpse which I\n" +
                    "\n" +
                    "got of it from the train and the little I could walk through the\n" +
                    "\n" +
                    "streets. I feared to go very far from the station, as we had arrived\n" +
                    "\n" +
                    "late and would start as near the correct time as possible. The\n" +
                    "\n" +
                    "impression I had was that we were leaving the West and entering the\n" +
                    "\n" +
                    "East; the most western of splendid bridges over the Danube, which is\n" +
                    "\n" +
                    "here of noble width and depth, took us among the traditions of Turkish\n" +
                    "\n" +
                    "rule.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "We left in pretty good time, and came after nightfall to Klausenburgh.\n" +
                    "\n" +
                    "Here I stopped for the night at the Hotel Royale. I had for dinner, or\n" +
                    "\n" +
                    "rather supper, a chicken done up some way with red pepper, which was\n" +
                    "\n" +
                    "very good but thirsty. (_Mem._, get recipe for Mina.) I asked the\n" +
                    "\n" +
                    "waiter, and he said it was called \"paprika hendl,\" and that, as it was a\n" +
                    "\n" +
                    "national dish, I should be able to get it anywhere along the\n" +
                    "\n" +
                    "Carpathians. I found my smattering of German very useful here; indeed, I\n" +
                    "\n" +
                    "don't know how I should be able to get on without it.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Having had some time at my disposal when in London, I had visited the\n" +
                    "\n" +
                    "British Museum, and made search among the books and maps in the library\n" +
                    "\n" +
                    "regarding Transylvania; it had struck me that some foreknowledge of the\n" +
                    "\n" +
                    "country could hardly fail to have some importance in dealing with a\n" +
                    "\n" +
                    "nobleman of that country. I find that the district he named is in the\n" +
                    "\n" +
                    "extreme east of the country, just on the borders of three states,\n" +
                    "\n" +
                    "Transylvania, Moldavia and Bukovina, in the midst of the Carpathian\n" +
                    "\n" +
                    "mountains; one of the wildest and least known portions of Europe. I was\n" +
                    "\n" +
                    "not able to light on any map or work giving the exact locality of the\n" +
                    "\n" +
                    "Castle Dracula, as there are no maps of this country as yet to compare\n" +
                    "\n" +
                    "with our own Ordnance Survey maps; but I found that Bistritz, the post\n" +
                    "\n" +
                    "town named by Count Dracula, is a fairly well-known place. I shall enter\n" +
                    "\n" +
                    "here some of my notes, as they may refresh my memory when I talk over my\n" +
                    "\n" +
                    "travels with Mina.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "In the population of Transylvania there are four distinct nationalities:\n" +
                    "\n" +
                    "Saxons in the South, and mixed with them the Wallachs, who are the\n" +
                    "\n" +
                    "descendants of the Dacians; Magyars in the West, and Szekelys in the\n" +
                    "\n" +
                    "East and North. I am going among the latter, who claim to be descended\n" +
                    "\n" +
                    "from Attila and the Huns. This may be so, for when the Magyars conquered\n" +
                    "\n" +
                    "the country in the eleventh century they found the Huns settled in it. I\n" +
                    "\n" +
                    "read that every known superstition in the world is gathered into the\n" +
                    "\n" +
                    "horseshoe of the Carpathians, as if it were the centre of some sort of\n" +
                    "\n" +
                    "imaginative whirlpool; if so my stay may be very interesting. (_Mem._, I\n" +
                    "\n" +
                    "must ask the Count all about them.)\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "I did not sleep well, though my bed was comfortable enough, for I had\n" +
                    "\n" +
                    "all sorts of queer dreams. There was a dog howling all night under my\n" +
                    "\n" +
                    "window, which may have had something to do with it; or it may have been\n" +
                    "\n" +
                    "the paprika, for I had to drink up all the water in my carafe, and was\n" +
                    "\n" +
                    "still thirsty. Towards morning I slept and was wakened by the continuous\n" +
                    "\n" +
                    "knocking at my door, so I guess I must have been sleeping soundly then.\n" +
                    "\n" +
                    "I had for breakfast more paprika, and a sort of porridge of maize flour\n" +
                    "\n" +
                    "which they said was \"mamaliga,\" and egg-plant stuffed with forcemeat, a\n" +
                    "\n" +
                    "very excellent dish, which they call \"impletata.\" (_Mem._, get recipe\n" +
                    "\n" +
                    "for this also.) I had to hurry breakfast, for the train started a little\n" +
                    "\n" +
                    "before eight, or rather it ought to have done so, for after rushing to\n" +
                    "\n" +
                    "the station at 7:30 I had to sit in the carriage for more than an hour\n" +
                    "\n" +
                    "before we began to move. It seems to me that the further east you go the\n" +
                    "\n" +
                    "more unpunctual are the trains. What ought they to be in China?\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "All day long we seemed to dawdle through a country which was full of\n" +
                    "\n" +
                    "beauty of every kind. Sometimes we saw little towns or castles on the\n" +
                    "\n" +
                    "top of steep hills such as we see in old missals; sometimes we ran by\n" +
                    "\n" +
                    "rivers and streams which seemed from the wide stony margin on each side\n" +
                    "\n" +
                    "of them to be subject to great floods. It takes a lot of water, and\n" +
                    "\n" +
                    "running strong, to sweep the outside edge of a river clear. At every\n" +
                    "\n" +
                    "station there were groups of people, sometimes crowds, and in all sorts\n" +
                    "\n" +
                    "of attire. Some of them were just like the peasants at home or those I\n" +
                    "\n" +
                    "saw coming through France and Germany, with short jackets and round hats\n" +
                    "\n" +
                    "and home-made trousers; but others were very picturesque. The women\n" +
                    "\n" +
                    "looked pretty, except when you got near them, but they were very clumsy\n" +
                    "\n" +
                    "about the waist. They had all full white sleeves of some kind or other,\n" +
                    "\n" +
                    "and most of them had big belts with a lot of strips of something\n" +
                    "\n" +
                    "fluttering from them like the dresses in a ballet, but of course there\n" +
                    "\n" +
                    "were petticoats under them. The strangest figures we saw were the\n" +
                    "\n" +
                    "Slovaks, who were more barbarian than the rest, with their big cow-boy\n" +
                    "\n" +
                    "hats, great baggy dirty-white trousers, white linen shirts, and enormous\n" +
                    "\n" +
                    "heavy leather belts, nearly a foot wide, all studded over with brass\n" +
                    "\n" +
                    "nails. They wore high boots, with their trousers tucked into them, and\n" +
                    "\n" +
                    "had long black hair and heavy black moustaches. They are very\n" +
                    "\n" +
                    "picturesque, but do not look prepossessing. On the stage they would be\n" +
                    "\n" +
                    "set down at once as some old Oriental band of brigands. They are,\n" +
                    "\n" +
                    "however, I am told, very harmless and rather wanting in natural\n" +
                    "\n" +
                    "self-assertion.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "It was on the dark side of twilight when we got to Bistritz, which is a\n" +
                    "\n" +
                    "very interesting old place. Being practically on the frontier--for the\n" +
                    "\n" +
                    "Borgo Pass leads from it into Bukovina--it has had a very stormy\n" +
                    "\n" +
                    "existence, and it certainly shows marks of it. Fifty years ago a series\n" +
                    "\n" +
                    "of great fires took place, which made terrible havoc on five separate\n" +
                    "\n" +
                    "occasions. At the very beginning of the seventeenth century it underwent\n" +
                    "\n" +
                    "a siege of three weeks and lost 13,000 people, the casualties of war\n" +
                    "\n" +
                    "proper being assisted by famine and disease.";

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
            greatestLevel = vocabCnt.length-1;
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

