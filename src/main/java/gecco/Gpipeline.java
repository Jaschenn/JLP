package gecco;

import Hibernate.DataEntity;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.spider.SpiderBean;
import net.bytebuddy.implementation.bind.annotation.Pipe;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import tool.Tool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@PipelineName("Gpipeline")
public class Gpipeline implements Pipeline<BaiduComp> {

    public void process(BaiduComp baiduComp) {
        Session session = Tool.getSessionfactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from DataEntity as d where d.title='"+baiduComp.getTitle()+"'";
        Query query = session.createQuery(hql);
        System.out.println(hql);
        List resultList = query.list();
        DataEntity dataEntity = (DataEntity) resultList.get(0);
        dataEntity.setBaidu_comp(baiduComp.getContent());
        transaction.commit();
        session.close();

    }
}
