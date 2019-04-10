package tool;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;

import java.util.List;


public class JLPTools {
    static double[] similarity = new double[5];
    static float Similarity = 0;//默认的相似度
//    static float path_1 = 0;//句子的关键字的w2v距离
//    static float path_2 = 0;//句子的整体结构
//    static float path_3 = 0;//句子的上下文意思
//    static float path_4 = 0;//句子的summary的相似度
    /**
     * 已经更改为数组表示，下标分别对应1，2，3，4
     * */

    public static double[] getSimilarityRate(String originText,String compareText){
        List<String> originSummaryList = HanLP.extractSummary(originText,50);
        List<String> compSummaryList = HanLP.extractSummary(compareText,50);//实验说明50的limit效果比较好
        similarity[4] = JLPTools.getStringSimilarity(originSummaryList.toString(),compSummaryList.toString())*100;//得到句子概要的相似度
        similarity[2] = JLPTools.getStructSimilarity(originText,compareText)*100;//句子结构的相似度
        similarity[1] = JLPTools.getKeyWordsSimilarity(originText,compareText)*100;
        similarity[3] = 100;
        similarity[0] = (similarity[1]+similarity[2]+similarity[3]+similarity[4])/4.0;
        return similarity;
    }

    /**
     *
     * ToDO 设计一个算法，分析两个CoNLLSentences的结构。
     * 算法的输入是两个CoNLLSentence，输出是一个float类型的数值，表示的是两个句子的相似度（找到句子的主干成分，然后判定句子主干的相似度）
     * */
    public static float getStructSimilarity(String origin,String  comp){
        float similarity = 0;
        CoNLLSentence originStructure = HanLP.parseDependency(origin);
        CoNLLSentence compStructure = HanLP.parseDependency(comp);
        CoNLLWord[] originCoNLLWords = originStructure.getWordArray();
        CoNLLWord[] compCoNLLwords = compStructure.getWordArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (CoNLLWord word:originCoNLLWords){
            if(word.DEPREL.equals("主谓关系")||word.DEPREL.equals("动宾关系")||word.DEPREL.equals("核心关系")){
                stringBuilder.append(word.LEMMA);
            }
        }
        String s1 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        for (CoNLLWord word:compCoNLLwords){
            if(word.DEPREL.equals("主谓关系")||word.DEPREL.equals("动宾关系")||word.DEPREL.equals("核心关系")){
                stringBuilder.append(word.LEMMA);
            }
        }
        String s2 = stringBuilder.toString();
        similarity = getStringSimilarity(s1,s2);
        return similarity;

    }

    static private int compare(String str, String target)
    {
        int d[][];              // 矩阵
        int n = str.length();
        int m = target.length();
        int i;                  // 遍历str的
        int j;                  // 遍历target的
        char ch1;               // str的
        char ch2;               // target的
        int temp;               // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
        if (n == 0) { return m; }
        if (m == 0) { return n; }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++)
        {                       // 初始化第一列
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++)
        {                       // 初始化第一行
            d[0][j] = j;
        }

        for (i = 1; i <= n; i++)
        {                       // 遍历str
            ch1 = str.charAt(i - 1);
            // 去匹配target
            for (j = 1; j <= m; j++)
            {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2 || ch1 == ch2+32 || ch1+32 == ch2)
                {
                    temp = 0;
                } else
                {
                    temp = 1;
                }
                // 左边+1,上边+1, 左上角+temp取最小
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
            }
        }
        return d[n][m];
    }

    static private int min(int one, int two, int three)
    {
        return (one = one < two ? one : two) < three ? one : three;
    }

    /**
     * 获取两字符串的相似度
     */

    static public float getStringSimilarity(String str, String target)
    {
        return 1 - (float) compare(str, target) / Math.max(str.length(), target.length());
    }


    public static double getKeyWordsSimilarity(String str,String target){
        /**
         * 判定关键词的相似度，需要在原文中才可以判断。
         * 使用word2vec算法
         * */
        double similarity = 0;
        List<String> strKeyWords = HanLP.extractKeyword(str,3);
        List<String> targetKeyWords = HanLP.extractKeyword(target,3);
//        similarity = CoreSynonymDictionary.similarity(strKeyWords.toString(),targetKeyWords.toString());
        String s = strKeyWords.toString();
        String t = targetKeyWords.toString();

        return similarity;
    }

    public static void showInformation(CoNLLWord[] originCoNLLWords){

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<originCoNLLWords.length;i++){
            if(originCoNLLWords[i].NAME.equals("#核心#")){
                stringBuilder.append(originCoNLLWords[i].LEMMA);
            }
            if(originCoNLLWords[i].DEPREL.equals("动宾关系")||originCoNLLWords[i].DEPREL.equals("主谓关系")){
                if(originCoNLLWords[i].DEPREL.equals("动宾关系")){
                    stringBuilder.append(originCoNLLWords[i].HEAD.LEMMA);
                }
                stringBuilder.append(originCoNLLWords[i].LEMMA);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
