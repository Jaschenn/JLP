import Hibernate.DataEntity;
import Hibernate.HiberDao;
import com.hankcs.hanlp.HanLP;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import tool.JLPTools;
import tool.Tool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args){

       fillDate();
    }

    public static void fillDate(){
        ArrayList<DataEntity> datas;
        Session session = Tool.getSessionfactory().openSession();
        Query query = session.createQuery("from DataEntity");
        List resultList = query.list();
        Iterator iterator = resultList.iterator();
        while (iterator.hasNext()){
            Transaction transaction = session.beginTransaction();
            DataEntity dataEntity = (DataEntity) iterator.next();

            String summary = HanLP.extractSummary(dataEntity.getContent(),50).get(0);
            String keywords = HanLP.extractWords(dataEntity.getContent(),2).toString().replaceAll("[|]","");
            double[] rate = JLPTools.getSimilarityRate(dataEntity.getContent(),dataEntity.getBaidu_comp());
            dataEntity.setKeyword(keywords);
            StringBuilder stringBuilder = new StringBuilder();
            for (double i:rate
            ) {
                stringBuilder.append(i+",");
            }
            dataEntity.setSimilar(stringBuilder.toString());
            dataEntity.setSummarg(summary);
            transaction.commit();
        }
    }

    public static void updateBaiduCompAll(){
        HiberDao hiberDao = new HiberDao();
        hiberDao.updateAll();
    }
    public static void fillDataForTest(){
        //把爬取没有爬到的数据项补充完整。为了演示需要，这里用原文进行替代。
        Session session = Tool.getSessionfactory().openSession();
        Query query = session.createQuery("from DataEntity");
        List<DataEntity> list = query.list();
        Transaction transaction = session.beginTransaction();
        for (DataEntity d:list
             ) {
            if(d.getBaidu_comp().equals("null")){
                String s = d.getContent();
                d.setBaidu_comp(s);
            }
        }
        transaction.commit();
    }
    public static void testJPLTool(){
        double rate = JLPTools.getKeyWordsSimilarity("小明爱吃牛肉面","小明爱吃牛肉面");
        System.out.println(rate);
    }
}
