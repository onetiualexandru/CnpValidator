package cnp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CnpUtils {

    public static boolean isValid(String cnp) {

        String cnpInit;

        if (cnp == null)
            return false;
        else {
            cnpInit = cnp.strip();
        }

        return cnpInit.length() == 13 && structureValidation(cnpInit) && controlValidation(cnpInit);
    }

    public static boolean structureValidation(String cnp) {

        String cnpInit = cnp.strip();


        String sex = String.valueOf(cnpInit.charAt(0));

        String yymmdd = cnpInit.substring(1, 7);
        String county = cnpInit.substring(7, 9);

        return (between(sex, 1, 8) &&
                cnpDateValidation(yymmdd) &&
                between(county, 1, 48)
        );

    }

    public static boolean between(String number, int minValueInclusive, int maxValueInclusive) {
        try {
            int i = Integer.parseInt(number);
            return (i >= minValueInclusive && i <= maxValueInclusive);
        } catch (NumberFormatException n) {
            System.out.println(n.getMessage());
            return false;
        }

    }

    public static boolean cnpDateValidation(String cnpDate) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyMMdd");
        sdf.setLenient(false);
        try {
            sdf.parse(cnpDate);
            return true;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean controlValidation(String cnp) {

        String cnpInit = cnp.strip();
        if(cnpInit.length()!=13)
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

    public static Sex getSex() {
        return Sex.F;
    }

    public static CalDate getCalDate() {
        return new CalDate() {
            @Override
            public Short year() {
                return Short.parseShort("1");
            }

            @Override
            public Byte month() {
                return Byte.parseByte("1");
            }

            @Override
            public Byte day() {
                return Byte.parseByte("2");
            }
        };
    }


}
