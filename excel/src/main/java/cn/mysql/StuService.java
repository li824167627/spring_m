package cn.mysql;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

import cn.mysql.DBhepler;
import cn.mysql.StuEntity;

/**
 * @author Javen
 * @Email zyw205@gmail.com
 * 
 */
public class StuService {
    /**
     * 查询stu表中所有的数据
     * @return 
     */
    public static List<StuEntity> getAllByDb(){
        List<StuEntity> list=new ArrayList<StuEntity>();
        try {
            DBhepler db=new DBhepler();
            String sql="select * from stu";
            ResultSet rs= db.Search(sql, null);
            while (rs.next()) {
                int id=rs.getInt("id");
                String organization=rs.getString("organization");
                String company=rs.getString("company");
                String username=rs.getString("username");
                String nickname=rs.getString("nickname");
                String mailbox=rs.getString("mailbox");
                int phone=rs.getInt("phone");
                int officephone=rs.getInt("officephone");
                String employeecoding=rs.getString("employeecoding");
                String employeename=rs.getString("employeename");
                Date Lastlogindate=rs.getDate("Lastlogindate");
                
                //System.out.println(id+" "+name+" "+sex+ " "+num);
                list.add(new StuEntity(id, organization, company, username,nickname,mailbox,phone,officephone,employeecoding,employeename,Lastlogindate));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    /**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */
    public static List<StuEntity> getAllByExcel(String file){
        List<StuEntity> list=new ArrayList<StuEntity>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("text1");//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 5; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String organization=rs.getCell(j++, i).getContents();
                    String company=rs.getCell(j++, i).getContents();
                    String username=rs.getCell(j++, i).getContents();
                    String nickname=rs.getCell(j++, i).getContents();
                    String mailbox=rs.getCell(j++, i).getContents();
                    String phone=rs.getCell(j++, i).getContents();
                    String officephone=rs.getCell(j++, i).getContents();
                    String employeecoding=rs.getCell(j++, i).getContents();
                    String employeename=rs.getCell(j++, i).getContents();
                    String Lastlogindate=rs.getCell(j++, i).getContents();                   
                    System.out.println("id:"+id+" organization:"+organization+" company:"+company+" username:"+username+" nickname:"+nickname+" mailbox:"+mailbox+" phone:"+phone+" officephone:"+officephone+" employeecoding:"+employeecoding+" employeename:"+employeename+" Lastlogindate:"+Lastlogindate);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    list.add(new StuEntity(Integer.parseInt(id),organization,company,username,nickname,mailbox,Integer.parseInt(phone),Integer.parseInt(officephone),employeecoding,employeename,sdf.parse(Lastlogindate)));
                  
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
    
    /**
     * 通过Id判断是否存在
     * @param id
     * @return
     */
    public static boolean isExist(int id){
        try {
            DBhepler db=new DBhepler();
            ResultSet rs=db.Search("select * from stu where id=?", new String[]{id+""});
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        /*List<StuEntity> all=getAllByDb();
        for (StuEntity stuEntity : all) {
            System.out.println(stuEntity.toString());
        }*/
        
        System.out.println(isExist(1));
        
    }
    
}
