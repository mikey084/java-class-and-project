/**
 * This class parses data from the CSV saving it as a 2d array object
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
// instantiate country name year labels parsed table in the constructor

public class CSVReader
{

   private int numCountries;
   private String[] countryNames;
   private int[] yearLabels;
   private double[][] cellularData;

   /**
    * csv reader
    * @param fileName  name of File being parsed
    */
   public CSVReader(String fileName){ 
      File file = new File(fileName);
      try {
         Scanner scan = new Scanner(file);
         String line; // the line being read
         String[] split; // to split up our csv
         // since we know our file starts with an unwanted label, we can skip it
         scan.nextLine();

         // second line tells us how many countries (how long our array length)
         // needs to be
         line = scan.nextLine();
         split = line.split(",");
         numCountries = Integer.parseInt(split[1]);
         countryNames = new String[numCountries];

         // Third line to figure out how many columns we need to make
         line = scan.nextLine();
         split = line.split(","); 
         yearLabels = new int[split.length - 1]; // -1 to ignore label
         for (int i = 1; i < split.length; i++) {
            yearLabels[i - 1] = Integer.parseInt(split[i]);
         }

         // initialize our table
         cellularData = new double[numCountries][yearLabels.length];

         // organize data
         int countryIndex = 0;
         while (scan.hasNext()) {
            // This starts with first country
            line = scan.nextLine();
            split = line.split(",");
            countryNames[countryIndex] = split[0];
            for (int i = 1; i < split.length; i++) {
               // countryIndex indexes the ROW of our table
               // i indexes the COLUMN of our table
               // populate our cellular data table
               cellularData[countryIndex][i - 1] = Double.parseDouble(split[i]);
            }
            countryIndex ++;
         }
      }
      catch (IOException e) {
         System.out.println("IOExcepton with file");
      }

   }
   /**
    * getter method for number of years
    * @return nubmer of years (array length)
    */
   public int getNumberOfYears(){
      return yearLabels.length;
   }
   /**
    * getter method for parsed Table
    * @return parsedTable
    */
   public double[][] getParsedTable()
   {

      return cellularData;
   }
   /**
    * getter method for year lavels
    * @return yearLabels  
    */
   public int[] getYearLabels()
   {
      return yearLabels;

   }
   /**
    * getter method for string of countrynames
    * @return countryNames
    */
   public String[] getCountryNames()
   {
      return countryNames;
   }
}

//String[] tokens has country names
// while loop while(input.hasnextline String line;
// file not found exception put under try and catch
// string Line = input.nextline
// if(thelinecontains "." AND the line does not contain Number of countries AND not contain Country Name
// String[] tokens = line.split(","
// read index 
// countryName[] = tokens[0]    //counter
// rows and columns if(line contains"number of countries" then rows would be tokens [1]
// Numrows = tokens[1]
//goal go into second line and use 252
// NumCol set to length of tokens - 1, if it contains country name
//countryName = new[rows]
//cellularDataTable = new [numRows][numColumns]
//yearLabels = new[]
// two while loops while1(calculating numrows and numCol)
// instantiate arrays
//2nd while loop(CountryName, Yearlabels, Partial Data)
