import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TextParser {
    public static StringBuffer findWordsOfGivenLengthInQuestionSentences(String text, int length)
    {
        StringBuffer textBuffer = new StringBuffer(text);

        findQuestionSentences(textBuffer);

        findWordsOfGivenLength(textBuffer, length);

        findUniqueWords(textBuffer);

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

    private static void findUniqueWords(StringBuffer words)
    {
        ArrayList<StringBuffer> distinctWords = new ArrayList<>();

        int start = 0;
        for(int i = 0; i < words.length(); i++)
        {
            if(words.charAt(i) == ' ')
            {
                StringBuffer word = new StringBuffer(words.subSequence(start, i));
                if(!containsInArray(distinctWords, word))
                {
                    distinctWords.add(word);
                }

                start = i + 1;
            }
        }

        words.replace(0, words.length(), "");

        for (StringBuffer w: distinctWords) {
            words.append(w);
            words.append(" ");
        }
    }

    private static boolean containsInArray(ArrayList<StringBuffer> array, StringBuffer word)
    {
        for (StringBuffer w : array) {
            if(isWordsEqual(w, word))
                return true;
        }

        return false;
    }

    private static boolean isWordsEqual(StringBuffer word1, StringBuffer word2)
    {
        if(word1.length() != word2.length())
        {
            return false;
        }

        for(int i = 0; i < word1.length(); i++)
        {
            if(word1.charAt(i) != word2.charAt(i))
            {
                return false;
            }
        }

        return true;
    }
}
