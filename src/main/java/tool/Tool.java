package tool;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Tool {

    private static SessionFactory sessionfactory = null;

    public static SessionFactory getSessionfactory(){
        try {
            sessionfactory = new Configuration().configure().buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sessionfactory!=null){
                return sessionfactory;
            }else {
                return null;
            }

        }

    }

}
