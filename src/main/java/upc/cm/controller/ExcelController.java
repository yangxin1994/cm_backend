package upc.cm.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upc.cm.model.SystemUser;
import upc.cm.repository.SURe;

import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    SURe suRe;

    @GetMapping("/exportExcel")
    public Object getExcel() {
        ExcelWriterBuilder write = EasyExcel.write("test.xlsx", SystemUser.class);
        ExcelWriterSheetBuilder sheet = write.sheet();
        List<SystemUser> systemUsers = suRe.findAll();
        sheet.doWrite(systemUsers);

        return "success";
    }
}
