package dps.hivetools.controller;

import dps.hivetools.service.ExcelAnalysisService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/table/create")
public class DataAnalysisController {

    @PostMapping("/excel")
    public String createTabelByExcel(MultipartFile file) throws Exception {
        List<String> analysis = ExcelAnalysisService.analysis(file);
        return "";
    }
}
