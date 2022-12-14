package com.sda.mark.bookmanagement.utils;



import com.sda.mark.bookmanagement.model.Author;
import com.sda.mark.bookmanagement.model.Book;
import com.sda.mark.bookmanagement.model.Review;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager() {
    }

    public static SessionFactory getSessionFactory() {
        return INSTANCE.getSessionFactory("book_management_system");
    }

    public static void shutDown() {
        INSTANCE.shutdownSessionManager();
    }

//    private void shutdownSessionManager() {
//    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
        // Hibernate model will be added here
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Review.class);


    }
}
