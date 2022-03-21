package controller;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author 蔡心勇
 * @create 2022/3/17 - 11:49
 */
public class FormSubmit extends BaseServlet {
    protected void formSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取页面上输出的参数
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String message = req.getParameter("message");
        System.out.println(name + "\n" + email + "\n" + message);

        //数据写入：D:/data.xlsx
        String[] title = {"id", "name", "email", "message"};
        File file = new File("D:/data.xlsx");
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            Label labelA = null;

            //设置xlsx的列名
            for (int i = 0; i < title.length; i++) {
                labelA = new Label(i, 0, title[i]);
                sheet.addCell(labelA);
            }

            //设置数据
            String data[]={"1",name,email,message};
            for (int i = 0; i < data.length; i++) {
                Label label = new Label(i, 1, data[i]);
                sheet.addCell(label);
            }
            workbook.write();
            workbook.close();

            //跳转成功页面
            req.getRequestDispatcher("/band/success.html").forward(req, resp);
        } catch (Exception e) {
            //跳转失败页面
            req.getRequestDispatcher("/band/error.html").forward(req, resp);
        }
    }

}
