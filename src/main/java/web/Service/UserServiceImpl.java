package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {

        this.userDao = userDao;
    }


    @Override
    public void add(User user) {
        userDao.add(user);

    }


    @Override
    @Transactional (readOnly = true)
    public List<User> index() {
        return userDao.index();
    }


    @Override
    @Transactional
    public User showById(Long id) {
        return userDao.showById(id);
    }


    @Override

    public void update(User updatedUser) {
        userDao.update(updatedUser);

    }


    @Override

    public void delete(Long id) {
        userDao.delete(id);

    }
}
