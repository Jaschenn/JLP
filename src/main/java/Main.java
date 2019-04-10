import Hibernate.DataEntity;
import com.geccocrawler.gecco.GeccoEngine;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.ReaderInputStream;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        /**
         * 首先从数据库中读取到所有的数据到程序内存中
         *
         *
         * */
//        String document ="互联网+概念于2012年11月易观国际董事长兼首席执行官于扬首次提出，并于2015年7月4日，国务院印发了《国务院关于积极推进“互联网+”行动的指导意见》。“互联网+”作为知识社会创新2.0推动下的互联网形态演进，成为了中国互联网发展的新形态和新业态。“互联网+”既是互联网的移动与泛在，促进了传统行业与互联网的融合及应用，将数据、计算、知识三者融合，使创新渗入到各行各业，从而开创了创新驱动发展的“新常态”。 \n";
//        tool.JLPTools.getSimilarityRate(document,"金玉今天吃了很大一碗牛肉面");
//        System.out.println(tool.JLPTools.getSunmmary(document,50));


//        Configuration configuration = new Configuration().configure();
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        String hql = "from DataEntity";
//        Query query = session.createQuery(hql);
//        List<DataEntity> dataEntities = query.list();
//        String test1 = "电子政府又称电子政务、数字政府、在线政府等。电子政府是通过数字化技术将政府到公民（政府-公民称为：government and citizens，简称G2C，下同）、政府到企业（government and businesses/Commerce，G2B）、政府到员工（government and employees，G2E），甚至于政府到政府之间（government and governments /agencies，G2G）连接。电子政务的模式一般归纳如下：\n" +
//                "    G2C (政府到公民，Government to Citizens)\n" +
//                "    G2B (政府到企业，Government to Businesses)\n" +
//                "    G2E (政府到员工，Government to Employees)\n" +
//                "    G2G (政府之间，Government to Governments)\n" +
//                "    C2G (公民到政府，Citizens to Governments)\n" +
//                "    其中，数字化主要包括政府管理、 信息和通讯技术 (简称：ICT)、企业流程再造 (简称：BPR)和电子公民等，也包括国际、国家、省级、市级各级政府。\n";
//        String test2 = "电子政府是指在政府内部采用电子化和自动化技术的基础上，利用现代信息技术和网络技术，建立起网络化的政府信息系统，并利用这个系统为政府机构、社会组织和公民提供方便、高效的政府服务和政务信息。\"电子政府\"实质上是将工业化模型的大政府（特点是集中管理、分层结构、在物理经济中运行）转变为适应以知识经济为基础，同时适应社会不断发展变化的虚拟政府（新型公共行政管理模式）。其功能一是通过政府业务信息化，精简机构和简化办事程序，大幅度提高效率；二是为公众、为社会提供优质服务；三是以政府信息化推动社会信息化。";
//        double[] result = tool.JLPTools.getSimilarityRate(test1,test2);
//        for (double i : result){
//            System.out.print(i+"\t");
//        }

    }

}
