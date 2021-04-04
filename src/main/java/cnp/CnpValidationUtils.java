package cnp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CnpValidationUtils {

    protected static boolean isValid(String cnp) {

        String cnpInit;

        if (cnp == null)
            return false;
        else {
            cnpInit = cnp.strip();
        }

        return cnpInit.length() == 13 && structureValidation(cnpInit) && controlValidation(cnpInit);
    }

    protected static boolean structureValidation(String cnp) {

        String cnpInit = cnp.strip();

        String sex = String.valueOf(cnpInit.charAt(0));

        String yymmdd = cnpInit.substring(1, 7);
        String county = cnpInit.substring(7, 9);

        return (cnpSexValidation(sex) &&
                cnpDateValidation(yymmdd) &&
                cnpCountyValidation(county)
        );

    }

    protected static boolean cnpSexValidation(String number) {
        int i = Integer.parseInt(number);
        return (i >= 1 && i <= 8);
    }

    protected static boolean cnpCountyValidation(String number) {
        int i = Integer.parseInt(number);
        return i >= 1 && i <= 46 || i == 51 || i == 52;

    }

    protected static boolean cnpDateValidation(String cnpDate) {

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyMMdd");
        sdf.setLenient(false);
        try {
            sdf.parse(cnpDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    protected static boolean controlValidation(String cnp) {

        String cnpInit = cnp.strip();
        if (cnpInit.length() != 13)
            return false;

        String controlConstant = "279146358279";
        int controlSum = 0;
        int controlNumber;

        for (int i = 0; i < controlConstant.length(); i++) {
            controlSum += Character.getNumericValue(controlConstant.charAt(i)) *
                    Character.getNumericValue(cnpInit.charAt(i));
        }
        if (controlSum % 11 == 10)
            controlNumber = 1;
        else
            controlNumber = controlSum % 11;


        return controlNumber + '0' == cnpInit.charAt(controlConstant.length());
    }


}
