package cn.hibernatedemo.dao;

import cn.hibernatedemo.entity.Dept;

public class DeptDao extends BaseDao {
    // 使用merge()方法将游离对象的数据合并到拥有相同OID的持久态对象中
    // 或者保存临时对象的副本，得到新的持久态对象
    public Dept merge(Dept dept) {
        return (Dept) currentSession().merge(dept);
    }
    // 省略其他DAO方法
}
