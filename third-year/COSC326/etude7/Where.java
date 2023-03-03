import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * This program takes a latitude and longitude input from the user. This is either in
 * standard form, dms form, or degrees and decimal minutes form. It then processes the input
 * and if the input is valid it writes the location to the output file in GeoJSON format.
 * 
 * My code is not normally this ugly. I had to keep adding to it in small iterations for
 * the course coordinators.
 */
public class Where {
    private ArrayList<String> lines;
    private ArrayList<String> tokens;
    private ArrayList<String> output;

    private int lineCount;
    private int tokenCount;
    private int partCount;

    private String latitude;
    private String longitude;
    private String label;

    private boolean valid;
    private int numCount;

    private int written;

    private double degrees;
    private double minutes;
    private double seconds;
    private double result;

    /**
     * Main method makes an instance of itself and calls start() on the instance,
     * this is so I don't have to write the word "static" everywhere.
     */
    public static void main(String[] args) {
        new Where().start();
    }

    /**
     * This method prompts the user to enter a latitude and longitude, it then takes the input and confirms that
     * it is valid. If it is valid then the program writes the valid location in GeoJSON format to the output.txt file.
     */
    public void start() {
        System.out.println("Enter latitude and longitude: \n");
        Scanner scanner = new Scanner(System.in);

        //initializing/resetting values
        lines = null;
        lines = new ArrayList<String>();
        output = null;
        output = new ArrayList<String>();
        lineCount = 0;
        tokenCount = 0;
        partCount = 0;
        written = 0;

        //adds all lines of input to an arraylist for later use
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            lines.add(temp);
            lineCount++;
        }

        System.out.println();

