package cn.hibernatedemo.service;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import cn.hibernatedemo.dao.DeptDao;
import cn.hibernatedemo.entity.Dept;

public class DeptBiz {
    private DeptDao deptDao = new DeptDao();
    
    public Dept mergeDept(Dept dept) {
        Transaction tx = null;
        Dept persistentDept = null;
        try {
            tx = deptDao.currentSession().beginTransaction(); // 开启事务
            // 合并dept的数据或者保存dept的副本，返回持久态对象
            persistentDept = deptDao.merge(dept);
            tx.commit(); // 提交事务
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback(); // 回滚事务
        }
        return persistentDept;
    }
    
    public DeptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
