package cnp;

public class CnpValidatorImpl implements CnpValidator {


    @Override
    public CnpParts validateCnp(String cnp) throws CnpException {


        if (CnpValidationUtils.isValid(cnp)) {

            String cnpInit = cnp.strip();

            Sex sex = CnpUtils.getCnpSex(cnpInit);
            Boolean foreigner = CnpUtils.getForeigner(cnpInit);
            CalDate calDate = CnpUtils.getBirthdate(cnpInit);
            County county = CnpUtils.getCounty(cnpInit);


            CnpParts cnpParts = new CnpParts() {
                @Override
                public Sex sex() {
                    return sex;
                }

                @Override
                public Boolean foreigner() {
                    return foreigner;
                }

                @Override
                public CalDate birthDate() {
                    return calDate;
                }

                @Override
                public County county() {
                    return county;
                }

                @Override
                public Integer orderNumber() {
                    return null;
                }

            };

            return cnpParts;
        } else throw new CnpException("Cnp is invalid!");
    }

}



