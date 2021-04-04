package cnp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CnpValidationUtils {

    public static boolean isValid(String cnp) throws CnpException {

        String cnpInit;

        if (cnp == null)
            return false;
        else {
            cnpInit = cnp.strip();
        }

        return cnpInit.length() == 13 && structureValidation(cnpInit) && controlValidation(cnpInit);
    }

    public static boolean structureValidation(String cnp) throws CnpException {

        String cnpInit = cnp.strip();

        String sex = String.valueOf(cnpInit.charAt(0));

        String yymmdd = cnpInit.substring(1, 7);
        String county = cnpInit.substring(7, 9);

        return (cnpSexValidation(sex) &&
                cnpDateValidation(yymmdd) &&
                cnpCountyValidation(county)
        );

    }

    public static boolean cnpSexValidation(String number) {
        int i = Integer.parseInt(number);
        return (i >= 1 && i <= 8);
    }

    public static boolean cnpCountyValidation(String number) {
        int i = Integer.parseInt(number);
        return i >= 1 && i <= 46 || i == 51 || i == 52;

    }

    public static boolean cnpDateValidation(String cnpDate) throws CnpException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyMMdd");
        sdf.setLenient(false);
        try {
            sdf.parse(cnpDate);
            return true;
        } catch (ParseException e) {
          throw new CnpException("Invalid Date "+e.getMessage());
        }
    }

    public static boolean controlValidation(String cnp) {

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
