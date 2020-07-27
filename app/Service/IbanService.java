package Service;


public class IbanService {

    private String countryCode;
    private String bankCode;

    public IbanService(String countryCode, String bankCode)
    {
        this.countryCode = countryCode;
        this.bankCode = bankCode;
    }

    public String getBankCode()
    {
        return bankCode;
    }
    public void setBankCode(String bankCode)
    {
        this.bankCode = bankCode;
    }
    public String getCountryCode()
    {
        return countryCode;
    }
    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    private void formatBankCode()
    {
        int maxCount = getNumberOfConsecutiveChars();
        int increasedIndex=0;
        StringBuilder bankCodeBuilder = new StringBuilder(bankCode);
        for (int i=0; i<bankCode.length()-1; i++){
            int currentCountOfChars = 1;
            for (int j=i+1; j<bankCode.length(); j++){
                if (bankCode.charAt(i) != bankCode.charAt(j))
                    break;
                currentCountOfChars++;;
            }

            if (currentCountOfChars == maxCount)
            {
                System.out.println("countas: " + maxCount);
                int startIndex = i;
                int endIndex = startIndex+maxCount;
                bankCodeBuilder.insert(startIndex+increasedIndex,'(');
                //index increases because '(' is added to the string
                increasedIndex++;
                bankCodeBuilder.insert(endIndex+increasedIndex,')');
                //index increases because ')' is added to the string
                increasedIndex++;
            }
        }
        bankCode = bankCodeBuilder.toString();
    }

    public String getConcatIban()
    {
        formatBankCode();
        return countryCode + " " + bankCode;
    }
    private int getNumberOfConsecutiveChars()
    {
        int count = 0;
        for (int i=0; i<bankCode.length()-1; i++){
            int currentCountOfChars = 1;
            for (int j=i+1; j<bankCode.length(); j++){
                if (bankCode.charAt(i) != bankCode.charAt(j))
                    break;
                currentCountOfChars++;;
            }
            if (currentCountOfChars >= count && currentCountOfChars>1)
                count = currentCountOfChars;
        }
        return count;
    }
}
