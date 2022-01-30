package Entities;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.StringJoiner;

public class person {

    private String name;
    private Double weight;
    private Double height;
    private Double BMI;
    private String diagnosisDate;
    private String result;
    private String gender;

    public person() {

    }

    public person(String name, Double weight, Double height, String diagnosisDate, String gender) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.diagnosisDate = diagnosisDate;
        this.gender = gender;
    }

    public person(String name, Double weight, Double height, String diagnosisDate) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.diagnosisDate = diagnosisDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getBMI() {
        return BMI;
    }

    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void calculateBMI() {
        this.BMI = (this.weight / (Math.pow(this.height, 2)));
    }

    public String diagnosisDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    // BMI calculation - MALE
    public String BMIMale() {

        Locale.setDefault(Locale.US);

        BMI = (weight / (Math.pow(height, 2)));

        double weightDifference;
        double getFatWeightQuantity;
        double loseWeightQuantity;

        StringJoiner sj = new StringJoiner("\n");

        DecimalFormat df_TwoDecimalPlaces = new DecimalFormat("#,##0.00");
        DecimalFormat df_ThreeDecimalPlaces = new DecimalFormat("#,##0.000");

        // Underweight
        if (BMI < 20.70) {

            result = "UnderWeight";
            getFatWeightQuantity = (Math.pow(height, 2) * 20.70) - weight;

            sj.add("BMI Calculator");
            sj.add("");
            sj.add("Date of diagnosis: " + diagnosisDate());
            sj.add("");
            sj.add("Name: " + name);
            sj.add("Gender: " + gender);
            sj.add("Weight: " + df_ThreeDecimalPlaces.format(weight) + " kg");
            sj.add("Height: " + (height * 100) + " cm");
            sj.add("BMI: " + df_TwoDecimalPlaces.format(BMI));
            sj.add("You need to fatten " + df_ThreeDecimalPlaces.format(getFatWeightQuantity)
                    + " kgs to have a weight appropriate to your height!");
            sj.add("");
            sj.add("RESULT: " + result);

        }

        // Ideal Weight
        if (BMI >= 20.70 && BMI <= 26.49) {

            result = "Ideal Weight";

            getFatWeightQuantity = (Math.pow(height, 2) * 26.49) - weight;
            loseWeightQuantity = weight - (Math.pow(height, 2) * 20.70);

            sj.add("BMI Calculator");
            sj.add("");
            sj.add("Date of diagnosis: " + diagnosisDate());
            sj.add("");
            sj.add("Name: " + name);
            sj.add("Gender: " + gender);
            sj.add("Weight: " + df_ThreeDecimalPlaces.format(weight) + " kgs");
            sj.add("Height: " + (height * 100) + " cm");
            sj.add("BMI: " + df_TwoDecimalPlaces.format(BMI));
            sj.add("Your weight is ideal for your height!");
            sj.add("You can still gain " + df_ThreeDecimalPlaces.format(getFatWeightQuantity)
                    + " kgs or lose " + df_ThreeDecimalPlaces.format(loseWeightQuantity)
                    + " kgs without leaving normality!");
            sj.add("");
            sj.add("RESULT: " + result);

        }

        // Little Overweight
        if (BMI >= 26.50 && BMI <= 27.89) {

            result = " Little Overweight";
            loseWeightQuantity = weight - (Math.pow(height, 2) * 26.49);

            sj.add("BMI Calculator");
            sj.add("");
            sj.add("Date of diagnosis: " + diagnosisDate());
            sj.add("");
            sj.add("Name: " + name);
            sj.add("Gender: " + gender);
            sj.add("Weight: " + df_ThreeDecimalPlaces.format(weight) + " kgs");
            sj.add("Height: " + (height * 100) + " cm");
            sj.add("BMI: " + df_TwoDecimalPlaces.format(BMI));
            sj.add("You need to lose " + df_ThreeDecimalPlaces.format(loseWeightQuantity)
                    + " kgs to stay within normal range!");
            sj.add("");
            sj.add("RESULT: " + result);

        }

        // Overweight
        if (BMI >= 27.90 && BMI <= 31.19) {

            result = "Overweight";
            loseWeightQuantity = weight - (Math.pow(height, 2) * 26.49);

            sj.add("BMI Calculator");
            sj.add("");
            sj.add("Date of diagnosis: " + diagnosisDate());
            sj.add("");
            sj.add("Name: " + name);
            sj.add("Gender: " + gender);
            sj.add("Weight: " + df_ThreeDecimalPlaces.format(weight) + " kgs");
            sj.add("Height: " + (height * 100) + " cm");
            sj.add("BMI: " + df_TwoDecimalPlaces.format(BMI));
            sj.add("You need to lose " + df_ThreeDecimalPlaces.format(loseWeightQuantity)
                    + " kgs to stay within normal range!");
            sj.add("");
            sj.add("RESULT: " + result);

        }

        // Obesity
        if (BMI >= 31.20) {

            result = "Obesity";
            weightDifference = weight - (Math.pow(height, 2) * 26.49);

            sj.add("BMI Calculator");
            sj.add("");
            sj.add("Date of diagnosis: " + diagnosisDate());
            sj.add("");
            sj.add("Name: " + name);
            sj.add("Gender: " + gender);
            sj.add("Weight: " + df_ThreeDecimalPlaces.format(weight) + " kgs");
            sj.add("Height: " + (height * 100) + " cm");
            sj.add("BMI: " + df_TwoDecimalPlaces.format(BMI));
            sj.add("You need to lose " + df_ThreeDecimalPlaces.format(weightDifference)
                    + " kgs to stay within normal range!");
            sj.add("");
            sj.add("RESULT: " + result);

        }

        return sj.toString();

    }

    // BMI calculation - FEMALE
    public String BMIFemale() {

        Locale.setDefault(Locale.US);

        BMI = (weight / (Math.pow(height, 2)));

        double weightDifference;
        double getFatWeightQuantity;
        double loseWeightQuantity;

        StringJoiner sj = new StringJoiner("\n");

        DecimalFormat df_TwoDecimalPlaces = new DecimalFormat("#,##0.00");
        DecimalFormat df_ThreeDecimalPlaces = new DecimalFormat("#,##0.000");

        // Underweight
        if (BMI < 19.10) {

            result = "Underweight";
            weightDifference = (Math.pow(height, 2) * 19.10) - weight;

            sj.add("BMI Calculator");
            sj.add("");
            sj.add("Date of diagnosis: " + diagnosisDate());
            sj.add("");
            sj.add("Name: " + name);
            sj.add("Gender: " + gender);
            sj.add("Weight: " + df_ThreeDecimalPlaces.format(weight) + " kgs");
            sj.add("Height: " + (height * 100) + " cm");
            sj.add("BMI: " + df_TwoDecimalPlaces.format(BMI));
            sj.add("You need to fatten " + df_ThreeDecimalPlaces.format(weightDifference)
                    + " kgs to stay within normal range!");
            sj.add("");
            sj.add("RESULT: " + result);

        }

        // Ideal Weight
        if (BMI >= 19.10 && BMI <= 25.89) {

            result = "Ideal Weight";

            getFatWeightQuantity = (Math.pow(height, 2) * 25.89) - weight;
            loseWeightQuantity = weight - (Math.pow(height, 2) * 19.10);

            sj.add("BMI Calculator");
            sj.add("");
            sj.add("Date of diagnosis: " + diagnosisDate());
            sj.add("");
            sj.add("Name: " + name);
            sj.add("Gender: " + gender);
            sj.add("Weight: " + df_ThreeDecimalPlaces.format(weight) + " kgs");
            sj.add("Height: " + (height * 100) + " cm");
            sj.add("BMI: " + df_TwoDecimalPlaces.format(BMI));
            sj.add("Your weight is ideal for your height!");
            sj.add("You can still gain " + df_ThreeDecimalPlaces.format(getFatWeightQuantity)
                    + " kgs or lose " + df_ThreeDecimalPlaces.format(loseWeightQuantity)
                    + " kgs without leaving normality!");
            sj.add("");
            sj.add("RESULT: " + result);

        }

        // Little Overweight
        if (BMI >= 25.90 && BMI <= 27.39) {

            result = "Overweight";
            weightDifference = weight - (Math.pow(height, 2) * 25.89);

            sj.add("BMI Calculator");
            sj.add("");
            sj.add("Date of diagnosis: " + diagnosisDate());
            sj.add("");
            sj.add("Name: " + name);
            sj.add("Gender: " + gender);
            sj.add("Weight: " + df_ThreeDecimalPlaces.format(weight) + " kgs");
            sj.add("Height: " + (height * 100) + " cm");
            sj.add("BMI: " + df_TwoDecimalPlaces.format(BMI));
            sj.add("You need to lose " + df_ThreeDecimalPlaces.format(weightDifference)
                    + " kgs to stay within normal range!");
            sj.add("");
            sj.add("RESULT: " + result);

        }

        // Overweight
        if (BMI >= 27.40 && BMI <= 32.39) {

            result = "Overweight";
            weightDifference = weight - (Math.pow(height, 2) * 25.89);

            sj.add("BMI Calculator");
            sj.add("");
            sj.add("Date of diagnosis: " + diagnosisDate());
            sj.add("");
            sj.add("Name: " + name);
            sj.add("Gender: " + gender);
            sj.add("Weight: " + df_ThreeDecimalPlaces.format(weight) + " kgs");
            sj.add("Height: " + (height * 100) + " cm");
            sj.add("BMI: " + df_TwoDecimalPlaces.format(BMI));
            sj.add("You need to lose " + df_ThreeDecimalPlaces.format(weightDifference)
                    + " kgs to stay within normal range!");
            sj.add("");
            sj.add("RESULT: " + result);

        }

        // Obesity
        if (BMI >= 32.40) {

            result = "Obesity";
            weightDifference = weight - (Math.pow(height, 2) * 25.89);

            sj.add("BMI Calculator");
            sj.add("");
            sj.add("Date of diagnosis: " + diagnosisDate());
            sj.add("");
            sj.add("Name: " + name);
            sj.add("Gender: " + gender);
            sj.add("Weight: " + df_ThreeDecimalPlaces.format(weight) + " kgs");
            sj.add("Height: " + (height * 100) + " cm");
            sj.add("BMI: " + df_TwoDecimalPlaces.format(BMI));
            sj.add("You need to lose " + df_ThreeDecimalPlaces.format(weightDifference)
                    + " kgs to stay within normal range!");
            sj.add("");
            sj.add("RESULT: " + result);

        }

        return sj.toString();
    }

}
