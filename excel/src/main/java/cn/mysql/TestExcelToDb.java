package cn.mysql;
import java.util.List;

import cn.mysql.DBhepler;
import cn.mysql.StuEntity;
import cn.mysql.StuService;

/**
 * @author Javen
 * @Email zyw205@gmail.com
 * 
 */
public class TestExcelToDb {
    public static void main(String[] args) {
        //得到表格中所有的数据
        List<StuEntity> listExcel=StuService.getAllByExcel("/Users/lyn/eclipse-workspace/text/text.xls");
        /*//得到数据库表中所有的数据
        List<StuEntity> listDb=StuService.getAllByDb();*/
        
        DBhepler db=new DBhepler();
        
        for (StuEntity stuEntity : listExcel) {
            int id=stuEntity.getId();
            if (!StuService.isExist(id)) {
                //不存在就添加
                String sql="insert into stu (organization,company,username,nickname,mailbox,phone,officephone,employeecoding,employeename,Lastlogindate) values(?,?,?,?,?,?,?,?,?,?)";
                String[] str=new String[]{stuEntity.getOrganization(),stuEntity.getCompany(),stuEntity.getUsername(),stuEntity.getNickname(),stuEntity.getMailbox(),stuEntity.getPhone()+"",stuEntity.getOfficephone()+""+stuEntity.getEmployeecoding(),stuEntity.getEmployeename(),stuEntity.getLastlogindate()+""};
                db.AddU(sql, str);
            }else {
                //存在就更新
                String sql="update stu set organization=?,company=?,username=?,nickname=?,mailbox=?,phone=?,officephone=?,employeecoding=?,employeename=?,Lastlogindate=? where id=?";
                String[] str=new String[]{stuEntity.getOrganization(),stuEntity.getCompany(),stuEntity.getUsername(),stuEntity.getNickname(),stuEntity.getMailbox(),stuEntity.getPhone()+"",stuEntity.getOfficephone()+""+stuEntity.getEmployeecoding(),stuEntity.getEmployeename(),stuEntity.getLastlogindate()+"",id+""};
                db.AddU(sql, str);
            }
        }
    }
}