        //for each line of input
        for (int z = 0; z < lines.size(); z++) {
            //initializing/resetting values
            latitude = "";
            longitude = "";
            label = "";
            tokens = null;
            tokens = new ArrayList<String>();
            valid = true;
            numCount = 0;
            degrees = 0;
            minutes = 0;
            seconds = 0;
            result = 0;

            String line = lines.get(z);
            Scanner lineScanner = new Scanner(line);

            //splits line up into tokens and stores them for later use
            while (lineScanner.hasNext()) {
                String temp = lineScanner.next();
                tokens.add(temp);
                tokenCount++;
            }

            //goes through all the tokens, removes non number characters from the end of them and counts the numbers in the line.
            for (String s : tokens) {
                char c = s.charAt(s.length() - 1);
                String endOfWord = String.valueOf(c);

                try{
                    Double.parseDouble(endOfWord);
                }catch (Exception e){
                    s = s.substring(0, s.length() - 1);
                }

                try {
                    Double.parseDouble(s);
                    numCount++;
                } catch (Exception e) {
                }
            }

            if (numCount == 0) { //DMS with no spaces
                for (int i = 0; i < tokens.size(); i++) { //for each token/word in the line
                    String temp = tokens.get(i);
                    char c = temp.charAt(temp.length() - 1);
                    if (c == ',') temp = temp.substring(0, temp.length() - 1);

                    if (i == 0) {  // i = token/word number
                        if (temp.contains("°") && temp.contains("\"") && temp.contains("'")){
                            degrees = Double.parseDouble(temp.substring(0, temp.indexOf('°')));
                            minutes = Double.parseDouble(temp.substring(temp.indexOf('°') + 1, temp.indexOf('\'')));
                            seconds = Double.parseDouble(temp.substring(temp.indexOf('\'') + 1, temp.indexOf('"')));

                            result = degrees + (minutes / 60) + (seconds/3600);
                            latitude = String.valueOf(result);
                            if (temp.charAt(temp.length() - 1) == 'S' || temp.charAt(temp.length() - 1) == 'W'){
                                if (latitude.charAt(0) == '-'){

                                }else{
                                    latitude = ("-" + latitude);
                                }
                            }
                        }else{
                            valid = false;
                        }
                    }else if (i == 1) {  // i = token/word number
                        if (temp.contains("°") && temp.contains("\"") && temp.contains("'")){
                            degrees = Double.parseDouble(temp.substring(0, temp.indexOf('°')));
                            minutes = Double.parseDouble(temp.substring(temp.indexOf('°') + 1, temp.indexOf('\'')));
                            seconds = Double.parseDouble(temp.substring(temp.indexOf('\'') + 1, temp.indexOf('"')));

                            result = degrees + (minutes / 60) + (seconds/3600);
                            longitude = String.valueOf(result);
                            if (temp.charAt(temp.length() - 1) == 'S' || temp.charAt(temp.length() - 1) == 'W'){
                                if (longitude.charAt(0) == '-'){

                                }else{
                                    longitude = ("-" + longitude);
                                }
                            }
                        }else{
                            valid = false;
                        }
                    }if (i == 2) {  // i = token/word number
                        try{
                            Double.parseDouble(temp);
                            valid = false;
                        }catch (Exception ex){
                            label = temp;
                        }
                    }
                }
            }else if (numCount == 2) { //Standard Form
                for (int i = 0; i < tokens.size(); i++) { //for each token/word in the line
                    String temp = tokens.get(i);
                    char c = temp.charAt(temp.length() - 1);
                    if (c == ',' || c == '°' || c == '\'' || c == '"') {
                        temp = temp.substring(0, temp.length() - 1);
                    }

                    if (i == 0) { // i = token/word number
                        latitude = temp;
                    } else if (i == 1) {  // i = token/word number
                        if (temp.equals("N") || temp.equals("S") || temp.equals("E") || temp.equals("W")) {
                            if (temp.equals("S") || temp.equals("W")){
                                if (latitude.charAt(0) == '-'){

                                }else{
                                    latitude = ("-" + latitude);
                                }
                            }else{
                                if (latitude.charAt(0) == '-'){
                                    latitude = latitude.substring(1);
                                }
                            }
                        } else {
                            longitude = temp;
                        }
                    } else if (i == 2) { // i = token/word number
                        if (temp.equals("N") || temp.equals("S") || temp.equals("E") || temp.equals("W")) {
                            if (temp.equals("S") || temp.equals("W")){
                                if (longitude.charAt(0) == '-'){

                                }else{
                                    longitude = ("-" + longitude);
                                }
                            }else{
                                if (longitude.charAt(0) == '-'){
                                    longitude = longitude.substring(1);
                                }
                            }
                        } else {
                            try {
                                double longi = Double.parseDouble(temp);
                                longitude = String.valueOf(longi);
                            } catch (Exception e) {
                                try{
                                    Double.parseDouble(temp);
                                    valid = false;
                                }catch (Exception ex){
                                    label = temp;
                                }
                            }
                        }
                    }else if (i == 3) { // i = token/word number
                        if (temp.equals("N") || temp.equals("S") || temp.equals("E") || temp.equals("W")) {
                            if (temp.equals("S") || temp.equals("W")){
                                if (longitude.charAt(0) == '-'){

                                }else{
                                    longitude = ("-" + longitude);
                                }
                            }else{
                                if (longitude.charAt(0) == '-'){
                                    longitude = longitude.substring(1);
                                }
                            }
                        } else {
                            try{
                                Double.parseDouble(temp);
                                valid = false;
                            }catch (Exception e){
                                label = temp;
                            }
                        }
                    } else if (i == 4) { // i = token/word number
                        if (temp.equals("N") || temp.equals("S") || temp.equals("E") || temp.equals("W")) {
                            if (temp.equals("S") || temp.equals("W")){
                                if (longitude.charAt(0) == '-'){

                                }else{
                                    longitude = ("-" + longitude);
                                }
                            }else{
                                if (longitude.charAt(0) == '-'){
                                    longitude = longitude.substring(1);
                                }
                            }
                        } else {
                            try{
                                Double.parseDouble(temp);
                                valid = false;
                            }catch (Exception e){
                                label = temp;
                            }
                        }
                    }
                }
            } else if (numCount == 4) { //Degrees and Decimal Minutes
                for (int i = 0; i < tokens.size(); i++) { //for each token/word in the line
                    String temp = tokens.get(i);
                    char c = temp.charAt(temp.length() - 1);
                    if (c == ',' || c == '°' || c == '\'' || c == '"') {
                        temp = temp.substring(0, temp.length() - 1);
                    }

                    if (i == 0) { // i = token/word number
                        try{
                            degrees = Double.parseDouble(temp);
                        }catch(Exception e){
                            valid = false;
                        }
                    } else if (i == 1) { // i = token/word number
                        try{
                            minutes = Double.parseDouble(temp);
                            result = degrees + (minutes/60);
                            latitude = String.valueOf(result);
                            degrees = 0;
                            minutes = 0;
                            result = 0;
                        }catch(Exception e){
                            valid = false;
                        }
                    } else if (i == 2) { // i = token/word number
                        if (temp.equals("N") || temp.equals("S") || temp.equals("E") || temp.equals("W")) {
                            if (temp.equals("S") || temp.equals("W")){
                                if (latitude.charAt(0) == '-'){

                                }else{
                                    latitude = ("-" + latitude);
                                }
                            }else{
                                if (latitude.charAt(0) == '-'){
                                    latitude = latitude.substring(1);
                                }
                            }
                        } else {
                            try {
                                degrees = Double.parseDouble(temp);
                            } catch (Exception e) {
                                valid = false;
                            }
                        }
                    }else if (i == 3) { // i = token/word number
                        if (degrees == 0){
                            try {
                                degrees = Double.parseDouble(temp);
                            } catch (Exception e) {
                                valid = false;
                            }
                        }else{
                            try {
                                minutes = Double.parseDouble(temp);
                                result = degrees + (minutes/60);
                                longitude = String.valueOf(result);
                                degrees = 0;
                                minutes = 0;
                                result = 0;
                            } catch (Exception e) {
                                valid = false;
                            }
                        }
                    } else if (i == 4) { // i = token/word number
                        if (Objects.equals(longitude, "") && minutes == 0){
                            try {
                                minutes = Double.parseDouble(temp);
                                result = degrees + (minutes/60);
                                longitude = String.valueOf(result);
                                degrees = 0;
                                minutes = 0;
                                result = 0;
                            } catch (Exception e) {
                                valid = false;
                            }
                        } else if (temp.equals("N") || temp.equals("S") || temp.equals("E") || temp.equals("W")) {
                            if (temp.equals("S") || temp.equals("W")){
                                if (longitude.charAt(0) == '-'){

                                }else{
                                    longitude = ("-" + longitude);
                                }
                            }else{
                                if (longitude.charAt(0) == '-'){
                                    longitude = longitude.substring(1);
                                }
                            }
                        } else {
                            try{
                                Double.parseDouble(temp);
                                valid = false;
                            }catch (Exception e){
                                label = temp;
                            }
                        }
                    } else if (i == 5) { // i = token/word number
                        if (temp.equals("S") || temp.equals("W") && !Objects.equals(longitude, "")){
                            if (longitude.charAt(0) == '-'){

                            }else{
                                longitude = ("-" + longitude);
                            }
                        } else {
                            try{
                                Double.parseDouble(temp);
                                valid = false;
                            }catch (Exception e){
                                label = temp;
                            }
                        }
                    } else if (i == 6) { // i = token/word number
                        try{
                            Double.parseDouble(temp);
                            valid = false;
                        }catch (Exception e){
                            label = temp;
                        }
                    }
                }
            } else if (numCount == 6) { //Degrees, Minutes, Seconds Form
                if (line.contains("d") && line.contains("m") && line.contains("s")){
                    longDMS();
                }else{
                    for (int i = 0; i < tokens.size(); i++) { //for each token/word in the line
                        String temp = tokens.get(i);
                        char c = temp.charAt(temp.length() - 1);
                        if (c == ',' || c == '°' || c == '\'' || c == '"') {
                            temp = temp.substring(0, temp.length() - 1);
                        }

                        if (i == 0) { // i = token/word number
                            try {
                                degrees = Double.parseDouble(temp);
                            } catch (Exception e) {
                                valid = false;
                            }
                        } else if (i == 1) { // i = token/word number
                            try {
                                minutes = Double.parseDouble(temp);
                            } catch (Exception e) {
                                valid = false;
                            }
                        } else if (i == 2) { // i = token/word number
                            try {
                                seconds = Double.parseDouble(temp);
                                result = degrees + (minutes / 60) + (seconds / 3600);
                                latitude = String.valueOf(result);
                                degrees = 0;
                                minutes = 0;
                                seconds = 0;
                                result = 0;
                            } catch (Exception e) {
                                valid = false;
                            }
                        } else if (i == 3) { // i = token/word number
                            if (temp.equals("N") || temp.equals("S") || temp.equals("E") || temp.equals("W")) {
                                if (temp.equals("S") || temp.equals("W")) {
                                    if (latitude.charAt(0) == '-') {

                                    } else {
                                        latitude = ("-" + latitude);
                                    }
                                } else {
                                    if (latitude.charAt(0) == '-') {
                                        latitude = latitude.substring(1);
                                    }
                                }
                            } else {
                                try {
                                    degrees = Double.parseDouble(temp);
                                } catch (Exception e) {
                                    valid = false;
                                }
                            }
                        } else if (i == 4) { // i = token/word number
                            if (degrees == 0) {
                                try {
                                    degrees = Double.parseDouble(temp);
                                } catch (Exception e) {
                                    valid = false;
                                }
                            } else {
                                try {
                                    minutes = Double.parseDouble(temp);
                                } catch (Exception e) {
                                    valid = false;
                                }
                            }
                        } else if (i == 5) { // i = token/word number
                            if (minutes == 0) {
                                try {
                                    minutes = Double.parseDouble(temp);
                                } catch (Exception e) {
                                    valid = false;
                                }
                            } else {
                                try {
                                    seconds = Double.parseDouble(temp);
                                    result = degrees + (minutes / 60) + (seconds / 3600);
                                    longitude = String.valueOf(result);
                                    degrees = 0;
                                    minutes = 0;
                                    seconds = 0;
                                    result = 0;
                                } catch (Exception e) {
                                    valid = false;
                                }
                            }
                        } else if (i == 6) { // i = token/word number
                            if (temp.equals("N") || temp.equals("S") || temp.equals("E") || temp.equals("W")) {
                                if (temp.equals("S") || temp.equals("W")) {
                                    if (longitude.charAt(0) == '-') {

                                    } else {
                                        longitude = ("-" + longitude);
                                    }
                                } else {
                                    if (longitude.charAt(0) == '-') {
                                        longitude = longitude.substring(1);
                                    }
                                }
                            } else if (Objects.equals(longitude, "")) {
                                try {
                                    seconds = Double.parseDouble(temp);
                                    result = degrees + (minutes / 60) + (seconds / 3600);
                                    longitude = String.valueOf(result);
                                    degrees = 0;
                                    minutes = 0;
                                    seconds = 0;
                                    result = 0;
                                } catch (Exception e) {
                                    valid = false;
                                }
                            } else {
                                try {
                                    Double.parseDouble(temp);
                                    valid = false;
                                } catch (Exception e) {
                                    label = temp;
                                }
                            }
                        } else if (i == 7) { // i = token/word number
                            if (temp.equals("N") || temp.equals("S") || temp.equals("E") || temp.equals("W")) {
                                if (temp.equals("S") || temp.equals("W")) {
                                    if (longitude.charAt(0) == '-') {

                                    } else {
                                        longitude = ("-" + longitude);
                                    }
                                } else {
                                    if (longitude.charAt(0) == '-') {
                                        longitude = longitude.substring(1);
                                    }
                                }
                            } else {
                                try {
                                    Double.parseDouble(temp);
                                    valid = false;
                                } catch (Exception e) {
                                    label = temp;
                                }
                            }
                        } else if (i == 8) { // i = token/word number
                            try {
                                Double.parseDouble(temp);
                                valid = false;
                            } catch (Exception e) {
                                label = temp;
                            }
                        }
                    }
                }
            }else{
                System.out.println("Invalid input: --> " + line + " <-- Wrong amount of numbers. Input must be either Standard Form, DMS form, or DDM form.");
                continue;
            }

            //if latitude and longitude cannot be converted to double's then input is invalid
            try{
                Double.parseDouble(latitude);
                Double.parseDouble(longitude);
            }catch (Exception e){
                valid = false;
            }

            if (!valid){
                System.out.println("Invalid input: --> " + line + " <-- Did not match any of the formats that can be converted to GeoJSON. (Standard form, DMS form, DDM form)");
                continue;
            }

            //Switches format around for GeoJSON
            String temp = latitude;
            latitude = longitude;
            longitude = temp;

            if (written == 0) { //adds location to output arraylist without a comma preceding
                output.add("{\n" +
                        "      \"type\": \"Feature\",\n" +
                        "      \"geometry\": {\n" +
                        "          \"type\": \"Point\",\n" +
                        "          \"coordinates\": [" + latitude + ", " + longitude + "]\n" +
                        "      },\n" +
                        "      \"properties\": {\n" +
                        "          \"name\": \"" + label + "\"\n" +
                        "      }\n" +
                        "   }");
                written++;
            } else { //writes location to output arraylist with a comma preceding
                output.add(",\n{\n" +
                        "      \"type\": \"Feature\",\n" +
                        "      \"geometry\": {\n" +
                        "          \"type\": \"Point\",\n" +
                        "          \"coordinates\": [" + latitude + ", " + longitude + "]\n" +
                        "      },\n" +
                        "      \"properties\": {\n" +
                        "          \"name\": \"" + label + "\"\n" +
                        "      }\n" +
                        "   }");
            }
        }

