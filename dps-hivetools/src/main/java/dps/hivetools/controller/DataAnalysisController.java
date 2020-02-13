package dps.hivetools.controller;

import dps.common.exception.ServiceException;
import dps.common.utils.NDateUtil;
import dps.hivetools.service.ExcelAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/api/table/create")
public class DataAnalysisController {

    private static final Logger log = LoggerFactory.getLogger(DataAnalysisController.class);


    @GetMapping("/upload")
    public String uploadExcel() {
        return "file";
    }

    @PostMapping("/excel")
    public String createTabelByExcel(MultipartFile file, HttpServletRequest request) {
        if (file == null) {
            request.setAttribute("data", "请上传文件！");
            return "fail";
        }
        if (!file.getContentType().equals("application/vnd.ms-excel") &&
                !file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            request.setAttribute("data", "请上传Excel文件！");
            return "fail";
        }
        String fileName = file.getOriginalFilename();
        log.info(String.format("开始解析Excel [%s] 文件名：[%s] 文件大小：[%d]", NDateUtil.getTime(), fileName, file.getSize()));

        try {
            List<String> filePaths = ExcelAnalysisService.analysis(file, fileName);
            log.info(String.format("文件：%s 解析成功！[%s]", fileName, NDateUtil.getTime()));
            request.setAttribute("filePaths", filePaths);
            return "success";
        } catch (ServiceException ex) {
            log.error(String.format("文件：%s 解析失败！[%s] 业务异常错误信息：%s", fileName, NDateUtil.getTime(), ex.getErrorMsg()));
            request.setAttribute("data", String.format("文件：%s 解析失败！[%s] 业务异常错误信息：%s", fileName, NDateUtil.getTime(), ex.getErrorMsg()));
            return "fail";
        } catch (Exception ex) {
            log.error("error: {}", ex.getMessage(), ex);
            request.setAttribute("data", String.format("文件：%s 解析失败！[%s] 未知异常错误信息：%s", fileName, NDateUtil.getTime(), ex.getMessage()));
            return "fail";
        }
    }
}
