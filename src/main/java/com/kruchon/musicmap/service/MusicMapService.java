package com.kruchon.musicmap.service;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.kruchon.musicmap.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Service("musicMapService")
@Transactional
public class MusicMapService {

    protected static Logger logger = Logger.getLogger("service");

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void add(User user) {
        logger.debug("Adding new user");
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

}