        try { //makes the output file if it does not exist already
            File outputFile = new File("output.txt");
            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFile.getName());
            } else {
                //System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred creating the file.");
            e.printStackTrace();

        }

        //writes everything to the output file including the header/footer
        try (FileWriter fileStream = new FileWriter("output.txt");
             BufferedWriter writer = new BufferedWriter(fileStream)) {

            writer.write("{\n" +
                    "  \"type\": \"FeatureCollection\",\n" +
                    "  \"features\": [\n");

            for (String out : output) {
                writer.write(out);
            }

            writer.write("]\n" +
                    "}");
            System.out.println("\n\nSuccessfully wrote to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void longDMS(){
        for (int i = 0; i < tokens.size(); i++) { //for each token/word in the line
            String temp = tokens.get(i);
            char c = temp.charAt(temp.length() - 1);
            if (c == ',' || c == '°' || c == '\'' || c == '"' || c == 'd' || c == 'm' || c == 's') {
                temp = temp.substring(0, temp.length() - 1);
            }

            if (i == 0) { // i = token/word number
                try {
                    degrees = Double.parseDouble(temp);
                } catch (Exception e) {
                    valid = false;
                }
            } else if (i == 2) { // i = token/word number
                try {
                    minutes = Double.parseDouble(temp);
                } catch (Exception e) {
                    valid = false;
                }
            } else if (i == 4) { // i = token/word number
                try {
                    seconds = Double.parseDouble(temp);
                    result = degrees + (minutes / 60) + (seconds / 3600);
                    latitude = String.valueOf(result);
                    degrees = 0;
                    minutes = 0;
                    seconds = 0;
                    result = 0;
                } catch (Exception e) {
                    valid = false;
                }
            } else if (i == 5) { // i = token/word number
                if (temp.equals("N") || temp.equals("S") || temp.equals("E") || temp.equals("W")) {
                    if (temp.equals("S") || temp.equals("W")) {
                        if (latitude.charAt(0) == '-') {

                        } else {
                            latitude = ("-" + latitude);
                        }
                    } else {
                        if (latitude.charAt(0) == '-') {
                            latitude = latitude.substring(1);
                        }
                    }
                }
            } else if (i == 6) { // i = token/word number
                if (degrees == 0) {
                    try {
                        degrees = Double.parseDouble(temp);
                    } catch (Exception e) {
                        valid = false;
                    }
                }
            } else if (i == 8) { // i = token/word number
                if (minutes == 0) {
                    try {
                        minutes = Double.parseDouble(temp);
                    } catch (Exception e) {
                        valid = false;
                    }
                }
            } else if (i == 10) { // i = token/word number
                    try {
                        seconds = Double.parseDouble(temp);
                        result = degrees + (minutes / 60) + (seconds / 3600);
                        longitude = String.valueOf(result);
                        degrees = 0;
                        minutes = 0;
                        seconds = 0;
                        result = 0;
                    } catch (Exception e) {
                        valid = false;
                    }
            } else if (i == 11) { // i = token/word number
                if (temp.equals("N") || temp.equals("S") || temp.equals("E") || temp.equals("W")) {
                    if (temp.equals("S") || temp.equals("W")) {
                        if (longitude.charAt(0) == '-') {

                        } else {
                            longitude = ("-" + longitude);
                        }
                    } else {
                        if (longitude.charAt(0) == '-') {
                            longitude = longitude.substring(1);
                        }
                    }
                }
            } else if (i == 12) { // i = token/word number
                try {
                    Double.parseDouble(temp);
                    valid = false;
                } catch (Exception e) {
                    label = temp;
                }
            }
        }
    }
}
