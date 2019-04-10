package Hibernate;

import com.alibaba.fastjson.JSON;
import gecco.GeccoTools;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import plug.Tree;
import tool.Tool;
import org.hibernate.Session;


import java.util.*;

public class HiberDao {
    public String getAllInfoJSON(){

        Session session = Tool.getSessionfactory().openSession();
        Query query = session.createQuery("from DataEntity");
        List resultList = query.list();
        Iterator iterator = resultList.iterator();
        ArrayList<DataEntity> arrayList = new ArrayList();
        while (iterator.hasNext()){
            arrayList.add((DataEntity) iterator.next());
        }

        return JSON.toJSONString(arrayList);
    }

    public void updateAll(){
        Session session = Tool.getSessionfactory().openSession();
        Query query = session.createQuery("from DataEntity ");
        List resultList = query.list();
        Iterator iterator = resultList.iterator();
        while (iterator.hasNext()){
            GeccoTools.loadBaiduinfo(((DataEntity)(iterator.next())).getTitle());
        }
    }

    public void updateOne(String title_name){
        Session session = Tool.getSessionfactory().openSession();
        Query query = session.createQuery("from DataEntity as d where d.title="+"'"+title_name+"'");
        List resultList = query.list();
        Iterator iterator = resultList.iterator();
        while (iterator.hasNext()){
            String title = ((DataEntity)iterator.next()).getTitle();
            GeccoTools.loadBaiduinfo(title);
        }
    }

    public List<DataEntity> getAllInfo(){
        Session session = Tool.getSessionfactory().openSession();
        Query query = session.createQuery("from DataEntity");
        return query.list();
    }

    public Set<Tree> getTreeInfo(){
        Session session = Tool.getSessionfactory().openSession();
        Query query = session.createQuery("from DataEntity");
        List list = query.list();
        Set<Tree> set = new HashSet();
        for (int i = 0;i < list.size() ; i++){
            Tree tree = new Tree(((DataEntity) list.get(i)).getZhang());
            if(!set.toString().contains(tree.text)){
                set.add(tree);
            }
        }
        for (Tree t:set
             ) {
            Query query1 = session.createQuery("select title from DataEntity where zhang ='"+((Tree)t).getText()+"'");
            List<String> list1 = query1.list();
            for (String s:list1
                 ) {
                if (s!=null){
                    t.addNodes(new Tree(s));
                }
            }
        }
        return set;
    }
    public DataEntity getDetail(String title_name){
        String result = "";
        Session session = Tool.getSessionfactory().openSession();
        Query query = session.createQuery("from DataEntity as d where d.title='"+title_name+"'");
        List<DataEntity> list = query.list();
        return list.get(0);
    }

}
