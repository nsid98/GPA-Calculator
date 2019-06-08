public class UBCGPACalculator {

    public static void main(String[] args) {
        double sum = 0;
        int totalCredits = 0;

        for(int i = 0; i < args.length; i=i+2){
            int percentage = Integer.parseInt(args[i]);
            int weight = Integer.parseInt(args[i+1]);
            sum += convertPercentageToWeightedGPA(percentage, weight);
            totalCredits += weight;
        }
        //convert to 2 decimal places
        double result = sum/totalCredits;
        result = result *1000;

        //checks the third decimal value to see if we need to round the second value up
        int finalGPA = 0;
        if ((result %10) > 4){
            finalGPA = (int) ((result / 10) + 1);
        }
        else{
            finalGPA = (int) (result / 10);
        }


        System.out.println(finalGPA/100 + "."+finalGPA%100);
        
    }

    public static double convertPercentageToWeightedGPA(int percentage, int weight){
        //This is according to the UBC section under https://www.ouac.on.ca/guide/omsas-conversion-table/ 
    
        if (percentage > 89){
            return 4.0*weight;
        }
                        
        else if (percentage > 84){
            return 3.9*weight;
        }
        
        else if (percentage>79){
            return 3.7*weight;
        }
        
        else if (percentage>75){
            return 3.3*weight;
        }
            
        else if (percentage>71){
            return 3.0*weight;  
        }  
        
        else if (percentage>67){
            return 2.7*weight;
        }

        else if (percentage>63){
            return 2.3*weight;
        }

        else if (percentage>59){
            return 2.0*weight;
        }

        else if (percentage>54){
            return 1.7*weight;
        }

        else if (percentage>49){
            return 1.0*weight;
        }
        else{
            return 0.0;
        }
    }
}