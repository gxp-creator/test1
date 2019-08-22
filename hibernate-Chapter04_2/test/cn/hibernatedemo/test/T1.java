package cn.hibernatedemo.test;

import org.junit.Test;
import cn.hibernatedemo.entity.Dept;
import cn.hibernatedemo.service.DeptBiz;

public class T1 {

    /**
     * 修改部门信息，merge
     */
    @Test
    public void eg10_mergeDept() {
        // 构建测试数据
        Dept dept = new Dept();
        dept.setDeptNo(new Short("12")); // 游离状态，去掉为临时状态
        dept.setDeptName("开发部");
        dept.setLocation("西区");
        // 合并游离态dept的数据或者保存临时态dept的副本
        new DeptBiz().mergeDept(dept);
    }
}
