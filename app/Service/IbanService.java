package Service;

public class IbanService {

    public IbanService(){
    }

    public String formatBankCode(String bankCode)
    {
        int maxCount = getMaxConsecutiveCharLength(bankCode);
        int numOfPairs = 0;
        StringBuilder bankCodeBuilder = new StringBuilder(bankCode);
        for (int i=0; i<bankCode.length()-1; i++){

            int currentCountOfChars = getConsecutiveCharLength(i,bankCode);

            if (currentCountOfChars == maxCount)
            {
                int endIndex = i +maxCount;

                addParentheses(i, endIndex, bankCodeBuilder, numOfPairs);
                numOfPairs++;
            }
        }
        bankCode = bankCodeBuilder.toString();
        return bankCode;
    }
    public String concatenateIbanCode(String countryCode,String bankCode)
    {
        return countryCode + " " + bankCode;
    }
    private int getMaxConsecutiveCharLength(String bankCode)
    {
        int count = 0;
        for (int i=0; i<bankCode.length()-1; i++){
            int currentCountOfChars = getConsecutiveCharLength(i,bankCode);
            if (currentCountOfChars > count && currentCountOfChars>1)
                count = currentCountOfChars;
        }
        return count;
    }
    private int getConsecutiveCharLength(int i,String bankCode){

        int currentCountOfChars = 1;
        for (int j=i+1; j<bankCode.length(); j++){
            if (bankCode.charAt(i) != bankCode.charAt(j))
                break;
            currentCountOfChars++;
        }
        return currentCountOfChars;

    }
    private StringBuilder addParentheses(int firstIndex, int secondIndex, StringBuilder bankCode, int numberOfPairs)
    {
        bankCode.insert(firstIndex + numberOfPairs*2 ,'(');
        bankCode.insert(secondIndex + numberOfPairs*2 + 1,')');
        return bankCode;
    }
}
