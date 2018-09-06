package cn.mysql;

import java.io.File;
import java.util.List;

import cn.mysql.StuEntity;
import cn.mysql.StuService;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class TestDbToExcel {

    public static void main(String[] args) {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
               String fileName = "/Users/lyn/eclipse-workspace/text/test3.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("数据用户", 0);
               int a=2;
               //查询数据库中所有的数据
               List<StuEntity> list= StuService.getAllByDb();
               //要插入到的Excel表格的行号，默认从0开始
               Label labeltitle= new Label(6, 1, "用户数据");
               Label labelId= new Label(0, a, "编号");//表示第
               Label labelorganization= new Label(1, a, "归属机构");
               Label labelcompany= new Label(2, a, "归属公司");
               Label labelusername= new Label(3, a, "登录账号");
               Label labelnickname= new Label(4, a, "用户昵称");
               Label labelmailbox= new Label(5, a, "电子邮箱");
               Label labelphone= new Label(6, a, "手机号码");
               Label labelofficephone= new Label(7, a, "办公电");
               Label labelemployeecoding= new Label(8, a, "员工编码");
               Label labelemployeename= new Label(9, a, "员工姓名");
               Label labelLastlogindate= new Label(10, a, "最后登录日期");
               
               ws.addCell(labeltitle);
               ws.addCell(labelId);
               ws.addCell(labelorganization);
               ws.addCell(labelcompany);
               ws.addCell(labelusername);
               ws.addCell(labelnickname);
               ws.addCell(labelmailbox);
               ws.addCell(labelphone);
               ws.addCell(labelofficephone);
               ws.addCell(labelemployeecoding);
               ws.addCell(labelemployeename);
               ws.addCell(labelLastlogindate);
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelId_i= new Label(0, i+1+a, list.get(i).getId()+"");
                   Label labelorganization_i= new Label(1, i+1+a, list.get(i).getOrganization());
                   Label labelcompany_i= new Label(2, i+1+a, list.get(i).getCompany());
                   Label labelUsername_i= new Label(3, i+1+a, list.get(i).getUsername());
                   Label labelnickname_i= new Label(4, i+1+a, list.get(i).getNickname());
                   Label labelmailbox_i= new Label(5, i+1+a, list.get(i).getMailbox());
                   Label labelphone_i= new Label(6, i+1+a, list.get(i).getPhone()+"");
                   Label labelofficephone_i= new Label(7, i+1+a, list.get(i).getOfficephone()+"");
                   Label labelemployeecoding_i= new Label(8, i+1+a, list.get(i).getEmployeecoding());
                   Label labelemployeename_i= new Label(9, i+1+a, list.get(i).getEmployeename());
                   Label labelLastlogindate_i= new Label(10, i+1+a, list.get(i).getLastlogindate()+"");
                   ws.addCell(labelId_i);
                   ws.addCell(labelorganization_i);
                   ws.addCell(labelcompany_i);
                   ws.addCell(labelUsername_i);
                   ws.addCell(labelnickname_i);
                   ws.addCell(labelmailbox_i);
                   ws.addCell(labelphone_i);
                   ws.addCell(labelofficephone_i);
                   ws.addCell(labelemployeecoding_i);
                   ws.addCell(labelemployeename_i);
                   ws.addCell(labelLastlogindate_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}