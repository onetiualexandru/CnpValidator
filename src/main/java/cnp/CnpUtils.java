package cnp;

public class CnpUtils {

    protected static Sex getCnpSex(String cnp) {

        char cnpSex = cnp.charAt(0);
        if (cnpSex == '1' || cnpSex == '3' || cnpSex == '5' || cnpSex == '7')
            return Sex.M;
        else if (cnpSex == '2' || cnpSex == '4' || cnpSex == '6' || cnpSex == '8')
            return Sex.F;
        else return Sex.U;
    }

    protected static boolean getForeigner(String cnp) {
        char cnpSex = cnp.charAt(0);
        if (cnpSex == '7' || cnpSex == '8')
            return true;
        else return false;

    }

    protected static CalDate getBirthdate(String cnp) {

        Byte day = Byte.valueOf(cnp.substring(5, 7));
        Byte month = Byte.valueOf(cnp.substring(3, 5));
        Short year;

        int cnpYear = Integer.parseInt(cnp.substring(1, 3));
        char century = cnp.charAt(0);

        if (century == '1' || century == '2')
            year = (short) (1900 + cnpYear);
        else if (century == '3' || century == '4')
            year = (short) (1800 + cnpYear);
        else if (century == '5' || century == '6')
            year = (short) (2000 + cnpYear);
        else
            year = null;


        CalDate calDate = new CalDate() {
            @Override
            public Short year() {
                return year;
            }

            @Override
            public Byte month() {
                return month;
            }

            @Override
            public Byte day() {
                return day;
            }
        };

        return calDate;

    }

    protected static County getCounty(String cnp) throws CnpException {

        String county = cnp.substring(7, 9);
        try {
            switch (county) {
                case "01":
                    return County.AB;
                case "02":
                    return County.AR;
                case "03":
                    return County.AG;
                case "04":
                    return County.BC;
                case "05":
                    return County.BH;
                case "06":
                    return County.BN;
                case "07":
                    return County.BT;
                case "08":
                    return County.BR;
                case "09":
                    return County.BV;
                case "10":
                    return County.BZ;
                case "11":
                    return County.CS;
                case "12":
                    return County.CJ;
                case "13":
                    return County.CT;
                case "14":
                    return County.CV;
                case "15":
                    return County.DB;
                case "16":
                    return County.DJ;
                case "17":
                    return County.GL;
                case "18":
                    return County.GJ;
                case "19":
                    return County.HR;
                case "20":
                    return County.HD;
                case "21":
                    return County.IL;
                case "22":
                    return County.IS;
                case "23":
                    return County.IF;
                case "24":
                    return County.MM;
                case "25":
                    return County.MH;
                case "26":
                    return County.MS;
                case "27":
                    return County.NT;
                case "28":
                    return County.OT;
                case "29":
                    return County.PH;
                case "30":
                    return County.SM;
                case "31":
                    return County.SJ;
                case "32":
                    return County.SB;
                case "33":
                    return County.SV;
                case "34":
                    return County.TR;
                case "35":
                    return County.TM;
                case "36":
                    return County.TL;
                case "37":
                    return County.VS;
                case "38":
                    return County.VL;
                case "39":
                    return County.VN;
                case "40":
                    return County.BU;
                case "41":
                    return County.B1;
                case "42":
                    return County.B2;
                case "43":
                    return County.B3;
                case "44":
                    return County.B4;
                case "45":
                    return County.B5;
                case "46":
                    return County.B6;
                case "51":
                    return County.CL;
                case "52":
                    return County.GR;
            }
        } catch (IllegalArgumentException e) {
            throw new CnpException("County with number " + county + " not found!");
        }

        return null;
    }
}
