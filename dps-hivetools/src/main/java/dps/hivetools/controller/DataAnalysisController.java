package dps.hivetools.controller;

import dps.common.exception.ServiceException;
import dps.common.utils.NDateUtil;
import dps.hivetools.service.ExcelAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/table/create")
public class DataAnalysisController {

    private static final Logger log = LoggerFactory.getLogger(DataAnalysisController.class);

    @PostMapping("/excel")
    public String createTabelByExcel(MultipartFile file) {
        if (file == null) {
            return "请上传文件！";
        }
        if (!file.getContentType().equals("application/vnd.ms-excel") &&
                !file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return "请上传Excel文件！";
        }
        String fileName = file.getOriginalFilename();
        log.info(String.format("开始解析Excel [%s] 文件名：[%s] 文件大小：[%d]", NDateUtil.getTime(), fileName, file.getSize()));

        try {
            ExcelAnalysisService.analysis(file, fileName);
            log.info(String.format("文件：%s 解析成功！[%s]", fileName, NDateUtil.getTime()));
            return String.format("文件：%s 解析成功！[%s]", fileName, NDateUtil.getTime());
        } catch (ServiceException ex) {
            log.error(String.format("文件：%s 解析失败！[%s] 业务异常错误信息：%s", fileName, NDateUtil.getTime(), ex.getErrorMsg()));
            return String.format("文件：%s 解析失败！[%s] 业务异常错误信息：%s", fileName, NDateUtil.getTime(), ex.getErrorMsg());
        } catch (Exception ex) {
            log.error("error: {}", ex.getMessage(), ex);
            return String.format("文件：%s 解析失败！[%s] 未知异常错误信息：%s", fileName, NDateUtil.getTime(), ex.getMessage());
        }

    }
}
