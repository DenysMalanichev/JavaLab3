public class TextParser {
    public static StringBuffer findWordsOfGivenLengthInQuestionSentences(String text, int length)
    {
        StringBuffer textBuffer = new StringBuffer(text);

        findQuestionSentences(textBuffer);

        findWordsOfGivenLength(textBuffer, length);

        return textBuffer;
    }

    private static void findQuestionSentences(StringBuffer text)
    {
        int start = 0;
        for(int i = 0; i < text.length(); i++)
        {
            if(text.charAt(i) == '.' || text.charAt(i) == '!')
            {
                text.replace(start, i + 1, " ");
                i = start;
            }
            else if(!Character.isAlphabetic(text.charAt(i)) && text.charAt(i) != ' ')
            {
                text.replace(i, i + 1, " ");
                start = i;
            }
        }
    }

    private static void findWordsOfGivenLength(StringBuffer text, int length)
    {
        int start = 0;
        for(int i = 0; i < text.length(); i++)
        {
            if(i == text.length() - 1 && i - start == length - 1)
            {
                continue;
            }
            else if(text.charAt(i) == ' ' || i == text.length() - 1)
            {
                if(i - start != length){
                    text.replace(start, i + 1, "");
                    i = start - 1;
                }
                else{
                    start = i + 1;
                }
            }
        }
    }
}
